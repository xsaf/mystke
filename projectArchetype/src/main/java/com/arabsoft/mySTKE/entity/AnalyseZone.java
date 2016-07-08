package com.arabsoft.mySTKE.entity;

import javax.persistence.Entity;

@Entity
public class AnalyseZone extends Analyse {

	private int idAnaZone;
	private String descImm;
	private String descLoyer;
	private String descBureau;
	private String prixMetre;
	
	public AnalyseZone() {
		super();
	}

	public int getIdAnaZone() {
		return idAnaZone;
	}

	public void setIdAnaZone(int idAnaZone) {
		this.idAnaZone = idAnaZone;
	}

	public String getDescImm() {
		return descImm;
	}

	public void setDescImm(String descImm) {
		this.descImm = descImm;
	}

	public String getDescLoyer() {
		return descLoyer;
	}

	public void setDescLoyer(String descLoyer) {
		this.descLoyer = descLoyer;
	}

	public String getDescBureau() {
		return descBureau;
	}

	public void setDescBureau(String descBureau) {
		this.descBureau = descBureau;
	}

	public String getPrixMetre() {
		return prixMetre;
	}

	public void setPrixMetre(String prixMetre) {
		this.prixMetre = prixMetre;
	}
	
	
	

}