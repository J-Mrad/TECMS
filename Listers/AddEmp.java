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

import Exceptions.ClerkLimit;
import Exceptions.ManagerLimit;
import Files.Clerk_Save;
import Files.Manager_Save;
import Interface.Account;
import Interface.Popups;
import Interface.UsageLog;
import People.Clerk;
import People.Manager;

@SuppressWarnings("serial")
public class AddEmp extends JFrame implements Adder{
	
	
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel("FName:");
	private JLabel label2 = new JLabel("LName:");
	private JLabel label3 = new JLabel("Age:");
	private JLabel label4 = new JLabel("Hourly:");
	private JLabel label5 = new JLabel("Hours/week:");
	private JLabel label6 = new JLabel("Shift start:");
	private JLabel label7 = new JLabel("Shift end:");

	
	private JTextField f1 = new JTextField(20);
	private JTextField f2 = new JTextField(20);
	private JTextField f3 = new JTextField(20);
	private JTextField f4 = new JTextField(20);
	private JTextField f5 = new JTextField(20);
	private JTextField f6 = new JTextField(20);
	private JTextField f7 = new JTextField(20);
	
	
	private JButton cancel = new JButton("Cancel");
	private JButton save = new JButton("Save");

	
	AddEmp(Account A, int X, EmployeeLister EL){
		
		
		setUndecorated(true);																//Setting up the frame
		setSize(300,500);
		setTitle("Create Account");  
		setVisible(true);   
		setLayout(null);
		setLocation(1000,100);	
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));	//Adding border
		
																							
		
		panel.setBorder(BorderFactory.createTitledBorder(									//Panel to hold our fields
				BorderFactory.createEtchedBorder(), "Details"));
		
		
		panel.setVisible(true);																//Fields
		label.setVisible(true);label7.setVisible(true);
		label2.setVisible(true);label3.setVisible(true);label4.setVisible(true);label5.setVisible(true);label6.setVisible(true);

		panel.setBounds(20,80,260,420); 
		

		panel.add(label);																	//Adding in the fields:
		panel.add(f1);
		panel.add(label2);
		panel.add(f2);
		panel.add(label3);
		panel.add(f3);
		panel.add(label4);
		panel.add(f4);
		panel.add(label5);
		panel.add(f5);
		panel.add(label6);
		panel.add(f6);
		panel.add(label7);
		panel.add(f7);
		
		f1.setText("FName");
		f2.setText("LName");
		f3.setText("18");
		f4.setText("10");
		f5.setText("30");
		f6.setText("8");
		f7.setText("2");

		add(panel);
		
		save.setLocation(170, 10);															//Save button:
		save.setSize(120, 20);
		save.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//Getting values:
				String a = f1.getText();
				String b = f2.getText();
        
				int c = 0,
					e1 = 0,
					f = 0,
					g = 0;
				float d = 0;
				
	            try {
	            	c = Integer.parseInt(f3.getText());
	            	d = Float.parseFloat(f4.getText());
	            	e1 = Integer.parseInt(f5.getText());
	            	f = Integer.parseInt(f6.getText());
	            	g = Integer.parseInt(f7.getText());
	            	
	           	}
	           	catch (NumberFormatException nfe) { 
	           		Popups.show("Wrong values!");
					UsageLog.add("Employee creation failed");
	           		dispose();
	           		
			    }
	            
	            if(X == 0) {
	            	try { if(Manager_Save.getList().size() > 10) throw new ManagerLimit(10);}
	            	catch (ManagerLimit ML) {}
	            	
	            	Manager_Save.AddManager(new Manager(d,e1,f,g,a,b,c));
					UsageLog.add("Manager creation succeeded");

					System.out.println("created");

	            	EL.dispose();
	            	
	            	EmployeeLister	EL2 = new EmployeeLister(A);
	            	EL2.setVisible(true);
	            }
	            
	            else {
	            	try { if(Clerk_Save.getList().size() > 10) throw new ClerkLimit(20);}
	            	catch (ClerkLimit CL) {}
	            	
	            	Clerk_Save.AddClerk(new Clerk(d,e1,f,g,a,b,c));
					UsageLog.add("Clerk creation succeeded");
					
	            	EL.dispose();
	            	
	            	EmployeeLister	EL2 = new EmployeeLister(A);
	            	EL2.setVisible(true);
	            
	            }
	            
	            
            	dispose();
			}
		} );
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
