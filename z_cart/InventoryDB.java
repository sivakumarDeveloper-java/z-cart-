package z_cart;

import java.util.*;

 class Inventory {
	String brand;
	String model;
	int price;
	int stock;
	
	public Inventory(String brand,String model,int price,int stock) {
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.stock = stock;
	}	
}

class InventoryDB{
	
	private static Map<String, List<Inventory>> inventoryDetails = new HashMap<>();
	
	public static Map<String, List<Inventory>> getInventory() {
		return inventoryDetails;
	}
	
	public static void setNewStock(String category, String brand, String model,int newStock) {
		if (inventoryDetails.containsKey(category)) {
            List<Inventory> items = inventoryDetails.get(category);
            for (Inventory item : items) {
                if (item.brand.equals(brand) && item.model.equals(model)) {
                    item.stock = item.stock+newStock;
                }
            }
        }
	}
	
	//Setting the new stock after the purchase
	public static boolean setInventory(String category, String brand, String model, int quantity) {
        if (inventoryDetails.containsKey(category)) {
            List<Inventory> items = inventoryDetails.get(category);
            for (Inventory item : items) {
                if (item.brand.equals(brand) && item.model.equals(model)) {
                    item.stock = item.stock - quantity;
                }
            }
        }
        return false; // Category or item not found
    }
	
	//Printing all inventory lists
	public static void printInventory() {
		for (Map.Entry<String, List<Inventory>> entry : inventoryDetails.entrySet()) {
		    String category = entry.getKey();
		    List<Inventory> items = entry.getValue();
		    
		    System.out.println("Category \t\t Brand \t\t Model \t\t Price \t\t Stock");

		    for (Inventory item : items) {
		        System.out.println(category+"\t\t"+item.brand+"\t\t"+item.model+"\t\t"+item.price+"\t\t"+item.stock);
		    }
		}

	}
	
	//adding new item into inventory
	    public static void addItem(String category, Inventory item) {
	    	if (inventoryDetails.containsKey(category)) {
	            // If the category exists, get the list of items associated with it
	            List<Inventory> itemList = inventoryDetails.get(category);
	            // Add the new item to the existing list
	            itemList.add(item);
	        } else {
	            // If the category does not exist, create a new list and add the item to it
	            List<Inventory> itemList = new ArrayList<>();
	            itemList.add(item);
	            inventoryDetails.put(category, itemList);
	        }
	    }
  
	    // Checking stock details
	    public static boolean checkStock(String category, String brand, String model, int quantity) {
	        if (inventoryDetails.containsKey(category)) {
	            List<Inventory> items = inventoryDetails.get(category);
	            for (Inventory item : items) {
	                if (item.brand.equals(brand) && item.model.equals(model)) {
	                    if (item.stock >= quantity) {
	                        return true; // Sufficient stock available
	                    } else {
	                        return false; // Insufficient stock available
	                    }
	                }
	            }
	        }
	        return false; // Category or item not found
	    }
	    
	    //Returning the price of the user selected product
	    public static int getPrice(String category, String brand, String model) {
	        if (inventoryDetails.containsKey(category)) {
	            List<Inventory> items = inventoryDetails.get(category);
	            for (Inventory item : items) {
	                if (item.brand.equals(brand) && item.model.equals(model)) {
	                    return item.price;
	                }
	            }
	        }
	        return -1; // Category or item not found
	    }
	    
	    

	
}
