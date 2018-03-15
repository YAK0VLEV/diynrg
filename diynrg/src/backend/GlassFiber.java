package backend;

/**
 * The concrete class for the glass fiber type insulation.
 * 
 * @author mike briden
 */

public class GlassFiber extends Insulation {
	/**
	 * Cost for Glassfiber insulation per square foot.
	 */
	private float myItemCost = (float) 3;
	
	/**
	 * Insulation energy consumption is 0.
	 */
	private int myEnergyConsumption = 0;
	
	/**
	 * R value for our updated insulation
	 * 
	 */
	 private final float GLASSR = (float) 19.0;
	 
	 /**
	  * day degree days
	  */
	 private final float DDH = (float) 4697.0;
	 
	 
	/**
	 * 
	 * @param theArea
	 */
	public GlassFiber(int theQuantity, int theArea) {
		super(theQuantity, theArea);
	}
	
	/**
	 * A type of insulation.
	 * 
	 * @return the insulation type name.
	 */
	@Override
	public String name() {
		return "Glassfiber";
	}

	/**
	 * Access to the cost of the glass fiber insulation.
	 * 
	 * @return cost of glass fiber insulation.
	 */
	public float getGlassFibercost() {
		return myItemCost;
	}

	/**
	 * Access to the Energy Consumption of the Insulation type.
	 * 
	 * @return Energy Consumption of the glass fiber insulation.
	 */
	public float getGlassFiberEnergyLoss() {
		return myEnergyConsumption;
	}
	
	/**
	 * Access to the Energy Consumption of the Insulation type.
	 * 
	 * @return Energy Consumption of the glass fiber insulation.
	 */
	public float getGlassFiberEnergyConsumption() {
		int heatingValueElec = 3412;   // BTU per KW
		float energy = 0;
		
		//savings per year
		energy = (float) ((float) getArea() * DDH * 24.0 / GLASSR);
		
		//energy lost per year with heating value of 100% electric heater
		energy = (float) (energy/(heatingValueElec *1));
		
		//convert to energy kW lost per hour
		energy = energy/(365*24) *1000;
	
		return energy;
	}
	
	/**
	 * Access to the Energy Consumption of the Insulation type.
	 * 
	 * @return Energy Consumption of the glass fiber insulation R13.
	 */
	public float getWorstedEnergyConsumption() {
		int heatingValueElec = 3412;   // BTU per KW
		float energy = 0;
		
		//BTUs lost per year
		energy = (float) ((getArea() * DDH * 24.0) / worstRValue() );
		
		//energy lost per year with heating value of 100% electric heater
		energy = (float) (energy/(heatingValueElec *1) );
		
		//convert to energy kW lost per hour
		energy = (float) (energy/(365*24)) * 1000;
		
		return energy;
	}
	
	/**
	 * The total price for a chosen number of 
	 * rooms for a given Area type of items.
	 * quantity is set to one.
	 * @return cost * quantity.
	 */
	@Override
	public float getPriceForQuantity() {
		return getGlassFibercost() * getQuantity() * getArea();
	}

	/**
	 * The total Energy Consumption per day for a chosen number of 
	 * the glass fiber type of items.
	 * 
	 * @return energy consumption * quantity.
	 */
	@Override
	public float getEnergyConsumptionForQuantity() {
		return 24 * getGlassFiberEnergyConsumption() * getQuantity();
	}
	
	/**
	 * @author mike briden 3/2/18
	 * get the Energy Consumption/loss per day for a chosen number of R13 insulation
	 * @return
	 */
	public float getBaseEnergyConsumptionForQuantity() {
		return 24 * getWorstedEnergyConsumption() * getQuantity();
		
	}
}
