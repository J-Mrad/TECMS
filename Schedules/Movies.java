package Schedules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;


public class Movies {

	public class Actors {
		String fistName;
		String lastName;
		int Age;
		float Rating;

		protected Actors(String fistName, String lastName, int Age, float Rating) {
			this.fistName = fistName;
			this.lastName = lastName;
			this.Age = Age;
			this.Rating = Utils.clamp(Rating, 0, 10);
		}
		
		public String toString() {
			return "          " + fistName + " " + lastName + " Age: " + Age + " Rating: " + Rating ;
			
			
		}
		
	}
	public final String Title;
	protected ArrayList<Actors> Cast;
	protected ArrayList<Schedules> schedules;
	protected ArrayList<ShowRooms> showRooms;

	protected static ArrayList<Movies> movies;

	protected float Rating;

	public Movies(String Title, float Rating) {

		if (movies == null)
			movies = new ArrayList<Movies>();
		if (Cast == null)
			Cast = new ArrayList<Actors>();
		if(showRooms == null)
			showRooms = new ArrayList<ShowRooms>();

		this.Title = Title;
		this.Rating = Utils.clamp(Rating, 0, 10);
		if (!movies.contains(this) && DoesntContainsMovie())
			movies.add(this);
		
		Collections.sort(movies,new Comparator<Movies>() {
			public int compare(Movies a,Movies b) {
				return (int)(b.Rating)-Math.round(a.Rating);
			}
		});
	}

	private boolean DoesntContainsMovie() {
		Iterator<Movies> iterator = movies.listIterator();
		while (iterator.hasNext()) {
			if (iterator.next().Title.equals(this.Title)) {
				return false;
			}
		}
		return true;
	}

	public void addActors(String fistName, String lastName, int Age, float Rating) {
		if (Cast == null)
			Cast = new ArrayList<Actors>();
		if (!Cast.contains(new Actors(fistName, lastName, Age, Rating)))
			Cast.add(new Actors(fistName, lastName, Age, Rating));
	}

	public String toString() {		

		return Title + " | " + Rating + " ";
	}
	
}
