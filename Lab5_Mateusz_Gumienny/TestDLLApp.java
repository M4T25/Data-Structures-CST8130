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
 * This class represents a test application for the DoublyLinkedList class.
*/
class TestDLLApp {
	
	/**
	 * The main method creates a new instance of DoublyLinkedList, inserts elements, 
	 * and performs various operations on the list.
	 * @param args an array of command-line arguments
	*/
	public static void main(String[] args) {

		// create a new instance of DoublyLinkedList and insert elements
        DoublyLinkedList newLL = new DoublyLinkedList();
        newLL.insertFirst(22);
        newLL.insertFirst(44);
        newLL.insertFirst(74);
        newLL.insertFirst(97);
        newLL.insertLast(9);
        newLL.insertLast(33);
        newLL.insertLast(55);     

     // print the list forwards and backwards
        newLL.printForwards();
        newLL.printBackwards();
        
     // delete the first and last nodes, search and delete a specific node,]
     // and print the list forwards after adding a new node
        newLL.deleteFirstNode();
        newLL.deleteLastNode();
        newLL.searchAndDelete(9);
        newLL.printForwards();
        newLL.addNodeAfter(22, 69);
        newLL.addNodeAfter(34, 88);
        newLL.printForwards();

	} // end of main() method
} // end class TestDLLApp
