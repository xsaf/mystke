package com.arabsoft.mySTKE.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ReunionChantier {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idReunion;
	private Date dateReunion;
	private String libelleReunion;
	private String avancement;
	private String etatTravaux;
	@ManyToOne
	private Projet projet;
	@ManyToOne
	private PlanningActivite planningActivite;
	@ManyToOne
	private Utilisa utilisa;

	public ReunionChantier() {
	}

	public int getIdReunion() {
		return idReunion;
	}

	public void setIdReunion(int idReunion) {
		this.idReunion = idReunion;
	}

	public Date getDateReunion() {
		return dateReunion;
	}

	public void setDateReunion(Date dateReunion) {
		this.dateReunion = dateReunion;
	}

	public String getLibelleReunion() {
		return libelleReunion;
	}

	public void setLibelleReunion(String libelleReunion) {
		this.libelleReunion = libelleReunion;
	}

	public String getAvancement() {
		return avancement;
	}

	public void setAvancement(String avancement) {
		this.avancement = avancement;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Utilisa getUtilisateur() {
		return utilisa;
	}

	public void setUtilisateur(Utilisa utilisa) {
		this.utilisa = utilisa;
	}

	public String getEtatTravaux() {
		return etatTravaux;
	}

	public void setEtatTravaux(String etatTravaux) {
		this.etatTravaux = etatTravaux;
	}

	public Utilisa getUtilisa() {
		return utilisa;
	}

	public void setUtilisa(Utilisa utilisa) {
		this.utilisa = utilisa;
	}

	public PlanningActivite getPlanningActivite() {
		return planningActivite;
	}

	public void setPlanningActivite(PlanningActivite planningActivite) {
		this.planningActivite = planningActivite;
	}
	

}