package com.arabsoft.mySTKE.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AxeAmelioration {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idAxe;
	private String nomAxe;
	private String descAxe;
	@ManyToOne
	private Projet projet;
		
	public AxeAmelioration() {}

	public int getIdAxe() {
		return idAxe;
	}

	public void setIdAxe(int idAxe) {
		this.idAxe = idAxe;
	}

	public String getDescAxe() {
		return descAxe;
	}

	public void setDescAxe(String descAxe) {
		this.descAxe = descAxe;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public String getNomAxe() {
		return nomAxe;
	}

	public void setNomAxe(String nomAxe) {
		this.nomAxe = nomAxe;
	}
	
	
 

}
