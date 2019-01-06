package SeatChooser;

import java.awt.Color;
import java.awt.Graphics;

public class Seat {
	public int x, y, i, j;
	int scale = 1;
	boolean reserved,chosen;

	public Seat(int x, int y, boolean Seat[][],int i,int j) {
		this.x = x;
		this.y = y;
		this.i = i;
		this.j = j;
		reserved = Seat[i][j];
		chosen = false;
	}

	public void render(Graphics graphics) {
		graphics.setColor(Color.white);
		if(reserved)
			graphics.setColor(Color.red);
		if(chosen) 
			graphics.setColor(Color.green);
		graphics.fillRect(x, y, 30 * scale, 50 * scale);
		graphics.fillRect(x + 8, y - 14, 15 * scale, 10 * scale);

		graphics.setColor(Color.white);

	}


}
