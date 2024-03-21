import java.util.Scanner;
import java.util.Arrays;

/**
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Mateusz Gumienny
 * Student Number: 041033057
 * Course: CST8130 301 - Data Structures
 * CET-CS-Level 3
 * @author/Professor James Mwangi PhD. 
 * 
  */
public class Numbers {
	/**
	 * Stores Float values.
	 */
	private Float [] numbers;
	
	/**
	 * Store the number of items currently in the array.
	 */
	private int numItems;
	
	/**
	 * Default Constructor
	 */
	public Numbers() {
		// TODO Write code here to initialize a "default" array since this is the default constructor
		numbers = new Float[100];
		numItems = 0;
	}

	/**
	 * Constructor that initializes the numbers array.
	 * @param size - Max size of the numbers array
	 */
	public Numbers(int size) {
		// TODO Write code here to initialize the numbers array of max 'size'
		numbers = new Float[size];
		numItems = 0;
	}
	
	/**
	 * Adds a value in the array
	 * @param keyboard - Scanner object to use for input
	 */
	public void addValue(Scanner keyboard) {
		// TODO Write code here to add the values in the array
		if(numbers.length == numItems){
			System.out.println("Array full.");
			return;
			}
			System.out.print("Enter a value: ");
			Float value = keyboard.nextFloat();
			numbers[numItems] = value;
			numItems++;
	}
	
	/**
	 * Calculates the average of all the values in the numbers array.
	 * @return float value that represents the average
	 */
	public float calcAverage() {
		// TODO Write code to return the average of the values in the array
		Float sum = 0.0F;
		for(int i = 0; i < numItems; i++){
				sum += numbers[i];
			}
		Float avrg = sum / numbers.length;
		
		return (float) avrg;
	}

	/**
	* Calculates the min and max value from numbers array.
	* @return max and min value represented in array format
	*/

	public Float[] findMinMax(){
		int modulo;
		Float min = Float.MAX_VALUE;
		Float max = Float.MIN_VALUE;

			for(int i=0;i<numItems;i++){
				min = Float.min(min,numbers[i]);
				max = Float.max(max,numbers[i]);
			}
			
		Float[] result = new Float[2];
				result[0] = max;
				result[1] = min;
				
				
			return result;
		}
	
	/**
	 * getFactorialMax Method calculates the factorial of the maximum value
	 * @param num
	 * @return the factorial value of the max integer
	 */
	public float getFactorialMax(float num) {
		  if (num == 0) {
		      return 1;
		  }
		  else {
		      return (num * getFactorialMax(num - 1));
		  }
		}
	
	/**
	* To String Method
	* @return the list of numbers in numbers array in string format
	*/
	@Override
	public String toString() {
		String str = "";
		
		for(int i=0;i<numItems;i++) {
			str += "\n"+ String.valueOf(numbers[i]) ;
			}
			return str;
		}
	
}
