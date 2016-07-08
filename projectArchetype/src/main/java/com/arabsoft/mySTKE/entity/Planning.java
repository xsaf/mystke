package com.arabsoft.mySTKE.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Planning {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idPlanning;
	private int etudeSemaine;
	private int planificationSemaine;
	private int reunionSemaine;
	private int clotureSemaine;
	private int analyseSemaine;
	private int etudeSemaineReel;
	private int planificationSemaineReel;
	private int reunionSemaineReel;
	private int clotureSemaineReel;
	private int analyseSemaineReel;
	@ManyToOne
	private Projet projet;

	public Planning() {
	}

	public int getIdPlanning() {
		return idPlanning;
	}

	public void setIdPlanning(int idPlanning) {
		this.idPlanning = idPlanning;
	}

	public int getEtudeSemaine() {
		return etudeSemaine;
	}

	public void setEtudeSemaine(int etudeSemaine) {
		this.etudeSemaine = etudeSemaine;
	}

	public int getPlanificationSemaine() {
		return planificationSemaine;
	}

	public void setPlanificationSemaine(int planificationSemaine) {
		this.planificationSemaine = planificationSemaine;
	}

	public int getReunionSemaine() {
		return reunionSemaine;
	}

	public void setReunionSemaine(int reunionSemaine) {
		this.reunionSemaine = reunionSemaine;
	}

	public int getClotureSemaine() {
		return clotureSemaine;
	}

	public void setClotureSemaine(int clotureSemaine) {
		this.clotureSemaine = clotureSemaine;
	}

	public int getAnalyseSemaine() {
		return analyseSemaine;
	}

	public void setAnalyseSemaine(int analyseSemaine) {
		this.analyseSemaine = analyseSemaine;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public int getEtudeSemaineReel() {
		return etudeSemaineReel;
	}

	public void setEtudeSemaineReel(int etudeSemaineReel) {
		this.etudeSemaineReel = etudeSemaineReel;
	}

	public int getPlanificationSemaineReel() {
		return planificationSemaineReel;
	}

	public void setPlanificationSemaineReel(int planificationSemaineReel) {
		this.planificationSemaineReel = planificationSemaineReel;
	}

	public int getReunionSemaineReel() {
		return reunionSemaineReel;
	}

	public void setReunionSemaineReel(int reunionSemaineReel) {
		this.reunionSemaineReel = reunionSemaineReel;
	}

	public int getClotureSemaineReel() {
		return clotureSemaineReel;
	}

	public void setClotureSemaineReel(int clotureSemaineReel) {
		this.clotureSemaineReel = clotureSemaineReel;
	}

	public int getAnalyseSemaineReel() {
		return analyseSemaineReel;
	}

	public void setAnalyseSemaineReel(int analyseSemaineReel) {
		this.analyseSemaineReel = analyseSemaineReel;
	}
	
	
	
	

	

}
