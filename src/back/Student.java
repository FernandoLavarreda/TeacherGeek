/*
@author Fernando Jose Lavarreda Urizar
@version 02/02/2021
Representación del estudiante de una Materia
*/

package back;
import java.util.ArrayList;

public class Student{
	private String nombre;
	private ArrayList<Unidad> unidades = new ArrayList<Unidad>();
	
	public Student(){
		
	}
	
	
	public void addUnidad(Unidad d){
		unidades.add(d);
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
}