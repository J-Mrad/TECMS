package Interface;

import java.awt.Color;						//Design

import javax.swing.JFrame;					//Basic Swing components
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.BorderFactory;

import java.awt.event.ActionEvent;			//Buttons
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Login extends JFrame {
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel("Enter Username:");
	private JLabel label2 = new JLabel("Enter Password:");
	
	private JTextField password = new JTextField(20);
	private JTextField userName = new JTextField(20);

	private JButton Login = new JButton("Login");
	private JButton cancel = new JButton("Cancel");

	
	public Login(Loading L){
		
		
		setUndecorated(true);																//Setting up the frame
		setSize(300,300);
		setTitle("Create Account");  
		setVisible(true);   
		setLayout(null);
		setLocation(1000,212);	
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));	//Adding border
		
																							
		
		panel.setBorder(BorderFactory.createTitledBorder(									//Panel to hold our fields
				BorderFactory.createEtchedBorder(), "Details"));
		
		
		panel.setVisible(true);																//Fields
		label.setVisible(true);
		label2.setVisible(true);

		panel.setBounds(20,80,260,200); 
		label.setBounds(5, 5, 10, 5);
		label2.setBounds(5, 5, 10, 5);
		
		userName.setText("Enter your name");

		password.setText("Enter an integer value");
		
		

		panel.add(label);																	//Adding in the fields:
		panel.add(userName);
		panel.add(label2);
		panel.add(password);
		
		add(panel);
		


		Login.setLocation(170, 10);															//Login button:
		Login.setSize(120, 20);
		Login.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				
				//Getting Name:
				String curName = userName.getText();
				//Getting Age:
	            int curpass = 0;
	            
	            try {
	            	curpass = Integer.parseInt(String.valueOf(password.getText()));
	            	
	           	}
	           	catch (NumberFormatException nfe) { //This will check if password is a number or not :D
	           		Popups.show("Wrong Username or Password! [101]");
					UsageLog.add("Login failed");
	           		dispose();
	           		
			    }
	            
	            int passed = 0;
	            for(Account A : L.AM.list ) {
	            	
	            	if(A.getUsername().equals(curName) && A.getPassword() == curpass) {
	            		
	            		L.dispose();
	            		
	            		Loading L2 = new Loading(A);

	            		L2.setVisible(true);

	            		passed = 1;
						UsageLog.add("Login successful, Guest is now " + curName);
	            	}
	            	
	            }
            	if(passed == 0) {
            		Popups.show("Wrong Username or Password! [102]");
    				UsageLog.add("Login failed");
            	}
            	dispose();
			}
		} );
		add(Login);
		
		cancel.setLocation(170, 40);															//cancel button:
		cancel.setSize(120, 20);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UsageLog.add("Login has been aborted");
				
			dispose();
			}
		} );
		add(cancel);
		
		 
		repaint();																			//refresh
	}
}