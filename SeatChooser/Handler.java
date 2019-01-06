package SeatChooser;

import java.awt.Graphics;

import Schedules.ShowRooms;

public class Handler {

	public ShowRooms showRoom;
	
	public Seat seats[][];
	
	public Handler(ShowRooms showRoom) {
		this.showRoom=showRoom;
		int nudge = 40;
		seats = new Seat[5][11];
		for(int i=0;i<5;i++) {
			for(int j=0;j<11;j++) {
				
				if(j<3)
					seats[i][j] = new Seat(j*SeatChooser.DIMENSION.width/(12)+nudge, i*SeatChooser.DIMENSION.height/(6)+30,showRoom.getSeats(),i,j);
				else if(j<8)
					seats[i][j] = new Seat(j*SeatChooser.DIMENSION.width/(12)+nudge*2, i*SeatChooser.DIMENSION.height/(6)+30,showRoom.getSeats(),i,j);
				else
					seats[i][j] = new Seat(j*SeatChooser.DIMENSION.width/(12)+nudge*3, i*SeatChooser.DIMENSION.height/(6)+30,showRoom.getSeats(),i,j);

			}	
		}
	}
	
	public void update() {
		
	}
	
	public void render(Graphics graphics) {
		for(int i=0;i<5;i++) {
			for(int j=0;j<11;j++) {
				seats[i][j].render(graphics);;
			}	
		}
	}
}
