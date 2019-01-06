package Schedules;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;


public class SchedulesSavingLoading {

	public static void Save() {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("./src/Schedules/ScheduleSave.txt")));
			Iterator<Schedules> iterator = Schedules.schedules.listIterator();
			while (iterator.hasNext()) {
				Schedules schedules = iterator.next();

				bufferedWriter.write("Movies:");
				bufferedWriter.newLine();

				bufferedWriter.write(schedules.movie.Title);
				bufferedWriter.newLine();

				bufferedWriter.write(schedules.movie.Rating + "");
				bufferedWriter.newLine();

				bufferedWriter.write("Cast:");
				bufferedWriter.newLine();

				Iterator<Movies.Actors> iterator2 = schedules.movie.Cast.listIterator();
				while (iterator2.hasNext()) {
					Movies.Actors actors = iterator2.next();

					bufferedWriter
							.write(actors.fistName + " " + actors.lastName + " " + actors.Age + " " + actors.Rating);
					bufferedWriter.newLine();

				}

				bufferedWriter.write("ShowRooms:");
				bufferedWriter.newLine();

				Iterator<Schedules.Show> iterator3 = schedules.shows.listIterator();
				while (iterator3.hasNext()) {
					Schedules.Show show = iterator3.next();

					bufferedWriter.write(show.showRooms.RoomNumber);
					bufferedWriter.newLine();
					bufferedWriter.write(show.showRooms.Type);
					bufferedWriter.newLine();
					bufferedWriter.write("ShowTimes:");
					bufferedWriter.newLine();

					Iterator<Calendar> iterator4 = show.showTimes.listIterator();
					while (iterator4.hasNext()) {
						Calendar calendar = iterator4.next();

						bufferedWriter.write(calendar.getTime().getTime() + "");
						bufferedWriter.newLine();

					}
					bufferedWriter.write("ShowTimesEnd");
					bufferedWriter.newLine();
				}
			}
			bufferedWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Load() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("./src/Schedules/ScheduleSave.txt")));
			String Line = bufferedReader.readLine();
			while (Line != null) {
				String Title = bufferedReader.readLine();
				float Rating = Float.parseFloat(bufferedReader.readLine());
				Line = bufferedReader.readLine();
				Movies movie = new Movies(Title, Rating);
				while (!(Line = bufferedReader.readLine()).equals("ShowRooms:")) {
					movie.addActors(Line.split(" ")[0], Line.split(" ")[1], Integer.parseInt(Line.split(" ")[2]),
							Float.parseFloat(Line.split(" ")[3]));
				}
				ArrayList<ShowRooms> showRooms = new ArrayList<ShowRooms>();
				ArrayList<Calendar> showTimes = new ArrayList<Calendar>();
				ShowRooms[] showRoomss = null;
				Calendar[][] calendars = null;
				while ((Line = bufferedReader.readLine()) != null && !Line.equals("Movies:")) {
					String RoomNumber = Line;
					String Type = bufferedReader.readLine();
					showRooms.add(new ShowRooms(RoomNumber, Type));
					bufferedReader.readLine();
					while ((Line = bufferedReader.readLine()) != null && !Line.equals("ShowTimesEnd")) {
						Long Time = Long.valueOf(Line);
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(new Date(Time));
						showTimes.add(calendar);
					}
				
				showRoomss = new ShowRooms[showRooms.size()];
				showRooms.toArray(showRoomss);
				calendars = new Calendar[showRooms.size()][showTimes.size()];
				for (int i = 0; i < showRooms.size(); i++) {
					showTimes.toArray(calendars[i]);
				}
				showTimes = new ArrayList<Calendar>();
				}
				SchedulingOperations.addShow(movie, showRoomss, calendars);
			}
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
