/**
 * Processing data using Doubly Linked List CST8130 Data Structures,
 * Computer Engineering Technology-Computer Science: Level 3
 * 
 * Professor: James Mwangi PhD
 * 
 * 
 * Student Name:Mateusz Gumienny
 * Student ID: 041033057
 * Program:CET-CS
 * Course:CST8130
 * Lab Section:301
 * 
 */

/**
 * The Node class represents a single node in a linked list.
 * It stores an integer value and references to the next and previous nodes in the list.
*/
public class Node {
	
	/**
	 *  data item
	 */
	public int mData;
	/**
	 *  next node in list
	 */
	public Node next;
	/**
	 *  previous node in list
	 */
	public Node previous;
	
	/**
	 * Constructs a new Node object with the specified data value.
	 * @param d the integer value to be stored in the node
	*/
	   public Node(int d) // constructor
	{
	       mData = d;
	   }

		/**
		 * Displays the data stored in this node to the console.
		*/
	   public void displayNode() {
	       System.out.print(mData + " "); 
	       }
}

