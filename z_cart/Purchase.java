package z_cart;

import java.util.*;

public class Purchase {
	
	public static void buy() throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		//getting the inventory DB
		Map<String, List<Inventory>> inventoryDetails = InventoryDB.getInventory();	
		
		//ask category
		System.out.println("-----------------------");
		System.out.println("| Choose the category |");
		System.out.println("-----------------------");
		for (Map.Entry<String, List<Inventory>> entry : inventoryDetails.entrySet()){
			System.out.println(entry.getKey());
        } 

		String choice = scan.next();
	    //Separate the category based on user preference
		List<Inventory> items = null;
		
		for (Map.Entry<String, List<Inventory>> entry : inventoryDetails.entrySet()){
			if(entry.getKey().equals(choice)) {
				items = entry.getValue();
			}
        } 
		//After getting the category print the stock details
		System.out.println("------------------------------------------");
		System.out.println("| Brand \t Model \t\t  Price |");
		System.out.println("------------------------------------------");
		for (Inventory item : items) {
            System.out.println("| "+item.brand+"\t\t"+item.model+"\t\t"+item.price+" |");
        }
		System.out.println("------------------------------------------");
		
		//asking to customer
		boolean done = false;
		while(!done) {
			
			System.out.println("Enter the brand");
			String brand = scan.next();
			System.out.println("Enter the Model");
			String model = scan.next();
			System.out.println("How many quantity");
			int quantity = scan.nextInt();
			
			//Checking availability
			boolean available = InventoryDB.checkStock(choice,brand,model,quantity);
		
			if(available) {
				//creating the object and store it in cart arraylist
				Cart obj = new Cart(choice,brand,model,quantity);
				CartArea.addCart(obj);
				
				System.out.println("Still want to purchase?....(yes/no)");
				String response = scan.next();
				
				//if enough of purchase stop the loop
				if(response.equals("no")) { done = true ; }
			} else {
				System.out.println("Stock is less...");
				System.out.println("Still want to purchase?....(yes/no)");
				String response = scan.next();
				
				if(response.equals("no")) { done = true ; }
			}
		}
     	CartArea.invoice();		
	}
	
}
