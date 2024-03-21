import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * File: Vegetable.java 
 * Description: This class represents vegetable items and inherits properties from FoodItem class
 * Student Name: Mateusz Gumienny
 * Student Number: 041033057
 * Assignment: 2 Course: CST8130_Data Structures
 * 
 * @author Mateusz Gumienny
 *
 */
public class Vegetable extends FoodItem {

	/** The farm name. */
	private String farmName;

	protected Vegetable() {}

	@Override
	public String toString() {
		return super.toString() + " farm supplier: " + farmName;
	}

	public void outputItem(Formatter writer) {
		super.outputItem(writer);
		writer.format("\n%s", farmName);
	}

	@SuppressWarnings("javadoc")
	public boolean addItem(Scanner scanner, boolean fromFile) {
		if (super.addItem(scanner, fromFile)) {
			if (fromFile) {
				if (!scanner.hasNextLine()) {
					return false;
				}
				farmName = scanner.nextLine();
				return true;
			} else {
				while (true) {
					System.out.print("Enter the name of the farm supplier: "); 
					String userInput = scanner.nextLine(); 
					if (userInput.replace(" ", "").isEmpty()) {
						System.out.println("You must enter the name of the farm supplier");
						continue; 
					}
					farmName = userInput;
					return true;
				}
			}
		}
		return false;
	}
}