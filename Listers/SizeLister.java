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

import Food.Food;
import Food.FoodOperations;
import Food.FoodSavingLoading;
import Food.FoodOperations.CheckOut;
import Food.Utils;
import Interface.Account;
import Interface.Popups;
import Interface.UsageLog;
import People.Customer;

@SuppressWarnings("serial")
public class SizeLister extends JFrame implements Lister{

	
	Color yellow = new Color(255,255,204);		//Background & Button colors

	JPanel content = new JPanel();					//Ading the scroll pane
    JScrollPane  Pane = new JScrollPane(content,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	JButton ok = new JButton("Close"); 
	
	public SizeLister(Account A, Customer C, Food f){
		
		setSize(600,600);
		setTitle("Select Size");  
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
        
        
        for( int i = 0 ; i < FoodOperations.getSizes(f).length ; i++ ) {

        	final int t = i;

        	if(FoodOperations.getSizes(f)[i]) {
        		
        		JButton sz = new JButton(i == 0 ? Utils.SIZE_SMALL : i == 1 ? Utils.SIZE_MEDIUM : Utils.SIZE_LARGE );  
        		sz.setPreferredSize(new Dimension(294,50));
        		sz.setMinimumSize(new Dimension(294,50));
        		sz.setMaximumSize(new Dimension(294,50));
        		
        		sz.setAlignmentX(Component.CENTER_ALIGNMENT);
        		
        		sz.addActionListener(new ActionListener() { //OnClick Event creation
        			public void actionPerformed(ActionEvent e) {//On-clicked, perform the following:
        				
        				
        				CheckOut Check = FoodOperations.BuyFood(f,sz.getText());
        				if(Check == null){
        					Popups.show("Quantity not enough for purchase!");
        					UsageLog.add("Opertion cancelled, quantity not enough");
        				}
        				else {
        					C.moneyCustomerPaidSoFar += Check.cost * (t + 1);
        					C.setLoyaltyPoints( (int)( C.getLoyaltyPoints() + Schedules.Utils.clamp((float)Check.cost/1000,1,15) ) );
        					
        					new ReceiptDisplay(A, C, sz.getText(), f);        				
        					
        					UsageLog.add("Total Food inCome: " + Food.inCome );
        					
        					FoodSavingLoading.Save();

        				}
        				
        				
        				dispose();
        				
        			}
        			
        		} );
        		content.add(sz);
        		
        		JPanel filler = new JPanel();
        		
        		filler.setPreferredSize(new Dimension(600,20));
        		filler.setMinimumSize(new Dimension(600,20));
        		filler.setMaximumSize(new Dimension(600,20));
        		content.add(filler);	
        		
        	}
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
