package com.arabsoft.mySTKE.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

@Entity
public class Notification {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idNoti;
	private String libelleNoti;
	private Date dateNoti;
	@ManyToOne
	private Projet projet;
	@ManyToOne
	private Utilisateur utilisateur;

	public Notification() {
	}

	public int getIdNoti() {
		return idNoti;
	}

	public void setIdNoti(int idNoti) {
		this.idNoti = idNoti;
	}

	public String getLibelleNoti() {
		return libelleNoti;
	}

	public void setLibelleNoti(String libelleNoti) {
		this.libelleNoti = libelleNoti;
	}

	public Date getDateNoti() {
		return dateNoti;
	}

	public void setDateNoti(Date dateNoti) {
		this.dateNoti = dateNoti;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	
	

}