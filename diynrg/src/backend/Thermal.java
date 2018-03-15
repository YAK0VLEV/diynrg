package backend;
/**
 * concrete class for Thermal Window
 * 
 * @author mike briden
 *
 */
public class Thermal extends Window {
	
	/**
	 * Cost for Thermal insulation per square foot.
	 */
	private float myItemCost = (float) 17;
	
	/**
	 * Insulation energy consumption is 0 for insulation.
	 */
	private int myEnergyConsumption = 0;
	
	/**
	 * R value for a double pane thermal window, equals 1/UFACTOR
	 * 
	 */
	 private final float ThermalR = (float) (1.0 / 0.7);
	 
	 /**
	  * day degree days
	  */
	 private final float DDH = (float) 4697.0;
	
	/**
	 * Constructor for Thermal Class
	 * @param theQuantity
	 * @param theArea
	 */
	public Thermal( int theQuantity, int theArea) {
		super(theQuantity, theArea);
	}
	
	/**
	 * A type of window.
	 * 
	 * @return the window type name.
	 */
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Thermal windows";
	}

	/**
	 * Access to the cost of the thermal window coast.
	 * 
	 * @return cost of thermal window per sq foot.
	 */
	public float getThermalcost() {
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
		return getThermalcost() * getQuantity() * getArea();
	} 
	
	/**
	 * Access to the Energy Consumption of the window type.
	 * 
	 * @return Energy Consumption/loss of the Thermal window per hour.
	 */
	public float getThermalenergyConsumption() {
		int heatingValueElec = 3412;   // BTU per KW for a 100% efficient electric heater
		float energy = 0;
		
		//BTUs lost per year
		energy = (float) ((float) getArea() * DDH * 24 / ThermalR);
		
		//energy lost per year with heating value of 100% electric heater
		energy = (float) (energy/(heatingValueElec *1));

		// convert to kW lost per hour
		energy = energy/(365*24) *1000;
		
		return energy;
	}
	
	
	/**
	 * Access to the Energy Consumption for worst window type single pane.
	 * 
	 * @return Energy Consumption/loss a single pane window per hour.
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
		
		return energy;
	}
	

	/**
	 * The total Energy Consumption per hour for a chosen number of 
	 * the thermal window type of items.
	 * 
	 * @return energy consumption * quantity.
	 */
	@Override
	public float getEnergyConsumptionForQuantity() {
		return 24 * getThermalenergyConsumption() * getQuantity();
	}
	
	/**
	 * @author mike briden 3/2/18
	 * get the Energy Consumption per day per for 24 of single pane windows of size myArea
	 * @return
	 */
	public float getBaseEnergyConsumptionForQuantity() {
		return  24 * getWorstedEnergyConsumption() * getQuantity();
	}

}
