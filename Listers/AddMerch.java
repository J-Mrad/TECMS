package Listers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Files.Merch_Save;
import Interface.Account;
import Interface.Popups;
import Interface.UsageLog;
import Merch.ActionFigures;
import Merch.GradeException;
import Merch.Posters;
import Merch.SizeException;
import Merch.ToyProps;
import Merch.Tshirts;
import People.Customer;


@SuppressWarnings("serial")
public class AddMerch extends JFrame implements Adder{
	
	JTextField f1 = new JTextField();
	JTextField f2 = new JTextField();
	JTextField f3 = new JTextField();
	JTextField f4 = new JTextField();
	JTextField f5 = new JTextField();
	JTextField f6 = new JTextField();
	JTextField f7 = new JTextField();
	JTextField f8 = new JTextField();
	JTextField f9 = new JTextField();
	JTextField f10 = new JTextField();
	JTextField f11 = new JTextField();
	
	JCheckBox TB1 = new JCheckBox("Fraamed");
	JCheckBox TB2 = new JCheckBox("Has Accessories");
	
	JCheckBox TB3 = new JCheckBox("Reformable: ");

	JCheckBox TB4 = new JCheckBox("Safe for children: ");
	JCheckBox TB5 = new JCheckBox("Collectible: ");
	
	JPanel panel = new JPanel();					//Ading the scroll pane
    JScrollPane  Pane = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
    JButton cancel = new JButton("Cancel");
	JButton save = new JButton("Save");
	
	public AddMerch(int v,Account A, MerchLister ML,Customer C){
	
		setUndecorated(true);																//Setting up the frame
		setSize(300,500);
		setTitle("Create Account");  
		setVisible(true);   
		setLayout(null);
		setLocation(1000,100);	
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));	//Adding border
																						
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        Pane.getVerticalScrollBar().setUnitIncrement(16);
        Pane.setSize(293,420);
        getContentPane().add(Pane, BorderLayout.CENTER);
     
        
		f1.setVisible(true);
		f2.setVisible(true);
		f3.setVisible(true);
		f4.setVisible(true);
		f5.setVisible(true);
		f6.setVisible(true);
		f7.setVisible(true);
		f8.setVisible(true);
		f9.setVisible(true);
		f10.setVisible(true);
		f11.setVisible(true);

		
		JLabel label1 = new JLabel("Product Name: ");
		f1.setText("Name");
		JLabel label2 = new JLabel("Movie Title: ");
		f2.setText("Shrek");
		JLabel label3 = new JLabel("Price: ");
		f3.setText("15000");
		JLabel label4 = new JLabel("Quantity: ");
		f4.setText("100");
		
		label1.setVisible(true);																					
		label2.setVisible(true);																					
		label3.setVisible(true);																					
		label4.setVisible(true);	
		
		panel.add(label1);
		panel.add(f1);
		panel.add(label2);
		panel.add(f2);
		panel.add(label3);
		panel.add(f3);
		panel.add(label4);
		panel.add(f4);
				
		if( v == 0 || v == 1 ) {
			
			JLabel label5 = new JLabel("Age group: ");
			f5.setText("10");
			JLabel label6 = new JLabel("Type: ");
			f6.setText("Mask");

			
			panel.add(label5);
			panel.add(f5);
			panel.add(label6);
			panel.add(f6);
			
			panel.add(TB1);
			panel.add(TB2);

		}
		
		if( v == 0 ) {
			
			JLabel label7 = new JLabel("Height: ");
			f7.setText("10");
			JLabel label8 = new JLabel("Grade: (1,2,3) ");
			f8.setText("2");
			JLabel label9 = new JLabel("Material: ");
			f9.setText("Wood");
			JLabel label10 = new JLabel("Charachter: ");
			f10.setText("Shrek");

			panel.add(label7);
			panel.add(f7);
			panel.add(label8);
			panel.add(f8);
			panel.add(label9);
			panel.add(f9);
			panel.add(label10);
			panel.add(f10);

			panel.add(TB3);
		}
		
		if( v == 1) {
			
			JLabel label7 = new JLabel("Depicts: ");
			f7.setText("Shrek");
			JLabel label8 = new JLabel("Weight: ");
			f8.setText("1");

			panel.add(label7);
			panel.add(f7);
			panel.add(label8);
			panel.add(f8);

			panel.add(TB4);
			panel.add(TB5);

		}
		
		if( v == 2 ) {
			
			JLabel label5 = new JLabel("Charachter: ");
			f5.setText("Shrek");

			JLabel label6 = new JLabel("Height: ");
			f6.setText("2");

			JLabel label7 = new JLabel("Width: ");
			f7.setText("3");

			JLabel label8 = new JLabel("Fabric: ");
			f8.setText("cotton");

			JLabel label9 = new JLabel("Res Height: ");
			f9.setText("22");

			JLabel label10 = new JLabel("Res Width: ");
			f10.setText("11");

			JLabel label11 = new JLabel("Pix density: ");
			f11.setText("1");

			panel.add(label5);
			panel.add(f5);
			panel.add(label6);
			panel.add(f6);
			panel.add(label7);
			panel.add(f7);
			panel.add(label8);
			panel.add(f8);
			panel.add(label9);
			panel.add(f9);
			panel.add(label10);
			panel.add(f10);
			panel.add(label11);
			panel.add(f11);

		}
		
		if( v == 3) {
			
			JLabel label5 = new JLabel("Size: (S,M,L) ");
			f5.setText("S");

			JLabel label6 = new JLabel("Fabric type: ");
			f6.setText("cotton");

			JLabel label7 = new JLabel("Made in: ");
			f7.setText("China");

			JLabel label8 = new JLabel("Color: ");
			f8.setText("Yellow");

			JLabel label9 = new JLabel("Type: ");
			f9.setText("LongSleeve");

			panel.add(label5);
			panel.add(f5);
			panel.add(label6);
			panel.add(f6);
			panel.add(label7);
			panel.add(f7);
			panel.add(label8);
			panel.add(f8);
			panel.add(label9);
			panel.add(f9);

		}
		
		
		save.setLocation(170, 430);															//Save button:
		save.setSize(120, 20);
		save.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				System.out.println(v);
				
				  if(v == 0) {

					try {
																					
						new ActionFigures(
								f1.getText(),
								f2.getText(),
								Float.parseFloat(f3.getText()),
								Integer.parseInt(f4.getText()),
								false,
								Integer.parseInt(f5.getText()),
								f6.getText(),
								TB1.isSelected(),
								TB2.isSelected(),
								Integer.parseInt(f7.getText()),
								Integer.parseInt(f8.getText()),
								f9.getText(),
								f10.getText(),
								TB3.isSelected() );
						
						UsageLog.add(A.getUsername() + " added ActionFigure");

						
					} catch (NumberFormatException | GradeException e1) {
						
						Popups.show("Error with input details");
						UsageLog.add("Input error ; operation aborted");
					}


				}
				
				  else if(v == 1) {
					
					try {
						new ToyProps(
								f1.getText(),
								f2.getText(),
								Float.parseFloat(f3.getText()),
								Integer.parseInt(f4.getText()),
								false,
								Integer.parseInt(f5.getText()),
								f6.getText(),
								TB1.isSelected(),
								TB2.isSelected(),
								f7.getText(),
								Float.parseFloat(f8.getText()),
								TB4.isSelected(),
								"N/A",
								TB5.isSelected() );
						
					UsageLog.add(A.getUsername() + " added Toy Prop");

					} catch (NumberFormatException E) {
						
						Popups.show("Error with input details");
						UsageLog.add("Input error ; operation aborted");
					}	
				}
				
				  else if(v == 2) {
					
					try {
						new Posters(
								f1.getText(),
								f2.getText(),
								Float.parseFloat(f3.getText()),
								Integer.parseInt(f4.getText()),
								false,
								f5.getText(),
								Integer.parseInt(f6.getText()),
								Integer.parseInt(f7.getText()),
								f8.getText(),
								Integer.parseInt(f9.getText()),
								Integer.parseInt(f10.getText()),
								Integer.parseInt(f11.getText())
								);
						
					UsageLog.add(A.getUsername() + " added Poster");

					} catch (NumberFormatException E) {
						
						Popups.show("Error with input details");
						UsageLog.add("Input error ; operation aborted");
					}	
				}
				
				  else if(v == 3) {
					try {
						new Tshirts(
								f1.getText(),
								f2.getText(),
								Float.parseFloat(f3.getText()),
								Integer.parseInt(f4.getText()),
								false,
								f5.getText().charAt(0),
								f6.getText(),
								f7.getText(),
								f9.getText(),
								f10.getText()
								);

					UsageLog.add(A.getUsername() + " added Tshirt");

						
					} catch (NumberFormatException | SizeException E) {
						
						Popups.show("Error with input details");
						UsageLog.add("Input error ; operation aborted");
					}	
				}

				dispose();
				
				ML.dispose();
				Merch_Save.SaveList();

				new MerchLister(A,C);
			}
		} );
		
		add(save);
		
		cancel.setLocation(170, 470);															//cancel button:
		cancel.setSize(120, 20);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UsageLog.add("Creation has been aborted");
				
			dispose();
			}
		} );
		add(cancel);
		
		
		repaint();																			//refresh
		
	}
	
	
}
