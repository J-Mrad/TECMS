package Files;

import People.Manager;

import java.util.ArrayList;

import Interface.Popups;


import java.io.PrintWriter;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class Manager_Save extends Saver{

public Manager CurrentAccount;

	
	protected static ArrayList<Manager>  list = new ArrayList<Manager>();

	public static void BuildList(){
				
		try {
			dataIn = new DataInputStream(new FileInputStream("./src/SessionData/Managers.txt"));

			list.clear();																					//Empty list

			while(dataIn.available()>0) {																	//Iterate file's lines
			
				String k = dataIn.readUTF();
				String []tmp = k.split("~");	
				//Split each line

				list.add(new Manager(
							Float.parseFloat(tmp[0]),
							Integer.parseInt(tmp[1]),
							Integer.parseInt(tmp[2]),
							Integer.parseInt(tmp[3]),
							tmp[4],
							tmp[5],
							Integer.parseInt(tmp[6]),
							Integer.parseInt(tmp[7])
							));		//Create new account per line
	         
	      }
		//	dataOut.close();
	      
		} 
		catch (IOException e) {

			Popups.show("WARNING: Error recovering managers list, conact IT immediately.");

		}
		
	}
	public static void AddManager(Manager M) {

		list.add(M);
		SaveList();

	}
	

	public static void RemoveManager(Manager M){
		
		list.remove(M);							//Delete a single accout
		SaveList();

	}
	
	
	public static void SaveList(){
		
	     try {
	    	 dataOut = new DataOutputStream(new FileOutputStream("./src/SessionData/Managers.txt"));    	 
	    	 	    	 
	    	 //Clearing file:
	    	 PrintWriter writer = new PrintWriter("./src/SessionData/Managers.txt"); writer.print(""); writer.close();

	    	 for(Manager M : list) {																	//Iteate Arraylist
	    		 		
	    		dataOut.writeUTF(M.getHourlyWage() + "~" +
	    				M.getHoursPerWeek() + "~" +
	    				M.getshiftStartingHour() + "~" +
	    				M.getshiftEndingHour() + "~" +
	    				M.getFirstName() +  "~" +
	    				M.getLastName() + "~" +
	    				M.getage() + "~" +
	    				M.getEmployeeID());					//Print one per line
	    	 
	    	 }
	    	 dataOut.close();
		} 
	      
	     catch (IOException e) {
	    	 Popups.show("WARNING: New manager(s) may have not been saved properly.");
		}
		
	}
	
	public String toString(){
       
		String S = "Username	|	Password 	|	Admin\n";
		
		for(Manager M : list) {
			S += M.getHourlyWage() + "~" +
    				M.getHoursPerWeek() + "~" +
    				M.getshiftStartingHour() + "~" +
    				M.getshiftEndingHour() + "~" +
    				M.getFirstName() +  "~" +
    				M.getLastName() + "~" +
    				M.getage() + "\n";
		}
		return S;
		
	}
	
	public static ArrayList<Manager> getList(){
		return list;
	}

}
