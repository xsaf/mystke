package com.arabsoft.mySTKE.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProjetValidation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idProjValid;
	private Date dateReunion;
	private String projValid;
	private int etatValid;
	@ManyToOne
	private Projet projet;
	
	public ProjetValidation(){
	}

	public int getIdProjValid() {
		return idProjValid;
	}

	public void setIdProjValid(int idProjValid) {
		this.idProjValid = idProjValid;
	}

	public Date getDateReunion() {
		return dateReunion;
	}

	public void setDateReunion(Date dateReunion) {
		this.dateReunion = dateReunion;
	}
	
	public String getProjValid() {
		return projValid;
	}

	public void setProjValid(String projValid) {
		this.projValid = projValid;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public int getEtatValid() {
		return etatValid;
	}

	public void setEtatValid(int etatValid) {
		this.etatValid = etatValid;
	}
	
	
	
	

}
