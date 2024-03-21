import java.util.Scanner;
/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * @author Student: Mateusz Gumienny
 * Student Number: 041033057
 * Course: CST8130 301 - Data Structures
 * This class defines sub class Preserve derived from suer class FoodItem
 */
class Preserve extends FoodItem
{
   // Instance variables to store preserve information
   private int jarSize;
 

   /**
 * Default constructor definition
 */
Preserve()
   {
       // Calls base class constructor
       super();
       jarSize = 0;
   }// End of constructor
 
   // Overrides super class method to accept data for preserve item
   @SuppressWarnings("javadoc")
boolean addItem(Scanner in)
   {
       // Calls super class method addItem if it is successful
       // then accept size of the jar
       if(super.addItem(in))
       {
           // Calls the method to jar capacity
           // stores the return data
           int data = validatePositiveIntegerData(in, "Enter the size of the jar in millilitres: ");
 
           // Checks if return data is not -1 then valid
           if(data != -1)
           {
               // Assigns the return data to instance variable
               jarSize = data;
               return true;
           }
           // Otherwise return false invalid jar capacity
           else
               return false;
       }
       // Otherwise invalid data entered for food item
       else
           return false;      
   }// End of method
 
   // Method to search parameter item code in array of object FoodItem
   // if found return the found index position else returns -1
   /**
 * @param fi
 * @param itemCode
 * @return c or -1
 */
int alreadyExists(FoodItem fi[], int itemCode)
   {
       // Loops till end of the array
       for(int c = 0; c < fi.length; c++)
           // Checks if parameter item code is equal to current object item code
           // return loop variable as found index position
           if(fi[c].isEqual(itemCode))
               return c;
       // else return -1 for not found
       return -1;
   }// End of method
 
   // Method to update quantity of an item based of parameter index position (pos)
   // Parameter updateType is for buy or sell
   /**
 * @param in
 * @param updateType
 * @param fi
 * @param pos
 * @return true or false
 */
boolean updateQuantity(Scanner in, boolean updateType, FoodItem fi[], int pos, int qty)
   {
       // Calls method to quantity to update
       // stores the return data
       qty = validatePositiveIntegerData(in,
               "\n Enter quantity to: ");
 
       // Checks if return data is not -1 and update type is true then buy
       if(qty != -1 && updateType == true)
       {
           // Calls method to update quantity
           updateItem(qty);
           return true;
       }
       // else checks if return data is not -1 and update type is false then sell
       else if(qty != -1 && updateType == false)
       {
           // Calls the method to update quantity with negative quantity
           updateItem(-qty);
           return true;
       }
       // else displays error message
       else
       {
           if(updateType == true)
               System.out.println("\n Error...could not buy item");
           else
               System.out.println("\n Error...could not sell item");
           return false;
       }
   }// End of method
 
   // Overrides toString() method to return preserve item information
   @SuppressWarnings("javadoc")
public String toString()
   {
       return "\n Preserve item: " + super.toString() + "\n size:: " + jarSize;
   }// End of method
}//End of class