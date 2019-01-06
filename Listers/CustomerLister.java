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

import Files.Customer_Save;
import Interface.Account;
import Interface.UsageLog;
import People.Customer;

@SuppressWarnings("serial")
public class CustomerLister extends JFrame{

	CustomerLister CL = this;  //sent as reference

	Color yellow = new Color(255,255,204);		//Background & Button colors

	JPanel content = new JPanel();					//Ading the scroll pane
    JScrollPane  Pane = new JScrollPane(content,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	JButton ok = new JButton("Close");  
	
	public CustomerLister(Account A){
		
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
        
		for(Customer C : Customer_Save.getList()) {
			
			JLabel text = new JLabel();
			text.setSize(470, 50);
			text.setText(C.getCustomerID() + " - " +
					C.getFirstName() + " " + C.getLastName() + " " + C.getage() + 
					" - Paid so far: " +
					C.getMoneyCustomerPaidSoFar() + " L.L. " +
					" Points: " + C.getLoyaltyPoints() +
					" Movies Watched: " + C.moviesWatchedCount

					);
			content.add(text);
		}
		
		

		ok.setLocation(680, 420);
		ok.setSize(100, 25);
		ok.addActionListener(new ActionListener() { //OnClick Event creation
			public void actionPerformed(ActionEvent e) {//On-clicked, perform the following:
				dispose();
			}
		} );
		add(ok);
		
		
		JButton addC = new JButton("Add Customer");  
		addC.setLocation(250, 420);
		addC.setSize(150, 25);
		addC.addActionListener(new ActionListener() { //OnClick Event creation
			public void actionPerformed(ActionEvent e) {//On-clicked, perform the following:

				UsageLog.add(A.getUsername() + " is adding a new customer");

				AddCust AC = new AddCust(A,CL);
				AC.setVisible(true);
				
			}
		} );
		add(addC);
	}
}
