/*
@author Fernando Jose Lavarreda Urizar
@version 02/02/2021
Representación del estudiante de una Materia
*/

package back;
import java.util.ArrayList;

public class Student{
	private String name;
	private ArrayList<Unidad> unidades = ArrayList<Unidad>();
	
	public Student(){
		
	}
	
	
	public void addUnidad(){
		unidades.addUnidad(new Unidad());
	}
	
}