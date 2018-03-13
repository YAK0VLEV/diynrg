/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import backend.SprayFoam;

/**
 * @author Kevin Nguyen
 * Test class of Spray Foam Class.
 *
 */
public class SprayFoamTest {
	private SprayFoam mySf;

	/**
	 * @throws java.lang.Exception
	 */
	@Before 
	public void setUp() throws Exception {
		mySf = new SprayFoam(10, 10);
	}
	
	/**
	 * Test method for {@link backend.SprayFoam#SprayFoam(int, int)}. 
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void testSprayFoam() {
		new SprayFoam(-1, -1);
	}
	

	/**
	 * Test method for {@link backend.SprayFoam#GetSprayFoamEnergyConsumption()}.
	 */
	@Test
	public final void testGetSprayFoamEnergyConsumption() {
		double realVal = 2.6939569;
		double testVal = mySf.getSprayFoamEnergyConsumption();
		
		assertTrue(Math.abs(realVal - testVal ) < 1);
	}


}
