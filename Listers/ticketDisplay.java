package Listers;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Interface.Popups;
import Interface.UsageLog;
import People.Customer;
import Schedules.Movies;
import Schedules.ShowRooms;
import SeatChooser.Seat;

@SuppressWarnings("serial")
public class ticketDisplay extends JFrame implements Display{
	
	private JLabel t = new JLabel();	

	private String FilePatha = "./src/Interphotos/tick.png";
	
	public ticketDisplay(Customer C, Movies M, ShowRooms S, Calendar cal, Seat seat){
					
		setSize(200,300);  
		setVisible(true);   
		setLayout(null);
	    setResizable(false);
		setLocationRelativeTo(null);
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));	//Adding border
		
        try {
        	if(S.Type.equals("VIP")) {
        		        		
        		setContentPane(
            
        				new JLabel(
            				new ImageIcon(
            						ImageIO.read(
            								new File("./src/Interphotos/tickvip.png")
            								).getScaledInstance(185, 275, java.awt.Image.SCALE_SMOOTH)
            						)
            				)
            		);
        	}
        	else {
        		setContentPane(
        				new JLabel(
            				new ImageIcon(
            						ImageIO.read(
            								new File(FilePatha)
            								).getScaledInstance(185, 275, java.awt.Image.SCALE_SMOOTH)
            						)
            				)
            		);
        	}
        } catch (IOException e) {
        	Popups.show("Error printing ticket");
        }
        
		 t.setBackground(null);																//Some text
		 t.setForeground(Color.gray);
		 t.setBounds(40, 130, 100, 100);
		 t.setFont(new Font("Impact",Font.PLAIN,12));
		 t.setText("<html> Name: " + C.getFirstName() + " " + C.getLastName() + "<br/>" +
				 "Time: " + cal.getTime() +  "<br/>" +
				 "Showroom: " + S + " L.L. " +
				 "Seat: " + seat.i + Character.toString((char)('A' + seat.j))  + "</html>"
				 	);
		 
		 add(t);
		
			UsageLog.add("Ticket sold: Customer: " + C.getFirstName() + " " + C.getLastName() + " Price: " + S.getPrice() );

	}
}
