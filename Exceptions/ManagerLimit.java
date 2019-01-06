package Exceptions;

import Interface.Popups;

@SuppressWarnings("serial")
public class ManagerLimit extends Exception{

	public ManagerLimit(int n){
		
		Popups.show("Manager limit ["+ n +"] exceeded! Contact IT for extension");
	}
	
}
