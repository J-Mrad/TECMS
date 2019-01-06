package Exceptions;

import Interface.Popups;

@SuppressWarnings("serial")
public class MovieNotFound extends Exception{

	public MovieNotFound(String S){
		
	Popups.show("Movie ["+ S +"] does not exist");

	}
}
