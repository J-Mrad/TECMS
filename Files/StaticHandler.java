package Files;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import Interface.Popups;
import People.Customer;
import People.Employee;

public class StaticHandler extends Saver{
 
	
	public static void LoadAll(){
		
		try {
			dataIn = new DataInputStream(new FileInputStream("./src/SessionData/Statics.txt"));

			String []tmp = dataIn.readUTF().split("~");
			
			Customer.availableCustomerID = Integer.parseInt(tmp[0]);
	      
			Customer.totalMoviesProfit = Float.parseFloat(tmp[1]);
			
			Employee.availableEmployeeID = Integer.parseInt(tmp[2]);
			
		} 
		catch (IOException e) {

			Popups.show("WARNING: Error recovering static values, conact IT immediately.");

		}
		
		
	}
	
	
	public static void SaveAll(){
		
		try {
			dataOut = new DataOutputStream(new FileOutputStream("./src/SessionData/Statics.txt"));

			dataOut.writeUTF(Customer.availableCustomerID + "~" + Customer.totalMoviesProfit + "~" + Employee.availableEmployeeID);

			
		} 
		catch (IOException e) {

			Popups.show("WARNING: Error recovering static values, conact IT immediately.");

		}
		
		
	}
	
}
