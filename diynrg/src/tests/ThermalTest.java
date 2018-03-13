/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import backend.Thermal;

/**
 * @author Kevin Nguyen
 * Test class for Thermal.
 *
 */
public class ThermalTest {
	private Thermal myT;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		myT = new Thermal(10, 10);
	}

	/**
	 * Test method for {@link backend.Thermal#Thermal(int, int)}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void testThermal() {
		new Thermal(-1, 100);
	}


	/**
	 * Test method for {@link backend.Thermal#getThermalenergyConsumption()}.
	 */
	@Test
	public final void testGetThermalenergyConsumption() {
		double diff = Math.abs(26.400778 - myT.getThermalenergyConsumption());
		assertTrue(diff < 1);
		assertTrue(diff > 0);
	}


	/**
	 * Test method for {@link backend.Thermal#getEnergyConsumptionForQuantity()}.
	 */
	@Test
	public final void testGetEnergyConsumptionForQuantity() {
		double myVal = 26.400778*24*10;
		double notMyVal = myT.getEnergyConsumptionForQuantity();
		
		double diff = Math.abs(myVal - notMyVal);
		assertTrue(diff > 0 && diff < 1); // Differences must be less than 1 to be correct! 
		
		
	}



}
