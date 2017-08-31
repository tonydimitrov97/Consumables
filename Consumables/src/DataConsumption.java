/**
 * DataConsumption.java
 * Class which process data in the arrayList based on the
 * consumption instructions
 * @author Antonio Dimitrov
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataConsumption {
	
	private ArrayList<Identifiable> loadedData = new ArrayList<Identifiable>();
	
	/**
	 * Adds identifiable type to array list
	 * @param identifiable
	 */
	public void addData(Identifiable identifiable){

		loadedData.add(identifiable);
	}//end addData
	
	/**
	 * Opens the instruction file and handles all exceptions with it
	 * @return consumption instructions
	 */
	public Scanner openInstructionFile() {

		String filename = "consumption_instructions.txt";
		File file = new File(filename);	
		Scanner inputFile = null;
		
		try{
			inputFile = new Scanner(file);
		}//end try
		catch (FileNotFoundException fne){
			System.exit(1125);
		}//end catch
		
		return inputFile;
	}//end openInstructionFile
	
	/**
	 * Tracks down the correct Identifiable based upon the Id parameter
	 * @param productId
	 * @return - Identifiable
	 */
	public Identifiable findProductById(int productId){
		Identifiable temp;
		
		/*Loops through array list until product is founded*/
		for (int i = 0; i < loadedData.size(); i++){
			temp = loadedData.get(i);
			if (productId == temp.getId())
				return temp;
		}//end for
		
		return null;					//If no Id is found, return null
	}//end findProductById
	
	/**
	 * Loops through instructions and performs actions based upon them
	 * @param inputFile
	 */
	public void loopThroughInstruction(Scanner inputFile){
		int lineNumber = 1;
		
		String[] details;
		String line;
		
		System.out.println
		("==================================================");
		System.out.println("           Executing instructions");
		System.out.println
		("==================================================");
		
		//Begin Looping
		while(inputFile.hasNextLine()){
			
			line = inputFile.nextLine();
			details = line.split(",");
			
			//Checks for valid Id input, if invalid skip it
			//and go to next line
			try{
				Integer.parseInt(details[0].trim());
			}//end try
			catch( NumberFormatException nfe){
				line = inputFile.nextLine();
				details = line.split(",");
			}//end catch
			
		//If Id is not found
			if (findProductById(Integer.parseInt(details[0].trim())) == null)
				System.out.printf("%d - %s not found.\n", lineNumber,
						details[0]);
		//If product is not a consumable	
			else if (!(findProductById(Integer.parseInt(details[0].trim()))
					instanceof Consumable))
				System.out.printf("%d - %s not consumable.\n", lineNumber,
						details[0]);
		//If product is consumable	
			else if (findProductById(Integer.parseInt(details[0].trim())) instanceof Consumable){
				//Checks for valid consume amount input
				//If invalid set to 0
				try{
					Integer.parseInt(details[1].trim());	
				}//end try
				catch( NumberFormatException nfe){
					details[1] = "0";
				}//end catch
				
				try {
					((Consumable)findProductById(Integer.parseInt(details[0].trim())))
					.consume(Integer.parseInt(details[1].trim()));
					
					//If no exception is thrown
					System.out.printf("%d - %s has %s remaining\n", lineNumber,
							details[0].trim(), 
							((Consumable)findProductById(Integer.parseInt
								(details[0].trim()))).getRemainingCapacityUnits());
				}//end try
				
				catch (OverConsumedException oce){
					//If exception is thrown
					System.out.printf
					("%d - %s didn't have enough and is now empty.\n", 
							lineNumber, details[0].trim());
				}//end catch
			}//end else
			lineNumber++;					//increments line number to be output
		}//end while
	}//end loopThroughInstruction
	
	/**
	 * Outputs the data Summary
	 */
	public void outputSummary(){
		
		System.out.println
		("\n==================================================");
		System.out.println
		("   Summary of data after running instructions");
		System.out.println
		("==================================================");
  
		//Loops through each Id and prints proper summary
		for (int i = 0; i < loadedData.size(); i++)
			loadedData.get(i).printSummary(); 
	}//end outputSummary
}//end DataConsumption