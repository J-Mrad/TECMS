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

import Exceptions.MovieNotFound;
import Exceptions.ShowRoomNotFound;
import Interface.Account;
import Interface.UsageLog;
import Schedules.Movies;
import Schedules.SchedulesSavingLoading;
import Schedules.SchedulingOperations;
import Schedules.ShowRooms;
import Schedules.Timee;

@SuppressWarnings("serial")
public class AddShow extends JFrame implements Adder{

	private JPanel panel = new JPanel();
	private JLabel label = new JLabel("Movie:");
	private JLabel label2 = new JLabel("ShowRoom:");
	private JLabel label3 = new JLabel("Date&Time:");
	
	
	private JLabel labelx1 = new JLabel("<HTML> A : Mon/Wed/Fri <br/> B : Tue/Thu <br/> C : Sat/Sun <br/> 1 : Morning <br/> 2 : Evening <br/> 3 : Night <br/> <br/> Ex: A2 </HTML>");

	
	private JTextField f1 = new JTextField(20);
	private JTextField f2 = new JTextField(20);
	private JTextField f3 = new JTextField(20);
	
	private JButton cancel = new JButton("Cancel");
	private JButton save = new JButton("Save");
	
	AddShow(Account A, ShowsLister SL){
		
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
		
		f1.setText("Movie");
		f2.setText("ShowRoom");
		f3.setText("a1");
		
		panel.add(labelx1);
		
		save.setLocation(170, 10);															//Save button:
		save.setSize(120, 20);
		save.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//Getting values:
				String a = f1.getText();
				String []b = f2.getText().split(",");
				String c = f3.getText();
				
				ShowRooms []SR = new ShowRooms[b.length];
				
				try {
					for(int i = 0 ; i < b.length ; i++) {
					
						SR[i] = SchedulingOperations.getShowRoom(Integer.parseInt(b[i]));
						if (SR[i] == null) throw new ShowRoomNotFound(b[i]);
					}
				}
				catch(ShowRoomNotFound ESR){
					
				}
				 
				UsageLog.add(A.getUsername() + " has added a new showroom");
				UsageLog.add(a + " - " + c);

				Movies M = null;
				
				try {
					
				M = SchedulingOperations.getMovie(a);
				
				if(M == null) throw new MovieNotFound(a);

				}
				catch(MovieNotFound E) {
					
					UsageLog.add("Movie not found ; operation aborted");
					
				}
				
				
				SchedulingOperations.addShow(M, SR,  Timee.getTimes(c));
				
				SchedulesSavingLoading.Save();
	            
				SL.dispose();
				
				new ShowsLister(A);

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
