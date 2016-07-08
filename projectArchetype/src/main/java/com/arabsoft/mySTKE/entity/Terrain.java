package com.arabsoft.mySTKE.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Terrain {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idTerrain;
	private String numTerrain;
	private String adresse;
	private String ville;
	private String xTerrain;
	private String yTerrain;
	private String visite;
	private Date dateVisite;
	private String achatTerrain;
	@ManyToOne
	private Projet projet;
	@ManyToOne
	private Zone zone;

	public Terrain() {
	}

	public int getIdTerrain() {
		return idTerrain;
	}

	public void setIdTerrain(int idTerrain) {
		this.idTerrain = idTerrain;
	}

	public String getNumTerrain() {
		return numTerrain;
	}

	public void setNumTerrain(String numTerrain) {
		this.numTerrain = numTerrain;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getxTerrain() {
		return xTerrain;
	}

	public void setxTerrain(String xTerrain) {
		this.xTerrain = xTerrain;
	}

	public String getyTerrain() {
		return yTerrain;
	}

	public void setyTerrain(String yTerrain) {
		this.yTerrain = yTerrain;
	}

	public String getVisite() {
		return visite;
	}

	public void setVisite(String visite) {
		this.visite = visite;
	}

	public Date getDateVisite() {
		return dateVisite;
	}

	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}

	public String getAchatTerrain() {
		return achatTerrain;
	}

	public void setAchatTerrain(String achatTerrain) {
		this.achatTerrain = achatTerrain;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

}