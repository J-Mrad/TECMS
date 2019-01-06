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

import Interface.UsageLog;
import People.Customer;
import Schedules.Movies;
import Schedules.SchedulingOperations;

@SuppressWarnings("serial")
public class MovieLister extends JFrame implements Lister{
	
	Color yellow = new Color(255,255,204);		//Background & Button colors

	JPanel content = new JPanel();					//Ading the scroll pane
    JScrollPane  Pane = new JScrollPane(content,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    
	public MovieLister(Customer C) {

		setSize(600,600);
		setTitle("Select Movie");  
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
        
        
        for( Movies M : SchedulingOperations.listMovies() ) {
        	
        	JButton mov = new JButton(SchedulingOperations.getTitle(M));  
        	mov.setPreferredSize(new Dimension(294,50));
        	mov.setMinimumSize(new Dimension(294,50));
        	mov.setMaximumSize(new Dimension(294,50));

        	mov.setAlignmentX(Component.CENTER_ALIGNMENT);
        	
        	mov.addActionListener(new ActionListener() { //OnClick Event creation
    			public void actionPerformed(ActionEvent e) {//On-clicked, perform the following:

    			Movies selected = SchedulingOperations.getMovie(mov.getText());

    			ShowroomLister SL = new ShowroomLister(C,selected);
    			SL.setVisible(true);
    			
    			dispose();

    			}
    			
    		} );
        	content.add(mov);
        	
        	JPanel filler = new JPanel();
        	
        	filler.setPreferredSize(new Dimension(600,20));
        	filler.setMinimumSize(new Dimension(600,20));
        	filler.setMaximumSize(new Dimension(600,20));
        	content.add(filler);	
        		
        }
      
        
    	JButton cancel = new JButton("Cancel");
        cancel.setLocation(50, 540);															//cancel button:
		cancel.setSize(100, 40);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UsageLog.add("Sale has been aborted");
				
			dispose();
			}
		} );
		add(cancel);
		
	}
	

}
