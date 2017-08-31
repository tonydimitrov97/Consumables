/**
 * Consumable.java
 * Interface for consumables
 * @author Antonio Dimitrov
 */
public interface Consumable {

	public int consume(int amount) throws OverConsumedException;
	public int getRemainingCapacity();
	public String getRemainingCapacityUnits();	
}//end Consumable