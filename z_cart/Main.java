package z_cart;

import java.util.*;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) throws InterruptedException
	{
		Scanner scan = new Scanner(System.in);
		
		//Pre-registered users
		Customer cOne = new Customer("Admin@zoho.com","admin","admin",9047128117l);	
		CustomerDB.setCustomer(Customer.getID(),cOne);
		Customer cTwo = new Customer("Chan@zoho.com","chan","userchan",8923538910l);	
		CustomerDB.setCustomer(Customer.getID(),cTwo);
		
		//Pre-registered inventories
		Inventory mobileItem1 = new Inventory("Poco", "X3", 16000, 30);
		Inventory mobileItem2 = new Inventory("Apple", "14Pro", 150000, 20);
		Inventory laptopItem = new Inventory("lenova", "ideapad", 170000, 10);

		InventoryDB.addItem("Mobile", mobileItem1);
		InventoryDB.addItem("Mobile", mobileItem2);
		InventoryDB.addItem("Laptop", laptopItem);

		
		
		System.out.println("Welcome To Z-Cart");
		
		boolean logout = false;
		//Log in start
		while(!logout) {
			System.out.println("1.Log In \n2.Sign In \n3.Logout");
			int choice = scan.nextInt();
			
			if(choice == 1) {
				System.out.println("Log In With your Credentials");
				System.out.println("Enter Your Name");
				String name = scan.next();
				System.out.println("Enter Your Password");
				String pass = scan.next();
				System.out.println();
				System.out.println("Checking yout Credentials");
				Thread.sleep(1000);
				//check valid user or not
				boolean valid = CustomerDB.check(name, pass);
				if(valid) {
					System.out.println(" Login Success ");
					System.out.println(" Welcome Back "+name);
					System.out.println();
					if(name.equals("admin")) {
						Admin.control();
						continue;
					}
					Purchase.buy();
				} else {
					System.out.println("Sorry We can't find your name");
					System.out.println("Please Sign In First");
					System.out.println();
					SignIn.newCustomer();
					continue;
				}
				System.out.println();
				System.out.println("Want to explore more again.... (yes/no)");
				String response = scan.next();
				
				if(response.equals("yes")){
					Purchase.buy();
				} else {
					System.out.println("Thanks Come again");
					System.out.println();
				}
			} else if(choice == 2) {
				SignIn.newCustomer();
			} else if(choice == 3) {
				logout = true;
				System.out.println("Bye...Bye");
			} else {
				System.out.println("Invalid input");
			}
			
			
			
		}
	}
	
	
    
}
