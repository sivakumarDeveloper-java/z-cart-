package z_cart;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Admin {
	static Scanner scan = new Scanner(System.in);
	
	public static void addNewInventory() throws InterruptedException {
		System.out.println("Enter the Category");
		 String category = scan.next();
		 System.out.println("Enter the Brand");
		 String brand = scan.next();
		 System.out.println("Enter the Model");
		 String model = scan.next();
		 System.out.println("Enter the price");
		 int price = scan.nextInt();
		 System.out.println("Set the Stock");
		 int stock = scan.nextInt();
		 Inventory newItem = new Inventory(brand,model,price,stock);
		 InventoryDB.addItem(category,newItem);
		 System.out.println();
		 System.out.println("Please wait....");
		 Thread.sleep(1000);
		 System.out.println("New Inventory added Successfully");
	}
	
	public static void UpdateStock() throws InterruptedException {
		System.out.println("Preparing for Details");
 	     Thread.sleep(1000);
 	     
 	     System.out.println("-----------------------");
 	     System.out.println("| Choose the category |");
 	     System.out.println("-----------------------");
 	     Map<String, List<Inventory>> inventoryDetails = InventoryDB.getInventory();	
 	   
 	     for (Map.Entry<String, List<Inventory>> entry : inventoryDetails.entrySet()){
 	    	 System.out.println(entry.getKey());
 	     } 
 	     
       String response = scan.next();
	    //Separate the category based on user preference
	 	List<Inventory> items = null;
		
		for (Map.Entry<String, List<Inventory>> entry : inventoryDetails.entrySet()){
			if(entry.getKey().equals(response)) {
				items = entry.getValue();
			}
       } 
		//After getting the category print the stock details
		System.out.println("--------------------------------");
		System.out.println("| Brand \t\t Model \t\t  Price \t\tStock|");
		for (Inventory item : items) {
           System.out.println("| "+item.brand+"\t\t"+item.model+"\t\t"+item.price+"\t\t"+item.stock+" |");
       }
		System.out.println("--------------------------------");
		
		System.out.println("Enter the category");
		String category = scan.next();
		System.out.println("Enter the Brand");
		String brand = scan.next();
		System.out.println("Enter the Model");
		String model = scan.next();
		System.out.println("Enter How Many New Stock are Available");
		int newStock = scan.nextInt();
		InventoryDB.setNewStock( category, brand, model, newStock);
		
		System.out.println();
		System.out.println("Please Wait...");
		Thread.sleep(1000);
		System.out.println("Stock Added Succcessfullt...");
	}
	
	public static void control() throws InterruptedException {
		
		boolean logout = false;
		
		//Admin control
		while(!logout) {
			System.out.println("1.Print All Customers");
			System.out.println("2.Print All Inventories");
			System.out.println("3.Print Order Histories");
			System.out.println("4.Add New Inventory");
			System.out.println("5.Update Stock");
			System.out.println("6.Logout");
			
			int choice = scan.nextInt();
			
			switch(choice) {
			
			case 1 : CustomerDB.printAllCustomers();
					 break;
			case 2 : InventoryDB.printInventory();
					 break;
			case 3 : CartArea.printAllOrderHistory();
					 break;
			case 4 : Admin.addNewInventory();
					 break;
			case 5:	 Admin.UpdateStock();
					 break;
			case 6 : logout = true;
					 break;
		    default : System.out.println("Invalid Input");			 
			}
		}
	}
}
