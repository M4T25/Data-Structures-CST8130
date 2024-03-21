/**
 * Processing data using Doubly Linked List CST8130 Data Structures,
 * Computer Engineering Technology-Computer Science: Level 3
 * 
 * Professor: James Mwangi PhD
 * 
 * Lab4
 * Student Name:____FN______ _____LN_______
 * Student ID:__________________
 * Program:
 * Course:
 * Lab Section:
 * 
 */

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

// ===================== class starts here=============================
/*class Node {
	public int mData; // data item
	public Node next; // next node in list
	public Node previous; // previous node in list
	// -------------------------------------------------------------

	public Node(int d) // constructor
	{
		mData = d;
	}

	// -------------------------------------------------------------
	// display this node data
	public void displayNode() {
		System.out.print(mData + " ");
	}
	// -------------------------------------------------------------
} // end class Node
*/

// ===================== class design starts here =============================
class DoublyLinkedList {
	private Node first;
	private Node last;

	// -------------------------------------------------------------
	/**
	 * A doubly linked list implementation.
	 */
	public DoublyLinkedList() {
		first = null;
		last = null;
	}
   
	/**
	 * Inserts an element at the beginning of the list.
	 * @param element the element to insert.
	*/
	public void insertFirst(int element) {
        Node newNode = new Node(element);
        if (first == null) {
                first = newNode;
                last = newNode;
        } 
        	else {
        			newNode.next = first;
        			first.previous = newNode;
        			first = newNode;
        	}
	}

	/**
	 * Inserts an element at the end of the list.
	 * @param element the element to insert.
	*/
	 public void insertLast(int element) {
         Node newNode = new Node(element);

         if (last == null) {
                 first = newNode;
         } 
         	else {
                  last.next = newNode;
                  newNode.previous = last;
         	}
         last = newNode;
	 }
	 /**
	  * Adds a node after a given value.
	  * @param after the value to add a node after.
	  * @param element the element to insert.
	 */

	 public void addNodeAfter(int after, int element) {

         Node currentNode = first;
         while (currentNode != null && currentNode.mData != after) {
                 currentNode = currentNode.next;
         }

         if (currentNode != null) {
                 Node next = currentNode.next;
                 Node newNode = new Node(element);
                 currentNode.next = newNode;
                 newNode.previous = currentNode;
                 if (next != null) {
                         next.previous = newNode;
                         newNode.next = next;
                 } else {
                         last = newNode;
                 }

         }
 }
	
	// -------------------------------------------------------------
	 /**
	  * Checks if the list is empty. 
	  * @return true if the list is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return first == null;
	}

	// ------------------------------------------------

	/**
	 * Deletes the first node in the list.
	 */
	public void deleteFirstNode() {

		if (first != null) {
            int firstElement = first.mData;
            if (first.next == null) {
                    first = null;
                    last = null;
            } else {
                    first = first.next;
                    first.previous = last;
            }
		}
		


	}

	// -----------------------------------------------

	/**
	 *  delete last node
	 */
	public void deleteLastNode() {

		if (first == null || first.next == null) {
				deleteFirstNode();
			} else {
				Node currentNode = first;
				Node previous = null;
				
            while (currentNode != last) {
                 previous = currentNode;
                currentNode = currentNode.next;
            }
            	previous.next = null;
            	last = previous;
		}

		
	}

	// -------------------------------------------------------------

	// -----------------------------------------finds, deletes and returns the node
	// that contains the given int value
	
	/**
	 * Searches for a node that contains the given value and deletes it from the list.
	 * @param number the value to search for and delete.
	 * @return the deleted node.
	*/
	public Node searchAndDelete(int number) {

		Node currentNode = first;
		Node previous = null;
        while (currentNode != null && currentNode.mData != number) {
                previous = currentNode;
                currentNode = currentNode.next;
        }

        if (currentNode != null) {
                previous.next = currentNode.next;
                currentNode.next.previous = previous;
        }
        return currentNode;
		
	}


	// -------------------------------------------display data from first node to
	// last node
	
		/**
		 * Prints the data in each node from first to last.
		 */
	public void printForwards() {

        Node currentNode = first;
        System.out.print("Linked List: [From first_to_last]: ");
        while (currentNode != null) {
                System.out.print(currentNode.mData + " ");
                currentNode = currentNode.next;
        }
        System.out.println();

	}

	// -------------------------------------------


	 /**
	  * Prints the data in each node from last to first.
	 */
	public void printBackwards() {

		
		Node currentNode = last;
        System.out.print("Linked List: [From last_to_first]: ");
        while (currentNode != null) {
                System.out.print(currentNode.mData + " ");
                currentNode = currentNode.previous;
        }
        System.out.println();

	}
	// -------------------------------------------------------------
} // end class DoublyLinkedList

// ==========================================================
