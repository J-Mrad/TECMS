package Listers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Interface.Account;
import Interface.Popups;
import Interface.UsageLog;
import Schedules.Movies;
import Schedules.SchedulingOperations;


@SuppressWarnings("serial")
public class MovieManagementLister extends JFrame implements Lister {

	MovieManagementLister MML = this; //sent as reference
	
	Color yellow = new Color(255,255,204);		//Background & Button colors

	JPanel content = new JPanel();					//Ading the scroll pane
    JScrollPane  Pane = new JScrollPane(content,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	JButton ok = new JButton("Close");  
	
	public MovieManagementLister(Account A) {
		
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
        
        for(Movies M : SchedulingOperations.listMovies()) {
        	
        	JLabel text1 = new JLabel();
			text1.setForeground(Color.black);
			text1.setSize(470, 50);
			text1.setText(SchedulingOperations.listActors(M).isEmpty() ? M.toString() : M.toString() + " Cast: " );
			content.add(text1);
			
			 for(Movies.Actors A1 : SchedulingOperations.listActors(M)) {
			 
				 JLabel text2 = new JLabel();
					text2.setForeground(Color.black);
					text2.setSize(470, 50);
					text2.setText(A1.toString()
							);
					content.add(text2);
			 }
			 
        }
     
		JButton addM = new JButton("Add Movie");  
		addM.setLocation(80, 420);
		addM.setSize(150, 25);
		addM.addActionListener(new ActionListener() { //OnClick Event creation
			public void actionPerformed(ActionEvent e) {//On-clicked, perform the following:

				UsageLog.add(A.getUsername() + " is adding a new movie");
				
				AddMovie AM = new AddMovie(A,MML);
				AM.setVisible(true);
			}
		} );
		add(addM);
        
		JButton addAc = new JButton("Add Actor");  
		addAc.setLocation(250, 420);
		addAc.setSize(150, 25);
		addAc.addActionListener(new ActionListener() { //OnClick Event creation
			public void actionPerformed(ActionEvent e) {//On-clicked, perform the following:

				UsageLog.add(A.getUsername() + " is adding a new actor");
				
				String s = Popups.ShowAndGetString("Which movie?");
				if( s != null) {
					Movies M = SchedulingOperations.getMovie(s);
					if(M != null) {
						AddActor AA = new AddActor(A,MML,M);
						AA.setVisible(true);	
					}
					else{
						Popups.show("Movie does not exist!");
					
						UsageLog.add("Movie name not found ; operation cancelled");
					}
				}
				
				else{
					UsageLog.add("Operation cancelled");
				}
				
			}
		} );
		add(addAc);
		
		JButton ok = new JButton("Close");  
		ok.setLocation(680, 420);
		ok.setSize(100, 25);
		ok.addActionListener(new ActionListener() { //OnClick Event creation
			public void actionPerformed(ActionEvent e) {//On-clicked, perform the following:
				dispose();
			}
		} );
		add(ok);
		
	}
}
