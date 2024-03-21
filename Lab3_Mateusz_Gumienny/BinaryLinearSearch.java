import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;
/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class is performing binary and linear search
 * Student Name: Mateusz Gumienny
 * Student Number: 041033057
 * Course: CST8130 301 - Data Structures
 */
	public class BinaryLinearSearch {
		protected int searchKey;
		protected static int[] randomArr; //array for random numbers
		protected int low, mid, hi;
		protected int ttl;
		protected long startTimeNano; //for checking time
		protected long endTimeNano; //for checking time
		protected long startTimeMilli;
		protected long endTimeMilli;


		//----------------------------generate random numbers and printing time---------------------------//

		/**
		 * generateRandomInts : generating 30 random integers and storing in array
		 * @param sc Scanner
		 */
		public void generateRandomInts(Scanner sc) {
			SecureRandom random = new SecureRandom(); //for random numbers
			randomArr = new int[32];

			System.out.println("Array of randomly generated integers: ");
			System.out.print("Unsorted array: [ ");
			int a=0; //array index start number
			for(int i=0;i<100000;i++) {
				int number = random.nextInt(100); //generate random number
				if(randomArr[31] > 0 ) { //if last element is not null(zero) = if it is full
					break;
				} //if end
				if(number>10) {
					randomArr[a] = number;
					System.out.print(randomArr[a] + " ");
					a++; //increase index number
				} //if end
			} //for end
				System.out.println("]");

				Arrays.sort(randomArr); //sorted array
				System.out.print("Sorted array: [ ");
				
				for(int j=0;j<32;j++) {
					System.out.print(randomArr[j] + " "); //print sorted array
				} //for end
				
			System.out.println("]");
		}
		//generateRandomInts end
		
		//-------------recursive : stack frame's push, pop / call another method--------------------------//

		/**
		 * recursiveBinarySearch : recursive binary search, calling the method
		 * @param sc
		 */
		public void recursiveBinarySearch(Scanner sc) { //recursion
			System.out.print("Please enter an integer value to search: ");
			searchKey = sc.nextInt();

			remainingElements(searchKey);

			recursiveLinearSearch(sc, searchKey);
		}//recursiveBinarySearch end
		/**
		 * remainingElements : calculate middle point, comparing with search key, print index
		 * @param searchKey
		 */
		public void remainingElements(int searchKey){ //for recursive search
			startTimeNano = System.nanoTime();
			startTimeMilli = System.currentTimeMillis();

			for(int j=0;j<32;j++) {
				System.out.print(randomArr[j] + " "); //print sorted array
			} //for end
			
			System.out.println("");

			low = 0; //initial low value
			hi = 31; //initial high value
			System.out.print(" ");
			for(int i=0;i<32;i++) {
				ttl = low + hi;
			if(ttl%2 == 0) { //if it is even number
				mid = ttl/2;
			} 
			else if(ttl%2 != 0) { //if it is odd number
				mid = (ttl+1)/2;
			} //if-else end
			System.out.print(mid + " "); //print mid

			if(randomArr[mid]==searchKey) { //middle point is input, found!
				endTimeNano = System.nanoTime();
				endTimeMilli = System.currentTimeMillis();

				System.out.println("");
				System.out.println(searchKey + " found at index at " + mid + ": Recursive Binary Search");

				nanoTime(startTimeNano, endTimeNano);
				currentTimeMills(startTimeMilli, endTimeMilli);

				break;
			}
			else if(randomArr[mid]>searchKey) { //if search key is smaller than middle point
				hi = mid -1;
			}
			else if(randomArr[mid]<searchKey) { //if search key is bigger than middle point
				low = mid + 1 ;
			} //if-else end
			
			if(randomArr[hi]<searchKey){
				endTimeNano = System.nanoTime();
				endTimeMilli = System.currentTimeMillis();
				System.out.println("");
				System.out.println(searchKey + " was not found : Recursive Binary Search");

				nanoTime(startTimeNano, endTimeNano);
				currentTimeMills(startTimeMilli, endTimeMilli);
				break;
				}//if end
			} //for end
		} //remainingElements end
		/**
		 * recursiveLinearSearch : Recursive Linear Search with for loop
		 * @param sc Scanner
		 * @return
		 */
		public int recursiveLinearSearch(Scanner sc, int searchKey) {
			startTimeNano = System.nanoTime();
			startTimeMilli = System.currentTimeMillis();
			int no = 0;
			for(int i=1;i<=randomArr.length;i++) { //linear search
				if(randomArr[i-1]==searchKey) {
					no = i-1;
					break;
				} //if end
			} //for end

			if (no == 0) { //if no is initial value
				endTimeNano = System.nanoTime();
				endTimeMilli = System.currentTimeMillis();

				System.out.println(searchKey + " was not found : Recursive Linear Search");

				nanoTime(startTimeNano, endTimeNano);
				currentTimeMills(startTimeMilli, endTimeMilli);
				return -1;
			}
			else {
				endTimeNano = System.nanoTime();
				endTimeMilli = System.currentTimeMillis();

				System.out.println(searchKey + " found at index at " + no + ": Recursive Linear Search");

				nanoTime(startTimeNano, endTimeNano);
				currentTimeMills(startTimeMilli, endTimeMilli);

				return no;
			} //if-else end
		} //recursiveLinearSearch end

		//------------iterative: for,while,do-while loop--------------------------------------------------//

		/**
		 * iterativeBinarySearch : main iterative binary search
		 * @param sc
		 */
		public int iterativeBinarySearch(Scanner sc){ //iterative + looping construct
			System.out.print("Please enter an integer value to search: ");
			searchKey = sc.nextInt();

			for(int j=0;j<32;j++) {
				System.out.print(randomArr[j] + " "); //print sorted array
			} //for end
			System.out.println("");

			low = 0; //initial low value
			hi = 31; //initial high value

			for(int i=0;i<32;i++) {
				ttl = low + hi;
				
				if(ttl%2 == 0) { //if it is even number
					mid = ttl/2;
				}
				else if(ttl%2 != 0) { //if it is odd number
					mid = (ttl+1)/2;
				} //if-else end
				System.out.print(mid + " "); //print mid
				if(randomArr[mid]==searchKey) { //middle point is input, found!
					return mid;
				}
				else if(randomArr[mid]>searchKey) { //if search key is smaller than middle point
					hi = mid -1;
				}
				else if(randomArr[mid]<searchKey) { //if search key is bigger than middle point
					low = mid + 1 ;
				} //if-else end
				if((hi-low) == 1){
					endTimeNano = System.nanoTime();
					endTimeMilli = System.currentTimeMillis();

					System.out.println(searchKey + " was not found : Iterative Binary Search");

					nanoTime(startTimeNano, endTimeNano);
					currentTimeMills(startTimeMilli, endTimeMilli);
					break;
				}//if end
			} //for end
			System.out.println("");
			return -1; //if not found, return -1
		}//iterativeBinarySearch end
		
		/**
		 * iterativeBinarySearchResult : result for the iterative binary search
		 * @param sc Scanner
		 */
		public void iterativeBinarySearchResult(Scanner sc) { //printing the result
			startTimeNano = System.nanoTime();
			startTimeMilli = System.currentTimeMillis();
			iterativeBinarySearch(sc);
			if (mid != -1) {
				endTimeNano = System.nanoTime();
				endTimeMilli = System.currentTimeMillis();
				System.out.println("");
				System.out.println(searchKey + " found at index " + mid + " : Iterative Binary Search");

				nanoTime(startTimeNano, endTimeNano);
				currentTimeMills(startTimeMilli, endTimeMilli);
			}
			else {
				endTimeNano = System.nanoTime();
				endTimeMilli = System.currentTimeMillis();

				System.out.println(searchKey + " was not found");

				nanoTime(startTimeNano, endTimeNano);
				currentTimeMills(startTimeMilli, endTimeMilli);
			} //if-else end

			iterativeLinearSearch(searchKey);
		} //iterativeBinarySearch end
		
		/**
		 * iterativeLinearSearch : get search key from user input and search with linear search
		 * @param sc Scanner for search key from user
		 */
		public int iterativeLinearSearch(int searchKey) { //iterative linear search
			startTimeNano = System.nanoTime();
			startTimeMilli = System.currentTimeMillis();
			int no = 0;
			for(int i=1;i<=randomArr.length;i++) { //linear search
				if(randomArr[i-1]==searchKey) {
					no = i-1;
					break;
				} //if end
			} //for end
			if (no == 0) { //if no is initial value
				endTimeNano = System.nanoTime();
				endTimeMilli = System.currentTimeMillis();

				System.out.println(searchKey + " was not found : Iterative Linear Search");

				nanoTime(startTimeNano, endTimeNano);
				currentTimeMills(startTimeMilli, endTimeMilli);

				return -1;
			} 
			else {
				endTimeNano = System.nanoTime();
				endTimeMilli = System.currentTimeMillis();

				System.out.println(searchKey + " found at index at " + no + ": Iterative Linear Search");

				nanoTime(startTimeNano, endTimeNano);
				currentTimeMills(startTimeMilli, endTimeMilli);

				return no;
			} //if-else end
		} //iterativeLinearSearch end

		/**
		 * nanoTime : calculate taken time in nano seconds
		 */
		public void nanoTime(long startTimeNano, long endTimeNano){ //get time in nano
			System.out.println("Time taken in nanoseconds: " + (endTimeNano-startTimeNano));
		} //nanoTime end
		
		/**
		 * currentTimeMills : calculate taken time in million seconds
		 */
		public void currentTimeMills(long startTimeMil, long endTimeMil){ //get current time in mills
			System.out.println("Time taken in milliseconds: " + (endTimeMil-startTimeMil));
		} //currentTimeMills end

	} //BinaryLinearSearch class end