import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * @author Student: Mateusz Gumienny
 * Student Number: 041033057
 * Course: CST8130 301 - Data Structures
 * This class contains the main method and a method that displays the main menu
 */
public class Assign1 {
	
	static Scanner in = new Scanner(System.in);
	
	/**
	 * This method displays the main menu which user can pick an option from
	 * then it saves the users input (choice) in system memory
	 * @return in.nextInt();
	 */
	static int displayMenu() {
	    System.out.println("\n\n Please select one of the following: " +
	            "\n 1: Add Item to Inventory \n 2: Display Current Inventory " +
	            "\n 3: Buy Item(s) \n 4: Sell Item(s) \n 5: To Exit");
	        return in.nextInt();
	}
	
	   /**
	    * Main method
	 * @param args
	 */
	public static void main(String[] args)
	   {
	       // Maximum food item capacity 
	       final int MAX = 20;
	       // Creates array of class FoodItem with MAX size
	       FoodItem fi[] = new FoodItem[MAX];
	       int itemCode;
	       int count = 0;
	       int found = -1;
	       int qty = 0;
	       int nQty = -1;
	       // Loops till user choice isn't 5
	       while(true)
	       {
	           // Call method to accept the users choice
	           switch(displayMenu())
	           {
	               case 1:
	                   // Checks if current counter's equal to max size
	                   
	                   if(count == MAX)
	                   {
	                       System.out.println("Inventory Full."); //display message and stop
	                       break;
	                   }
	                   // Accepts choice of food item
	                   System.out.print("\n Do you wish to add a fruit(f), vegetable(v) or " +
	                       "a preserve(p)? ");
	                   char choice = in.next().charAt(0);
	 
	                   // Checks the type of food item
	                   switch(choice)
	                   {
	                       case 'F':
	                       case 'f':
	                           // Creates object of class Fruit
	                           fi[count] = new Fruit();
	                           // Calls method to accept data for fruit
	                           // increase counter by one
	                           fi[count++].addItem(in);
	                       break;
	                       case 'V':
	                       case 'v':
	                           // Creates object of class Vegetable
	                           fi[count] = new Vegetable();
	                           // Calls method to accept data for vegetable
	                           // increase counter by one
	                           fi[count++].addItem(in);
	                       break;
	                       case 'P':
	                       case 'p':
	                           // Creates object of class Preserve
	                           fi[count] = new Preserve();
	                           // Calls method to accept data for preserve
	                           // increase counter by one
	                           fi[count++].addItem(in);
	                       break;
	                       default:
	                           System.out.println("Invalid food type.");
	                   }
	 
	               break;
	               case 2:
	                   // Checks if current counter value = 0, then empty list
	                   if(count == 0)
	                       System.out.println("Empty Inventory.");
	                   // Loop till number of records
	                   for(int c = 0; c < count; c++)
	                   {
	                       // Checks if found object is an instance of Fruit class object
	                       if(fi[c] instanceof Fruit)
	                       {
	                           Fruit f = new Fruit();
	                           // Converts current object to Fruit class object
	                           f = (Fruit)fi[c];
	                           // Display data
	                           System.out.println(f);
	                       }
	                       // Checks if found object is an instance of Vegetable class object
	                       else if(fi[c] instanceof Vegetable)
	                       {
	                           Vegetable v = new Vegetable();
	                           // Converts current object to Vegetable class object
	                           v = (Vegetable)fi[c];
	                           // Display data
	                           System.out.println(v);
	                       }
	                       // Checks if found object is an instance of Preserve class object
	                       else if(fi[c] instanceof Preserve)
	                       {
	                           Preserve p = new Preserve();
	                           // Converts current object to Preserve class object
	                           p = (Preserve)fi[c];
	                           // Display data
	                           System.out.println(p);
	                       }
	                   }
	               break;
	               case 3:
	                   // Accepts item code
	                   itemCode = fi[0].validatePositiveIntegerData(in,
	                       "\n Enter item code to update: ");
	 
	                   // Checks if item code isn't -1 then valid item code
	                   if(itemCode != -1)
	                   {
	                       // Sets found status to -1 (not found)
	                       found = -1;
	                       // Loops till number of records
	                       for(int c = 0; c < count; c++)
	                       {
	                    	// Checks if current object item code is equal to user entered item code then update the found status
	                           if(fi[c].isEqual(itemCode))
	                               found = c;
	                       }
	                   }
	                   // Checks if found status is -1 then display that it's not found
	                   if(found == -1)
	                   {
	                       System.out.println("\n Code not found in inventory...");
	                       break;
	                   }
	                   // Checks if found object is an instance of Fruit class object
	                   if(fi[found] instanceof Fruit)
	                   {
	                       Fruit f = new Fruit();
	                       // Converts found object to Fruit class object
	                       f = (Fruit)fi[found];
	                       // Calls method to update quantity
	                       // Second parameter; true for purchase
	                       f.updateQuantity(in, true, fi, found, qty);
	                   }
	                   // Else, checks if found object is an instance of Vegetable class object
	                   else if(fi[found] instanceof Vegetable)
	                   {
	                       Vegetable v = new Vegetable();
	                       // Converts found object to Vegetable class object
	                       v = (Vegetable)fi[found];
	                       // Calls method to update quantity
	                       // Second parameter; true for purchase
	                       v.updateQuantity(in, true, fi, found, qty);
	                   }
	                   // Else, found object is an instance of Preserve class object
	                   else
	                   {
	                       Preserve p = new Preserve();
	                       // Converts found object to Preserve class object
	                       p = (Preserve)fi[found];
	                       // Calls method to update quantity
	                       // Second parameter; true for purchase
	                       p.updateQuantity(in, true, fi, found, qty);
	                   }              
	               break;
	               case 4:
	                   // Accepts item code
	                   itemCode = fi[0].validatePositiveIntegerData(in,
	                           "\n Enter item code to update: ");
	 
	                   // Checks if item code is not -1, if not then valid item code
	                   if(itemCode != -1)
	                   {
	                       // Sets found status to -1 (not found)
	                       found = -1;
	                       // Loop till number of records
	                       for(int c = 0; c < count; c++)
	                       {
	                           // Checks if current object item code is equal to user entered item code then update the found status
	                           if(fi[c].isEqual(itemCode))
	                               found = c;
	                       }
	                   }
	                   // Checks if found status is -1 the display that it's not found
	                   if(found == -1)
	                   {
	                       System.out.println("\n Code not found in inventory...");
	                       break;
	                   }
	                   // Checks if found object is an instance of Fruit class object
	                   if(fi[found] instanceof Fruit)
	                   {
	                       Fruit f = new Fruit();
	                       // Calls method to update quantity
	                       // Second parameter; false for sell
	                       f.updateQuantity(in, false, fi, found, nQty);
	                   }
	                   // Else, checks if found object is an instance of Vegetable class object
	                   else if(fi[found] instanceof Vegetable)
	                   {
	                       Vegetable v = new Vegetable();
	                       // Calls method to update quantity
	                       // Second parameter; false for sell
	                       v.updateQuantity(in, false, fi, found, nQty);
	                   }
	                   // Else, found object is an instance of Preserve class object
	                   else
	                   {
	                       Preserve p = new Preserve();
	                       // Calls method to update quantity
	                       // Second parameter; false for sell
	                       p.updateQuantity(in, false, fi, found, nQty);
	                   }              
	               break;
	               case 5:
	                   System.exit(0);
	               default:
	                   System.out.println("\n Invalid choice!");
	           }// outer switch case End
	       }// while loop End
	   }// main method End
	}// driver class End

