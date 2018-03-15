package backend;

/**
 * The concrete class for the CFL type bulbs.
 * 
 * @author Denis Yakovlev
 */
public class CFL extends Bulb {
	
	/**
	 * Cost for CFL type bulb.
	 */
	private float myItemCost = 2;
	
	/**
	 * Energy consumption by this types of bulbs watts / hour.
	 */
	private int myEnergyConsumption = 50;
	
	/**
	 * The concrete class constructor for the CFL type bulbs.
	 * 
	 * @param theQuantity - total number chosen items.
	 */
	public CFL(int theQuantity) {
		super(theQuantity, 0);
	}

	/**
	 * A type of bulb.
	 * 
	 * @return the bulb type name.
	 */
	@Override
	public String name() {
		return "CFL";
	}
	
	/**
	 * Access to the cost of the CFL bulb.
	 * 
	 * @return cost of CFL bulb.
	 */
	public float getCFLcost() {
		return myItemCost;
	}
	
	/**
	 * Access to the Energy Consumption of the CFL bulb.
	 * 
	 * @return Energy Consumption of the CFL bulb.
	 */
	public float getCFLenergyConsumption() {
		return myEnergyConsumption;
	}
	
	/**
	 * The total price for a chosen number of 
	 * the CFL type of items.
	 * 
	 * @return cost * quantity.
	 */
	@Override
	public float getPriceForQuantity() {
		return getCFLcost() * getQuantity();
	}
	
	/**
	 * @author mike briden 3/2/18
	 * The total Energy Consumption per day for 12 hours a day for a chosen number of 
	 * the CFL type of items.
	 * 
	 * @return the number of watts
	 */
	@Override
	public float getEnergyConsumptionForQuantity() {
		return 12 * getCFLenergyConsumption() * getQuantity();
	}
	
	/**
	 * @author mike briden 3/2/18
	 * get the Energy Consumption per day for 12 hours for a chosen number 
	 * of incandescent bulbs
	 * @return
	 */
	public float getBaseEnergyConsumptionForQuantity() {
		return 12 * worstEnergy() * getQuantity();
	}
	
}
