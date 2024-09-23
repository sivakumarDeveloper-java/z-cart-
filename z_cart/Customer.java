package z_cart;

import java.util.*;

class Customer {
	static int cId = 0;
	String email;
	String name;
	String pass;
	long phone;
	
	
	public Customer(String email,String name,String pass,long phone) {
		this.email = email;
		this.name = name;
		this.pass = pass;
		this.phone = phone;
		int id = cId++;
	}
	
	public static int getID() {
		return cId;	
	}
}

class CustomerDB{
	
    private static HashMap<Integer, Customer> customerDetails = new HashMap<>();
	
	public static void setCustomer(int cId, Customer detail) {
        customerDetails.put(cId, detail);
    }
	
	public static HashMap<Integer, Customer> getCustomer() {
        return customerDetails;
    }
	
	public static void printAllCustomers() {
		System.out.println("Id  \t\t  name \t\t  email  \t\t   pass  \t\t  phone");
		for (Map.Entry<Integer, Customer> entry : customerDetails.entrySet()) {
		    int id = entry.getKey();
		    Customer customer = entry.getValue();
		    
		    System.out.println(id+"\t\t"+customer.name+"\t\t"+customer.email+"\t\t"+customer.pass+"\t\t"+customer.phone);
		}

	}
	
	static int currCusId = 0;
	
	public static boolean check(String name,String pass) {
		for (Map.Entry<Integer, Customer> entry : customerDetails.entrySet()) 
		{
			if(entry.getValue().name.equals(name)) {
				currCusId = entry.getKey();
				return true;
			}
		}
		
		return false;
	}
	
}