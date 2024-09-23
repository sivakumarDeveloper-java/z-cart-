package z_cart;

import java.util.HashMap;
import java.util.Map;

public class just {
	public static void main(String[] args) {
		String[] arr = {"def","ghi"};
		String output = firstPalindrome(arr);
		System.out.println(output);
	}
	
     public static String firstPalindrome(String[] words) {  
	        for(String str : words) {
	        	 boolean found = true;
	        	 int i = 0 , j = str.length()-1;
	        	 while(i<=j) {
	        		 if(str.charAt(i) == str.charAt(j)) {
	        			 i++;
	        			 j--;
	        		 } else {
	        			 found = false;
	        			 break;
	        		 }
	        	 }
	        	 if(found) return str;
	        }
	        
	   return "";
	}
}

