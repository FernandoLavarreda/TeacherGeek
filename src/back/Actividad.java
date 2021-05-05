/*
@author Fernando Jose Lavarreda Urizar
@version 02/02/2021
Ejercicio, tarea, evaluación que testea los conocimientos de los estudiates sobre un tema
*/

package back;

public class Actividad{
	private String nombre;
	private double peso;
	private double nota;
	private boolean entregado;
	private boolean grupal;
	
	public Actividad(){
	
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setPeso(double peso){
		this.peso = peso;
	}
	
	public void setNota(double nota){
		this.nota = nota;
	}
	
	public void setEntregado(boolean entregado){
		this.entregado = entregado;
	}
	
	public void setGrupal(boolean grupal){
		this.grupal = grupal;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public double getPeso(){
		return peso;
	}
	
	public double getNota(){
		return nota;
	}
	
	public boolean getEntregado(){
		return entregado;
	}
	
	public boolean getGrupal(){
		return grupal;
	}

}