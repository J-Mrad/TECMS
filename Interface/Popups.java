package Interface;

import javax.swing.JOptionPane;

public class Popups{
	
	public static int ShowAndGetValue(String value){
		try {
		return Integer.parseInt(JOptionPane.showInputDialog(null, value));
		
		}catch(NumberFormatException e){
			return -1;
		}

	}
	
	public static String ShowAndGetString(String value){
		
		return JOptionPane.showInputDialog(null, value);
		
		
	}
    
	
	public static void dispAndClose(String value) {
		JOptionPane.showMessageDialog(null, value);
		System.exit(0);
	}
	
	public static void show(String value) {
		JOptionPane.showMessageDialog(null, value);
	}
	
}
