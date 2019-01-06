package SeatChooser;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;


public class Window extends Canvas{
	private static final long serialVersionUID = -3243549075703803619L;
	public JFrame frame;
	public Window(Dimension dimension,String title,SeatChooser seatChooser) {
		frame = new JFrame(title);
		
		frame.setPreferredSize(dimension);
		frame.setMaximumSize(dimension);
		frame.setMinimumSize(dimension);
		
		
	//	frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		frame.addWindowListener(new WindowAdapter(){			//Adjusting the top-right 'X' button
			  public void windowClosing(WindowEvent we)
			  {
				  frame.dispose();
			  }
			 });
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(seatChooser);
		frame.setVisible(true);
		
		seatChooser.start();
	}


}
