package Interface;

import javax.swing.JFrame;				//Basic swing display components
import javax.swing.JLabel;
import javax.swing.JPanel;

import Files.Clerk_Save;
import Files.Customer_Save;
import Files.Manager_Save;
import Files.Merch_Save;
import Files.StaticHandler;
import Food.FoodOperations;
import Food.FoodSavingLoading;
import Listers.CustomerLister;
import Listers.EmployeeLister;
import Listers.FoodLister;
import Listers.MerchLister;
import Listers.MovieLister;
import Listers.MovieManagementLister;
import Listers.ShowroomManagementLister;
import Listers.ShowsLister;
import People.Customer;
import Schedules.SchedulesSavingLoading;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;					//Spacing and design
import java.awt.Font;
import java.awt.event.WindowEvent;		//Changing the top-right X butotn to add a save command
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class Interface extends JFrame{
	
	private Color yellow = new Color(255,255,204);		//Background
	

	Interface(Account A){ 
		
		SchedulesSavingLoading.Load();
		Merch_Save.BuildList();
		Manager_Save.BuildList();
		Clerk_Save.BuildList();
		StaticHandler.LoadAll();
		Customer_Save.BuildList();
		FoodSavingLoading.Load();
		
		setLayout(null);								//Design
		setVisible(true);   
	    setSize(1200, 600);
	    setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Welcome,"+ A.getUsername() +"!");  
	    getContentPane().setBackground(yellow);
		addWindowListener(new WindowAdapter(){			//Adjusting the top-right 'X' button
		  public void windowClosing(WindowEvent we)
		  {
				UsageLog.add(A.getUsername() + " is signing off");
  
				SchedulesSavingLoading.Save();
				Merch_Save.SaveList();
				Manager_Save.SaveList();
				Clerk_Save.SaveList();
				Customer_Save.SaveList();
				StaticHandler.SaveAll();
				FoodSavingLoading.Save();
				
				UsageLog.add("Saved successful");

				  System.exit(0);
		  }
		 });
		
		JButton Log = new JButton("User Log");	//User Log
		Log.setSize(120,30);
		Log.setLocation(1050,20);
		Log.addActionListener(new ActionListener() { 							//OnClick Event: Create & Open user log sheet
			public void actionPerformed(ActionEvent e) {
				
				UsageLog u = new UsageLog();
				u.setVisible(true);
				
			}
		});
		add(Log);
		
		
		ProfImage pro = new ProfImage(A.getUsername());
		pro.setBounds(0,0,70,70);
		add(pro);
		
		JLabel name = new JLabel();
		name.setBackground(null);
		name.setForeground(Color.gray);
		name.setBounds(60, 10, 100, 20);
		name.setFont(new Font("Impact",Font.PLAIN,12));
		name.setText("Name: " + A.getUsername());
		add(name);
		
		repaint();
		
		//Manager stuff------------------------------------------------------------------------------------------------------------
				
		JButton employees = new JButton(
				new ImageIcon(
						(
								(
										new ImageIcon("./src/Interphotos/employees.png")
								
										).getImage()
								).getScaledInstance(95, 95, java.awt.Image.SCALE_SMOOTH)
						)
				);
		employees.setSize(100,100);
		employees.setLocation(20,60);
		employees.addActionListener(new ActionListener() { 							//OnClick Event: Create & Open employee sheet
			public void actionPerformed(ActionEvent e) {
				
				if(A.getAdmin() == true) {
					UsageLog.add(A.getUsername() + " has entered the Employees tab");

					EmployeeLister EL = new EmployeeLister(A);
					EL.setVisible(true);				
				}

 				else {
					Popups.show("You have to be a manager to access that part!");
					UsageLog.add(A.getUsername() + " attempted to enter Employees tab");
				}
			}
		});
		add(employees);
		
		
		
		JButton movie = new JButton(
				new ImageIcon(
						(
								(
										new ImageIcon("./src/Interphotos/movie.png")
								
										).getImage()
								).getScaledInstance(95, 95, java.awt.Image.SCALE_SMOOTH)
						)
				);
		movie.setSize(100,100);
		movie.setLocation(20,180);
		movie.addActionListener(new ActionListener() { 							//OnClick Event: Create & Open movie sheet
			public void actionPerformed(ActionEvent e) {
				
				if(A.getAdmin() == true) {
					UsageLog.add(A.getUsername() + " has entered the Movies tab");
					
					MovieManagementLister MML = new MovieManagementLister(A);
					MML.setVisible(true);
					
				}
				
				else {
					Popups.show("You have to be a manager to access that part!");
					UsageLog.add(A.getUsername() + " attempted to enter Movies tab");
				}
			}
		});
		add(movie);
		
		
		
		JButton room = new JButton(
				new ImageIcon(
						(
								(
										new ImageIcon("./src/Interphotos/room.png")
								
										).getImage()
								).getScaledInstance(95, 95, java.awt.Image.SCALE_SMOOTH)
						)
				);
		room.setSize(100,100);
		room.setLocation(20,300);
		room.addActionListener(new ActionListener() { 							//OnClick Event: Create & Open room sheet
			public void actionPerformed(ActionEvent e) {
				
				if(A.getAdmin() == true) {
					UsageLog.add(A.getUsername() + " has entered the Showrooms tab");

					new ShowroomManagementLister(A);
					
				}
				
				else {
					Popups.show("You have to be a manager to access that part!");
					UsageLog.add(A.getUsername() + " attempted to enter Showrooms tab");
				}
			}
		});
		add(room);
		
		
		
		
		JButton show = new JButton(
				new ImageIcon(
						(
								(
										new ImageIcon("./src/Interphotos/show.png")
								
										).getImage()
								).getScaledInstance(95, 95, java.awt.Image.SCALE_SMOOTH)
						)
				);
		show.setSize(100,100);
		show.setLocation(20,420);
		show.addActionListener(new ActionListener() { 							//OnClick Event: Create & Open room sheet
			public void actionPerformed(ActionEvent e) {
				
				if(A.getAdmin() == true) {
					UsageLog.add(A.getUsername() + " has entered the Shows tab");

					new ShowsLister(A);
					
				}
				
				else {
					Popups.show("You have to be a manager to access that part!");
					UsageLog.add(A.getUsername() + " attempted to enter Shows tab");
				}
			}
		});
		add(show);
		
		
		
		
		//----------------------------------------------------------------------------------------------------------------------------
		
		JPanel separator = new JPanel();
		
		separator.setBackground(Color.gray);
		separator.setBounds(150,20,20,500);
		add(separator);
		
		//Clerk Stuff-----------------------------------------------------------------------------------------------------------------
		
		
		
		
				
		JButton clients = new JButton(
				new ImageIcon(
						(
								(
										new ImageIcon("./src/Interphotos/clients.png")
								
										).getImage()
								).getScaledInstance(195, 195, java.awt.Image.SCALE_SMOOTH)
						)
				);
		clients.setSize(200,200);
		clients.setLocation(300,20);
		clients.addActionListener(new ActionListener() { 							//OnClick Event: Create & Open clients sheet
			public void actionPerformed(ActionEvent e) {
				
				UsageLog.add(A.getUsername() + " has entered the Customers tab");

				CustomerLister CL = new CustomerLister(A);
				CL.setVisible(true);
				
			}
		});
		add(clients);
		
		
		
		JButton tix = new JButton(
				new ImageIcon(
						(
								(
										new ImageIcon("./src/Interphotos/ticket.png")
								
										).getImage()
								).getScaledInstance(195, 195, java.awt.Image.SCALE_SMOOTH)
						)
				);
		tix.setSize(200,200);
		tix.setLocation(520,20);
		tix.addActionListener(new ActionListener() { 							//OnClick Event: Create & Open ticket sales sheet
			public void actionPerformed(ActionEvent e) {
				
				UsageLog.add(A.getUsername() + " has entered the Ticket sale tab");

				int ID = Popups.ShowAndGetValue("Enter the Customer ID");
				
				if (ID == -1) {

					UsageLog.add("Sale Aborted");
				}
				else {
					
					
					Customer C = Customer_Save.getByID(ID);
					
					if(C != null) {
						
						MovieLister ML = new MovieLister(C);
						ML.setVisible(true);
					}
					else {
						Popups.show("Customer ID not found, sale aborted");
						UsageLog.add("Customer ID not found, sale aborted");
					}
				}
			}
				
		});
		add(tix);
		
		
		
		
		JButton food = new JButton(
				new ImageIcon(
						(
								(
										new ImageIcon("./src/Interphotos/food.png")
								
										).getImage()
								).getScaledInstance(195, 195, java.awt.Image.SCALE_SMOOTH)
						)
				);
		food.setSize(200,200);
		food.setLocation(740,20);
		food.addActionListener(new ActionListener() { 							//OnClick Event: Create & Open food sales sheet
			public void actionPerformed(ActionEvent e) {
				
				UsageLog.add(A.getUsername() + " has entered the Food sale tab");

				int ID = Popups.ShowAndGetValue("Enter the Customer ID");
				
				if (ID == -1) {

					UsageLog.add("Sale Aborted");
				}
				else {
					Customer C = Customer_Save.getByID(ID);
					
					if(C != null) {
						
						FoodLister FL = new FoodLister(A,C);
						FL.setVisible(true);
					}
					else {
						Popups.show("Customer ID not found, sale aborted");
						UsageLog.add("Customer ID not found, sale aborted");
					}
				
				}
				
			}
		});
		add(food);
		
		
		
		
		
		JButton merch = new JButton(
				new ImageIcon(
						(
								(
										new ImageIcon("./src/Interphotos/merch.png")
								
										).getImage()
								).getScaledInstance(195, 195, java.awt.Image.SCALE_SMOOTH)
						)
				);
		merch.setSize(200,200);
		merch.setLocation(520,300);
		merch.addActionListener(new ActionListener() { 							//OnClick Event: Create & Open food sales sheet
			public void actionPerformed(ActionEvent e) {
				
				UsageLog.add(A.getUsername() + " has entered the Merch sale tab");

				int ID = Popups.ShowAndGetValue("Enter the Customer ID");
				
				if (ID == -1) {

					UsageLog.add("Sale Aborted");
				}
				else {
					Customer C = Customer_Save.getByID(ID);
					
					if(C != null) {

						MerchLister ML = new MerchLister(A,C);
						ML.setVisible(true);
						
					}
					else {
						Popups.show("Customer ID not found, sale aborted");
						UsageLog.add("Customer ID not found, sale aborted");
					}
				
				}
				
			}
		});
		add(merch);
		
		
		
		
		JButton foodres = new JButton(
				new ImageIcon(
						(
								(
										new ImageIcon("./src/Interphotos/foodres.png")
								
										).getImage()
								).getScaledInstance(195, 195, java.awt.Image.SCALE_SMOOTH)
						)
				);
		foodres.setSize(200,200);
		foodres.setLocation(300,300);
		foodres.addActionListener(new ActionListener() { 							//OnClick Event: Create & Open food sales sheet
			public void actionPerformed(ActionEvent e) {
				
				UsageLog.add(A.getUsername() + " has entered the Food Restock sale tab");

				String name = Popups.ShowAndGetString("Enter the Food name");
				
				if (name == null) {

					UsageLog.add("Sale Aborted");
				}
				else {
					
					int x = Popups.ShowAndGetValue("Quantity?");
					
					if(FoodOperations.addQuantity(name,x) == true ) {

						Popups.show("Added " + x + " to " + name);
						UsageLog.add("Added " + x + " to " + name);
						
					}
					else {
						Popups.show("Food not found, operation aborted");
						UsageLog.add("Food not found, operation aborted");
					}
				
				}
				
			}
		});
		add(foodres);
		
		
	}
	
	
	
}