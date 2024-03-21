
import java.util.Scanner;
import java.io.*; 

/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Mateusz Gumienny
 * Student Number: 041033057
 * Course: CST8130 301 - Data Structures
 * @author/Professor: James Mwangi PhD. 
 * 
  */

public class Lab1 {
	
    public static void displayMainMenu() {
    	
        Scanner sc = new Scanner(System.in);
        
        float maxValue = 0;
		float minValue = 0;
		float factorialMax = 0;
        
        Numbers N = new Numbers();
        
        boolean flag = true;
        
        while (flag) { //while loop
            System.out.println("Please select the following.");
            System.out.println("1: Initialize a default array.");
            System.out.println("2: To specify the max size of the array.");
            System.out.println("3: Add value to the array.");
            System.out.println("4: Display values in the array.");
            System.out.println("5: Display the average of the values, minimum value, maximum value, maxValue mod minValue, maxFactorial");
            System.out.println("6: Enter multiple values");
            System.out.println("7: Read values from file");
            System.out.println("8. Save values to file");
            System.out.println("9: To Exit.");
            System.out.print("> ");
          //ask for user choice
            int option = sc.nextInt();
         // loop for choice
            switch (option) { //change statements
            case 1:
                N = new Numbers();  //Create new Numbers class
                break;
            case 2:
                System.out.print("Enter new size of array:");
                int size = sc.nextInt(); //Get user input
                N = new Numbers(size); //Set max size of array
                break;
            case 3:
                N.addValue(sc); //Add value to array
                break;
            case 4:
                System.out.println("Numbers are: " + N.toString());
                break;
            case 5:
            	System.out.print("Average is: " + N.calcAverage());
				
				if(N.findMinMax()[1]!=Float.MIN_VALUE)
					maxValue = N.findMinMax()[0]; 
					System.out.print(", Maximum value: " + maxValue);
				
					
				if(N.findMinMax()[1]!=Float.MAX_VALUE)
					minValue = N.findMinMax()[1];
					System.out.print(", Minimum value: " + minValue);
					
					//Cast float max and min values to integer
					int modulo = (int)(maxValue % minValue); //Calculate the modulo of max and min
					
					System.out.print(", max mod min is " + modulo);
					
					factorialMax = N.getFactorialMax(maxValue);
					System.out.print(", Factorial of " + maxValue + " is: " + factorialMax);
				System.out.print("\n");
                break;
            case 6: // adding multiple values from keyboard

            	N.addMultiple(sc, true);

            	break;
            case 7:
                System.out.println("Enter the file name: ");
                //take the file name from the user
                String fileName = sc.next();
                File file = new File(fileName); 
                try {
                    //call the addValues method with true as argument to read.
                                        N.addValues(file, true);
                                } catch (NumberFormatException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                } catch (IOException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                }
                break; 
            case 8: 
                System.out.println("Enter the file name: ");
                //take the file name from the user
                fileName = sc.next();
                file = new File(fileName);
                try {
                    //call the addValues method with false as argument to write.
                    N.addValues(file, false);
                } catch (NumberFormatException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break; 
            case 9: 
                System.out.println("Exiting...");
                flag = false;
                break; 
            default:
            }
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {//method the display the main menu   
		// TODO Auto-generated method stub
		displayMainMenu();

	}

}
