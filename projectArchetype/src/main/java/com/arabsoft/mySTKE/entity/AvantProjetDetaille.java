package com.arabsoft.mySTKE.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class AvantProjetDetaille {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idApd;
	private float budgetDefinitive;
	private String recommandationRST;
	private Boolean valider;
	@ManyToOne
	private Projet projet;
	
	public AvantProjetDetaille() {}

	public int getIdApd() {
		return idApd;
	}

	public void setIdApd(int idApd) {
		this.idApd = idApd;
	}

	public float getBudgetDefinitive() {
		return budgetDefinitive;
	}

	public void setBudgetDefinitive(float budgetDefinitive) {
		this.budgetDefinitive = budgetDefinitive;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public String getRecommandationRST() {
		return recommandationRST;
	}

	public void setRecommandationRST(String recommandationRST) {
		this.recommandationRST = recommandationRST;
	}

	public Boolean getValider() {
		return valider;
	}

	public void setValider(Boolean valider) {
		this.valider = valider;
	}
	
	

}