package Interface;

import java.awt.Font;					//Design
import java.awt.Color;
	
import java.awt.event.ActionEvent;		//Buttons
import java.awt.event.ActionListener;

import javax.swing.JFrame;				//Basic swing cmponents
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JProgressBar;

import javax.swing.BorderFactory;

@SuppressWarnings("serial")
public class Loading extends JFrame{
	
	private JButton b = new RoundButton("Open");  
	private JButton Login = new JButton("Login");  
	private JButton reset = new JButton("Log out");  
	private JButton top = new JButton("Create Account");  

	private JLabel text = new JLabel();	
	private JLabel welc = new JLabel();
	private JProgressBar progressBar = new JProgressBar();
		
	protected AccountManager AM = new AccountManager();

	
	Loading(){																				//Initialize main loading screen

		
		UsageLog.BuildList();
				
		UsageLog.add( " ========= Log in number: " + UsageLog.loginCount + " =========");
		
		UsageLog.add("Guest has opened the program");
		
		AccountManager.BuildList();
		
		Loading L = this;			//Sent as reference
		
		setUndecorated(true);
		setLayout(null);
		setVisible(true);
		setSize(600,300);  
		setLocationRelativeTo(null);
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan)); 	//Adding border


		text.setBackground(null);																//Some text
		text.setForeground(Color.gray);
		text.setBounds(10, 280, 200, 20);
		text.setFont(new Font("Impact",Font.PLAIN,12));
		text.setText("Made with love.. and hours of coding");
		 add(text);
		 
		 welc.setBackground(null);
		 welc.setForeground(Color.gray);
		 welc.setBounds(60, 10, 200, 40);
		 welc.setFont(new Font("Impact",Font.PLAIN,20));
		 welc.setText("Welcome!");
		 add(welc);
		    
	    
	    

	    this.getContentPane().add(progressBar);												//Loading bar

	    progressBar.setStringPainted(true);
	    progressBar.setForeground(Color.orange);
	    progressBar.setBounds(125, 245, 350, 20);
	    
	    
		b.setLocation(240, 80);
		b.setSize(120, 120);
		b.addActionListener(new ActionListener() { //OnClick Event: Run program
			public void actionPerformed(ActionEvent e) {
				

			b.setText("Please Login");
			
			}
			
		} );
		add(b);
		
		
		top.setBorder(new RoundBorder(10));
		top.setSize(160, 20);
		top.setLocation(420, 10);
		top.setBorderPainted(false);
		top.addActionListener(new ActionListener() { //OnClick Event: open profile creation page
			public void actionPerformed(ActionEvent e) {
				
				UsageLog.add("Guest is atempting to create a new account");
				
				Create_Account cre = new Create_Account(L);
				cre.setVisible(true);
			}
		} );
		add(top);
		
		Login.setBorder(new RoundBorder(10));
		Login.setSize(160, 20);
		Login.setLocation(420, 40);
		Login.setBorderPainted(false);
		Login.addActionListener(new ActionListener() { //OnClick Event: open login page
			public void actionPerformed(ActionEvent e) {
				
				UsageLog.add("Guest is attempting to log in");
				
				Login cre = new Login(L);
				cre.setVisible(true);
			}
		} );
		add(Login);
		
		
		ProfImage pro = new ProfImage("backup");
		pro.setBounds(0,0,330,330);
		add(pro);
		
		repaint();
	}
	
	
	
	
	Loading(Account A){																		//Initialize main loading screen
		
		UsageLog.add( A.getUsername() + " has opened the program");
		
		setUndecorated(true);
		setLayout(null);
		setVisible(true);
		setSize(600,300);  
		setLocationRelativeTo(null);
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan)); 	//Adding border


		text.setBackground(null);																//Some text
		text.setForeground(Color.gray);
		text.setBounds(10, 280, 200, 20);
		text.setFont(new Font("Impact",Font.PLAIN,12));
		text.setText("Made with love.. and hours of coding");
		 add(text);
		 
		 welc.setBackground(null);
		 welc.setForeground(Color.gray);
		 welc.setBounds(60, 10, 200, 40);
		 welc.setFont(new Font("Impact",Font.PLAIN,20));
		 welc.setText("Welcome back, "+ A.getUsername() + " !");
		 add(welc);
		    
	    
	    

	    this.getContentPane().add(progressBar);												//Loading bar

	    progressBar.setStringPainted(true);
	    progressBar.setForeground(Color.orange);
	    progressBar.setBounds(125, 245, 350, 20);
	    
	    
		b.setLocation(240, 80);
		b.setSize(120, 120);
		b.addActionListener(new ActionListener() { //OnClick Event: Run program
			public void actionPerformed(ActionEvent e) {
				
				if(true) {
					
				
					//Progress bar:
					for (int i = 0; i < 100; i = i + 3) {//Fill
						progressBar.setValue(i);
						progressBar.update(progressBar.getGraphics());
						try{
							Thread.sleep(30);
						}
						catch(Exception e1){
							//Wait(0.5);
						}
					}
			    
					dispose();//End frame
			    
					UsageLog.add( A.getUsername() + " has gained Interface access");
					
					Interface I = new Interface(A);//Open interface
					I.setVisible(true);
				}
			}
		} );
		add(b);
		
		
		reset.setLocation(420, 10);															//Reset button:
		reset.setSize(160, 20);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				UsageLog.add( A.getUsername() + " has logged out");
				UsageLog.add( A.getUsername() + " is now known as Guest");

				
				dispose();
				Loading F = new Loading();
				F.setVisible(true);
			}
		} );
		add(reset);
		
		
		ProfImage pro = new ProfImage(A.getUsername());
		pro.setBounds(0,0,330,330);
		add(pro);
		
		repaint();
	}
	
	
	 public static void main(String args[]) throws InterruptedException {
		
		 Loading L = new Loading();
		 
		 L.setVisible(true);
		 
	 }
}