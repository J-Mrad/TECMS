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
import Interface.Account;
import Interface.UsageLog;
import People.Customer;

@SuppressWarnings("serial")
public class FoodLister extends JFrame implements Lister{
	
	
	Color yellow = new Color(255,255,204);		//Background & Button colors

	JPanel content = new JPanel();					//Ading the scroll pane
    JScrollPane  Pane = new JScrollPane(content,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	JButton ok = new JButton("Close");  
	
	public FoodLister(Account A, Customer C){
		

		setSize(600,600);
		setTitle("Select Food");  
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
        
        
        for( Food f : FoodOperations.listFood() ) {
        	
        	JButton fd = new JButton(FoodOperations.getName(f) + " (" + f.quantity + ")");  
        	fd.setPreferredSize(new Dimension(294,50));
        	fd.setMinimumSize(new Dimension(294,50));
        	fd.setMaximumSize(new Dimension(294,50));

        	fd.setAlignmentX(Component.CENTER_ALIGNMENT);
        	
        	fd.addActionListener(new ActionListener() { //OnClick Event creation
    			public void actionPerformed(ActionEvent e) {//On-clicked, perform the following:

    				
    				SizeLister SL = new SizeLister(A,C,f);
    				SL.setVisible(true);
    				
    				
    			
    			dispose();

    			}
    			
    		} );
        	content.add(fd);
        	
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
