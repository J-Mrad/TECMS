package Schedules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;

public class Schedules {
	public static ArrayList<Schedules> schedules;

	public Movies movie;
	public ArrayList<ShowRooms> showRooms;
	public ArrayList<Show> shows;

	public class Show {
		public ShowRooms showRooms;
		public ArrayList<Calendar> showTimes;

		protected Show(ShowRooms showRooms, Calendar[] showTimes,Schedules schedules) {
			this.showTimes = new ArrayList<Calendar>();
			this.showRooms = showRooms;
			for (int i = 0; i < showTimes.length; i++) {
				if (!this.showTimes.contains(showTimes[i])) {
					this.showTimes.add(showTimes[i]);
				}
			}
			if (!shows.contains(this)) {
				schedules.shows.add(this);
			}
		}
	}

	protected Schedules(Movies movies, ShowRooms[] showRooms, Calendar[][] showTimes) {
		if (schedules == null)
			schedules = new ArrayList<Schedules>();

		this.showRooms = new ArrayList<ShowRooms>();
		this.shows = new ArrayList<Show>();
		this.movie = movies;
		for (ShowRooms showRooms2 : showRooms) {
			if (!movie.showRooms.contains(showRooms2) && !containsShowRoom(showRooms2)) {
				movie.showRooms.add(showRooms2);
				movie.showRooms.sort(new Comparator<ShowRooms>() {
					public int compare(ShowRooms A, ShowRooms B) {
						return Integer.parseInt(A.RoomNumber.split(" ")[1])
								- Integer.parseInt(B.RoomNumber.split(" ")[1]);
					}
				});
			}
		}
		if (this.movie.schedules == null)
			this.movie.schedules = new ArrayList<Schedules>();
		if (this.movie.showRooms == null)
			this.movie.showRooms = new ArrayList<ShowRooms>();

		for (int i = 0; i < showRooms.length; i++)
			if (!this.showRooms.contains(showRooms[i]))
				this.showRooms.add(showRooms[i]);

		for (int i = 0; i < showRooms.length; i++)
			new Show(this.showRooms.get(this.showRooms.indexOf(showRooms[i])), showTimes[i],this);

		Schedules schedule = null;
		if (!schedules.contains(this) && (schedule = ContainsMovie(movies)) == null) {
			schedules.add(this);
			this.movie.schedules.add(this);
		} else {
			add2(schedule, showRooms, showTimes);
		}

		Collections.sort(shows, new Comparator<Show>() {
			public int compare(Show a, Show b) {
				return Integer.parseInt(a.showRooms.RoomNumber.split(" ")[1])
						- Integer.parseInt(b.showRooms.RoomNumber.split(" ")[1]);
			}
		});
		
		Collections.sort(this.showRooms,new Comparator<ShowRooms>() {
			public int compare(ShowRooms a,ShowRooms b) {
				return Integer.parseInt(a.RoomNumber.split(" ")[1])
						- Integer.parseInt(b.RoomNumber.split(" ")[1]);
			}
		});
	}

	private Schedules ContainsMovie(Movies movies) {
		Iterator<Schedules> iterator = schedules.listIterator();
		while (iterator.hasNext()) {
			Schedules schedules;
			if ((schedules = iterator.next()).movie.Title.equals(movies.Title)) {
				return schedules;
			}
		}
		return null;
	}

	private boolean containsShowRoom(ShowRooms showRooms) {
		for (ShowRooms showRooms2 : this.movie.showRooms) {
			if (showRooms2.RoomNumber.equals(showRooms.RoomNumber)) {
				return true;
			}
		}
		return false;
	}

	private void add2(Schedules schedule, ShowRooms[] showRooms, Calendar[][] showTimes) {
		int flag = 0;
		for (int i = 0; i < showRooms.length; i++) {
			final int r = i;
			for (int j = 0; j < schedule.showRooms.size(); j++) {
				if (schedule.showRooms.get(j).RoomNumber.equals(showRooms[i].RoomNumber)) {
					Show[] s = new Show[schedule.shows.size()];
					schedule.shows.toArray(s);
					Optional<Show> optional = Arrays.stream(s)
							.filter(x -> x.showRooms.RoomNumber.equals(showRooms[r].RoomNumber)).findFirst();
					if (optional.isPresent()) {
						Show x = optional.get();
						for (int l = 0; l < showTimes[i].length; l++) {
							for (int k = 0; k < x.showTimes.size(); k++) {
								if (x.showTimes.get(k).getTimeInMillis() == showTimes[i][l].getTimeInMillis()) {
									flag = 1;
								}
							}
							if (flag == 0) {
								x.showTimes.add(showTimes[i][l]);
							}
						}
					}
				} else {
					new Show(showRooms[i], showTimes[i],schedule);
					return;
				}
			}
		}
	}

	public String toString() {
		String string = movie + " ";
		for (int i = 0; i < shows.size(); i++) {
			string += shows.get(i).showRooms + " ";
			for (int j = 0; j < shows.get(i).showTimes.size(); j++)
				string += "\n" + shows.get(i).showTimes.get(j).getTime().toString();
			string += "\n------------------------------------------------------\n";
		}

		return string;
	}

}
