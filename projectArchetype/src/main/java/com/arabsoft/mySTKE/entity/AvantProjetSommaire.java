package com.arabsoft.mySTKE.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class AvantProjetSommaire {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idAps;
	private float budgetEstime;
	private String recommandationRST;
	private String recommandationDG;
	private String bureauPilotage;
	private String bureauControle;
	private String bureauIngenieur;
	private String missionPilotage;
	private String missionControle;
	private String missionIngenieur;
	private Boolean valider;
	@ManyToOne
	private Projet projet;
	
	public AvantProjetSommaire() {}

	public int getIdAps() {
		return idAps;
	}

	public void setIdAps(int idAps) {
		this.idAps = idAps;
	}

	public float getBudgetEstime() {
		return budgetEstime;
	}

	public void setBudgetEstime(float budgetEstime) {
		this.budgetEstime = budgetEstime;
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

	public String getRecommandationDG() {
		return recommandationDG;
	}

	public void setRecommandationDG(String recommandationDG) {
		this.recommandationDG = recommandationDG;
	}

	public Boolean getValider() {
		return valider;
	}

	public void setValider(Boolean valider) {
		this.valider = valider;
	}

	public String getBureauPilotage() {
		return bureauPilotage;
	}

	public void setBureauPilotage(String bureauPilotage) {
		this.bureauPilotage = bureauPilotage;
	}

	public String getBureauControle() {
		return bureauControle;
	}

	public void setBureauControle(String bureauControle) {
		this.bureauControle = bureauControle;
	}

	public String getBureauIngenieur() {
		return bureauIngenieur;
	}

	public void setBureauIngenieur(String bureauIngenieur) {
		this.bureauIngenieur = bureauIngenieur;
	}

	public String getMissionPilotage() {
		return missionPilotage;
	}

	public void setMissionPilotage(String missionPilotage) {
		this.missionPilotage = missionPilotage;
	}

	public String getMissionControle() {
		return missionControle;
	}

	public void setMissionControle(String missionControle) {
		this.missionControle = missionControle;
	}

	public String getMissionIngenieur() {
		return missionIngenieur;
	}

	public void setMissionIngenieur(String missionIngenieur) {
		this.missionIngenieur = missionIngenieur;
	}

	
	

}