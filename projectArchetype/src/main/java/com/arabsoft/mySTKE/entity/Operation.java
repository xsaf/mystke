package com.arabsoft.mySTKE.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

@Entity
public class Operation {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idOp;
	private String libelleOp;
	@ManyToMany(mappedBy = "operations")
	private Set<Utilisateur> utilisateurs;

	public Operation() {
	}

	public int getIdOp() {
		return idOp;
	}

	public void setIdOp(int idOp) {
		this.idOp = idOp;
	}

	public String getLibelleOp() {
		return libelleOp;
	}

	public void setLibelleOp(String libelleOp) {
		this.libelleOp = libelleOp;
	}

	public Set<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	
}