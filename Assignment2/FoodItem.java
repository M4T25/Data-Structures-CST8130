import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * File: FoodItem.java Description: This main class displays a menu to
 * manipulate the program and displays results from the inventory display to the
 * screen the inventory, buy an item (i.e. add to the quantity of that item),
 * and sell an item (i.e. subtract from the quantity of that item) 
 * Student Name: Mateusz Gumienny
 * Student Number: 041033057
 * Assignment: 2 
 * Course: CST8130_Data Structures
 * @author Mateusz Gumienny
 * @version 2.0
 * @since 1.0
 *
 */
public class FoodItem implements Comparable<FoodItem> {

	/** The item's code. */
	private int itemCode;

	/** The item's name. */
	private String itemName;

	/** The item's price. */
	private float itemPrice;

	/** The item's quantity in stock. */
	private int itemQuantityInStock;

	/** The item's cost. */
	private float itemCost;

	/** The cents format. */
	private DecimalFormat centsFormat = new DecimalFormat("#0.00");

	/**
	 * Creates a new FoodItem object. Initializes the cents format to round numbers
	 * up if the place value is greater than 5.
	 */
	protected FoodItem() {
		centsFormat.setRoundingMode(RoundingMode.HALF_UP);
	}

	/**
	 * Returns a String representation of this FoodItem object.
	 * 
	 * @return A String representing the values in the inventory. The format is:
	 *         "Item: <code> <name> <quantity> price: $<price> cost: $<cost>"
	 */
	public String toString() {
		String returnString = "Item: " + itemCode + " " + itemName + " " + itemQuantityInStock + " price: $"
				+ centsFormat.format(itemPrice) + " cost: $" + centsFormat.format(itemCost);

		return returnString;
	}

	/**
	 * Outputs this FoodItem object's data to the given formatter, excluding the
	 * description.
	 * 
	 * @param writer The formatter to write the data to.
	 */
	public void outputItem(java.util.Formatter writer) {
		writer.format("\n%d", itemCode);
		writer.format("\n%s", itemName);
		writer.format("\n%d", itemQuantityInStock);
		writer.format("\n%.2f", itemPrice);
		writer.format("\n%.2f", itemCost);
	}

	/**
	 * Gets the item code.
	 * 
	 * @return The item code.
	 */
	public int getItemCode() {
		return itemCode;
	}

	/**
	 * Updates this FoodItem object's quantity by the given amount.
	 * 
	 * @param amount The amount to add to the quantity.
	 * @return True if the quantity was successfully updated, false if not. The
	 *         quantity cannot be less than 0.
	 */
	protected boolean updateItem(int amount) {
		if ((itemQuantityInStock + amount) < 0) {
			return false;
		} else {
			itemQuantityInStock += amount;
			return true;
		}
	}

	/**
	 * Compares this FoodItem object to the given object based on their item codes.
	 * 
	 * @param item The FoodItem object to compare to.
	 * @return An int value indicating the comparison result: 0 if the item codes
	 *         are the same, -1 if this object's code is less than the given
	 *         object's code, 1 if this object's code is greater than the given
	 *         object's code.
	 */
	@Override
	public int compareTo(FoodItem item) {
		return Integer.compare(this.itemCode, item.itemCode);
	}

	/**
	 * Adds the item.
	 *
	 * @param scanner  from main, sither Scanner(System.in) or Scanner(File)
	 * @param fromFile a boolean value specifying whether the data is being inputted
	 *                 from a file or not
	 * @return true, if successful
	 */
	public boolean addItem(Scanner scanner, boolean fromFile) {
	    inputCode(scanner, fromFile);

	    if (fromFile) {
	        try {
	            itemName = scanner.nextLine();
	            itemQuantityInStock = Integer.parseInt(scanner.nextLine());
	            itemPrice = Float.parseFloat(scanner.nextLine());
	            itemCost = Float.parseFloat(scanner.nextLine());
	            return true;
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid file data");
	            return false;
	        }
	    } else {
	        String userInput;
	        int tempInt;
	        float tempFloat;
	        int currentStep = 1;

	        while (currentStep != 5) {
	            try {
	                switch (currentStep) {
	                    case 1:
	                        System.out.print("Enter the name for the item: ");
	                        userInput = scanner.nextLine();
	                        if (userInput.isBlank()) {
	                            throw new InputMismatchException();
	                        }
	                        itemName = userInput;
	                        currentStep++;
	                        break;

	                    case 2:
	                        System.out.print("Enter the quantity for the item: ");
	                        userInput = scanner.nextLine();
	                        if (userInput.isBlank()) {
	                            throw new InputMismatchException();
	                        }
	                        tempInt = Integer.parseInt(userInput);
	                        if (tempInt < 0) {
	                            throw new InputMismatchException();
	                        }
	                        itemQuantityInStock = tempInt;
	                        currentStep++;
	                        break;

	                    case 3:
	                        System.out.print("Enter the cost of the item: ");
	                        userInput = scanner.nextLine();
	                        if (userInput.isBlank()) {
	                            throw new InputMismatchException();
	                        }
	                        tempFloat = Float.parseFloat(centsFormat.format(Float.parseFloat(userInput)));
	                        if (tempFloat < 0) {
	                            throw new InputMismatchException();
	                        }
	                        itemCost = tempFloat;
	                        currentStep++;
	                        break;

	                    case 4:
	                        System.out.print("Enter the sales price of the item: ");
	                        userInput = scanner.nextLine();
	                        if (userInput.isBlank()) {
	                            throw new InputMismatchException();
	                        }
	                        tempFloat = Float.parseFloat(centsFormat.format(Float.parseFloat(userInput)));
	                        if (tempFloat <= 0) {
	                            throw new InputMismatchException();
	                        }
	                        itemPrice = tempFloat;
	                        currentStep++;
	                        break;
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid entry");
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid entry");
	            }
	        }
	        return true;
	    }
	}

	/**
	 * Asks and receives an item code from the user, then checks if it is the right
	 * format (int).
	 *
	 * @param scanner  from main, sither Scanner(System.in) or Scanner(File)
	 * @param fromFile a boolean value specifying whether the data is being inputted
	 *                 from a file or not
	 * @return true, if successfully got itemCode from user
	 */
	public boolean inputCode(Scanner scanner, boolean fromFile) {
// Reads a valid itemCode from the Scanner object and returns true/false if successful

		String userInput;
		if (!fromFile) {
			System.out.print("Enter the code for the item: ");
		}
		userInput = scanner.nextLine();

		try {
// must be an int
			if (userInput.replace(" ", "").isEmpty()) {
//if empty string
				throw new InputMismatchException();
			}
			itemCode = Integer.valueOf(userInput);
			return true;
		} catch (NumberFormatException x) {
			if (!fromFile) {
				System.out.println("Invalid entry");
			}
		}
		return false;

	}

}