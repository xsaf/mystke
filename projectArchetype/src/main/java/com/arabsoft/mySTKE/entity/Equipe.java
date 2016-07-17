package com.arabsoft.mySTKE.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

@Entity
public class Equipe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idEquipe;
	@ManyToOne
	private Projet projet;
	@ManyToOne
	private Utilisateur utilisateur;
	
	public Equipe() {
	}

	public int getIdEquipe() {
		return idEquipe;
	}

	public void setIdEquipe(int idEquipe) {
		this.idEquipe = idEquipe;
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
