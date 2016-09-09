package com.arabsoft.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.joda.time.Days;
import org.joda.time.LocalDate;


public class mainProj {

	public static void main(String[] args) {

		    Date d3 = new Date();
			DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

			
			Date d4 = new Date();
			d4.setHours(5);
			d4.setMinutes(30);
			d4.setDate(30);

			 System.out.println("hhh + "+d3);
			    System.out.println("hhh + "+d4);
			    
			int diff123 = (int) (d4.getTime() - d3.getTime());
			
		    int h = Days.daysBetween(new LocalDate(d3), new LocalDate(d4)).getDays() ;

		    System.out.println("hhh + "+h/7);

		   
		    
	}
	
	

}
