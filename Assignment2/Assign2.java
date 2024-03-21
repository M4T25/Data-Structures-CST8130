import java.util.InputMismatchException;
import java.util.Scanner;

public class Assign2 {

	private void displayMenu() {
		System.out.println("Please select an option:");
		System.out.println("1. Add Item to Inventory");
		System.out.println("2. Display Current Inventory");
		System.out.println("3. Buy Item(s)");
		System.out.println("4. Sell Item(s)");
		System.out.println("5. Search for Item");
		System.out.println("6. Save Inventory to File");
		System.out.println("7. Read Inventory from File");
		System.out.println("8. Exit");
		}
	
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

	    Assign2 inventoryMenu = new Assign2();
	    int userOption = 0;
	    int[] optionRange = {1, 8};
	    Inventory inventory = new Inventory();

	    while (userOption != optionRange[1]) {
	        inventoryMenu.displayMenu();

	        try {
	            String userInput = scanner.nextLine();
	            if (userInput.isEmpty()) {
	                throw new InputMismatchException();
	            }
	            userOption = Integer.valueOf(userInput);
	        } catch (InputMismatchException e) {
	            System.out.println("Please enter a valid integer");
	            continue;
	        } catch (NumberFormatException e) {
	            System.out.println("Please enter an integer");
	            continue;
	        }

	        switch (userOption) {
	            case 1:
	                if (inventory.addItem(scanner, false)) {
	                    System.out.println("Item added to inventory");
	                }
	                break;
	            case 2:
	                System.out.println("Current Inventory:\n" + inventory.toString());
	                break;
	            case 3:
	                if (inventory.updateQuantity(scanner, true)) {
	                    System.out.println("Item(s) bought successfully");
	                }
	                break;
	            case 4:
	                if (inventory.updateQuantity(scanner, false)) {
	                    System.out.println("Item(s) sold successfully");
	                }
	                break;
	            case 5:
	                inventory.searchForItem(scanner);
	                break;
	            case 6:
	                inventory.saveToFile(scanner);
	                break;
	            case 7:
	                inventory.readFromFile(scanner);
	                break;
	            case 8:
	                System.out.println("Exiting...");
	                break;
	            default:
	                System.out.println("Invalid option");
	        }
	    }

	    scanner.close();
	}
}
