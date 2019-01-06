package Schedules;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;

public class SchedulingOperations {
	
	public static ShowRooms addShowRoom(int RoomNumber, String Type) {
		return new ShowRooms(RoomNumber,Type);
	}
	
	public static ShowRooms getShowRoom(int RoomNumber) {
		Iterator<ShowRooms> iterator = ShowRooms.ShowRooms.listIterator();
		while (iterator.hasNext()) {
			ShowRooms showRooms;
			if((showRooms=iterator.next()).RoomNumber.equals("Room " + RoomNumber))
				return showRooms;
		}
		return null;
	}
	
	public static Movies getMovie(String title) {
		for(Movies movies : Movies.movies) {
			if(movies.Title.equals(title)) {
				return movies;
			}
		}
		return null;
	}
	
	public static Schedules addShow(Movies movies, ShowRooms[] showRooms, Calendar[][] showTimes) {
		return new Schedules(movies,showRooms,showTimes);
	}

	public static LinkedList<Movies> listMovies() {
		LinkedList<Movies>moviess = new LinkedList<Movies>();
		for(Movies movies : Movies.movies) {
			moviess.add(movies);
		}
		return moviess;
	}
	
	public static LinkedList<ShowRooms> listShowRooms() {
		LinkedList<ShowRooms> showRoomss = new LinkedList<ShowRooms>();
		for(ShowRooms showRooms : ShowRooms.ShowRooms) {
			showRoomss.add(showRooms);
		}
		return showRoomss;
	}
	
	public static LinkedList<Schedules> listSchedules() {
		LinkedList<Schedules> schedules = new LinkedList<Schedules>();
		for(Schedules schedules2 : Schedules.schedules) {
			schedules.add(schedules2);
		}
		return schedules;
	}
	
	public static class MoviesAndTime{
		public Movies movies;
		ArrayList<Calendar> showTimes;
		public MoviesAndTime(Movies movies) {
			this.movies = movies;
		}
		public void addCalendar(Calendar calendar) {
			showTimes.add(calendar);
		}
	}
	
	public static LinkedList<MoviesAndTime> listMoviesAndTime() {
		LinkedList<MoviesAndTime> moviesAndTimes = new LinkedList<MoviesAndTime>();
		for(Schedules schedules : Schedules.schedules) {
			MoviesAndTime moviesAndTime;
			moviesAndTimes.add((moviesAndTime = new MoviesAndTime(schedules.movie)));
			for(Schedules.Show show : schedules.shows) {
				for(Calendar calendar : show.showTimes)
					moviesAndTime.addCalendar(calendar);
			}
		}
		return moviesAndTimes;
	}
	
	public static LinkedList<ShowRooms> listMoviesShowRooms(Movies movies) {
		LinkedList<ShowRooms> showRoomss = new LinkedList<ShowRooms>();
		for(ShowRooms showRooms : movies.showRooms) {
			showRoomss.add(showRooms);
		}
		return showRoomss;
	}
	
	public static String getTitle(Movies M) {
		if(M != null)return M.Title;
		return null;
	}

	public static LinkedList<Calendar> ListTime(Movies movie, ShowRooms showroom){
		 
		LinkedList<Calendar> showTime = new LinkedList<Calendar>();
		
		Schedules.Show show = null;
		for(Schedules S : Schedules.schedules) {
			
			if(S.movie == movie) {
				for(Schedules.Show tmp : S.shows) {
					if(tmp.showRooms == showroom) {
						show = tmp;
						break;
					}
				}
				break;
			}
			
		}
		if(show != null) {
			for(Calendar C : show.showTimes) {
				showTime.add(C);
			}
		}
		
		return showTime;
	}
	
	public static ArrayList<Movies.Actors> listActors(Movies M){
		return M.Cast;
	}
	
	public static Schedules getSchedule(Movies movies) {
        for(Schedules schedules : Schedules.schedules)
            if(schedules.movie.equals(movies) )
                return schedules;
        return null;
    }
}
