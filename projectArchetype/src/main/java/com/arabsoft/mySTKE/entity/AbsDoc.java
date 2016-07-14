package com.arabsoft.mySTKE.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class AbsDoc {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	protected int idAbsDoc;
	protected String numAbsDoc;
	protected String nomAbsDoc;
	protected int niveauAbsDoc;
	protected Date dateCreationAbsDoc;
	@ManyToOne
	private Projet projet;
	@ManyToOne
	private Dossier dossier;

	public abstract void operation();

	
	public AbsDoc() {
	}
	
	public int getIdAbsDoc() {
		return idAbsDoc;
	}

	public void setIdAbsDoc(int idAbsDoc) {
		this.idAbsDoc = idAbsDoc;
	}

	public String getNumAbsDoc() {
		return numAbsDoc;
	}

	public void setNumAbsDoc(String numAbsDoc) {
		this.numAbsDoc = numAbsDoc;
	}

	public String getNomAbsDoc() {
		return nomAbsDoc;
	}

	public void setNomAbsDoc(String nomAbsDoc) {
		this.nomAbsDoc = nomAbsDoc;
	}

	public int getNiveauAbsDoc() {
		return niveauAbsDoc;
	}

	public void setNiveauAbsDoc(int niveauAbsDoc) {
		this.niveauAbsDoc = niveauAbsDoc;
	}

	public Date getDateCreationAbsDoc() {
		return dateCreationAbsDoc;
	}

	public void setDateCreationAbsDoc(Date dateCreationAbsDoc) {
		this.dateCreationAbsDoc = dateCreationAbsDoc;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Dossier getDossier() {
		return dossier;
	}

	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}

}