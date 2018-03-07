package backend;

/**
 * The concrete class for the glass fiber type insulation.
 * 
 * @author mike briden
 */

public class SprayFoam extends Insulation {

	/**
	 * Cost for SprayFoam insulation per square foot.
	 */
	private float myItemCost = (float) 1;
	
	/**
	 * Insulation energy consumption is 0 for insulation.
	 */
	private int myEnergyConsumption = 0;

	/**
	 * R value for our updated insulation
	 * 
	 */
	 private final float FOAMR = (float) 14.0;
	 
	 /**
	  * day degree days
	  */
	 private final float DDH = (float) 4697;
	
	public SprayFoam(int theQuantity, int theArea) {
		super(theQuantity, theArea);
	}
	
	/**
	 * A type of insulation.
	 * 
	 * @return the insulation type name.
	 */
	@Override
	public String name() {
		return "Spray Foam";
	}

	/**
	 * Access to the cost of the mineral wool insulation.
	 * 
	 * @return cost of SprayFoam insulation.
	 */
	public float getSprayFoamcost() {
		return myItemCost;
	}


	
	
	/**
	 * The total price for a chosen number of 
	 * rooms for a given Area type of items.
	 * quantity is set to one.
	 * @return cost * quantity.
	 */
	@Override
	public float getPriceForQuantity() {
		return getSprayFoamcost() * getQuantity();
	}

	/**
	 * Access to the Energy Consumption of the Insulation type.
	 * 
	 * @return Energy Consumption of the Mineral wool insulation.
	 */
	public float getSprayFoamEnergyConsumption(){
		int heatingValueElec = 3412;   // BTU per KW
		float energy = 0;
		
		//BTUs lost per year
		energy = (float) (getArea() * DDH * 24.0 / FOAMR);
		
		//energy lost per year with heating value of 100% electric heater
		energy = (float) (energy/(heatingValueElec *1));
		
		// convert to kW lost per hour
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
		
		// convert to kW lost per hour
		energy = (float) (energy/(365*24)) * 1000;
		
		return energy;
	}
	
	/**
	 * The total Energy Consumption per hour for a chosen number of 
	 * the mineral wool type of items.
	 * 
	 * @return energy consumption * quantity.
	 */
	@Override
	public float getEnergyConsumptionForQuantity() {
		return 24 * getSprayFoamEnergyConsumption() * getQuantity();
	}

	/**
	 * @author mike briden 3/2/18
	 * get the Energy Consumption/loss per day for 24 hours a day for a chosen number 
	 * of r13 insulation pieces of size area
	 * @return energy loss for a given quantity of r13 insulation of size myArea
	 */
	public float getBaseEnergyConsumptionForQuantity() {
		return 24 * getWorstedEnergyConsumption() * getQuantity();
	}
}
