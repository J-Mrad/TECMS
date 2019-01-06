package Interface;

import java.util.ArrayList;

import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.PrintWriter;

public class AccountManager {

	public Account CurrentAccount;
	
	private static DataInputStream dataIn  = null;  
	private static DataOutputStream dataOut  = null;  
	protected static ArrayList<Account>  list = new ArrayList<Account>();
	

	public static void BuildList(){
		
		try {
			dataIn = new DataInputStream(new FileInputStream("./src/Account_Data/Accounts.txt"));

			list.clear();																					//Empty list
			
			while(dataIn.available()>0) {																	//Iterate file's lines
				String k = dataIn.readUTF();
				String []tmp = k.split("~");																//Split each line
	         
				list.add(new Account(tmp[0],Integer.parseInt(tmp[1]),Boolean.parseBoolean(tmp[2])));		//Create new account per line
	         
	      }
			dataIn.close();
	      
		} 
		catch (IOException e) {

			Popups.show("WARNING: Error recovering account data, conact IT immediately.");

		}
		
	}
	
	public static void AddAccount(String username, int Password, Boolean manager){
		
		list.add(new Account(username,Password,manager));												//Create new account
		
	}
	

	public static void DeleteAccount(Account A){
		
		list.remove(new Account(A.getUsername(),A.getPassword(),A.getAdmin()));							//Delete a single accout
		
	}
	
	
	public static void SaveList(){
		
	     try {
	    	 dataOut = new DataOutputStream(new FileOutputStream("./src/Account_Data/Accounts.txt"));
	    	 
	    	 //Clearing file:
	    	 PrintWriter writer = new PrintWriter("./src/Account_Data/Accounts.txt"); writer.print(""); writer.close();

	    	 for(Account A : list) {																	//Iteate Arraylist
	    		
	    		dataOut.writeUTF(A.getUsername()+"~"+A.getPassword()+"~"+A.getAdmin());					//Print one account per line
	    	 
	    	 }
				dataOut.close();

		} 
	      
	     catch (IOException e) {
	    	 Popups.show("WARNING: New account(s) may have not been saved properly.");
		}
		
	}
	
	public String toString(){
       
		String S = "Username	|	Password 	|	Admin\n";
		
		for(Account A : list) {
			S += A.getUsername() + "	|	"  + A.getPassword() + "	|	" + A.getAdmin() + "\n";
		}
		return S;
		
	}
}
