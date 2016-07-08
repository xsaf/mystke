package com.arabsoft.mySTKE.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Etape {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idEtape;
	private String libelleEtape;
	
	

	public Etape() {
	}

	public int getIdEtape() {
		return idEtape;
	}

	public void setIdEtape(int idEtape) {
		this.idEtape = idEtape;
	}

	public String getLibelleEtape() {
		return libelleEtape;
	}

	public void setLibelleEtape(String libelleEtape) {
		this.libelleEtape = libelleEtape;
	}


}