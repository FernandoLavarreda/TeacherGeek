/*
@author Fernando Jose Lavarreda Urizar
@version 02/02/2021
Persistencia de la información
*/
package back;
import java.io.File;
import java.util.Scanner;
import java.util.HashMap;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.InputMismatchException;

public class SaveMateria{
	private static String unicode = "[a-zA-Z\\u00C1\\u00E1\\u00C9\\u00E9\\u00CD\\u00ED\\u00ED\\u00F3\\u00DA\\u00FA\\s]+$";
	public static void Save(String path, Materia mat)throws IOException{
		File fl = new File(path);
		if(!fl.exists()){
			throw new IOException("Not existent path");
		}else{
			fl = new File(path+"/"+mat.getNombre());
			if(!fl.exists()){
				fl.mkdir();
				fl = new File(path+"/"+mat.getNombre()+"/Unidades");
				fl.mkdir();
			}
			for(Student est: mat.getEstudiantes()){
				SaveMateria.Save(path+"/"+mat.getNombre(), est);
			}
			for(Unidad uni: mat.getUnidades()){
				SaveMateria.Save(uni, path+"/"+mat.getNombre()+"/Unidades");
			}
		}
	}
	
	private static void Save(String path, Student std)throws IOException{
		File fd;
			fd = new File(path+"/"+std.getNombre());
			if(!fd.exists())
				fd.mkdir();
			for(Unidad d: std.getUnidades()){
				SaveMateria.Save(d, path+"/"+std.getNombre());
			}
		
	}
	
	private static void Save(Unidad b, String parentPath)throws IOException{
		File lr = new File(parentPath+"/"+b.getNombre());
		if(!lr.exists()){
			lr.mkdir();
		}
		FileWriter wrt = new FileWriter(parentPath+"/"+b.getNombre()+"/actividades.txt");
		for(Actividad t: b.getActividades()){
			wrt.write(t.getNombre());
			wrt.write(" "+t.getPeso());
			if(t.getGrupal()){
				wrt.write(" True");
			}else{
				wrt.write(" False");
			}
			if(t.getEntregado()){
				wrt.write(" True");
			}else{
				wrt.write(" False");
			}
			wrt.write(" "+t.getNota()+"\n");
		}
		wrt = new FileWriter(parentPath+"/"+b.getNombre()+"/temas.txt");
		for(Unidad r: b.getTemas()){
			wrt.write(r.getNombre()+" "+r.getPeso());
			SaveMateria.Save(r, parentPath+"/"+b.getNombre());
		}
	}
	
	private static void Load(String path, Materia mat) throws IOException{
		Pattern p = Pattern.compile(unicode);
		Matcher m = p.matcher(path);
		File location = new File(path);
		if(m.find()){
			String name = m.group(1);
			mat.setNombre(name);
			File[] files = location.listFiles();
			for(File t: files){
				p = Pattern.compile(unicode);
				m = p.matcher(t.toString());
				String student = m.group(1);
				if(student.equals("Unidades")){
					File[] more = t.listFiles();
					for(File h: more){
						Unidad nv = new Unidad();
						p = Pattern.compile(unicode);
						m = p.matcher(h.toString());
						String unity = m.group(1);
						nv.setNombre(unity);
						SaveMateria.Load(more.toString(), nv);
						mat.addUnidad(nv);
					}
				}else{
					Student addit = new Student();
					addit.setNombre(student);
					SaveMateria.Load(t.toString(), addit);
					mat.addStudent(addit);
				}
			}
		}
	}
	
	private static void Load(String path, Student stn) throws IOException{
		Pattern p = Pattern.compile(unicode);
		Matcher m = p.matcher(path);
		File location = new File(path);
		if(m.find()){
			String name = m.group(1);
			stn.setNombre(name);
			File[] files = location.listFiles();
			for(File t: files){
				p = Pattern.compile(unicode);
				m = p.matcher(t.toString());
				String unidad = m.group(1);
				Unidad ads = new Unidad();
				ads.setNombre(unidad);
				stn.addUnidad(ads);
				SaveMateria.Load(t.toString(), ads);
			}
		}
	}
	
	private static void Load(String path, Unidad main) throws InputMismatchException, IOException{
		File fd = new File(path);
		if(fd.exists()){
			fd = new File(path+"/actividades.txt");
			Scanner reader = new Scanner(fd);
			while(reader.hasNextLine()){
				String all = reader.nextLine();
				String[] subdivided = all.split(" ");
				String nombre = subdivided[0];
				double peso = Double.parseDouble(subdivided[1]);
				boolean grupal = Boolean.parseBoolean(subdivided[2]);
				boolean entregada = Boolean.parseBoolean(subdivided[3]);
				double nota = Double.parseDouble(subdivided[4]);
				main.addActividad(new Actividad(nombre, peso, nota, entregada, grupal));
			}
			fd = new File(path+"/temas.txt");
			reader = new Scanner(fd);
			while(reader.hasNextLine()){
				String all = reader.nextLine();
				String[] subdivided = all.split(" ");
				Unidad nt = new Unidad(Double.parseDouble(subdivided[1]), subdivided[0]);
				SaveMateria.Load(path+"/"+subdivided[0], nt);
				main.addTema(nt);
			}
		}else{
			throw new InputMismatchException("No such path");
		}
		
	}		
}