package com.arabsoft.utils;

public class StringUtilities {

	
	public static String padRight(String s, int n , char c) {
	     return String.format("%1$-" + n + "s", s).replace(' ', c);  
	}

	public static String padLeft(String s, int n ,char c) {
		
	    return String.format("%"+n+"s", s).replace(' ', c);  
	}
	
	public static void main(String...x){
		System.out.println(padRight("12",7,'1'));
	}
	
	
}
