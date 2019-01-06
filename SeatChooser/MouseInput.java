package SeatChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

	Handler handler;
	SeatChooser seatChooser;
	
	public MouseInput(Handler handler,SeatChooser seatChooser) {
		this.handler = handler;
		this.seatChooser = seatChooser;
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if (mouseOver(mx, my, 1030, 590, 200, 70)) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 11; j++) {
					if (handler.seats[i][j].chosen) {
						handler.seats[i][j].reserved=true;
						handler.seats[i][j].chosen=false;
						handler.showRoom.seats[i][j]=true;
						seatChooser.seats.add(handler.seats[i][j]);
					}
				}
			}
			seatChooser.finishOperation();

			return;
			
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 11; j++) {
				if (mouseOver(mx, my, handler.seats[i][j].x, handler.seats[i][j].y, 29, 64)) {
					if(!handler.seats[i][j].reserved)
						handler.seats[i][j].chosen = !handler.seats[i][j].chosen;
					return;
				}

			}

		}

	}

	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < x + width) {
			if (my > y && my < y + height) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	public void mouseReleased(MouseEvent e) {

	}
}
