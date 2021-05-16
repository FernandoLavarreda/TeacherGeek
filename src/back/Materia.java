/*
@author Fernando Jose Lavarreda Urizar
@version 02/02/2021
Representación de un curso impartido en alguna institución educativa (Ejemplo: Física, Cálculo, Inglés)
*/

package back;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Materia{
	private String nombre;
	private ArrayList<Unidad> unidades = new ArrayList<Unidad>();
	private ArrayList<Student> estudiantes = new ArrayList<Student>();
	
	public Materia(){
	
	}
	
	public Student getEstudiante(String nombre){
		for(Student std: estudiantes){
			if(nombre.equals(std.getNombre())){
				return std;
			}
		}
		return null;
	}
	
	public Unidad getUnidad(String[] broken){
		if(broken.length == 1){
			for(Unidad d:unidades){
				if(d.getNombre().equals(broken[0])){
					return d;
				}
			}
			return null;
		}else{
			for(Unidad d:unidades){
				if(d.getNombre().equals(broken[0])){
					String[] rest = new String[broken.length-1];
					for(int i=0; i<rest.length;++i){
						rest[i] = broken[i+1];
					}
					return d.getUnidad(rest);
				}
			}
			return null;
		}
	}
	
	public ArrayList<Student> getEstudiantes(){
		return estudiantes;
	}
	
	public ArrayList<Unidad> getUnidades(){
		return unidades;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void addStudent(Student td)throws InputMismatchException{
		for(Student std: estudiantes){
			if(std.getNombre().equals(td.getNombre())){
				throw new InputMismatchException("Estudiante ya existe");
			}
		}
		estudiantes.add(td);
	}
	
	public void addUnidad(Unidad unity)throws InputMismatchException{
		for(Unidad td: unidades){
			if(td.getNombre().equals(unity.getNombre())){
				throw new InputMismatchException("Unidad ya existe");
			}
			
		}
		unidades.add(unity);
	}
	
	public void removeStudent(){
		
	}
	
	public void removeUnidad(){
		
	}
}