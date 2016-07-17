package com.arabsoft.mySTKE.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.arabsoft.mySTKE.business.AbsDocBusiness;
import com.arabsoft.mySTKE.business.ProjetBusiness;
import com.arabsoft.mySTKE.entity.Projet;
import com.arabsoft.utils.FacesUtil;

@ManagedBean(name = "accueilCtr")
@ViewScoped
public class AccueilCtr {

	private Projet projet = new Projet();


	@ManagedProperty(value = "#{projetBusiness}")
	private ProjetBusiness projetBusiness;

	@ManagedProperty(value = "#{gedCtr}")
	private GedCtr gedCtr;

	

	@PostConstruct
	public void initialisation() {
		// "0B_KzijCYeJPvalRhMFVpYjl2bTA";
		gedCtr.setFolder("0B_KzijCYeJPveXkyNzJDTDQ0NEk");

	}

	public void createProjet(String nomProj) {
		projet.setNomProj(nomProj);
		projet.setDescEtat(11);
		projet = projetBusiness.createProjet(projet);
		FacesUtil.setSessionMapValue("AccueilCtr.idprojet", projet.getIdProj());
	}
	
	public void createFolder(){
		gedCtr.setProjet(projet);
		gedCtr.createFolder();
	}

	public String test123() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "test";
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public ProjetBusiness getProjetBusiness() {
		return projetBusiness;
	}

	public void setProjetBusiness(ProjetBusiness projetBusiness) {
		this.projetBusiness = projetBusiness;
	}

	public GedCtr getGedCtr() {
		return gedCtr;
	}

	public void setGedCtr(GedCtr gedCtr) {
		this.gedCtr = gedCtr;
	}


	
	

}
