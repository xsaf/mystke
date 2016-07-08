package com.arabsoft.mySTKE.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Immeuble {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idImm;
	private float surface;
	private int nbrEtage;
	private int nbrLoyer;
	private int nbrBureau;
	@OneToMany(mappedBy = "immeuble")
	public Set<Appartement> appartements;
	@OneToMany(mappedBy = "immeuble")
	public Set<Bureau> bureaux;
	@ManyToOne
	private Projet projetI;
	@OneToMany(mappedBy = "immeuble")
	public Set<Defaut> defauts;
	
	
	public Immeuble() {
	}

	public int getIdImm() {
		return idImm;
	}

	public void setIdImm(int idImm) {
		this.idImm = idImm;
	}

	public float getSurface() {
		return surface;
	}

	public void setSurface(float surface) {
		this.surface = surface;
	}

	public int getNbrEtage() {
		return nbrEtage;
	}

	public void setNbrEtage(int nbrEtage) {
		this.nbrEtage = nbrEtage;
	}

	public int getNbrLoyer() {
		return nbrLoyer;
	}

	public void setNbrLoyer(int nbrLoyer) {
		this.nbrLoyer = nbrLoyer;
	}

	public int getNbrBureau() {
		return nbrBureau;
	}

	public void setNbrBureau(int nbrBureau) {
		this.nbrBureau = nbrBureau;
	}

	public Set<Appartement> getAppartements() {
		return appartements;
	}

	public void setAppartements(Set<Appartement> appartements) {
		this.appartements = appartements;
	}

	public Set<Bureau> getBureaux() {
		return bureaux;
	}

	public void setBureaux(Set<Bureau> bureaux) {
		this.bureaux = bureaux;
	}

	public Projet getProjetI() {
		return projetI;
	}

	public void setProjetI(Projet projetI) {
		this.projetI = projetI;
	}

	public Set<Defaut> getDefauts() {
		return defauts;
	}

	public void setDefauts(Set<Defaut> defauts) {
		this.defauts = defauts;
	}



}