package com.arabsoft.mySTKE.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.arabsoft.mySTKE.business.AbsDocBusiness;
import com.arabsoft.mySTKE.entity.AbsDoc;
import com.arabsoft.mySTKE.entity.Dossier;

@ManagedBean(name = "testCtr")
@ViewScoped
public class TestCtr {
	
	private String s = "yes";
	private AbsDoc dossierParent;
	
	@ManagedProperty(value = "#{absDocBusiness}")
	private AbsDocBusiness absDocBusiness;
	
	@PostConstruct
	public void initialisation() {
		dossierParent = new Dossier();
		dossierParent.setNumAbsDoc("0B_KzijCYeJPvalRhMFVpYjl2bTA");
		dossierParent.setNomAbsDoc("parentFolder");
		absDocBusiness.createDossier((Dossier) dossierParent);
		
		System.out.println("Safffffffffff;");
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public AbsDoc getDossierParent() {
		return dossierParent;
	}

	public void setDossierParent(AbsDoc dossierParent) {
		this.dossierParent = dossierParent;
	}

	public AbsDocBusiness getAbsDocBusiness() {
		return absDocBusiness;
	}

	public void setAbsDocBusiness(AbsDocBusiness absDocBusiness) {
		this.absDocBusiness = absDocBusiness;
	}
	
	
	

}
