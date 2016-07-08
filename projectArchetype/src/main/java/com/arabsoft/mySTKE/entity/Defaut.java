package com.arabsoft.mySTKE.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Defaut {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idDefaut;
	private String descDefaut;
	private String travauxDefaut;
	private String validationReserve;
	private String validationDefaut;
	private String leveeReserve;
	@ManyToOne
	private Immeuble immeuble;
	@ManyToOne
	private Appartement appartement;
	@ManyToOne
	private Bureau bureau;
	@ManyToOne
	private Projet projet;
	
	
	public int getIdDefaut() {
		return idDefaut;
	}
	public void setIdDefaut(int idDefaut) {
		this.idDefaut = idDefaut;
	}
	public String getDescDefaut() {
		return descDefaut;
	}
	public void setDescDefaut(String descDefaut) {
		this.descDefaut = descDefaut;
	}
	public String getTravauxDefaut() {
		return travauxDefaut;
	}
	public void setTravauxDefaut(String travauxDefaut) {
		this.travauxDefaut = travauxDefaut;
	}
	public Immeuble getImmeuble() {
		return immeuble;
	}
	public void setImmeuble(Immeuble immeuble) {
		this.immeuble = immeuble;
	}
	public Appartement getAppartement() {
		return appartement;
	}
	public void setAppartement(Appartement appartement) {
		this.appartement = appartement;
	}
	public Bureau getBureau() {
		return bureau;
	}
	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	public String isValidationReserve() {
		return validationReserve;
	}
	public void setValidationReserve(String validationReserve) {
		this.validationReserve = validationReserve;
	}
	public String getValidationDefaut() {
		return validationDefaut;
	}
	public void setValidationDefaut(String validationDefaut) {
		this.validationDefaut = validationDefaut;
	}
	public String getValidationReserve() {
		return validationReserve;
	}
	public String getLeveeReserve() {
		return leveeReserve;
	}
	public void setLeveeReserve(String leveeReserve) {
		this.leveeReserve = leveeReserve;
	}
	
	
	

}
