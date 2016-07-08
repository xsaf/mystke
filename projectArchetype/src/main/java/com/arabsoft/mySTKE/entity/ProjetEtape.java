package com.arabsoft.mySTKE.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProjetEtape {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idProEta;
	private int dateEta;
	@ManyToOne
	public Projet projet;
	@ManyToOne
	public Etape etape;

	public ProjetEtape() {
	}

	public int getIdProEta() {
		return idProEta;
	}

	public void setIdProEta(int idProEta) {
		this.idProEta = idProEta;
	}

	public int getDateEta() {
		return dateEta;
	}

	public void setDateEta(int dateEta) {
		this.dateEta = dateEta;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Etape getEtape() {
		return etape;
	}

	public void setEtape(Etape etape) {
		this.etape = etape;
	}
	
	

}