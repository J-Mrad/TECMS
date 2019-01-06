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

import Files.Clerk_Save;
import Files.Manager_Save;
import Interface.Account;
import Interface.Popups;
import Interface.UsageLog;
import People.Clerk;
import People.Manager;

@SuppressWarnings("serial")
public class EmployeeLister extends JFrame implements Lister{
	
	EmployeeLister EL = this; //Sent as reference
	
	
	Color yellow = new Color(255,255,204);		//Background & Button colors

	JPanel content = new JPanel();					//Ading the scroll pane
    JScrollPane  Pane = new JScrollPane(content,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	JButton ok = new JButton("Close");  
	
	
	public EmployeeLister(Account A){
		
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
        
        
        
		for(Manager M : Manager_Save.getList()) {
			
			JLabel text1 = new JLabel();
			text1.setForeground(Color.black);
			text1.setSize(470, 50);
			text1.setText(M.getEmployeeID() + " - " +
					M.getFirstName() + " " + M.getLastName() + " " + M.getage() +
					" -  Hourly: " + M.getHourlyWage() + " Weekly Hours: "
					+ M.getHoursPerWeek() + " - Shift: " + M.getshiftStartingHour() + " to " + M.getshiftEndingHour() );
			content.add(text1);
		}
		
		
		for(Clerk C : Clerk_Save.getList()) {
			
			JLabel text2 = new JLabel();
			text2.setForeground(Color.DARK_GRAY);
			text2.setSize(470, 50);
			text2.setText(C.getEmployeeID() + " - " +
					C.getFirstName() + " " + C.getLastName() + " " + C.getage() +
					" -  Hourly: " + C.getHourlyWage() + " Weekly Hours: "
					+ C.getHoursPerWeek() + " - Shift: " + C.getshiftStartingHour() + " to " + C.getshiftEndingHour() );
			content.add(text2);
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
		
		
		
		JButton addM = new JButton("Add Manager");  
		addM.setLocation(80, 420);
		addM.setSize(150, 25);
		addM.addActionListener(new ActionListener() { //OnClick Event creation
			public void actionPerformed(ActionEvent e) {//On-clicked, perform the following:

				UsageLog.add(A.getUsername() + " is adding a new manager");
				
				AddEmp AE = new AddEmp(A,0,EL);
				AE.setVisible(true);
				
			
			}
		} );
		add(addM);
		
		
		JButton addC = new JButton("Add Clerk");  
		addC.setLocation(250, 420);
		addC.setSize(150, 25);
		addC.addActionListener(new ActionListener() { //OnClick Event creation
			public void actionPerformed(ActionEvent e) {//On-clicked, perform the following:

				UsageLog.add(A.getUsername() + " is adding a new clerk");

				AddEmp AE = new AddEmp(A,1,EL);
				AE.setVisible(true);

			}
		} );
		add(addC);
		
		
		JButton rem = new JButton("Remove Employee");  
		rem.setLocation(430, 420);
		rem.setSize(150, 25);
		rem.addActionListener(new ActionListener() { //OnClick Event creation
			public void actionPerformed(ActionEvent e) {//On-clicked, perform the following:

				UsageLog.add(A.getUsername() + " is firing an employee");

				int x = Popups.ShowAndGetValue("Enter ID of employee");
				
				if (Manager.RemoveEmployee(x,A)) {
												
						
					dispose();
						
					EmployeeLister EL2 = new EmployeeLister(A);
					EL2.setVisible(true);

				}		
			
			}
		} );
		add(rem);
		
		
	}
	
}
