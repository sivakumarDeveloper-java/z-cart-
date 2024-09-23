package z_cart;

import java.util.Scanner;

public class SignIn {
	public static void newCustomer() throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to the Sign In page");
		
		//Getting details from the user
		System.out.println("Enter your email");
		String email =scan.next();
		System.out.println("Enter your name");
		String name = scan.next();
		System.out.println("Enter your pass");
		String pass = scan.next();
		System.out.println("Enter your phone nummber");
		long phone = scan.nextLong();
		//creating a object and add it into the customerDB
		Customer obj = new Customer(email,name,pass,phone);	
		CustomerDB.setCustomer(Customer.getID(),obj);
		
		System.out.println();
		System.out.println("Please Wait");
		Thread.sleep(1000);
		System.out.println("You are added in out Database");
		System.out.println("Try to log in");
	}
}
