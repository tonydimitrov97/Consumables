/**
 * DataInput.java
 * Class which reads in a data file and loads data into array list
 * @author Antonio Dimitrov
 */
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInput {
	
	/**
	 * Opens data file and handles any exceptions
	 * @return DataInputStream
	 */
	public DataInputStream openDataFile(){
		
		DataInputStream inputFile = null;
		
		try {
			inputFile = new DataInputStream(new FileInputStream
					("program_data.dat"));
		}//end try
		catch (FileNotFoundException fnfe){
			System.out.println(fnfe.getMessage());
			System.exit(1125);
		}//end catch
		return inputFile;
	}//end openDataFile
	
	/**
	 * Goes through the data file and loads data based upon first character
	 * in the data file
	 * @param inputFile = data file
	 * @param consumption - DataConsumption object to load the data into 
	 * 						arrayList
	 */
	public void runThroughFile(DataInputStream inputFile, 
			DataConsumption consumption){
		
		char character = 0;
		boolean endOfFile = false;
			
		try {
			while (!endOfFile){
				character = inputFile.readChar();
				loadItems(inputFile, character, consumption);
			}//end while
			inputFile.close();
		}//end try
		catch (EOFException eofe){
				endOfFile = true;
		}//end catch
		catch (IOException ioe){
			System.out.println(ioe.getMessage());
			System.exit(1125);
		}//end catch				
	}//end runThroughFile

	/**
	 * Loads the data into the array list in the DataConsumption class
	 * @param inputFile - Data file to be read
	 * @param character - first character in the file
	 * @param consumption - Object which holds array list to load
	 */
	public void loadItems(DataInputStream inputFile, char character, 
			DataConsumption consumption) {
		
		/*Sets arrayList based on character read*/
		switch(Character.toUpperCase(character)){
		case 'P':
			Pizza pizza = new Pizza();
			try {
				pizza.setPizzaId(inputFile.readInt());
				pizza.setDiameter(inputFile.readInt());
				pizza.setFlavor(inputFile.readUTF());
				consumption.addData(pizza);
			}//end try
			catch (EOFException eofe){}
			catch (IOException ioe){
				System.out.println(ioe.getMessage());
				System.exit(1125);
			}//end catch
			break;
		case 'B':
			Battery battery = new Battery();
			try {
				battery.setBatteryId(inputFile.readInt());
				battery.setCapacityLeft(inputFile.readInt());
				consumption.addData(battery);
			}//end try
			catch (EOFException eofe){}
			catch (IOException ioe){
				System.out.println(ioe.getMessage());
				System.exit(1125);
			}//end catch
			break;
		case 'L':
			Luggage luggage = new Luggage();
			try {
				luggage.setLuggageId(inputFile.readInt());
				luggage.setColor(inputFile.readUTF());
				consumption.addData(luggage);
			}//end try
			catch (EOFException eofe){}
			catch (IOException ioe){
				System.out.println(ioe.getMessage());
				System.exit(1125);
			}//end catch
			break;
		}//end switch
	}//end loadItems
}//end DataInput