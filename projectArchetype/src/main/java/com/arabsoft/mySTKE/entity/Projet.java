package com.arabsoft.mySTKE.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Projet {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idProj;
	private String nomProj;
	private String libelleProj;
	private Date dateProj;
	private int descEtat;
	private String budgetFinal;
	@OneToMany(mappedBy = "projetI", cascade = CascadeType.ALL)
	private Set<Immeuble> immeubles = new HashSet<Immeuble>();
	@OneToMany(mappedBy = "projet")
	private Set<ReunionChantier> reunionChantiers;
	@ManyToOne
	private Entrepreneur entrepreneur;
	@OneToMany(mappedBy = "projet")
	private Set<Terrain> terrains;
	@OneToMany(mappedBy = "projet")
	private Set<AvantProjetSommaire> avantProjetSommaires;
	@OneToMany(mappedBy = "projet")
	private Set<AvantProjetDetaille> avantProjetDetailles;
	@OneToMany(mappedBy = "projet")
	private Set<Programme> programmes;
	@OneToMany(mappedBy = "projet")
	private Set<AbsDoc> absDocs;
	@OneToMany(mappedBy = "projet")
	private Set<Notification> notifications;
	@OneToMany(mappedBy = "projet")
	private Set<PlanningGlobal> planningGlobals;
	@OneToMany(mappedBy = "projet")
	private Set<Equipe> equipes;
	@OneToMany(mappedBy = "projet")
	private Set<Planning> plannings;
	@OneToMany(mappedBy = "projet")
	private Set<Zone> zones;
	@OneToMany(mappedBy = "projet")
	private Set<AxeAmelioration> axeAmeliorations;
	@OneToMany(mappedBy = "projet")
	private Set<Avis> avis;
	
	
	public Projet() {
	}

	public int getIdProj() {
		return idProj;
	}

	public void setIdProj(int idProj) {
		this.idProj = idProj;
	}

	public String getNomProj() {
		return nomProj;
	}

	public void setNomProj(String nomProj) {
		this.nomProj = nomProj;
	}

	public String getLibelleProj() {
		return libelleProj;
	}

	public void setLibelleProj(String libelleProj) {
		this.libelleProj = libelleProj;
	}

	public Date getDateProj() {
		return dateProj;
	}

	public void setDateProj(Date dateProj) {
		this.dateProj = dateProj;
	}
	
	public Set<Immeuble> getImmeubles() {
		return immeubles;
	}

	public void setImmeubles(Set<Immeuble> immeubles) {
		this.immeubles = immeubles;
	}

	public Set<ReunionChantier> getReunionChantiers() {
		return reunionChantiers;
	}

	public void setReunionChantiers(Set<ReunionChantier> reunionChantiers) {
		this.reunionChantiers = reunionChantiers;
	}

	public Entrepreneur getEntrepreneur() {
		return entrepreneur;
	}

	public void setEntrepreneur(Entrepreneur entrepreneur) {
		this.entrepreneur = entrepreneur;
	}

	public Set<Terrain> getTerrains() {
		return terrains;
	}

	public void setTerrains(Set<Terrain> terrains) {
		this.terrains = terrains;
	}

	public Set<AvantProjetSommaire> getAvantProjetSommaires() {
		return avantProjetSommaires;
	}

	public void setAvantProjetSommaires(Set<AvantProjetSommaire> avantProjetSommaires) {
		this.avantProjetSommaires = avantProjetSommaires;
	}

	public Set<AvantProjetDetaille> getAvantProjetDetailles() {
		return avantProjetDetailles;
	}

	public void setAvantProjetDetailles(Set<AvantProjetDetaille> avantProjetDetailles) {
		this.avantProjetDetailles = avantProjetDetailles;
	}

	public Set<Programme> getProgrammes() {
		return programmes;
	}

	public void setProgrammes(Set<Programme> programmes) {
		this.programmes = programmes;
	}

	public Set<AbsDoc> getAbsDocs() {
		return absDocs;
	}

	public void setAbsDocs(Set<AbsDoc> absDocs) {
		this.absDocs = absDocs;
	}

	public Set<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}

	public Set<PlanningGlobal> getPlanningGlobals() {
		return planningGlobals;
	}

	public void setPlanningGlobals(Set<PlanningGlobal> planningGlobals) {
		this.planningGlobals = planningGlobals;
	}

	public Set<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(Set<Equipe> equipes) {
		this.equipes = equipes;
	}

	public Set<Planning> getPlannings() {
		return plannings;
	}

	public void setPlannings(Set<Planning> plannings) {
		this.plannings = plannings;
	}

	public int getDescEtat() {
		return descEtat;
	}

	public void setDescEtat(int descEtat) {
		this.descEtat = descEtat;
	}

	public Set<Zone> getZones() {
		return zones;
	}

	public void setZones(Set<Zone> zones) {
		this.zones = zones;
	}

	public String getBudgetFinal() {
		return budgetFinal;
	}

	public void setBudgetFinal(String budgetFinal) {
		this.budgetFinal = budgetFinal;
	}

	public Set<AxeAmelioration> getAxeAmeliorations() {
		return axeAmeliorations;
	}

	public void setAxeAmeliorations(Set<AxeAmelioration> axeAmeliorations) {
		this.axeAmeliorations = axeAmeliorations;
	}

	public Set<Avis> getAvis() {
		return avis;
	}

	public void setAvis(Set<Avis> avis) {
		this.avis = avis;
	}
	
	
	
	


}