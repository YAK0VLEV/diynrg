package tests; 

/**
 * @author Kevin Nguyen
 * Test class for the LED class.
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import backend.LED;

public class LEDTest {

	private LED myLED;
	
	private LED mySameLED;
	
	@Before
	public void setUp() throws Exception {
		myLED = new LED(10);
		mySameLED = new LED(10);
	}

	
	@Test (expected = IllegalArgumentException.class) 
	public final void testLED() {
		new LED(-1);
	}
	@Test
	public final void testGetPriceForQuantity() {
		assertTrue(myLED.getPriceForQuantity() == mySameLED.getPriceForQuantity());
	}

	@Test
	public final void testGetEnergyConsumptionForQuantity() {
		assertFalse(myLED.getEnergyConsumptionForQuantity() == mySameLED.getBaseEnergyConsumptionForQuantity());
	}

	@Test
	public final void testGetBaseEnergyConsumptionForQuantity() {
		float random = -1; 
		
		assertFalse(myLED.getBaseEnergyConsumptionForQuantity() == random);
	}

}
