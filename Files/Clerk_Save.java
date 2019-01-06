package Files;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;

import Interface.Popups;
import People.Clerk;

public class Clerk_Save extends Saver{
	
	
	protected static ArrayList<Clerk>  list = new ArrayList<Clerk>();

	public static void BuildList(){
		
		try {
			dataIn = new DataInputStream(new FileInputStream("./src/SessionData/Clerks.txt"));

			list.clear();																					//Empty list
			
			while(dataIn.available()>0) {																	//Iterate file's lines
				String k = dataIn.readUTF();
				String []tmp = k.split("~");																//Split each line
	         
				list.add(new Clerk(
							Float.parseFloat(tmp[0]),
							Integer.parseInt(tmp[1]),
							Integer.parseInt(tmp[2]),
							Integer.parseInt(tmp[3]),
							tmp[4],
							tmp[5],
							Integer.parseInt(tmp[6]),
							Integer.parseInt(tmp[7])));		//Create new account per line
	         
	      }
			dataIn.close();
	      
		} 
		catch (IOException e) {

			Popups.show("WARNING: Error recovering clerks list, conact IT immediately.");

		}
		
	}
	public static void AddClerk(Clerk C) {
		
		list.add(C);
		SaveList();

	}
	

	public static void RemoveClerk(Clerk C){
		
		list.remove(C);							//Delete a single accout
		SaveList();

	}
	
	
	public static void SaveList(){
		
		
	     try {
	    	 dataOut = new DataOutputStream(new FileOutputStream("./src/SessionData/Clerks.txt"));
	    	 
	    	 //Clearing file:
	    	 PrintWriter writer = new PrintWriter("./src/SessionData/Clerks.txt"); writer.print(""); writer.close();

	    	 for(Clerk C : list) {																	//Iteate Arraylist
	    		
	    		dataOut.writeUTF(C.getHourlyWage() + "~" +
	    				C.getHoursPerWeek() + "~" +
	    				C.getshiftStartingHour() + "~" +
	    				C.getshiftEndingHour() + "~" +
	    				C.getFirstName() +  "~" +
	    				C.getLastName() + "~" +
	    				C.getage() + "~" +
	    				C.getEmployeeID());					//Print one per line
	    	 
	    	 }
	    	 dataOut.close();
		} 
	      
	     catch (IOException e) {
	    	 Popups.show("WARNING: New clerks(s) may have not been saved properly.");
		}
		
	}
	
	public String toString(){
       
		String S = "Username	|	Password 	|	Admin\n";
		
		for(Clerk C : list) {
			S += C.getHourlyWage() + "~" +
    				C.getHoursPerWeek() + "~" +
    				C.getshiftStartingHour() + "~" +
    				C.getshiftEndingHour() + "~" +
    				C.getFirstName() +  "~" +
    				C.getLastName() + "~" +
    				C.getage() + "\n";
		}
		return S;
		
	}
	
	public static ArrayList<Clerk> getList(){
		return list;
	}

}
