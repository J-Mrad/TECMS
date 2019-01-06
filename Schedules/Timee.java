package Schedules;

import java.util.Calendar;

public class Timee {

	public static Calendar[] ParseTimes(String Days, String Times) {
		switch (Days) {
		case "A": {
			Calendar c1, c2, c3;
			c1 = Calendar.getInstance();
			c2 = Calendar.getInstance();
			c3 = Calendar.getInstance();

			c1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			c2.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
			c3.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);

			c1.set(Calendar.MINUTE, 0);
			c1.set(Calendar.SECOND, 0);
			c2.set(Calendar.MINUTE, 0);
			c2.set(Calendar.SECOND, 0);
			c3.set(Calendar.MINUTE, 0);
			c3.set(Calendar.SECOND, 0);

			switch (Times) {

			case "1":
				c1.set(Calendar.HOUR_OF_DAY, 10);
				c2.set(Calendar.HOUR_OF_DAY, 10);
				c3.set(Calendar.HOUR_OF_DAY, 10);
				break;

			case "2":
				c1.set(Calendar.HOUR_OF_DAY, 15);
				c2.set(Calendar.HOUR_OF_DAY, 15);
				c3.set(Calendar.HOUR_OF_DAY, 15);
				break;

			case "3":
				c1.set(Calendar.HOUR_OF_DAY, 21);
				c2.set(Calendar.HOUR_OF_DAY, 21);
				c3.set(Calendar.HOUR_OF_DAY, 21);
				break;

			}

			Calendar[] calendars = { c1, c2, c3 };
			return calendars;
		}
		case "B": {
			Calendar c1, c2;
			c1 = Calendar.getInstance();
			c2 = Calendar.getInstance();

			c1.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
			c2.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);

			c1.set(Calendar.MINUTE, 0);
			c1.set(Calendar.SECOND, 0);
			c2.set(Calendar.MINUTE, 0);
			c2.set(Calendar.SECOND, 0);

			switch (Times) {

			case "1":
				c1.set(Calendar.HOUR_OF_DAY, 10);
				c2.set(Calendar.HOUR_OF_DAY, 10);
				break;

			case "2":
				c1.set(Calendar.HOUR_OF_DAY, 15);
				c2.set(Calendar.HOUR_OF_DAY, 15);
				break;

			case "3":
				c1.set(Calendar.HOUR_OF_DAY, 21);
				c2.set(Calendar.HOUR_OF_DAY, 21);
				break;

			}

			Calendar[] calendars = { c1, c2 };
			return calendars;
		}
		case "C": {
			Calendar c1, c2;
			c1 = Calendar.getInstance();
			c2 = Calendar.getInstance();

			c1.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
			c2.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);

			c1.set(Calendar.MINUTE, 0);
			c1.set(Calendar.SECOND, 0);
			c2.set(Calendar.MINUTE, 0);
			c2.set(Calendar.SECOND, 0);

			switch (Times) {

			case "1":
				c1.set(Calendar.HOUR_OF_DAY, 10);
				c2.set(Calendar.HOUR_OF_DAY, 10);
				break;

			case "2":
				c1.set(Calendar.HOUR_OF_DAY, 15);
				c2.set(Calendar.HOUR_OF_DAY, 15);
				break;

			case "3":
				c1.set(Calendar.HOUR_OF_DAY, 21);
				c2.set(Calendar.HOUR_OF_DAY, 21);
				break;

			}

			Calendar[] calendars = { c1, c2 };
			return calendars;
		}
		}
		return null;
	}

	public static Calendar[][] getTimes(String string) { /////////// STRING FORMAT "FirstShowRoomEntererInTheLastField's
															/////////// Times Before First Comma"
		String[] strings = string.trim().split(","); /////////// I.E: "A1,B2,C3,A2,B3" means ShowRoom 1 enter in last
														/////////// Field is in Times A1 , ShowRoom 2 is in Times B2
		Calendar[][] calendars = new Calendar[strings.length][];//////////Then Use SchedulingOperations.addShow(getMovie(),getShowRoom(),getTimes());
		int i = 0;
		for (String string2 : strings) {
			calendars[i] = ParseTimes(String.valueOf(string2.charAt(0)), String.valueOf(string2.charAt(1)));
			i++;
		}
		return calendars;
	}

}
