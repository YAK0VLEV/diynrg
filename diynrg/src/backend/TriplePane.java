package backend;
/**
 * concrete class for Glazed Window
 * 
 * @author mike briden
 *
 */
public class TriplePane extends Window {
	/**
	 * Cost for Thermal insulation per square foot.
	 */
	private float myItemCost = (float) 10;
	
	/**
	 * Insulation energy consumption is 0 for insulation.
	 */
	private int myEnergyConsumption = 0;
	
	/**
	 * R value for a triple pane glazed window, equals 1/UFACTOR
	 * 
	 */
	 private final float TriplePaneR = (float) (1.0 / 0.53);
	 
	 /**
	  * day degree days
	  */
	 private final float DDH = (float) 4697.0;
	
	 
	 /**
		 * Constructor for Triple Pane Class
		 * @param theQuantity
		 * @param theArea
		 */
		public TriplePane( int theQuantity, int theArea) {
			super(theQuantity, theArea);
		}
		
		/**
		 * A type of window.
		 * 
		 * @return the window type name.
		 */
		@Override
		public String name() {
			return "Triple Pane window";
		}

		/**
		 * Access to the cost of the Triple window cost.
		 * 
		 * @return cost of thermal window per sq foot.
		 */
		public float getTriplePanecost() {
			return myItemCost;
		}
		
		/**
		 * The total price for a chosen number of 
		 * windows for a given Area type of items.
		 * quantity is set to one.
		 * @return cost * quantity.
		 */
		@Override
		public float getPriceForQuantity() {
			return getTriplePanecost() * getQuantity() * getArea();
		} 
		
		/**
		 * Access to the Energy Consumption of the window type.
		 * 
		 * @return Energy Consumption of the Thermal window insulation.
		 */
		public float getTriplePaneEnergyConsumption() {
			int heatingValueElec = 3412;   // BTU per KW for a 100% efficient electric heater
			float energy = 0;
			//BTUs lost per year
			energy = (float) ((float) getArea() * DDH * 24 / TriplePaneR);
			
			//energy lost per year with heating value of 100% electric heater
			energy = (float) (energy/(heatingValueElec *1));

			//convert to energy kW lost per hour
			energy = energy/(365*24) *1000;

			return energy;
		}
		
		/**
		 * Access to the Energy Consumption for worst window type single pane.
		 * 
		 * @return Energy Consumption/loss of single pane window per hour.
		 */
		public float getWorstedEnergyConsumption() {
			int heatingValueElec = 3412;   // BTU per KW for 100% 
			float energy = 0;
			
			//BTUs lost per year
			energy = (float) ((getArea() * DDH * 24.0) / worstRValue() );
			
			//energy lost per year with heating value of 100% electric heater
			energy = (float) (energy/(heatingValueElec *1) );
			
			//convert to energy kW lost per hour
			energy = (float) (energy/(365*24)) * 1000;;
			
			return energy;
		}

		/**
		 * The total Energy Consumption per hour for a chosen number of 
		 * the triple pane window type of items.
		 * 
		 * @return energy consumption * quantity.
		 */
		@Override
		public float getEnergyConsumptionForQuantity() {
			return 24 * getTriplePaneEnergyConsumption() * getQuantity();
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
