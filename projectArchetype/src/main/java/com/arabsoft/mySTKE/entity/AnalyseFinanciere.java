package com.arabsoft.mySTKE.entity;

import javax.persistence.Entity;


@Entity
public class AnalyseFinanciere extends Analyse {

	private int idAnaFinan;
	private String estimRecette;
	private String estimProjet;
	private String margeRentabilite;
	private String propReparition;
	
	public AnalyseFinanciere() {
		super();
	}

	public int getIdAnaFinan() {
		return idAnaFinan;
	}

	public void setIdAnaFinan(int idAnaFinan) {
		this.idAnaFinan = idAnaFinan;
	}

	public String getEstimRecette() {
		return estimRecette;
	}

	public void setEstimRecette(String estimRecette) {
		this.estimRecette = estimRecette;
	}

	public String getEstimProjet() {
		return estimProjet;
	}

	public void setEstimProjet(String estimProjet) {
		this.estimProjet = estimProjet;
	}

	public String getMargeRentabilite() {
		return margeRentabilite;
	}

	public void setMargeRentabilite(String margeRentabilite) {
		this.margeRentabilite = margeRentabilite;
	}

	public String getPropReparition() {
		return propReparition;
	}

	public void setPropReparition(String propReparition) {
		this.propReparition = propReparition;
	}

	
	
}