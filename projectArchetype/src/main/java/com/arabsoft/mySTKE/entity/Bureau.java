package com.arabsoft.mySTKE.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Bureau {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idBur;
	private int numEtage;
	private int numBloc;
	private float surface;
	private float prix;
	@ManyToOne
	private Immeuble immeuble;
	@ManyToOne
	private Client client;
	@OneToMany(mappedBy = "bureau")
	public Set<Defaut> defauts;

	public Bureau() {
	}

	public int getIdBur() {
		return idBur;
	}

	public void setIdBur(int idBur) {
		this.idBur = idBur;
	}


	public Set<Defaut> getDefauts() {
		return defauts;
	}


	public void setDefauts(Set<Defaut> defauts) {
		this.defauts = defauts;
	}


	public int getNumEtage() {
		return numEtage;
	}

	public void setNumEtage(int numEtage) {
		this.numEtage = numEtage;
	}

	public int getNumBloc() {
		return numBloc;
	}

	public void setNumBloc(int numBloc) {
		this.numBloc = numBloc;
	}

	public float getSurface() {
		return surface;
	}

	public void setSurface(float surface) {
		this.surface = surface;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Immeuble getImmeuble() {
		return immeuble;
	}

	public void setImmeuble(Immeuble immeuble) {
		this.immeuble = immeuble;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}