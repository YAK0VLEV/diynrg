/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import backend.TriplePane;

/**
 * @author Kevin Nguyen
 * Test class for Triple Pane class.
 *
 */
public class TriplePaneTest {
	private TriplePane myTP;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		myTP = new TriplePane(10, 10);
	}

	
	/**
	 * Test method for {@link backend.TriplePane#getPriceForQuantity()}.
	 */
	@Test
	public final void testGetPriceForQuantity() {
		double diff = 107.7 - myTP.getPriceForQuantity();
		diff = Math.abs(diff);
		assertTrue(diff < 1);
	}

	/**
	 * Test method for {@link backend.TriplePane#getTriplePaneEnergyConsumption()}.
	 */
	@Test
	public final void testGetTriplePaneEnergyConsumption() {
		double diff = 19.989159 - myTP.getTriplePaneEnergyConsumption();
		diff = Math.abs(diff);
		assertTrue(diff < 1);
	}



	/**
	 * Test method for {@link backend.TriplePane#getEnergyConsumptionForQuantity()}.
	 */
	@Test
	public final void testGetEnergyConsumptionForQuantity() {
		double diff = 19.989159*10*24 - myTP.getEnergyConsumptionForQuantity();
		diff = Math.abs(diff);
		assertTrue(diff < 1);
	}


}
