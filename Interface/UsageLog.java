package Interface;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;


@SuppressWarnings("serial")
public class UsageLog extends JFrame {

	protected static int loginCount = 0;
	
	protected int textpos = 0;
	
	private static DataInputStream dataIn  = null;  
	private static DataOutputStream dataOut  = null;  
	
	private static ArrayList<String> text = new ArrayList<String>();
	
	private Color yellow = new Color(255,255,204);		//Background & Button colors

	public UsageLog(){

		BuildList();

		setSize(500,500);  
		setUndecorated(true);  
		setVisible(true);   
		setLayout(null);
		setLocationRelativeTo(null);
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));	//Adding border
				
		
		JPanel content = new JPanel();					//Ading the scroll pane
        content.setLayout(new BoxLayout(content,BoxLayout.PAGE_AXIS));
        content.setBackground(yellow);
        JScrollPane  Pane = new JScrollPane(content,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        Pane.getVerticalScrollBar().setUnitIncrement(16);
        Pane.setSize(493,420);
        getContentPane().add(Pane, BorderLayout.CENTER);
		
		for(String S : text) {
			
			JLabel text = new JLabel();
			text.setSize(470, 50);
			text.setText(S);
			content.add(text);
		}
		
		
		
		JButton ok = new JButton("Close");  
		ok.setLocation(390, 435);
		ok.setSize(100, 25);
		ok.addActionListener(new ActionListener() { //OnClick Event creation
			public void actionPerformed(ActionEvent e) {//On-clicked, perform the following:
				SaveList();
				dispose();
			}
		} );
		add(ok);
		
		
		
		JButton clear = new JButton("Clear Log");  
		clear.setLocation(5, 435);
		clear.setSize(100, 25);
		clear.addActionListener(new ActionListener() { //OnClick Event creation
			public void actionPerformed(ActionEvent e) {//On-clicked, perform the following:
		    	 
				PrintWriter writer;
				try {
					writer = new PrintWriter("./src/Account_Data/Log.txt"); writer.print(""); writer.close();
					loginCount = 0;
					dispose();
					UsageLog U = new UsageLog();
					U.setVisible(true);
					
				} catch (IOException e1) {
					System.out.println("Error clearing Log file.");
				} 
				repaint();
			}
		} );
		add(clear);
		
		
		repaint();
        revalidate();

	}
	
	public static void BuildList() {
		
		try {
			dataIn = new DataInputStream(new FileInputStream(new File("./src/Account_Data/Log.txt")));
			
			text.clear();
			loginCount = 0;
			
			while(dataIn.available() > 0) {
				
				String tmp = dataIn.readUTF(); 
				if (tmp.endsWith("====")) loginCount++;
				text.add(tmp);
			
			}
			dataIn.close();
				
		} catch (IOException e1) {
			Popups.show("WARNING: Error reading Log (Build), contact IT immeditely!");
		}
		
		
	}
	
	public static void SaveList() {
		
	     try {
	    	dataOut = new DataOutputStream(new FileOutputStream(new File("./src/Account_Data/Log.txt") , true));
	    		    	
	    	PrintWriter writer = new PrintWriter("./src/Account_Data/Log.txt"); writer.print(""); writer.close();

	    	for(String S : text) {
		    	dataOut.writeUTF(S);															//Print one account per line

	    	}
	    	dataOut.close();
		} 
	      
	     catch (IOException e) {
	    	 Popups.show("WARNING: Error with user Log (Save), contact IT immediately!");
		}
		
		
	}
	
	
	public static void add(String S) { //Add to text
		text.add(Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime() + " : " + S);
		SaveList();
	}
	
}

