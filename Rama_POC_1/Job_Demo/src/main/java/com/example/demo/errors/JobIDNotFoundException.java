package com.example.demo.errors;

public class JobIDNotFoundException extends Exception{
	 
	private static final long serialVersionUID = 1L;
	
	public JobIDNotFoundException(String s){
		super(s);  
	}

}
