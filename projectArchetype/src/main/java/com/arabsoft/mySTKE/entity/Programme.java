package com.arabsoft.mySTKE.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Programme {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idProg;
	private String descRepartition;
	private int nbrEtage;
	private int nbrImm;
	private String recommandation;
	private Boolean valide;
	@ManyToOne()
	private Projet projet;

	public Programme() {
	}

	public int getIdProg() {
		return idProg;
	}

	public void setIdProg(int idProg) {
		this.idProg = idProg;
	}

	public String getDescRepartition() {
		return descRepartition;
	}

	public void setDescRepartition(String descRepartition) {
		this.descRepartition = descRepartition;
	}

	public int getNbrEtage() {
		return nbrEtage;
	}

	public void setNbrEtage(int nbrEtage) {
		this.nbrEtage = nbrEtage;
	}

	public int getNbrImm() {
		return nbrImm;
	}

	public void setNbrImm(int nbrImm) {
		this.nbrImm = nbrImm;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public String getRecommandation() {
		return recommandation;
	}

	public void setRecommandation(String recommandation) {
		this.recommandation = recommandation;
	}

	public Boolean getValide() {
		return valide;
	}

	public void setValide(Boolean valide) {
		this.valide = valide;
	}


}