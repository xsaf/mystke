package com.arabsoft.mySTKE.entity;

import javax.persistence.Entity;

@Entity
public class AnalyseCout extends Analyse {

	private int idCout;
	private String coutTerrain;
	private String coutTavaux;
	private String coutPrestataires;
	private String coutAdministratifs;

	public AnalyseCout() {
		super();
	}

	public int getIdCout() {
		return idCout;
	}

	public void setIdCout(int idCout) {
		this.idCout = idCout;
	}

	public String getCoutTerrain() {
		return coutTerrain;
	}

	public void setCoutTerrain(String coutTerrain) {
		this.coutTerrain = coutTerrain;
	}

	public String getCoutTavaux() {
		return coutTavaux;
	}

	public void setCoutTavaux(String coutTavaux) {
		this.coutTavaux = coutTavaux;
	}

	public String getCoutPrestataires() {
		return coutPrestataires;
	}

	public void setCoutPrestataires(String coutPrestataires) {
		this.coutPrestataires = coutPrestataires;
	}

	public String getCoutAdministratifs() {
		return coutAdministratifs;
	}

	public void setCoutAdministratifs(String coutAdministratifs) {
		this.coutAdministratifs = coutAdministratifs;
	}
	

}