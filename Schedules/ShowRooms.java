package Schedules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class ShowRooms {

	protected ArrayList<Schedules> schedules;
	protected ArrayList<Movies> movies;
	public boolean seats[][];
	
	
	public String RoomNumber, Type;
	protected double price;

	protected static ArrayList<ShowRooms> ShowRooms;

	public double getPrice() {
		return price;
	}
	
	protected ShowRooms(int RoomNumber, String Type) {
		seats=new boolean[5][11];
		for(int i=0;i<5;i++) {
			for(int j=0;j<11;j++) {
				seats[i][j] = false;
			}	
		}
		
		if (ShowRooms == null)
			ShowRooms = new ArrayList<ShowRooms>();

		this.RoomNumber = "Room " + RoomNumber;
		this.Type = Type;

		switch (Type) {
		case Utils.IMAX:
			price = Utils.IMAX_PRICE;
			break;
		case Utils._4DX:
			price = Utils._4DX_PRICE;
			break;
		case Utils.NORMAL:
			price = Utils.NORMAL_PRICE;
			break;
		case Utils.VIP:
			price = Utils.VIP_MONTHLY_SUBSCRIPTION;
			break;

		}

		if (!ShowRooms.contains(this) && DoesntContainsShowroom())
			ShowRooms.add(this);
		
		Collections.sort(ShowRooms,new Comparator<ShowRooms>() {
			public int compare(ShowRooms a,ShowRooms b) {
				return Integer.parseInt(a.RoomNumber.split(" ")[1])
						- Integer.parseInt(b.RoomNumber.split(" ")[1]);
			}
		});
	}
	
	protected ShowRooms(String RoomNumber, String Type) {
		this(Integer.parseInt(RoomNumber.split(" ")[1]),Type);
	}

	public String toString() {
		return Type.equals(Utils.VIP) ? RoomNumber + " " + Type + " ( " + price +  " ) \n" : RoomNumber + " " + Type + " " + price + "\n";
	}

	public boolean[][] getSeats() {
		return seats;
	}
	
	private boolean DoesntContainsShowroom() {
        Iterator<ShowRooms> iterator = ShowRooms.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().RoomNumber.equals(this.RoomNumber)) {
                return false;
            }
        }
        return true;
    }
}
