/*
@author Fernando Jose Lavarreda Urizar
@version 02/02/2021
Persistencia de la información
*/

package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import back.Materia;

public class TeacherGeekGraphics extends JPanel{
	private ArrayList<Materia> materias = new ArrayList<Materia>();
	private JButton addMateria = new JButton("+Materia");
	private JButton addEstudiante = new JButton("+Estudiante");
	
	public TeacherGeekGraphics(){
		setLayout(new GridBagLayout());
		GridBagConstraints gcn = new GridBagConstraints();
		gcn.fill = GridBagConstraints.BOTH;
		gcn.gridx = 0;
		gcn.gridy = 0;
		gcn.gridwidth = 4;
		gcn.gridheight = 2;
		
		JLabel title = new JLabel("<html><div style='text-align: center;'>TeacherGeek</div><html>");
		title.setFont(new Font("Verdana", Font.BOLD, 24));
		title.setForeground(new Color(245, 185, 56));
		add(title, gcn);
		
		gcn.gridwidth = 1;
		gcn.gridwidth = 1;
		gcn.gridx = 2;
		gcn.gridy = 1;
		
		
		
		
		
	}
	
	private ButtonListener extends ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==addMateria){
				
			}else if(e.getSource()==addEstudiante){
				
			}
			
		}
	}
	
} 