/*
@author Fernando Jose Lavarreda Urizar
@version 02/02/2021
Persistencia de la información
*/

import gui.*;
import back.*;
import javax.swing.*;
public class TeacherGeek{

	public static void main(String[] args){
		JFrame jf = new JFrame("TeacherGeek");
		Materia[] oo = new Materia[1];
		oo[0] = new Materia();
		oo[0].setNombre("ooo");
		TeacherGeekGraphics graphs = new TeacherGeekGraphics(oo);
		String pwd = System.getProperty("user.dir")+"/data";
		
		jf.getContentPane().add(graphs);
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		Unidad naa = new Unidad();
		naa.setNombre("Fernando");
		Unidad naa2 = new Unidad();
		naa2.setNombre("Paca");
		naa.addTema(naa2);
		System.out.println(naa2.getFullNombre());
		System.out.println("Fer/lola/canva/mirio".split("/")[0]);
	}

}