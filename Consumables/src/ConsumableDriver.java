/**
 * ConsumableDriver.java
 * Main Driver classes which instantiates objects and calls
 * methods of those objects
 * @author Antonio Dimitrov
 */
public class ConsumableDriver {
	/**
	 * Main method which instantiates objects and calls methods of said objects
	 * @param args
	 */
	public static void main(String[] args) {
		/*Instantiating Objects*/
		DataInput dataInput = new DataInput();
		DataConsumption consumption = new DataConsumption();
		/*Calling Functions*/
		dataInput.runThroughFile(dataInput.openDataFile(), consumption);
		consumption.loopThroughInstruction(consumption.openInstructionFile());
		consumption.outputSummary();
	}//end main
}//end ConsumableDriver