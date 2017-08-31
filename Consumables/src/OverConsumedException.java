/**
 * OverConsumedException.java
 * Class which extends from the Exception class and defines
 * an OverConsumedException
 * @author Antonio Dimitrov
 */
public class OverConsumedException extends Exception{

	private static final long serialVersionUID = 1L;

	public OverConsumedException(){
		super("Error: Consumed more than available");
	}//end OverConsumedException constructor
}//end OverConsumedException class