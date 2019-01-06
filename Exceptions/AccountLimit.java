package Exceptions;

import Interface.Popups;

@SuppressWarnings("serial")
public class AccountLimit extends Exception{

	public AccountLimit(int n){
	
		Popups.show("Account limit ["+ n +"] exceeded! Contact IT for extension");
	}
	
}
