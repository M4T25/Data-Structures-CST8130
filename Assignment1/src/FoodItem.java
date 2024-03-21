import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * @author Student: Mateusz Gumienny
 * This class defines super class FoodItem
 * Student Number: 041033057
 * Course: CST8130 301 - Data Structures
 */
class FoodItem
{
	
   // Instance variables to store food item information
   private int itemCode;
   private String itemName;
   private int itemQuantityInStock;
   private double cost = 0.0;
   private double salesPrice;
   private int qty;

   /**
 * Default constructor definition
 */
public FoodItem()
   {
       itemCode = itemQuantityInStock = 0;
       itemName = null;
       cost = salesPrice = 0.0;
   }// End of default constructor
 
   // Method to return the valid integer entered by the user
   // Returns -1 for invalid data
   // Otherwise returns the valid integer
   /**
 * @param in
 * @param message
 * @return data
 */
int validatePositiveIntegerData(Scanner in, String message)
   {
       String input = "";
int data = -1;
// Displays the message
       System.out.print(message);
// Loops till integer data entered by the user
while(!in.hasNextInt())
{
   input = in.next();
   System.out.println("\n Invalid data.");
}
// Accepts data
input = in.next();
// Converts to integer
   data = Integer.parseInt(input);
   // Checks if data is negative returns -1
   if(data < 0)
   {
       System.out.println("Negative data not allowed.");
       return -1;
   }
   // Returns the integer
return data;
   }// End of method
 
   // Method to return the valid integer entered by the user
   // Returns -1 for invalid data
   // Otherwise returns the valid integer
   /**
 * @param in
 * @param message
 * @return -1.0 & data
 */
double validatePositiveDoubleData(Scanner in, String message)
   {
       double input = 0;
       double data = 0;
       // Displays the message
System.out.print(message);
// Loops till double data entered by the user
while (!in.hasNextDouble())
{

   System.out.printf("\"%s\" is not a valid data.\n", input);
   return -1.0;
}
	// Accepts data
	input = in.nextDouble();
	data = input;
   // Checks if data is negative returns -1
   if(data < 0)
   {
       System.out.println("Negative data not allowed.");
       return -1;
   }
   // Returns integer
return data;
   }// End of method
 
   // Method to accept data from the user
   // Returns true for success otherwise returns false
   /**
 * @param in
 * @return intdata or false
 */
boolean addItem(Scanner in)
   {
       // Calls the method to accept valid item code
       // stores the return data
       int intData = validatePositiveIntegerData(in, "\n Enter the code for the item: ");
// Checks if return data is not -1 then valid item code return true
       if(intData != -1)
           itemCode = intData;
       // Otherwise returns false
       else
           return false;
 
       // To skip new line character
       in.nextLine();
 
       // Accepts name of the item
       System.out.print("\n Enter the name for the item: ");
       itemName = in.nextLine();
 
 
       // Calls the method to accept valid quantity
       // stores the return data
       intData = validatePositiveIntegerData(in, "\n Enter the quantity for the item: ");
 
       // Checks if return data is not -1 then valid item code return true
       if(intData != -1)
           itemQuantityInStock = intData;
       // else returns false
       else
           return false;      
 
       // Calls the method to accept valid cost
       // stores the return data
       double doubleData = validatePositiveDoubleData(in, "\n Enter the cost of the item: ");
 
       // Checks if return data is not -1 then valid item code return true
       if(doubleData != -1.0)
           cost = doubleData;
       // else returns false
       else
           return false;
 
       // Calls the method to accept valid price
       // stores the return data
       doubleData = validatePositiveDoubleData(in, "\n Enter the sales price of the item: ");
       if(doubleData != -1.0)
           salesPrice = doubleData;
       // Otherwise returns false
       else
           return false;
       return true;      
   }// End of method
 
   // Method to update quantity
   // Returns true for success otherwise returns false
   /**
 * @param qty
 * @return false or true
 */
boolean updateItem(int qty)
   {
       // Adds parameter quantity with current quantity if it is equals to 0
       // Display error message & return false
       if((qty + itemQuantityInStock) == 0)
       {
           System.out.println("\n Cannot sell quantity becomes 0");
           return false;
       }
       // else update the quantity by adding parameter quantity
       // with current quantity & returns true
       else
       {
           qty += itemQuantityInStock;
           return true;
       }

   }// End of method
 
   // Method to return true if parameter item code is equals to
   // implicit object item code
   /**
 * @param itemCode
 * @return this.itemCode
 */
boolean isEqual(int itemCode)
   {
       return (itemCode == this.itemCode);
   }// End of method
 
   // Method to accept item code from the user
   // Returns true for success otherwise returns false
   /**
 * @param in
 * @return true or false
 */
boolean inputCode(Scanner in)
   {
       // Calls the method to accept valid item code
       // stores the return data
       int intData = validatePositiveIntegerData(in, "\n Enter the code for the item: ");
 
       // Checks if return data is not -1 then valid item code return true
       if(intData != -1)
           return true;
       // else returns false
       else
           return false;
   }// End of method
 
   // Overrides toString() method to return food item information
   @SuppressWarnings("javadoc")
public String toString()
   {
       return "\n Item: " + itemCode + ", Name: " + itemName + ", Quantity: " + itemQuantityInStock +
               " Price: $ " + String.format("%.2f", salesPrice) +
               " Cost: $" + String.format("%.2f", cost);
   }// End of method
}// End of class