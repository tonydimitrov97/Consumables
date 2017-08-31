/**
 * Luggage.java
 * Class which provides methods for a luggage object
 * @author Antonio Dimitrov
 */
public class Luggage implements Identifiable{

	private String color;
	private int luggageId;
	
	/**
	 * Retrieves the luggage Id
	 * @return luggageId(int)
	 */
	@Override
	public int getId() {
		return luggageId;
	}

	/**
	 * Prints the summary of the Luggage
	 */
	@Override
	public void printSummary() {
		StringBuilder str = new StringBuilder("Luggage: id=");
		str.append(luggageId);
		str.append(", color=");
		str.append(color);
		
		System.out.println(str);
	}//end printSummary

	/**
	 * Sets the luggage color
	 * @param color - string of the type of color the luggage is
	 */
	public void setColor(String color) {
		this.color = color;
	}//end set Color

	/**
	 * Sets the luggageId
	 * @param luggageId
	 */
	public void setLuggageId(int luggageId) {
		this.luggageId = luggageId;
	}//end setLuggageId
}//end Luggage