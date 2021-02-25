/**
 * 
 */
package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class VendingMachineItemTest.
 *
 * @author nibby
 */
public class VendingMachineItemTest {

	/** The item 1. */
	VendingMachineItem item1;
	
	/** The bad item. */
	VendingMachineItem badItem;
	
	/** The name test. */
	VendingMachineItem nameTest;
	
	/** The price test. */
	VendingMachineItem priceTest;
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		
		item1 = new VendingMachineItem("Skittles", 2.00);
		
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		
		item1 = null;
		
	}
	
	/**
	 * Bad constructor test.
	 */
	@Test (expected = VendingMachineException.class)
	public void badConstructorTest() {
		
		badItem = new VendingMachineItem("Chips", -8.00);
		
	}
	
	/**
	 * Constructor negative zero price test.
	 */
	@Test (expected = VendingMachineException.class)
	public void ConstructorNegativeZeroPriceTest() {
		
		badItem = new VendingMachineItem("Chips", -0);
		
	}
	
	/**
	 * Constructor empty name test.
	 */
	@Test (expected = VendingMachineException.class)
	public void ConstructorEmptyNameTest() {
		
		badItem = new VendingMachineItem("", 5.50);
		
	}

	/**
	 * Gets the name test.
	 */
	@Test
	public void getNameTest() {
		
		assertEquals("Skittles", item1.getName());
		
	}
	
	/**
	 * Gets the price test.
	 */
	@Test
	public void getPriceTest() {
		
		assertEquals(2.00, item1.getPrice(), 0.001);
		
	}
	
	/**
	 * Constructor name test.
	 */
	@Test
	public void constructorNameTest() {
		
		nameTest = new VendingMachineItem("Oreos", 2.50);
		assertEquals("Oreos", nameTest.getName());
		
	}
	
	/**
	 * Constructor price test.
	 */
	@Test
	public void constructorPriceTest() {
		
		priceTest = new VendingMachineItem("Chocolate Bar", 4.59);
		assertEquals(4.59, priceTest.getPrice(), 0.001);
		
	}

}
