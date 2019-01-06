package Listers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Interface.Account;
import Interface.Popups;
import Interface.UsageLog;
import Schedules.Movies;

@SuppressWarnings("serial")
public class AddMovie  extends JFrame implements Adder{


	private JPanel panel = new JPanel();
	private JLabel label = new JLabel("Title: ");
	private JLabel label2 = new JLabel("Rating: ");
	
	private JTextField f1 = new JTextField(20);
	private JTextField f2 = new JTextField(20);
	
	private JButton cancel = new JButton("Cancel");
	private JButton save = new JButton("Save");
	
	public AddMovie(Account A, MovieManagementLister MML){
		
		setUndecorated(true);																//Setting up the frame
		setSize(300,500);
		setTitle("Create Account");  
		setVisible(true);   
		setLayout(null);
		setLocation(1000,100);	
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));	//Adding border
		
		panel.setBorder(BorderFactory.createTitledBorder(									//Panel to hold our fields
				BorderFactory.createEtchedBorder(), "Details"));
		
		
		panel.setVisible(true);					
		label.setVisible(true);label2.setVisible(true);
		
		panel.setBounds(20,80,260,420); 

		panel.add(label);																	//Adding in the fields:
		panel.add(f1);
		panel.add(label2);
		panel.add(f2);

		
		f1.setText("Title");
		f2.setText("10");
		
		save.setLocation(170, 10);															//Save button:
		save.setSize(120, 20);
		save.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//Getting values:
				String a = f1.getText();
        
				float b = 0;
				
				try {
		            	b = Float.parseFloat(f2.getText());
				}
		           	catch (NumberFormatException nfe) { 
		           		Popups.show("Wrong values!");
						UsageLog.add("Employee creation failed");
		           		dispose();
		           		
				}
				 
				UsageLog.add(A.getUsername() + " has added a new Movie");
				UsageLog.add(a + " " + b);

				MML.dispose();
				
				new Movies(a,b);
				
				new MovieManagementLister(A);
				
	            dispose();
			}
		} );
		
		add(panel);
		
		add(save);
		
		cancel.setLocation(170, 40);															//cancel button:
		cancel.setSize(120, 20);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UsageLog.add("Creation has been aborted");
				
			dispose();
			}
		} );
		add(cancel);
		
		
		repaint();																			//refresh
		
	}
	
}
