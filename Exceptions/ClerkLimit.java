package Exceptions;

import Interface.Popups;

@SuppressWarnings("serial")
public class ClerkLimit  extends Exception{

	public ClerkLimit(int n){
		
		Popups.show("Clerk limit ["+ n +"] exceeded! Contact IT for extension");
	}
	
}
