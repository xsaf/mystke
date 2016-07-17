package com.arabsoft.mySTKE.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

@Entity
public class Departement {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idDep;
	private String libelleDepartement;
	@OneToMany(mappedBy = "departement")
	public Set<Utilisateur> utilisateurs;

	public Departement() {
	}

	public int getIdDep() {
		return idDep;
	}

	public void setIdDep(int idDep) {
		this.idDep = idDep;
	}

	public String getLibelleDepartement() {
		return libelleDepartement;
	}

	public void setLibelleDepartement(String libelleDepartement) {
		this.libelleDepartement = libelleDepartement;
	}

	public Set<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	

}