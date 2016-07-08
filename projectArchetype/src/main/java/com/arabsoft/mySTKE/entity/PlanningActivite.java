package com.arabsoft.mySTKE.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PlanningActivite {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idPlanAct;
	private String libelleAct;
	private Date debutAct;
	private Date finAct;
	private float budgetAct;
	private String sourceModification;
	private int progression;
	@ManyToOne
	private PlanningGlobal planningGlobal;
	@OneToMany(mappedBy = "planningActivite")
	private Set<ReunionChantier> reunionChantiers;

	public PlanningActivite() {
	}

	public int getIdPlanAct() {
		return idPlanAct;
	}

	public void setIdPlanAct(int idPlanAct) {
		this.idPlanAct = idPlanAct;
	}

	public String getLibelleAct() {
		return libelleAct;
	}

	public void setLibelleAct(String libelleAct) {
		this.libelleAct = libelleAct;
	}

	public Date getDebutAct() {
		return debutAct;
	}

	public void setDebutAct(Date debutAct) {
		this.debutAct = debutAct;
	}

	public Date getFinAct() {
		return finAct;
	}

	public void setFinAct(Date finAct) {
		this.finAct = finAct;
	}

	public float getBudgetAct() {
		return budgetAct;
	}

	public void setBudgetAct(float budgetAct) {
		this.budgetAct = budgetAct;
	}

	public PlanningGlobal getPlanningGlobal() {
		return planningGlobal;
	}

	public void setPlanningGlobal(PlanningGlobal planningGlobal) {
		this.planningGlobal = planningGlobal;
	}

	public Set<ReunionChantier> getReunionChantiers() {
		return reunionChantiers;
	}

	public void setReunionChantiers(Set<ReunionChantier> reunionChantiers) {
		this.reunionChantiers = reunionChantiers;
	}

	public String getSourceModification() {
		return sourceModification;
	}

	public void setSourceModification(String sourceModification) {
		this.sourceModification = sourceModification;
	}

	public int getProgression() {
		return progression;
	}

	public void setProgression(int progression) {
		this.progression = progression;
	}

}