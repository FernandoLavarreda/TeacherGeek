/*
@author Fernando Jose Lavarreda Urizar
@version 02/02/2021
Representación de un curso impartido en alguna institución educativa (Ejemplo: Física, Cálculo, Inglés)
*/

package back;
import java.util.ArrayList;

public class Materia{
	private String nombre;
	private ArrayList<Unidad> unidades;
	private ArrayList<Student> estudiantes;
	
	public Materia(){
	
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
	
	public void addStudent(Student td){
		estudiantes.add(td);
	}
	
	public void addUnidad(Unidad unity){
		unidades.add(unity);
	}
	
	public void removeStudent(){
		
	}
	
	public void removeUnidad(){
		
	}
}