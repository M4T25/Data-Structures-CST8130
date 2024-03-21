import java.util.Scanner;
import java.util.*; 
import java.io.*;
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
    private Float[] numbers;
    /**
	 * Store the number of items currently in the array.
	 */
    private int numItems;
    /**
	 * Default Constructor
	 */
    public Numbers() { 
        numbers = new Float[100];
        numItems = 0;
    }
	/**
	 * Constructor that initializes the numbers array.
	 * @param size - Max size of the numbers array
	 */
    public Numbers(int size) { //methods
        numbers = new Float[size];
        numItems = 0;
    }
    
    /**
	 * Adds a value in the array
	 * @param keyboard - Scanner object to use for input
	 */
    public void addValue(Scanner keyboard) {
        if (numbers.length == numItems) {
            System.out.println("Array full.");
            return;
        }
        System.out.print("Enter a value: ");
        Float value = keyboard.nextFloat();
        numbers[numItems] = value;
        numItems++;
    }

    //create new addValue with file input
    public void addValues(File file, boolean read) throws NumberFormatException, IOException {
        //in case of reading
        if(read){
            //if array is full
            if (numbers.length == numItems) {
                System.out.println("Array full.");
                return;
            }
            //reads first line 
            BufferedReader br = null;
            try {
                //create new buffered reader
                br = new BufferedReader(new FileReader(file));
                //read first line & store it in the size of the array.
                int size = Integer.parseInt(br.readLine());
                for (int i = 0; i < size; i++) {
                    //reads next lines and store them in the array.
                    numbers[numItems] = Float.parseFloat(br.readLine());
                    numItems++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        //in case of writing.
        else{
            //create new file
            //create PrintWriter object
            PrintWriter pw = null;
            try {
                //pass file object to the PrintWriter constructor
                pw = new PrintWriter(file);
                //write length first
                pw.println(numItems);
                for (int i = 0; i < numItems; i++) {
                    //writing content of numbers.
                    pw.println(numbers[i]);
                }
                pw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
	/**
	 * Calculates the average of all the values in the numbers array.
	 * @return float value that represents the average
	 */
    
    public float calcAverage() {
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
    public Float[] findMinMax() {
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
	

		//method to add multiple values from keyboard or from file based on value

		//of fromKeyboard flag

		public void addMultiple(Scanner scanner, boolean fromKeyboard) {

			if (fromKeyboard) {

				System.out.print("How many values do you wish to add? ");

			}

			//reading number of values

			int n = scanner.nextInt();

			//looping and calling addValue n times

			for (int i = 0; i < n; i++) {

				addValue(scanner);

			}

		}
	}
