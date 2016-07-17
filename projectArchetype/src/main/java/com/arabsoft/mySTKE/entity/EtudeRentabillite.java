package com.arabsoft.mySTKE.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

@Entity
public class EtudeRentabillite {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idEtude;
	private String prixVenteMoyen;
	private String prixTerrain;
	private String chargesConstruction;
	private String frais;
	@ManyToOne
	public Projet projet;
	@OneToMany(mappedBy = "etudeRentabillite")
	private Set<Analyse> analyses;
	@ManyToOne
	private Utilisateur utilisateur;

	public EtudeRentabillite() {
	}

	public int getIdEtude() {
		return idEtude;
	}

	public void setIdEtude(int idEtude) {
		this.idEtude = idEtude;
	}

	public String getPrixVenteMoyen() {
		return prixVenteMoyen;
	}

	public void setPrixVenteMoyen(String prixVenteMoyen) {
		this.prixVenteMoyen = prixVenteMoyen;
	}

	public String getPrixTerrain() {
		return prixTerrain;
	}

	public void setPrixTerrain(String prixTerrain) {
		this.prixTerrain = prixTerrain;
	}

	public String getChargesConstruction() {
		return chargesConstruction;
	}

	public void setChargesConstruction(String chargesConstruction) {
		this.chargesConstruction = chargesConstruction;
	}

	public String getFrais() {
		return frais;
	}

	public void setFrais(String frais) {
		this.frais = frais;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Set<Analyse> getAnalyses() {
		return analyses;
	}

	public void setAnalyses(Set<Analyse> analyses) {
		this.analyses = analyses;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	
	
	

}