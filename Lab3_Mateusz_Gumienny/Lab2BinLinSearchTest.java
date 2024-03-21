import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * Lab2BinLinSearchTest : Main method, displaying main menu
 * Student Name: Mateusz Gumienny
 * Student Number: 041033057
 * Course: CST8130 301 - Data Structures
*/

 public class Lab2BinLinSearchTest {
	/**
	 * main method : displaying main menu and leading to that option
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryLinearSearch b = new BinaryLinearSearch();
			while(true) {
				try {
					System.out.println("Select your option in the menu:");
					System.out.println("1.Initialize and populate an array of 32 random integers.");
					System.out.println("2.Perform recursive binary and linear search.");
					System.out.println("3.Perform iterative binary and linear search.");
					System.out.println("4.Exit");
					Scanner sc = new Scanner(System.in);
					int option = sc.nextInt();

					switch(option) {
					case 1:
						b.generateRandomInts(sc);
						break;
					case 2:
						b.recursiveBinarySearch(sc);
						break;
					case 3:
						b.iterativeBinarySearchResult(sc);
						break;
					case 4:
						sc.close();
						System.out.println("exiting...");
						System.exit(0);
					default:
						System.err.println("Please choose the option 1 to 4.");
						break;
					} //switch-case end
				}
					catch(InputMismatchException ime) {
						System.err.println("*****Input Mismatch Exception*****");
				}
					catch (Exception e) {
						System.err.println("Error");
				} //try-catch end
			} //while end
	} //main end
} //Lab2BinLinSearchTest class end