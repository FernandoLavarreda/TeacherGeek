/*
@author Fernando Jose Lavarreda Urizar
@version 02/02/2021
Ejercicio, tarea, evaluación que testea los conocimientos de los estudiates sobre un tema
*/

package back;
import java.util.InputMismatchException;

public class Actividad{
	private String nombre;
	private double peso;
	private double nota = 0.0;
	private boolean entregado;
	private boolean grupal;
	
	public Actividad(String nombre, double peso, double nota, boolean entregado, boolean grupal) throws InputMismatchException{
		setNombre(nombre);
		setPeso(peso);
		setNota(nota);
		setEntregado(entregado);
		setGrupal(grupal);
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setPeso(double peso)throws InputMismatchException{
		if(peso<0){
			throw new InputMismatchException("Peso no puede ser negativo");
		}
		this.peso = peso;
	}
	
	public void setNota(double nota){
		if(nota<0){
			throw new InputMismatchException("Peso no puede ser negativo");
		}
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