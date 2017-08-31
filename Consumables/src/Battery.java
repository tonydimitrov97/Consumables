/**
 * Battery.java
 * Class which provides methods for a battery object
 * @author Antonio Dimitrov
 */
public class Battery implements Consumable, Identifiable{
	
	final int maxCapacity = 3000;
	
	private int batteryId;
	private int capacityLeft;

	@Override
	/**
	 * Returns the battery Id
	 * @return batteryId
	 */
	public int getId() {
		return batteryId;
	}//end getId

	@Override
	/**
	 * Prints summary of output 
	 * i.e Battery: id=2, % left=7.966666666666667
	 */
	public void printSummary() {
		StringBuilder str = new StringBuilder("Battery: id=");
		str.append(batteryId);
		str.append(", % left=");
		str.append(getPercentBatteryLeft());
		
		System.out.println(str);
	}//end printSummary

	@Override
	/**
	 * Implements method of the interface consume which 
	 * changes the capacity based on the integer parameter
	 * and throws an OverConsumedException if capacity becomes negative
	 * @param amount
	 * @return capacityLeft(after it has been altered)
	 */
	public int consume(int amount) throws OverConsumedException {
		/*Subtracts remaining capacity from the parameter to consume*/
		capacityLeft = getRemainingCapacity() - amount;
		
		/*If negative set capacity to zero and throw exception*/
		if (capacityLeft < 0){	
			capacityLeft = 0;
			throw new OverConsumedException();
		}//end if
		
		return capacityLeft;
	}//end consume

	@Override
	/**
	 * Returns the remaining capacity(int)
	 * @return capacityLeft
	 */
	public int getRemainingCapacity() {
		return capacityLeft;
	}//end getRemainingCapacity

	@Override
	/**
	 * Returns the remaining capacity with the units(string)
	 * @return string of capacity with units
	 */
	public String getRemainingCapacityUnits() {
		return capacityLeft + " mAH";
	}//end getRemainingCapacityUnits
	
	/**
	 * Sets the batteryId
	 * @param batteryId
	 */
	public void setBatteryId(int batteryId) {
		this.batteryId = batteryId;
	}//end setBatteryId

	/**
	 * Sets the capacity that is left
	 * @param capacityLeft
	 */
	public void setCapacityLeft(int capacityLeft) {
		//If capacity goes over 3000 then set to 3000
		if (capacityLeft > 3000)
			capacityLeft = 3000;
		
		this.capacityLeft = capacityLeft;
	}//end setCapacityLeft
	
	/**
	 * Gets the percentage of battery left
	 * @return battery percentage
	 */
	public double getPercentBatteryLeft(){
		return (double)capacityLeft/maxCapacity * 100;
	}//end getPercentBatteryLeft
}//end Battery
