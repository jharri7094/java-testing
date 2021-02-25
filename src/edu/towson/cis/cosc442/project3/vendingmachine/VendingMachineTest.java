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
 * The Class VendingMachineTest.
 *
 * @author nibby
 */
public class VendingMachineTest {
	
	/** The machine. */
	VendingMachine machine;
	
	/** The item 1. */
	VendingMachineItem item1;
	
	/** The item 2. */
	VendingMachineItem item2;
	
	
	/** The bad item. */
	VendingMachineItem badItem;
	

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	// Initializes a new VendingMachine object and creates two VendingMachineItem() objects
	@Before
	public void setUp() throws Exception {
		
		machine = new VendingMachine();
		
		item1 = new VendingMachineItem("Skittles", 2.00);
		item2 = new VendingMachineItem("Doritos", 3.25);
		
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	// Sets the machine, item1, and item2 items to null
	@After
	public void tearDown() throws Exception {
		
		machine = null;
		
		item1 = null;
		item2 = null;
		
	}

	/**
	 * Adds the item slot occupied test.
	 */
	//Test that should throw an exception when an item is added to a slot that is already occupied
	@Test (expected = VendingMachineException.class)
	public void addItemSlotOccupiedTest() {
		
		machine.addItem(item1, "A");
		machine.addItem(item2, "A");
		
	}
	
	
	/**
	 * Adds the item invalid code.
	 */
	// Test that should throw and exception when an invalid slot code is entered
	@Test (expected = VendingMachineException.class)
	public void addItemInvalidCode() {
		
		machine.addItem(item1, "F");
		
	}
	
	/**
	 * Adds the item null item.
	 */
	// Test that should throw and exception when a null item is added to the VendingMachine
	@Test (expected = VendingMachineException.class)
	public void addItemNullItem() {
		
		machine.addItem(null, "C");
		
	}
	
	/**
	 * Adds the item test.
	 */
	//Test should pass if item added is the same as the item in the slot
	@Test
	public void addItemSlotEmptyTest(){
		
		machine.addItem(item1, "A");
		assertSame(item1, machine.getItem("A"));
		
	}
	
	/**
	 * Removes the item if slot empty test.
	 */
	// Test that should throw and exception when an item is removed from a slot that contains no VendingMachineItems
	@Test (expected = VendingMachineException.class)
	public void removeItemIfSlotEmptyTest() {
		
		machine.removeItem("A");
		
	}
	
	/**
	 * Removes the item if not null test.
	 */
	// Test that assures that the slot where an item was removed is empty
	@Test
	public void removeItemIfNotEmptyTest() {
		
		machine.addItem(item1, "A");
		machine.removeItem("A");
		
		assertNull(machine.getItem("A"));
		
	}
	
	
	/**
	 * Removes the item correct item returned test.
	 */
	// Test that checks if the returned item from the removeItem() method is the same as the item that was placed in the slot
	@Test
	public void removeItemCorrectItemReturnedTest() {
		
		machine.addItem(item1, "D");
		
		assertEquals(item1, machine.removeItem("D"));
		
	}
	
	/**
	 * Insert money amount less than zero test.
	 */
	// Test that should throw and exception when money inserted is less than 0
	@Test (expected = VendingMachineException.class)
	public void insertMoneyLessThanZeroTest() {
		
		machine.insertMoney(-1.00);
		
	}
	
	/**
	 * Insert money negative zero test.
	 */
	// Test that should throw an exception when money inserted is equal to -0
	@Test (expected = VendingMachineException.class)
	public void insertMoneyNegativeZeroTest() {
		
		machine.insertMoney(-0);
		
	}
	
	
	/**
	 * Insert money valid amount test.
	 */
	// Test that makes sure when entering a valid amount that the valid amount is reflected in the balance
	@Test
	public void insertMoneyValidAmountTest() {
		
		machine.insertMoney(40.35);
		assertEquals(40.35, machine.getBalance(), 0.001);
		
	}
	
	/**
	 * Gets the balance test.
	 */
	// Test that makes sure the amount inserted into the machine is equal to the balance
	@Test
	public void getBalanceTest() {
		
		machine.insertMoney(2.35);
		machine.insertMoney(1.00);
		machine.insertMoney(3.00);
		
		assertEquals(6.35, machine.getBalance(), 0.001);
		
	}
	
	/**
	 * Make purchase item slot null test.
	 */
	// Test that makes sure the return value after making a purchase is false when the item slot is empty
	@Test
	public void makePurchaseItemSlotNullTest() {
		
		assertEquals(false, machine.makePurchase("A"));
		
	}
	
	/**
	 * Make purchase balance equals price test.
	 */
	// Test that makes sure that the makePurchase() return value is true when the balance is equal to the price of the item
	@Test
	public void makePurchaseBalanceEqualsPriceTest() {
		
		machine.addItem(item1, "A");
		machine.insertMoney(2.00);
		
		assertEquals(true, machine.makePurchase("A"));
		
	}
	
	/**
	 * Make purchase balance more than price test.
	 */
	// Test that makes sure that the makePurchase() return value is true when the balance is more than the price of the item
	@Test
	public void makePurchaseBalanceMoreThanPriceTest() {
		
		machine.addItem(item1, "A");
		machine.insertMoney(40.00);
		
		assertEquals(true, machine.makePurchase("A"));
		
	}
	
	/**
	 * Make purchase balance less than price test.
	 */
	// Test that makes sure the makePurchase() method returns false when the balance is less than the price of the item
	@Test
	public void makePurchaseBalanceLessThanPriceTest() {
		
		machine.addItem(item1, "B");
		machine.insertMoney(1.99);
		
		assertEquals(false, machine.makePurchase("B"));
		
	}
	
	/**
	 * Return change no purchase test.
	 */
	// Test that makes sure the returnChange() method returns the correct amount of change when there is no purchase made
	@Test
	public void returnChangeNoPurchaseTest() {
		
		machine.insertMoney(20.00);
		
		assertEquals(20.00, machine.returnChange(), 0.001);
		
	}
	
	/**
	 * Return change one purchase test.
	 */
	// Test that ensures the returnChange() method returns the correct amount of change after a purchase is made
	@Test
	public void returnChangeOnePurchaseTest() {
		
		machine.addItem(item1, "C");
		machine.insertMoney(20.00);
		machine.makePurchase("C");
		
		assertEquals(18.00, machine.returnChange(), 0.001);
		
	}
	
	/**
	 * Return change zero balance test.
	 */
	// Test that ensures that the returnChange() method returns the correct amount of change when the balance is 0
	@Test
	public void returnChangeZeroBalanceTest() {
		
		assertEquals(0.00, machine.returnChange(), 0.001);
		
	}

}
