import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * File: Inventory.java 
 * Description: This class represents the Inventory and allows users to manipulate, save,
 * read from/to a file in a specified path 
 * Student Name: Mateusz Gumienny
 * Student Number: 041033057
 * Assignment2 
 * Course: CST8130
 * 
 * @author Mateusz Gumienny
 * @version 2.0
 * @since 1.0
 *
 */
public class Inventory {

	/** The inventory of FoodItems. */
	private ArrayList<FoodItem> inventory;

	/** The path where the inventory file is read or saved at */
	private String PATH = "C:\\Users\\ROG\\cst8130\\assignment2\\src\\";

	/** The text file regex. */
	private String TEXT_FILE_REGEX = "^([^\\s]+)(\\.(?i)txt)$";

	/**
	 * Instantiates a new inventory.
	 */
	protected Inventory() {
// For now, limit the inventory array to a maximum of 20 entries
		inventory = new ArrayList<FoodItem>();
	}

	/**
	 * Gets the file name.
	 *
	 * @param scanner the scanner
	 * @param toAsk   the to ask
	 * @return the file name
	 */

	private String getFileName(Scanner scanner, String toAsk) {
		System.out.println("Name of the file to " + toAsk + ": ");
		String fileName = scanner.nextLine();

//check valid text file format
		if (!Pattern.matches(TEXT_FILE_REGEX, fileName)) {
			return null;
		}

		return fileName;
	}

	/**
	 * @return String of the values in the inventory
	 */
	public String toString() {
// returns a String of the values
		String toReturn = "";
		for (int i = 0; i < inventory.size(); i++) {
			toReturn += inventory.get(i).toString();
			toReturn += "\n";
		}
		return toReturn;
	}

	/**
	 * Checks if a FoodItem with the same code exists.
	 *
	 * @param item (FoodItem) to compare the code to
	 * @return int value of the item's index in inventory, if doesn't match then
	 *         returns -1
	 */
	protected int alreadyExists(FoodItem item) {
// Returns the index of a FoodItem in the inventory array
// with the same itemCode as the FoodItem object in the parameter list
// else returns -1

		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).compareTo(item) == 0) {
				return i;
			}
		}
// else
		return -1;

	}

	/**
	 * Saves inventory to file.
	 *
	 * @param scanner the scanner
	 */

	public void saveToFile(Scanner scanner) {
	    //save the current inventory data into the text file
	    Formatter writer = null;

	    try {
	        String fileName = getFileName(scanner, "save to");
	        if (fileName == null) {
	            throw new InputMismatchException();
	        }
	        File outputTextFile = new File(PATH + fileName);
	        if (!outputTextFile.exists()) {
	            outputTextFile.createNewFile();
	            System.out.println("Creating new file...");
	        } else {
	            System.out.println("Adding to file...");
	        }

	        int numItems = 0;
	        String origComponents = "";
	        ArrayList<Integer> origItemCodes = new ArrayList<Integer>();

	        Scanner reader = new Scanner(outputTextFile);
	        if (reader.hasNext()) {
	            //if file already has components
	            numItems = Integer.valueOf(reader.nextLine());
	            //copy the values in the file to an array
	            while (reader.hasNext()) {
	                int itemCode = Integer.valueOf(reader.nextLine());
	                origItemCodes.add(itemCode);
	                origComponents += scanner.nextLine(); // itemName
	                origComponents += scanner.nextLine(); // itemQuantityInStock
	                origComponents += scanner.nextLine(); // itemPrice
	                origComponents += scanner.nextLine(); // itemCost
	            }
	        }
	        reader.close();

	        //open the output file
	        writer = new Formatter(outputTextFile);
	        writer.flush(); // clear the file
	        writer.format("%d", (int) numItems + inventory.size()); // write correct number of FoodItems
	        if (!origComponents.replace(" ", "").isEmpty()) {
	            writer.format("\n%s", origComponents); // add in the original data
	        }

	        for (FoodItem item : inventory) {
	            //check for duplicate item code
	            for (Integer origCode : origItemCodes) {
	                if (item.getItemCode() == origCode) {
	                    //duplicate item code
	                    System.out.println("ERROR: Duplicate item code");
	                    throw new InputMismatchException();
	                }
	            }
	            //append item type
	            if (item instanceof Fruit) {
	                writer.format("\n%s", "f");
	            } else if (item instanceof Vegetable) {
	                writer.format("\n%s", "v");
	            } else if (item instanceof Preserve) {
	                writer.format("\n%s", "p");
	            } else {
	                throw new InputMismatchException();
	            }
	            //append extra information
	            item.outputItem(writer);
	        }
	        System.out.println("Saved file successfully");

	    } catch (IOException e) {
	        System.out.println("ERROR: An error occurred");
	    } catch (NumberFormatException e) {
	        System.out.println("ERROR: Invalid text file");
	    } catch (InputMismatchException e) {
	        System.out.println("ERROR: Invalid text file");
	    }

	    try {
	        writer.close();
	    } catch (NullPointerException e) {
	    }
	}

	public void readFromFile(Scanner scanner) {
// Upon read, find a duplicate itemCode, abort reading in the file.
// Valid FoodItems before that one should remain in the inventory and an appropriate error message should be displayed
		Scanner reader = null;
		try {
			String file = getFileName(scanner, "read from");
			if (file == null) {
				throw new InputMismatchException();
			}
			File inputTextFile = new File(PATH + file);
			if (!inputTextFile.exists()) {
				throw new FileNotFoundException();
			}
			System.out.println("Reading from file...");

			reader = new Scanner(inputTextFile);
			int numOfItems = Integer.valueOf(reader.nextLine());
			if (!reader.hasNextLine()) {
//Only has a zero in the file
				System.out.println("ERROR: Empty text file");
				reader.close();
				return;
			}
			for (int i = 0; i < numOfItems; i++) {
//for every item in the list
				if (!addItem(reader, true)) {
					throw new InputMismatchException();
				}
			}
			System.out.println("Succesfully read inputs from file");
			return;
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found, ignoring...");
		} catch (InputMismatchException e) {
			System.out.println("Error Encountered while reading the file, aborting...");
		}
		try {
			reader.close();
		} catch (NullPointerException e) {
		}
	}

	/**
	 * Gets the food item type.
	 *
	 * @param itemType the item type
	 * @return the type
	 */

	private FoodItem getType(String itemType) {
// checks the Item type and returns a instance of the corresponding FoodItem
// returns null if invalid String
		switch (itemType) {
		case "f":
			return new Fruit();
		case "p":
			return new Preserve();
		case "v":
			return new Vegetable();
		default:
			return null;
		}
	}

	/**
	 * Adds the FoodItem to the inventory.
	 *
	 * @param scanner  from main is passed on
	 * @param fromFile a boolean value specifying whether the data is being inputted
	 *                 from a file or not
	 * @return true if successfully added item, otherwise false
	 */
	public boolean addItem(Scanner scanner, boolean fromFile) {

// The new item to add
		FoodItem newItemToAdd;
		newItemToAdd = null;

		if (fromFile) {
//adding values from the text file
			newItemToAdd = getType(scanner.nextLine());
			if (newItemToAdd == null) {
//corrupted file
				return false;
			}
		} else {
//adding values from user
//Get Type
			while (newItemToAdd == null) {
				System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)? ");
				newItemToAdd = getType(scanner.nextLine().toLowerCase());
			}
		}

		if (!newItemToAdd.addItem(scanner, fromFile)) {
			return false;
		}

//check if item code is overlapping
// If the user tries to enter a code that already exists, an error message should be displayed, 
// entry should not continue, the program should go back to the main menu and display it again
		if (alreadyExists(newItemToAdd) != -1) {
// Overlapping item code
			System.out.println("ERROR: Item code already exists");
			return false;
		} else {
// no overlapping itemcode -> try to add value
			int indexToBePlaced = inventory.size();
			for (int i = inventory.size() - 1; i >= 0; i--) {
				if (newItemToAdd.compareTo(inventory.get(i)) < 0) {
//if the new item's itemcode is less than the one in the inventory
					indexToBePlaced = i;
				} else {
					break;
				}
			}
			inventory.add(indexToBePlaced, newItemToAdd);
			return true; // successful
		}

	}

	/**
	 * Update quantity of items: buy or sell item.
	 *
	 * @param scanner the scanner from main is passed on
	 * @param buyOrSell value of whether the user is buying or not
	 * @return true if successfully modified the quantity, false if not
	 */
	protected boolean updateQuantity(Scanner scanner, boolean buyOrSell) {
// Reads in an itemCode to update and quantity to update by and updates that item by the input quantity in the inventory array.
// The boolean parameter is used to denote whether buying operation (true) or selling operation (false) is occurring.
// Method returns true/false on whether update was successful or not

		String userInput, operation;
		operation = buyOrSell ? "buy" : "sell"; // set string to ask

		if (inventory.size() > 0) {
//need to have data in inventory
			try {
// Get item code to update
// Create a temporary Food item to use its method
				FoodItem temp = new FoodItem();
				System.out.print("Enter valid item code: ");
				if (!temp.inputCode(scanner, false)) {
//user entered a wrong item code
					return false;
				}

				int indexOfItem = alreadyExists(temp);
				if (indexOfItem == -1) {
//Item does not exist
					System.out.println("Code not found in inventory...");
					throw new InputMismatchException();
				}

//Get number of Item update
				System.out.printf("Enter valid quantity to %s: ", operation); // must be an int
				userInput = scanner.nextLine(); // use nextLine to get the whitespaces
				if (userInput.isEmpty()) {
					throw new NumberFormatException();
				}
				int amount = Integer.valueOf(userInput);
				if (amount < 0) {
					throw new NumberFormatException();
				}

				int buying = buyOrSell ? 1 : -1; // selling: set the buying value to a negative so can subtract
				if (inventory.get(indexOfItem).updateItem(amount * buying)) {
//successfully updated list
					return true;
				} else {
					System.out.println("Insufficient stock in inventory...");
					throw new InputMismatchException();
				}

			} catch (NumberFormatException e) {
				System.out.printf("Invalid quantity...");
			} catch (InputMismatchException e) {

			}
		}
		System.out.printf("Error...could not %s item\n", operation);
		return false; // unsuccessful
	}

	/**
	 * Search for the item.
	 *
	 * @param scanner the scanner
	 */

	public void searchForItem(Scanner scanner) {
		System.out.print("Enter the code for the item: ");
		String userInput = scanner.nextLine();

		try {
			int itemCode = Integer.valueOf(userInput);
			for (FoodItem each : inventory) {
				if (each.getItemCode() == itemCode) {
					System.out.println("Item: " + each.toString());
					return;
				}
			}
		} catch (NumberFormatException e) {
		}
		System.out.println("Code not found in inventory...");

	}
}
