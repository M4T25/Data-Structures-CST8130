/*import java.util.Scanner;

class Inventory extends FoodItem {

	private String supplierName;
	
	public Inventory(){
		
		super();
	    supplierName = null;
	    
	}
	

	   boolean addItem(Scanner in)
	   {
	       if(super.addItem(in))
	       {
	           sc.nextLine();
	           System.out.print("\n Enter the name of the orchard supplier: ");
	           supplierName = sc.nextLine();
	 
	           return true;
	       }
	       else
	           return false;      
	   }

	   int alreadyExists(FoodItem fi[], int itemCode)
	   {

	       for(int c = 0; c < fi.length; c++)

	           if(fi[c].isEqual(itemCode))
	               return c;

	       return -1;
	   }

	   boolean updateQuantity(Scanner sc, boolean type, FoodItem fi[], int pos)
	   {

	       int qty = validatePositiveIntegerData(sc,
	               "\n Enter quantity to: ");

	       if(qty != -1 && type == true)
	       {

	           updateItem(qty);
	           return true;
	       }

	       else if(qty != -1 && type == false)
	       {

	           updateItem(-qty);
	           return true;
	       }

	       else
	       {
	           if(type == true)
	               System.out.println("\n Error...could not buy item");
	           else
	               System.out.println("\n Error...could not sell item");
	           return false;
	       }
	   }
}
*/