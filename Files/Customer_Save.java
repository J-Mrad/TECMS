package Files;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Interface.Popups;
import People.Customer;

public class Customer_Save extends Saver{ 
	
	protected static ArrayList<Customer>  list = new ArrayList<Customer>();

	public static void BuildList(){
		
		try {
			dataIn = new DataInputStream(new FileInputStream("./src/SessionData/Customers.txt"));

			list.clear();																					//Empty list
			
			while(dataIn.available()>0) {																	//Iterate file's lines
				String k = dataIn.readUTF();
				String []tmp = k.split("~");																//Split each line
				
				
				list.add(new Customer(
							tmp[0],
							tmp[1],
							Integer.parseInt(tmp[2]),
							Integer.parseInt(tmp[3]),
							Float.parseFloat(tmp[4]),
							Integer.parseInt(tmp[5]),
							Integer.parseInt(tmp[6])
			));		//Create new account per line
	         
	      }
	      
		} 
		catch (IOException e) {

			Popups.show("WARNING: Error recovering Customers list, conact IT immediately.");

		}
		
	}
	public static void AddCustomer(Customer C) {
		
		list.add(C);
		
		SaveList();

	}
	
	
	public static void SaveList(){
		
	     try {
	    	 dataOut = new DataOutputStream(new FileOutputStream("./src/SessionData/Customers.txt"));
	    	 //Clearing file:
	    	 PrintWriter writer = new PrintWriter("./src/SessionData/Customers.txt"); writer.print(""); writer.close();

	    	 for(Customer C : list) {																	//Iteate Arraylist
	    		dataOut.writeUTF(
	    				C.getFirstName() +  "~" +
	    				C.getLastName() + "~" +
	    				C.getage() + "~" +
	    				C.getLoyaltyPoints() + "~" +
	    				C.getMoneyCustomerPaidSoFar() + "~" +
	    				C.moviesWatchedCount + "~" +
	    				C.getCustomerID()
	    	 	);
	    	 }
	    	 dataOut.close();
		} 
	      
	     catch (IOException e) {
	    	 Popups.show("WARNING: New Customer(s) may have not been saved properly.");
		}
		
	}

	
	public static ArrayList<Customer> getList(){
		return list;
	}
	
	public static Customer getByID(int ID){
		for(Customer C : list) {
			if(C.getCustomerID() == ID) {
				return C;
			}
		}
		return null;
	}

}