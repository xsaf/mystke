package com.arabsoft.mySTKE.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Entrepreneur {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idEnt;
	private String nom;
	private String prenom;
	private String adresse;
	private String ville;
	private int telephone;
	private String mail;
	@OneToMany(mappedBy = "entrepreneur")
	public Set<Projet> projets;

	public Entrepreneur() {
	}

	public int getIdEnt() {
		return idEnt;
	}

	public void setIdEnt(int idEnt) {
		this.idEnt = idEnt;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Set<Projet> getProjets() {
		return projets;
	}

	public void setProjets(Set<Projet> projet) {
		this.projets = projet;
	}

}