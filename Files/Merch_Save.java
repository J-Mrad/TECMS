package Files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Interface.Popups;
import Merch.ActionFigures;
import Merch.Posters;
import Merch.ToyProps;
import Merch.Tshirts;

public class Merch_Save {

	
	static ObjectInputStream dataIn = null;
	static ObjectOutputStream dataOut = null;

	@SuppressWarnings("unchecked")
	public static void BuildList(){
		
		try {
				dataIn = new ObjectInputStream(new FileInputStream("./src/SessionData/Merch.ser"));
				
				Tshirts.tshirtsList = (ArrayList<Tshirts>)  dataIn.readObject();
				ToyProps.toyPropsList = (ArrayList<ToyProps>)  dataIn.readObject();
				Posters.postersList= (ArrayList<Posters>)  dataIn.readObject();
				ActionFigures.actionFiguresList = (ArrayList<ActionFigures>)  dataIn.readObject();
				dataIn.close();
		}
		catch(ClassNotFoundException | IOException e2) {
			Popups.show("Error reading Merch data, call IT immediately");
		}
		
	}
	public static void SaveList(){
		
		try {
				dataOut = new ObjectOutputStream(new FileOutputStream("./src/SessionData/Merch.ser"));
				
				dataOut.writeObject(Tshirts.getTshirtsList());
				dataOut.writeObject(ToyProps.getToyPropsList());
				dataOut.writeObject(Posters.getPostersList());
				dataOut.writeObject(ActionFigures.getActionFiguresList());
				dataOut.close();
		}
		catch(IOException E) {
			
		}
		
	}

		
}