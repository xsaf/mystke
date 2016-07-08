package com.arabsoft.mySTKE.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fonction {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idFon;
	private String libelleFonction;
	@OneToMany(mappedBy = "fonction")
	public Set<Utilisa> utilisas;

	public Fonction() {
	}

	public int getIdFon() {
		return idFon;
	}

	public void setIdFon(int idFon) {
		this.idFon = idFon;
	}

	public String getLibelleFonction() {
		return libelleFonction;
	}

	public void setLibelleFonction(String libelleFonction) {
		this.libelleFonction = libelleFonction;
	}

	public Set<Utilisa> getUtilisas() {
		return utilisas;
	}

	public void setUtilisateurs(Set<Utilisa> utilisas) {
		this.utilisas = utilisas;
	}

}