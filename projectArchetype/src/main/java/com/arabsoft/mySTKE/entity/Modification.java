package com.arabsoft.mySTKE.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Modification {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idMod;
	private String libelleMod;
	private Date dateMod;
	@ManyToOne
	public PlanningGlobal planningGlobal;

	public Modification() {
	}

	public int getIdMod() {
		return idMod;
	}

	public void setIdMod(int idMod) {
		this.idMod = idMod;
	}

	public String getLibelleMod() {
		return libelleMod;
	}

	public void setLibelleMod(String libelleMod) {
		this.libelleMod = libelleMod;
	}

	public Date getDateMod() {
		return dateMod;
	}

	public void setDateMod(Date dateMod) {
		this.dateMod = dateMod;
	}

	public PlanningGlobal getPlanningGlobal() {
		return planningGlobal;
	}

	public void setPlanningGlobal(PlanningGlobal planningGlobal) {
		this.planningGlobal = planningGlobal;
	}

}