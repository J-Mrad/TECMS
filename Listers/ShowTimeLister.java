package Listers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import People.Customer;
import Schedules.Movies;
import Schedules.SchedulingOperations;
import Schedules.ShowRooms;
import SeatChooser.SeatChooser;


@SuppressWarnings("serial")
public class ShowTimeLister extends JFrame implements Lister {

	Color yellow = new Color(255, 255, 204); // Background & Button colors

	JPanel content = new JPanel(); // Ading the scroll pane
	JScrollPane Pane = new JScrollPane(content, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	
	ShowTimeLister(Customer C, Movies M, ShowRooms S) {

		setSize(600, 600);
		setTitle("Select ShowRoom");
		setVisible(true);
		setResizable(false);
		setLayout(null);
		setLocation(700, 100);
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan)); // Adding border

		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.setBackground(yellow);
		Pane.getVerticalScrollBar().setUnitIncrement(16);
		Pane.setSize(594, 500);
		getContentPane().add(Pane, BorderLayout.CENTER);

		for (Calendar Cal : SchedulingOperations.ListTime(M, S)) {

			Calendar cal2 = (Calendar) Cal.clone();
			
			JButton time = new JButton(cal2.getTime().toString());
			time.setPreferredSize(new Dimension(294, 50));
			time.setMinimumSize(new Dimension(294, 50));
			time.setMaximumSize(new Dimension(294, 50));

			time.setAlignmentX(Component.CENTER_ALIGNMENT);

			time.addActionListener(new ActionListener() { // OnClick Event creation
				public void actionPerformed(ActionEvent e) {// On-clicked, perform the following:

					dispose();
					
					new SeatChooser(C,M,S, Cal);
					

				}
			}

			);

			content.add(time);


			JPanel filler = new JPanel();

			filler.setPreferredSize(new Dimension(600, 20));
			filler.setMinimumSize(new Dimension(600, 20));
			filler.setMaximumSize(new Dimension(600, 20));
			content.add(filler);

		}

	}

}
