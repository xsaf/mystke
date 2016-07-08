package com.arabsoft.mySTKE.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departement {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idDep;
	private String libelleDepartement;
	@OneToMany(mappedBy = "departement")
	public Set<Utilisa> utilisas;

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

	public Set<Utilisa> getUtilisas() {
		return utilisas;
	}

	public void setUtilisateurs(Set<Utilisa> utilisas) {
		this.utilisas = utilisas;
	}

}