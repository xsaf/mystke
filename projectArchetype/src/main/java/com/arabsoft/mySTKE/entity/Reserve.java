package com.arabsoft.mySTKE.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reserve {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idReserve;
	private String libelleReserve;
	private Date dateReserve;
	@ManyToOne()
	private Client client;

	public Reserve() {
	}

	public int getIdReserve() {
		return idReserve;
	}

	public void setIdReserve(int idReserve) {
		this.idReserve = idReserve;
	}

	public String getLibelleReserve() {
		return libelleReserve;
	}

	public void setLibelleReserve(String libelleReserve) {
		this.libelleReserve = libelleReserve;
	}

	public Date getDateReserve() {
		return dateReserve;
	}

	public void setDateReserve(Date dateReserve) {
		this.dateReserve = dateReserve;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}