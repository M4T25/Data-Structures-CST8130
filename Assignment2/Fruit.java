import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * File: Fruit.java
 * Description: This class represents the fruit items that inherits properties from FoodItem class
 * Student Name: Mateusz Gumienny
 * Student Number: 041033057
 * Assignment: 2
 * Course: CST8130_Data Structures
 * @author Mateusz Gumienny
 * @version 2.0
 * @since 1.0
 *
 */
public class Fruit extends FoodItem {

    /** The orchard name. */
    private String orchardName;

    /**
     * Instantiates a new Fruit.
     */
    protected Fruit() {
        super();
    }

    /**
     * @return String of the values in the inventory
     * @see FoodItem#toString()
     */
    @Override
    public String toString() {
        return super.toString() + " orchard supplier: " + orchardName;
    }

    /**
     * Output item to the writer just the data portion of it, no description needed
     *
     * @param writer the writer
     */
    public void outputItem(Formatter writer) {
        super.outputItem(writer);
        writer.format("\n%s", orchardName);
    }

    /**
     * Adds a Fruit item
     *
     * @param scanner from main, either Scanner(System.in) or Scanner(File)
     * @param fromFile 
     * @return true, if successfully added Item
     */
    public boolean addItem(Scanner scanner, boolean fromFile) {
        //Adds item info and returns a boolean value of whether the operation was successful or not

        if (super.addItem(scanner, fromFile)) {
            //if successfully read the basic Food Item inputs
            if (fromFile) {
                //Reading input from file
                if (!scanner.hasNextLine()) {
                    return false;
                }
                orchardName = scanner.nextLine();
                return true;
            } else {
                //Reading inputs from user
                String userInput;
                do {
                    System.out.print("Enter the name of the orchard supplier: ");
                    userInput = scanner.nextLine().trim();
                } while (userInput.isEmpty());
                orchardName = userInput;
                return true;
            }
        }
        return false;
    }
}