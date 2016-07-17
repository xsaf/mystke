package com.arabsoft.mySTKE.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

@Entity
public class Recommandation {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idRecomm;
	private int libelleRecomm;
	private Date dateRecomm;
	@ManyToOne
	public EtudeRentabillite etudeRentabillite;
	@ManyToOne
	public Utilisateur utilisateur;
	@ManyToOne
	public Projet projet;

	public Recommandation() {
	}

	public int getIdRecomm() {
		return idRecomm;
	}

	public void setIdRecomm(int idRecomm) {
		this.idRecomm = idRecomm;
	}

	public int getLibelleRecomm() {
		return libelleRecomm;
	}

	public void setLibelleRecomm(int libelleRecomm) {
		this.libelleRecomm = libelleRecomm;
	}

	public Date getDateRecomm() {
		return dateRecomm;
	}

	public void setDateRecomm(Date dateRecomm) {
		this.dateRecomm = dateRecomm;
	}

	public EtudeRentabillite getEtudeRentabillite() {
		return etudeRentabillite;
	}

	public void setEtudeRentabillite(EtudeRentabillite etudeRentabillite) {
		this.etudeRentabillite = etudeRentabillite;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	
	

}