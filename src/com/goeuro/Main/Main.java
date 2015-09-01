package com.goeuro.Main;

import com.goeuro.Client.RestClient;

public class Main {

	/*
	 * main method to run the client
	 */
	public static void main(String[] args) {
			
		  Message();
		  if (args.length == 0) {
		      System.err.println("No arguments! Please pass a name");
		      
		      System.exit(0);
		    }
		  
		  if(isLetters(args[0])){
			  
			 try{
				 
		  	RestClient goEuroClient = new RestClient();
		  	goEuroClient.run(args[0]);
		  	System.out.println("The files has been fetched successfuly");
			  }
			 
			 catch (Exception e) {
					e.printStackTrace();
				}
			  }
			  
		  else
			  System.out.println("Only letters are allowed");
		  		return;
		}

	  	/*
	  	 * Method to validate that the string contains only letters 
	  	 * @param name
	  	 * 			city name
	  	 */
	  
	  	public static boolean isLetters(String name) {
	  	    return name.matches("[a-zA-Z]+");
	  	}
	  	
	  	
	  	public static void Message(){
	  		System.out.println("Usage: java -jar goEuroTest.jar STRING");
	  	}
	  	
	  	
	}