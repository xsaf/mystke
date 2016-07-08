package com.arabsoft.mySTKE.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.security.access.prepost.PreAuthorize;

@ManagedBean(name = "testCtr")
@ViewScoped
public class TestCtr {
	
	private String s = "yes";
	
	@PreAuthorize("hasRole('PRDG')")
	public void initialisation() {
		System.out.println("Safffffffffff;");
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
	
	

}
