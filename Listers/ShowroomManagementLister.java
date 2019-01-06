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
import Interface.UsageLog;
import Schedules.SchedulingOperations;
import Schedules.ShowRooms;


@SuppressWarnings("serial")
public class ShowroomManagementLister extends JFrame implements Lister {

	ShowroomManagementLister SML = this; //sent as reference
	
	Color yellow = new Color(255,255,204);		//Background & Button colors

	JPanel content = new JPanel();					//Ading the scroll pane
    JScrollPane  Pane = new JScrollPane(content,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	JButton ok = new JButton("Close");  
	
	public ShowroomManagementLister(Account A) {
		
		
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
        
        for(ShowRooms Sh : SchedulingOperations.listShowRooms()) {
        	
        	JLabel text1 = new JLabel();
			text1.setForeground(Color.black);
			text1.setSize(470, 50);
			text1.setText(Sh.toString());
			content.add(text1);
			 
        }
     
		JButton addM = new JButton("Add ShowRoom");  
		addM.setLocation(80, 420);
		addM.setSize(150, 25);
		addM.addActionListener(new ActionListener() { //OnClick Event creation
			public void actionPerformed(ActionEvent e) {//On-clicked, perform the following:

				UsageLog.add(A.getUsername() + " is adding a new ShowRoom");

				new AddShowRoom(A,SML);
				
			}
		} );
		add(addM);
		
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
