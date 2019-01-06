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

import Food.Food;
import Food.FoodOperations;
import Interface.Account;
import Interface.Popups;
import Interface.UsageLog;
import People.Customer;

@SuppressWarnings("serial")
public class ReceiptDisplay extends JFrame implements Display{
	
	private JLabel t = new JLabel();	

	private String FilePath = "./src/Interphotos/recpt.png";
	
	public ReceiptDisplay(Account A, Customer C,String S, Food f){
		
		setSize(200,300);  
		setVisible(true);   
		setLayout(null);
	    setResizable(false);
		setLocationRelativeTo(null);
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));	//Adding border
		
        try {
            setContentPane(
            		new JLabel(
            				new ImageIcon(
            						ImageIO.read(
            								new File(FilePath)
            								).getScaledInstance(185, 275, java.awt.Image.SCALE_SMOOTH)
            						)
            				)
            		);
        } catch (IOException e) {
        	Popups.show("Error printing receipt! Call IT to check printer");
        }
        
		 t.setBackground(null);																//Some text
		 t.setForeground(Color.gray);
		 t.setBounds(40, 90, 100, 100);
		 t.setFont(new Font("Impact",Font.PLAIN,12));
		 t.setText("<html> Your Server : " + A.getUsername() + "<br/>" + 
		 "Name: " + C.getFirstName() + " " + C.getLastName() + "<br/>" +
				 "Time: " + Calendar.getInstance().getTime().toString() +  "<br/>" +
				 "Food: " + S + " " + FoodOperations.getName(f) + "<br/>" +
				 "Price: " + f.cost + "</html>"
				 	);
		 
		 add(t);
		
			UsageLog.add(S + " " + FoodOperations.getName(f) + "sold to " + C.getFirstName() + " " + C.getLastName() + " for " + f.cost + "L.L");

	}
	
	public ReceiptDisplay(Account A, Customer C,int items, float price){
		
		setSize(200,300);  
		setVisible(true);   
		setLayout(null);
	    setResizable(false);
		setLocationRelativeTo(null);
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));	//Adding border
		
        try {
            setContentPane(
            		new JLabel(
            				new ImageIcon(
            						ImageIO.read(
            								new File("./src/Interphotos/recpt.png")
            								).getScaledInstance(185, 275, java.awt.Image.SCALE_SMOOTH)
            						)
            				)
            		);
        } catch (IOException e) {
        	Popups.show("Error printing receipt! Call IT to check printer");
        }
        
		 t.setBackground(null);																//Some text
		 t.setForeground(Color.gray);
		 t.setBounds(40, 90, 100, 100);
		 t.setFont(new Font("Impact",Font.PLAIN,12));
		 t.setText("<html> Your Server : " + A.getUsername() + "<br/>" + 
		 "Name: " + C.getFirstName() + " " + C.getLastName() + "<br/>" +
				 "Time: " + Calendar.getInstance().getTime().toString() +  "<br/>" +
				 "Items: " + items + "<br/>" +
				 "Price: " + price + "</html>"
				 	);
		 
		 add(t);
		
	}
}