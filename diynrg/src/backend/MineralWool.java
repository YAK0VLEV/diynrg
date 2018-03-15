package backend;

/**
 * The concrete class for the glass fiber type insulation.
 * 
 * @author mike briden
 */
public class MineralWool extends Insulation {
	/**
	 * Cost for MineralWool insulation per square foot.
	 */
	private float myItemCost = (float) 10.75;
	

	/**
	 * R value for our updated insulation
	 * 
	 */
	 private final float WOOLR = (float) 29.0;
	
	 /**
	  * day degree days
	  */
	 private final float DDH = (float) 4697.0;
	 
	 
	/**
	 * Insulation energy consumption is 0 for insulation.
	 */
	private int myEnergyConsumption = 0;
	
	public MineralWool( int theQuantity, int theArea) {
		super(theQuantity, theArea);
	}
	
	/**
	 * A type of insulation.
	 * 
	 * @return the insulation type name.
	 */
	@Override
	public String name() {
		return "MineralWool";
	}

	/**
	 * Access to the cost of the mineral wool insulation.
	 * 
	 * @return cost of mineral wool insulation.
	 */
	public float getMineralWoolcost() {
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
		return getMineralWoolcost() * getQuantity() * getArea();
	}

	/**
	 * Access to the Energy Consumption of the Insulation type.
	 * 
	 * @return Energy Consumption/loss of the Mineral wool insulation per hour.
	 */
	public float getMineralWoolEnergyConsumption(){
		int heatingValueElec = 3412;   // BTU per KW for a 100% efficient electric heater
		float energy = 0;
		
		//BTUs lost per year
		energy = (float) ((float) getArea() * DDH * 24 / WOOLR);

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
		int heatingValueElec = 3412;   // BTU per KW for 100% 
		float energy = 0;
		
		//BTUs lost per year
		energy = (float) ((getArea() * DDH * 24.0) / worstRValue() );
		
		//energy lost per year with heating value of 100% electric heater
		energy = (float) (energy/(heatingValueElec *1) );
		
		//convert to energy kW lost per hour
		energy = (float) (energy/(365*24)) * 1000;
		
		//convert savings per hour. and return
		return energy;
	}
	
	
	
	/**
	 * The total Energy Consumption per day for 24 hours a day of use for a chosen number of 
	 * the mineral wool type of items.
	 * 
	 * @return energy consumption * quantity.
	 */
	@Override
	public float getEnergyConsumptionForQuantity() {
		return 24 * getMineralWoolEnergyConsumption() * getQuantity() ;
	}
	
	/**
	 * @author mike briden 3/2/18
	 * get the Energy Consumption per day per 24 hours of use for a chosen number of incandescent bulbs
	 * @return
	 */
	public float getBaseEnergyConsumptionForQuantity() {
		return  24 * getWorstedEnergyConsumption() * getQuantity();
	}
	
}
