package Listers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Exceptions.MovieNotFound;
import Interface.Account;
import Interface.Popups;
import Interface.UsageLog;
import Schedules.Movies;
import Schedules.Schedules;
import Schedules.SchedulingOperations;

@SuppressWarnings("serial")

public class ShowsLister extends JFrame implements Lister{
	
	ShowsLister SL = this; //Sent as reference
	
	
	Color yellow = new Color(255,255,204);		//Background & Button colors

	JPanel content = new JPanel();					//Ading the scroll pane
    JScrollPane  Pane = new JScrollPane(content,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	JButton ok = new JButton("Close");  
	
	
	public ShowsLister(Account A){
		
		setSize(800,500);  
		setVisible(true);   
		setLayout(null);
	    setResizable(false);
		setLocationRelativeTo(null);
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));	//Adding border
		
        content.setLayout(new BoxLayout(content,BoxLayout.PAGE_AXIS));
        content.setBackground(yellow);
        Pane.getVerticalScrollBar().setUnitIncrement(16);
        Pane.setSize(693,420);
        getContentPane().add(Pane, BorderLayout.CENTER);
        
        
        
		for(Schedules S : Schedules.schedules) {
			
			JLabel text1 = new JLabel();
			text1.setForeground(Color.black);
			text1.setSize(470, 50);
			text1.setText(S.movie.Title
						);
			content.add(text1);
			
			for(Schedules.Show Sh : S.shows) {
				JLabel text2 = new JLabel();
				text2.setForeground(Color.black);
				text2.setSize(470, 50);
				text2.setText("       " + Sh.showRooms.toString()
							);
				content.add(text2);
				
				for(Calendar C : Sh.showTimes) {
					JLabel text3 = new JLabel();
					text3.setForeground(Color.black);
					text3.setSize(470, 50);
					text3.setText("              " + C.getTime().toString()
								);
					content.add(text3);
				}
			}
			
		}
		
		
		
		JButton ok = new JButton("Close");  
		ok.setLocation(680, 420);
		ok.setSize(100, 25);
		ok.addActionListener(new ActionListener() { //OnClick Event creation
			public void actionPerformed(ActionEvent e) {//On-clicked, perform the following:
				dispose();
			}
		} );
		add(ok);
		
		
		
		JButton addM = new JButton("Add Show");  
		addM.setLocation(80, 420);
		addM.setSize(150, 25);
		addM.addActionListener(new ActionListener() { //OnClick Event creation
			public void actionPerformed(ActionEvent e) {//On-clicked, perform the following:

				UsageLog.add(A.getUsername() + " is adding a new show");
				
			
				new AddShow(A,SL);
				
			}
		} );
		add(addM);
		
		
		JButton rem = new JButton("Remove Show");  
		rem.setLocation(430, 420);
		rem.setSize(150, 25);
		rem.addActionListener(new ActionListener() { //OnClick Event creation
			public void actionPerformed(ActionEvent e) {//On-clicked, perform the following:

				UsageLog.add(A.getUsername() + " is removing a show");
				
				String sMov = Popups.ShowAndGetString("Movie name?");
				
				Movies M = null;
				
				try {
					
				M = SchedulingOperations.getMovie(sMov);
				
				if(M == null) throw new MovieNotFound(sMov);

				}
				catch(MovieNotFound E) {
					
					UsageLog.add("Movie not found ; operation aborted");
					
				}
				
				
				Schedules.schedules.remove(SchedulingOperations.getSchedule(M));
				
				dispose();
				
				new ShowsLister(A);
				
			}
		} );
		add(rem);
		
		
	}
	

}
