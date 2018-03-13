   /**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import backend.MineralWool;

/**
 * @author Kevin Nguyen
 * Test class for Mineral Wool.
 *
 */
public class MineralWoolTest {

	private MineralWool myMw;
	private MineralWool notMw;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		myMw = new MineralWool(10, 10);
		notMw = new MineralWool(100, 100);
		
	}

	/**
	 * Test method for {@link backend.MineralWool#MineralWool(int, int)}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void testMineralWool() {
		new MineralWool(-1, 10);
	}

	/**
	 * Test method for {@link backend.MineralWool#getMineralWoolEnergyConsumption()}.
	 */
	@Test
	public final void testGetMineralWoolEnergyConsumption() {
		double realVal = 1.3005309;
		double testVal = myMw.getMineralWoolEnergyConsumption();
		System.out.println(testVal);
		assertTrue(Math.abs(realVal - testVal) < 1);
	}


	/**
	 * Test method for {@link backend.MineralWool#getEnergyConsumptionForQuantity()}.
	 */
	@Test
	public final void testGetEnergyConsumptionForQuantity() {
		double realVal = 1.3005309*24*10;
		double testVal = myMw.getEnergyConsumptionForQuantity();
		assertTrue(Math.abs(realVal - testVal) < 1);
	}


}
