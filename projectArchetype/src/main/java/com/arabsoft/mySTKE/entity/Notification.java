package com.arabsoft.mySTKE.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Notification {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idNoti;
	private String libelleNoti;
	private Date dateNoti;
	@ManyToOne
	public Projet projet;
	@ManyToOne
	public Utilisa utilisa;

	public Notification() {
	}

	public int getIdNoti() {
		return idNoti;
	}

	public void setIdNoti(int idNoti) {
		this.idNoti = idNoti;
	}

	public String getLibelleNoti() {
		return libelleNoti;
	}

	public void setLibelleNoti(String libelleNoti) {
		this.libelleNoti = libelleNoti;
	}

	public Date getDateNoti() {
		return dateNoti;
	}

	public void setDateNoti(Date dateNoti) {
		this.dateNoti = dateNoti;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Utilisa getUtilisa() {
		return utilisa;
	}

	public void setUtilisa(Utilisa utilisa) {
		this.utilisa = utilisa;
	}
	
	

}