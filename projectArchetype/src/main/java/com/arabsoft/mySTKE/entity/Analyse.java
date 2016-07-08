package com.arabsoft.mySTKE.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Analyse {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idAnalyse;
	private String libelleAnalyse;
	private Date dateAna;
	private Boolean validee;
	@ManyToOne
	private EtudeRentabillite etudeRentabillite;

	public Analyse() {
	}

	public int getIdAnalyse() {
		return idAnalyse;
	}

	public void setIdAnalyse(int idAnalyse) {
		this.idAnalyse = idAnalyse;
	}

	public String getLibelleAnalyse() {
		return libelleAnalyse;
	}

	public void setLibelleAnalyse(String libelleAnalyse) {
		this.libelleAnalyse = libelleAnalyse;
	}

	public Date getDateAna() {
		return dateAna;
	}

	public void setDateAna(Date dateAna) {
		this.dateAna = dateAna;
	}

	public Boolean getValidee() {
		return validee;
	}

	public void setValidee(Boolean validee) {
		this.validee = validee;
	}

	public EtudeRentabillite getEtudeRentabillite() {
		return etudeRentabillite;
	}

	public void setEtudeRentabillite(EtudeRentabillite etudeRentabillite) {
		this.etudeRentabillite = etudeRentabillite;
	}

}