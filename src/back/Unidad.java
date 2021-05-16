/*
@author Fernando Jose Lavarreda Urizar
@version 02/02/2021
Subdivisión de los temas y actividades de una Materia
*/

package back;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Unidad{
	private double peso;
	private String nombre;
	private ArrayList<Unidad> temas = new ArrayList<Unidad>();
	private ArrayList<Actividad> actividades;
	private Unidad parent = null;
	private double lower = 0.0;
	private double higher = 1.0;
	
	public Unidad(){
		
	}
	
	public Unidad(double peso, String nombre, double...limits)throws InputMismatchException{
		this.peso = peso;
		this.nombre = nombre;
		if(limits.length>0){
			if(limits.length==2){
				if(limits[1]>limits[0]&&limits[0]>=0){
					double upper = limits[1];
					double lower = limits[0];
				}else{
					throw new InputMismatchException("Upperbound must be bigger than lowerbound and positive");
				}
			}else{
				throw new InputMismatchException("Needed two optinal arguments given:"+limits.length);
			}
		}
	}
	
	
	public double calcActividades(){
		double total = 0.0;
		double pesos = 0.0;
		double nota = 0.0;
		for(Actividad t: actividades){
			pesos+=t.getPeso();
			total+=t.getNota()*t.getPeso();
		}
		if(pesos>0){
			nota = total/pesos;
		}
		return nota;
	}
	
	public double calcNotas(){
		double nota = 0.0;
		if(temas.size()==0){
			nota = calcActividades();
		}else{
			double sum = 0.0;
			double down = 0.0;
			for(Unidad tema: temas){
				sum+= tema.calcActividades()*tema.getPeso();
				down+=tema.getPeso();
			}
			for(Actividad t: actividades){
				sum+=t.getNota();
				down+=t.getPeso();
			}
			if(down>0)
			nota = sum/down;
		}
		return nota;
	}
	
	public void setPeso(double peso)throws InputMismatchException{
		if(peso>higher||peso<lower){
			throw new InputMismatchException("Peso de tema no válido");
		}
		this.peso = peso;
	}
	
	public double getPeso(){
		return peso;
	}
	
	public Unidad getUnidad(String[] broken){
		if(broken.length == 1){
			for(Unidad d:temas){
				if(d.getNombre().equals(broken[0])){
					return d;
				}
			}
			return null;
		}else{
			for(Unidad d:temas){
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
	
	
	public void setNombre(String nom){
		this.nombre = nom;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getFullNombre(){
		if(parent==null){
			return getNombre();
		}else{
			return parent.getFullNombre()+nombre;
		}
	}
	
	public Unidad getParent(){
		return this.parent;
	}
	
	public void setParent(Unidad par){
		this.parent = par;
	}
	
	
	public void addTema(Unidad tema)throws InputMismatchException{
		boolean cont = true;
		for(Unidad t: temas){
			if(t.getNombre().equals(tema.getNombre())){
				throw new InputMismatchException("Tema ya existe");
			}
		}
		if(cont){
			tema.setParent(this);
			temas.add(tema);
		}
		return;
	}
	
	public void removeTema(){
		
	}
	
	public void addActividad(Actividad act){
		boolean aditable = true;
		for(Actividad tct: actividades){
			if(act.getNombre().equals(tct.getNombre())){
				aditable = false;
			}
		}
		if(aditable){
			actividades.add(act);
		}
	}
	
	public void removeActividad(){
		
	}
	
	public ArrayList<Actividad> getActividades(){
		return actividades;
	}
	
	public ArrayList<Unidad> getTemas(){
		return temas;
	}
}