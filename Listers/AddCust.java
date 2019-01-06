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

import Files.Customer_Save;
import Interface.Account;
import Interface.Popups;
import Interface.UsageLog;
import People.Customer;

@SuppressWarnings("serial")
public class AddCust extends JFrame implements Adder{

	private JPanel panel = new JPanel();
	private JLabel label = new JLabel("FName:");
	private JLabel label2 = new JLabel("LName:");
	private JLabel label3 = new JLabel("Age:");
	
	private JTextField f1 = new JTextField(20);
	private JTextField f2 = new JTextField(20);
	private JTextField f3 = new JTextField(20);
	
	private JButton cancel = new JButton("Cancel");
	private JButton save = new JButton("Save");
	
	AddCust(Account A, CustomerLister CL){
		
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
		label.setVisible(true);label2.setVisible(true);label3.setVisible(true);
		
		panel.setBounds(20,80,260,420); 

		panel.add(label);																	//Adding in the fields:
		panel.add(f1);
		panel.add(label2);
		panel.add(f2);
		panel.add(label3);
		panel.add(f3);
		
		f1.setText("FName");
		f2.setText("LName");
		f3.setText("18");
		
		save.setLocation(170, 10);															//Save button:
		save.setSize(120, 20);
		save.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//Getting values:
				String a = f1.getText();
				String b = f2.getText();
        
				int c = 0;
				
				try {
		            	c = Integer.parseInt(f3.getText());
				}
		           	catch (NumberFormatException nfe) { 
		           		Popups.show("Wrong values!");
						UsageLog.add("Employee creation failed");
		           		dispose();
		           		
				}
				 
				UsageLog.add(A.getUsername() + " has added a new Client");
				UsageLog.add(a + " " + b + " - " + c);

				
				Customer_Save.AddCustomer(new Customer(a,b,c));
				
	            CL.dispose();
	            
	            CustomerLister CL2 = new CustomerLister(A);
	            CL2.setVisible(true);

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
