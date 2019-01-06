package Listers;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public interface Adder {
	
	JPanel panel = new JPanel();

	JTextField f1 = new JTextField(20);
	JTextField f2 = new JTextField(20);
	
	JButton cancel = new JButton("Cancel");
	JButton save = new JButton("Save");
	
	
}
