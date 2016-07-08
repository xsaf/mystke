package com.arabsoft.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainProj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"/spring/ApplicationContext.xml",
				"/spring/ApplicationContext-ressources.xml", "/spring/ApplicationContext-security.xml",
				"/spring/applicationContext-transaction.xml"});

	}

}
