import java.util.Scanner;
/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * @author Student: Mateusz Gumienny
 * This class defines sub class Vegetable derived from suer class FoodItem
 * Student Number: 041033057
 * Course: CST8130 301 - Data Structures
 */
class Vegetable extends FoodItem
{
   // Instance variables to store vegetable information
   private String SupplierName;
 
   /**
 * Default constructor definition
 */
Vegetable()
   {
       // Calls base class constructor
       super();
       SupplierName = null;
   }// End of constructor
 
   // Overrides super class method to accept data for preserve item
   @SuppressWarnings("javadoc")
boolean addItem(Scanner in)
   {
       // Calls the super class method addItem if it is success
       // then accept size of the jar
       if(super.addItem(in))
       {
           // To skip new line character
           in.nextLine();
           // Accepts farm supplier name
           System.out.print("\n Enter the name of the orchard supplier: ");
           SupplierName = in.nextLine();
 
           return true;
       }
       // Otherwise invalid data entered for food item
       else
           return false;      
   }// End of method
 
   // Method to search parameter item code in the array of object FoodItem
   // if found return the found index position
   // otherwise returns -1
   /**
 * @param fi
 * @param itemCode
 * @return c or -1
 */
int alreadyExists(FoodItem fi[], int itemCode)
   {
       // Loops till end of the array
       for(int c = 0; c < fi.length; c++)
           // Checks if parameter item code is equals to current object item code
           // return loop variable as found index position
           if(fi[c].isEqual(itemCode))
               return c;
       // Otherwise return -1 for not found
       return -1;
   }// End of method
 
   // Method to update quantity of an item based of parameter index position (pos)
   // Parameter updateType is for buy or sell
   /**
 * @param in
 * @param type
 * @param fi
 * @param pos
 * @return true or false
 */
boolean updateQuantity(Scanner in, boolean type, FoodItem fi[], int pos, int qty)
   {
       // Calls the method to quantity to update
       // stores the return data
       qty = validatePositiveIntegerData(in,
               "\n Enter quantity to: ");
       // Checks if return data is not -1 and update type is true then buy
       if(qty != -1 && type == true)
       {
           // Calls the method to update quantity
           
           return updateItem(qty);//true;
       }
       // Otherwise checks if return data is not -1 and update type is false then sell
       else if(qty != -1 && type == false)
       {
           // Calls the method to update quantity with negative quantity
           
           return updateItem(-qty);//true;
       }
       // Otherwise displays error message
       else
       {
           if(type == true)
               System.out.println("\n Error...could not buy item");
           else
               System.out.println("\n Error...could not sell item");
           return false;
       }
   }// End of method 
 
   // Overrides toString() method to return vegetable item information
   @SuppressWarnings("javadoc")
public String toString()
   {
       return "\n Vegetable item: " + super.toString() +
               "\n Firm Supplier: " + SupplierName;
   }// End of method
}// End of class