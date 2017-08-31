/**
 * Pizza.java
 * Class which provides methods for a pizza object
 * @author Antonio Dimitrov
 */
public class Pizza implements Consumable, Identifiable{

	final int maxSlices = 8;
	
	private int diameter;
	private String flavor;
	private int pizzaId;
	private int slicesLeft = maxSlices;
	
	/**
	 * Retrieves Id of pizza
	 * @return pizzaId
	 */
	@Override
	public int getId() {
		return pizzaId;
	}//end getId
	
	/**
	 * Prints pizza summary
	 */
	@Override
	public void printSummary() {
		StringBuilder str = new StringBuilder("Pizza: id=");
		str.append(pizzaId);
		str.append(", diameter=");
		str.append(diameter);
		str.append(", flavor=");
		str.append(flavor);
		str.append(", rem_surf_area=");
		str.append(getRemainingSurfaceArea());
		
		System.out.println(str);
	}//end printSummary
	
	/**
	 * Consumes slices of pizza 
	 * @throws OverConsumedException if pizza to be consumed is more 
	 * 		   than what's left
	 * @param amount - the amount of slices to consume
	 */
	@Override
	public int consume(int amount) throws OverConsumedException {
		slicesLeft = getRemainingCapacity() - amount;
		
		/*Checks whether or not to throw exceptions*/
		if (slicesLeft < 0)	{
			slicesLeft = 0;
			throw new OverConsumedException();
		}//end if
		
		return slicesLeft;
	}//end consume
	
	/**
	 * Retrieves the amount of slices of left
	 * @return slicesLeft(int)
	 */
	@Override
	public int getRemainingCapacity() {
		return slicesLeft;
	}//end getRemainingCapacity
	
	/**
	 * Retrieves the amount left with units
	 * @return slicesLeft with units(string)
	 */
	@Override
	public String getRemainingCapacityUnits() {
		return slicesLeft + " slices";
	}//end getRemainingCapacityUnits
	
	/**
	 * Sets the diameter of the pizza
	 * @param diameter(int)
	 */
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}//end setDiameter
	
	/**
	 * Sets the flavor of the pizza
	 * @param flavor(string)
	 */
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}//end setFlavor
	
	/**
	 * Sets the Id of the pizza
	 * @param pizzaId(Id)
	 */
	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}//end setPizzaId	
	
	/**
	 * Does the calculations and returns the remaining
	 * surface area of the pizza
	 * @return remaining surface area(int)
	 */
	public double getRemainingSurfaceArea(){
	
		/*PI(r)^2/8 Which is the surface area per slice*/
		double surfaceAreaPerSlice = Math.PI * 
				Math.pow(((double)diameter/2), 2)/maxSlices;
		
		return surfaceAreaPerSlice * slicesLeft;
	}//end getRemainingSurfaceArea
}//end Pizza