package Exceptions;

import Interface.Popups;

@SuppressWarnings("serial")
public class ShowRoomNotFound extends Exception{

	public ShowRoomNotFound(String s){
		Popups.show("Room number" + s + "Not found!");
	}
	
}
