package edu.towson.cis.cosc442.project3.vendingmachine;

// TODO: Auto-generated Javadoc
/**
 * Class for items in the vending machine.
 */
public class VendingMachineItem {

	/** The name. */
	// The name of the item
	private String name;

	/** The price. */
	// The price of the item
	private double price;

	/** The Constant PRICE_LESS_THAN_ZERO_MESSAGE. */
	// Exception message for when the price is less than zero
	private final static String PRICE_LESS_THAN_ZERO_MESSAGE = "Price cannot be less than zero";
	
	/** The Constant INVALID_NAME. */
	// Exception message for when name is blank
	private final static String INVALID_NAME = "Blank item name";
	
	/**
	 * Constructor which fills in the name and price of the item
	 * Precondition: name is not an empty string or blank
	 * Postcondition: The name of the item is set to the the value entered
	 * Precondition: price argument >= 0 and != -0
	 * Postcondition:  The price of the item is set to be the values in the arguments.
	 *
	 * @param name The name of the item
	 * @param price The price of the item
	 * @throws VendingMachineException Thrown if name is blank
	 */
	public VendingMachineItem( String name, double price ) throws VendingMachineException {
		
		if(name.isBlank()) {
			throw new VendingMachineException(INVALID_NAME);
		}else {
			this.name = name;
		}
		
		if( price < 0 || price == -0) {
			throw new VendingMachineException(PRICE_LESS_THAN_ZERO_MESSAGE);
		} else {
			this.price = price;
		}
		
	}
	
	/**
	 * Gets the name of the vending machine item.
	 *
	 * @return The string corresponding to the name of the vending machine item
	 * Postcondition: the actual name of the item is returned
	 */
	public String getName() {
		
        return name;
        
    }
    
    /**
     * Gets the price of the vending machine item.
     *
     * @return The price of the vending machine item in dollars
     * Postcondition: The actual price of the item is returned
     */
    public double getPrice() {
    	
        return price;
        
    }
}
