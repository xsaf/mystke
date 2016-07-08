package com.arabsoft.mySTKE.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Avis {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idAvis;
	private String descAvis;
	private String validDG;
	private String validRST;
	@ManyToOne
	private Projet projet;
	
	public Avis() {}

	public int getIdAvis() {
		return idAvis;
	}

	public void setIdAvis(int idAvis) {
		this.idAvis = idAvis;
	}

	public String getDescAvis() {
		return descAvis;
	}

	public void setDescAvis(String descAvis) {
		this.descAvis = descAvis;
	}

	public String getValidDG() {
		return validDG;
	}

	public void setValidDG(String validDG) {
		this.validDG = validDG;
	}

	public String getValidRST() {
		return validRST;
	}

	public void setValidRST(String validRST) {
		this.validRST = validRST;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	
	
	
	
}
