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
import Merch.ActionFigures;
import People.Customer;

import Merch.*;

@SuppressWarnings("serial")
public class MerchLister extends JFrame implements Lister{
	
	MerchLister ML = this; //Sent as reference
	
	
	Color yellow = new Color(255,255,204);		//Background & Button colors

	JPanel content = new JPanel();					//Ading the scroll pane
    JScrollPane  Pane = new JScrollPane(content,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	JButton ok = new JButton("Close");  
	
	CustomerShoppingCart CSC = new CustomerShoppingCart();

	public MerchLister(Account A,Customer C){
		
		setSize(800,500);  
		setVisible(true);   
		setLayout(null);
	    setResizable(false);
		setLocationRelativeTo(null);
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));	//Adding border
		
        content.setLayout(new BoxLayout(content,BoxLayout.PAGE_AXIS));
        content.setBackground(yellow);
        Pane.getVerticalScrollBar().setUnitIncrement(16);
        Pane.setSize(653,420);
        getContentPane().add(Pane, BorderLayout.CENTER);
        
        
		JLabel text = new JLabel();
		text.setForeground(Color.black);
		text.setSize(470, 50);
		text.setText("Tshirts:"
				
				);
		content.add(text);
		
		for(Tshirts TS : Tshirts.getTshirtsList()) {
			
			JLabel text1 = new JLabel();
			text1.setForeground(Color.black);
			text1.setSize(470, 50);
			text1.setText(
				" " + TS.getProductID() + " - " + 
			TS.getProductName() + " - " + 
						//TS.getMovie().Title + " - " +
			TS.getPrice() + " - " + 
						TS.getQuantity()
					);
			content.add(text1);
			
			JLabel text12 = new JLabel();
			text12.setForeground(Color.black);
			text12.setSize(470, 50);
			text12.setText(
				"     Size: " + TS.getSize() + " -Made in: " + TS.getMadeIn() + " -Fabric: " + TS.getFabricType() + " -Color: " + TS.getColor() 
					);
			content.add(text12);
		}
		
        
		JLabel textAF = new JLabel();
		textAF.setForeground(Color.black);
		textAF.setSize(470, 50);
		textAF.setText("Action Figures:"
				
				);
		content.add(textAF);
		
		for(ActionFigures AF : ActionFigures.getActionFiguresList()) {
			
			JLabel text1 = new JLabel();
			text1.setForeground(Color.black);
			text1.setSize(470, 50);
			text1.setText(
				" " + AF.getProductID() + " - " + AF.getProductName() + " - " + AF.getMovie() + " - " + AF.getPrice() + " L.L - " + AF.getQuantity() + "In stock "
					);
			content.add(text1);
			
			JLabel text12 = new JLabel();
			text12.setForeground(Color.black);
			text12.setSize(470, 50);
			text12.setText(
				"     -Age Group: " + AF.getAgeGroup() + " -Type: " + AF.getType() + " -Framed: " + AF.isFramed() + " -HasAccessories: " + AF.isHasAccessories() 
					);
			content.add(text12);
			
			JLabel text2 = new JLabel();
			text2.setForeground(Color.black);
			text2.setSize(470, 50);
			text2.setText(
				"     Height: " + AF.getHeight() + " -Grade: " + AF.getGrade() + " -Material: " + AF.getMaterial() + " -Charachter: " + AF.getCharacter() + " Reformable: " + AF.isReformable()
					);
			content.add(text2);
			
		}
		
		
		JLabel textTP = new JLabel();
		textTP.setForeground(Color.black);
		textTP.setSize(470, 50);
		textTP.setText("Toy Props:"
				
				);
		content.add(textTP);

		for(ToyProps AF : ToyProps.getToyPropsList()) {
			
			JLabel text1 = new JLabel();
			text1.setForeground(Color.black);
			text1.setSize(470, 50);
			text1.setText(
				" " + AF.getProductID() + " - " + AF.getProductName() + " - " + AF.getMovie() + " - " + AF.getPrice() + "L.L - " + AF.getQuantity() + "In stock "
					);
			content.add(text1);
			
			JLabel text12 = new JLabel();
			text12.setForeground(Color.black);
			text12.setSize(470, 50);
			text12.setText(
				"     -Age Group: " + AF.getAgeGroup() + " -Type: " + AF.getType() + " -Framed: " + AF.isFramed() + " -HasAccessories: " + AF.isHasAccessories() 
					);
			content.add(text12);
			
			JLabel text2 = new JLabel();
			text2.setForeground(Color.black);
			text2.setSize(470, 50);
			text2.setText(
				"     Depicts: " + AF.getDepicts() + " -Weight: " + AF.getWeight() + " -Safe4Kids: " + AF.isSafeForChildren() + " Collectible: " + AF.isACollectable()
					);
			content.add(text2);
			
		}
		
		JLabel textPOS = new JLabel();
		textPOS.setForeground(Color.black);
		textPOS.setSize(470, 50);
		textPOS.setText("Posters:"
				
				);
		content.add(textPOS);
		
		for(Posters AF : Posters.getPostersList()) {
			
			JLabel text1 = new JLabel();
			text1.setForeground(Color.black);
			text1.setSize(470, 50);
			text1.setText(
				" " + AF.getProductID() + " - " + AF.getProductName() + " - " + AF.getMovie()  + " - " + AF.getPrice() + " - " + AF.getQuantity()+ "In stock "
					);
			content.add(text1);
			
			JLabel text12 = new JLabel();
			text12.setForeground(Color.black);
			text12.setSize(470, 50);
			text12.setText(
				"     -Charachter: " + AF.getCharacterDisplayed() + " -Dimensions: " + AF.getHeight() + " x " + AF.getWidth() 
					);
			content.add(text12);
					
			JLabel text2 = new JLabel();
			text2.setForeground(Color.black);
			text2.setSize(470, 50);
			text2.setText(
				"     -Fabric: " + AF.getFabricType() + " -Resolution: " + AF.getResolution_width() + "x" + AF.getResolution_height()
					);
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
		
		
		JButton sss = new JButton("+Cart");  
		sss.setLocation(680, 380);
		sss.setSize(100, 25);
		sss.addActionListener(new ActionListener() { //OnClick Event creation
			public void actionPerformed(ActionEvent e) {//On-clicked, perform the following:

				UsageLog.add(A.getUsername() + " is selling merch");
								
				int x = Popups.ShowAndGetValue("ID of merch?");
				Merchandise val = Merchandise.getFromID(x);
				if(val != null) {
					CSC.AddItem(val);
					Popups.show("Added! Current items: " + CSC.getNumberOfItems() + " Price: " + CSC.getTotalPrice() );
					UsageLog.add("Added " + x);

				}
				else {
					Popups.show("Item" + x + "does not exist");
					UsageLog.add("sale aborted");

				}				
				
			}
		} );
		add(sss);
		
		JButton ccc = new JButton("Checkout");  
		ccc.setLocation(680, 340);
		ccc.setSize(100, 25);
		ccc.addActionListener(new ActionListener() { //OnClick Event creation
			public void actionPerformed(ActionEvent e) {//On-clicked, perform the following:

				UsageLog.add(A.getUsername() + " is selling merch to " + C.getFirstName());
				
				if(CSC.getTotalPrice() != 0) {

					new ReceiptDisplay(A,C,CSC.getNumberOfItems(),CSC.getTotalPrice());
					
					Popups.show(C.getFirstName() + " paid " + CSC.getTotalPrice());

				}
				else {
					Popups.show("Cart is empty!");
					UsageLog.add("Cart empty");

				}				
				
			}
		} );
		add(ccc);
		
		JButton addM = new JButton("+ActionFig");  
		addM.setLocation(150, 420);
		addM.setSize(100, 25);
		addM.addActionListener(new ActionListener() { //OnClick Event creation
			public void actionPerformed(ActionEvent e) {//On-clicked, perform the following:

				UsageLog.add(A.getUsername() + " is adding Action Figures");

				AddMerch AM1 = new AddMerch(0,A,ML,C);
				AM1.setVisible(true);
			}
		} );
		add(addM);
		
		JButton addT = new JButton("+ToyProps");  
		addT.setLocation(250, 420);
		addT.setSize(100, 25);
		addT.addActionListener(new ActionListener() { //OnClick Event creation
			public void actionPerformed(ActionEvent e) {//On-clicked, perform the following:

				UsageLog.add(A.getUsername() + " is adding Toy Props");

				AddMerch AM2 = new AddMerch(1,A,ML,C);
				AM2.setVisible(true);
			
			}
		} );
		add(addT);
		
		JButton addPM = new JButton("+Posters");  
		addPM.setLocation(350, 420);
		addPM.setSize(100, 25);
		addPM.addActionListener(new ActionListener() { //OnClick Event creation
			public void actionPerformed(ActionEvent e) {//On-clicked, perform the following:

				UsageLog.add(A.getUsername() + " is adding Posters");

				AddMerch AM3 = new AddMerch(2,A,ML,C);
				AM3.setVisible(true);
			
			}
		} );
		add(addPM);
		
		JButton addTM = new JButton("+Tshirts");  
		addTM.setLocation(450, 420);
		addTM.setSize(100, 25);
		addTM.addActionListener(new ActionListener() { //OnClick Event creation
			public void actionPerformed(ActionEvent e) {//On-clicked, perform the following:

				UsageLog.add(A.getUsername() + " is adding TShirts");

				AddMerch AM4 = new AddMerch(3,A,ML,C);
				AM4.setVisible(true);
			
			}
		} );
		add(addTM);
		
		
		repaint();																			//refresh

	}
	
}
