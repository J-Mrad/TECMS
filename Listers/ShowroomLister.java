package Listers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import People.Customer;
import Schedules.Movies;
import Schedules.SchedulingOperations;
import Schedules.ShowRooms;

@SuppressWarnings("serial")
public class ShowroomLister extends JFrame implements Lister{

	Color yellow = new Color(255,255,204);		//Background & Button colors

	JPanel content = new JPanel();					//Ading the scroll pane
    JScrollPane  Pane = new JScrollPane(content,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    ShowroomLister(Customer C, Movies M){
		
		setSize(600,600);
		setTitle("Select ShowRoom");  
		setVisible(true);   
		setResizable(false);
		setLayout(null);
		setLocation(700,100);	
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));	//Adding border
		
        content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
        content.setBackground(yellow);
        Pane.getVerticalScrollBar().setUnitIncrement(16);
        Pane.setSize(594,500);
        getContentPane().add(Pane, BorderLayout.CENTER);
		
        for( ShowRooms S : SchedulingOperations.listMoviesShowRooms(M)) {
        	
        	JButton show = new JButton(S.toString());  
        	show.setPreferredSize(new Dimension(294,50));
        	show.setMinimumSize(new Dimension(294,50));
        	show.setMaximumSize(new Dimension(294,50));

        	show.setAlignmentX(Component.CENTER_ALIGNMENT);
        	
        	show.addActionListener(new ActionListener() { //OnClick Event creation
    			public void actionPerformed(ActionEvent e) {//On-clicked, perform the following:

    				
    				ShowTimeLister STL = new ShowTimeLister(C,M,S);
    				STL.setVisible(true);
    				
    				
    			dispose();

    			}
    			
    		} );
        	content.add(show);
        	
        	JPanel filler = new JPanel();
        	
        	filler.setPreferredSize(new Dimension(600,20));
        	filler.setMinimumSize(new Dimension(600,20));
        	filler.setMaximumSize(new Dimension(600,20));
        	content.add(filler);	
        		
        	
        }
	}
}
