/*
@author Fernando Jose Lavarreda Urizar
@version 02/02/2021
Persistencia de la información
*/

package gui;
import java.awt.*;
import javax.swing.*;
import back.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TeacherGeekGraphics extends JPanel{
	private ArrayList<Materia> materias = new ArrayList<Materia>();
	private JComboBox<String> mats, studs;
	private JButton addMateria = new JButton("+Materia");
	private JButton addEstudiante = new JButton("+Estudiante");
	
	public TeacherGeekGraphics(Materia[] todas){
		for(int i = 0; i<todas.length;++i){
			materias.add(todas[i]);
		}
		setLayout(new GridBagLayout());
		GridBagConstraints gcn = new GridBagConstraints();
		gcn.fill = GridBagConstraints.BOTH;
		gcn.gridx = 0;
		gcn.gridy = 0;
		gcn.gridwidth = 4;
		gcn.gridheight = 2;
		
		JLabel title = new JLabel("<html><div style='text-align: center;'>TeacherGeek</div></html>");
		title.setFont(new Font("Verdana", Font.BOLD, 28));
		title.setForeground(new Color(245, 185, 56));
		add(title, gcn);
		
		gcn.gridwidth = 1;
		gcn.gridheight = 1;
		gcn.gridx = 2;
		gcn.gridy = 2;
		
		mats= new JComboBox<String>();
		for(Materia t: materias){
			mats.addItem(t.getNombre());
		}
		add(mats, gcn);
		
		
		gcn.gridx = 3;
		mats.setSelectedItem(1);
		studs = new JComboBox<String>();
		Materia selected = null;
		for(Materia toos: materias){
			if(toos.getNombre().equals(mats.getSelectedItem().toString())){
				selected = toos;
			}
		}
		if(selected!=null){
			for(Student i:selected.getEstudiantes()){
				studs.addItem(i.getNombre());
			}
		}
		add(studs, gcn);
		
		
		gcn.gridy = 4;
		add(addMateria, gcn);
		
		
		
		
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==addMateria){
				
			}else if(e.getSource()==addEstudiante){
				
				
			}else if(e.getSource()==mats){
				mats.removeAllItems();
				Materia selected = null;
				for(Materia toos: materias){
					if(toos.getNombre().equals(mats.getSelectedItem().toString())){
						selected = toos;
					}
				}
				if(selected!=null){
					for(Student i:selected.getEstudiantes()){
						studs.addItem(i.getNombre());
					}
				}
			}
			
		}
	}
	
} 