package Interface;

import java.awt.Font;						//Design
import java.awt.Color;


import javax.swing.JFrame;					//Basic Swing components
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.BorderFactory;
import javax.swing.filechooser.FileNameExtensionFilter;

import Exceptions.AccountLimit;

import java.io.File;						//Files
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.awt.event.ActionEvent;			//Buttons
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Create_Account extends JFrame{

	
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel("Enter Username:");
	private JLabel label2 = new JLabel("Enter Password:");
	private JLabel label3 = new JLabel("Password has to be a number!");
	private JLabel label4 = new JLabel("Change profile photo:");
	private JLabel label5 = new JLabel("File Selected: N/A");
	
	private JTextField password = new JTextField(20);
	private JTextField userName = new JTextField(20);

	private JButton save = new JButton("Save");  
	private JButton cancel = new JButton("Cancel");
		
	private JCheckBox TB = new JCheckBox("Account is Manager");

	private File selectedFile;
    private String path = "./src/Account_Data/backup.png"; //In case no photo input is given
    private Image image;
    
	Create_Account(Loading loader){
		
		
		
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
		label3.setVisible(false);

		panel.setBounds(20,80,260,200); 
		label.setBounds(5, 5, 10, 5);
		label2.setBounds(5, 5, 10, 5);
		
		userName.setText("Enter your name");

		password.setText("Enter an integer value");
		
		label3.setBounds(5, 5, 10, 5);
		label3.setFont(new Font("Impact",Font.PLAIN,12));
		label3.setForeground(Color.red);
		

		panel.add(label);																	//Adding in the fields:
		panel.add(userName);
		panel.add(label2);
		panel.add(password);
   		panel.add(label3);
		
		add(panel);
		


		save.setLocation(170, 10);															//Save button:
		save.setSize(120, 20);
		save.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				
				//Getting Name:
				String curName = userName.getText();
				//Getting Age:
	            int curpass = 0;
	            
	            try {
	            	curpass = Integer.parseInt(String.valueOf(password.getText()));
	           		
	            	image = ImageIO.read(new File(path));
	            	BufferedImage buffered = (BufferedImage) image;
	            	ImageIO.write(buffered, "png" , new File("./src/Account_Data/"+userName.getText()+".png"));
	            	
	           		loader.AM.AddAccount(curName,curpass,TB.isSelected());
	           		loader.AM.SaveList();
	           		
	           		dispose();
	    			loader.dispose();
	    			
					UsageLog.add("Account successfully created:");
					UsageLog.add("Username: " + curName + " Passowrd: " + curpass + "Admin: " + TB.isSelected() );

	    			
	    			Loading F = new Loading();
	    			F.setVisible(true);
	    			
	    			if(AccountManager.list.size() >= 10) {
	    				throw new AccountLimit(10);
	    			}
	    				    			
	           	}
	           	catch (NumberFormatException nfe) { //This will check if password is a number or not :D
	        		label3.setVisible(true);
	        		
			    } catch (IOException e1) {	// Check if file was passed correctly

			    	Popups.show("Error creating new account");

				} catch (AccountLimit e1) { // Check if limit exceeeded
					
				}

				
			}
		} );
		add(save);
		
		cancel.setLocation(170, 40);															//cancel button:
		cancel.setSize(120, 20);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UsageLog.add("Account creation aborted");
				
			dispose();
			}
		} );
		add(cancel);
		
		
		
		panel.add(label4);
		
		
		
		TB.setBackground(null);
		TB.setBounds(20, 465, 150, 40);
		panel.add(TB);
		
		
		
		JButton setpic = new JButton("Browse..");											//Profile photo selection
		setpic.addActionListener(new ActionListener() {

		        public void actionPerformed(ActionEvent e) {
		        
		          JFileChooser file = new JFileChooser();
		          file.setCurrentDirectory(new File(System.getProperty("user.home")));
		          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
		          file.addChoosableFileFilter(filter);
		          int result = file.showSaveDialog(null);

		          if(result == JFileChooser.APPROVE_OPTION){
		              selectedFile = file.getSelectedFile();
		              path = selectedFile.getAbsolutePath();

	            	  label5.setText("File Selected: "+path);
	            	  label5.setVisible(true);
		          }

		          else if(result == JFileChooser.CANCEL_OPTION){
		            	label5.setText("Operation Cancelled");
						label5.setVisible(true);
		          }
		        }
	    });
		panel.add(setpic);
		
		label5.setVisible(false);
		panel.add(label5);
	
		
		repaint();																			//refresh
	}
}
