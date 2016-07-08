package com.arabsoft.mySTKE.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idCli;
	private String nom;
	private String prenom;
	private String adresse;
	private String ville;
	private int telephone;
	private String mail;
	private String fonctionSyndicat;

	@OneToMany(mappedBy = "client")
	private Set<Appartement> appartements;
	@OneToMany(mappedBy = "client")
	private Set<Bureau> bureaux;
	@OneToMany(mappedBy = "client")
	private Set<Reserve> reserves;

	public Client() {
	}

	public int getIdCli() {
		return idCli;
	}

	public void setIdCli(int idCli) {
		this.idCli = idCli;
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

	public Set<Reserve> getReserves() {
		return reserves;
	}

	public void setReserves(Set<Reserve> reserve) {
		this.reserves = reserve;
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

	public String getFonctionSyndicat() {
		return fonctionSyndicat;
	}

	public void setFonctionSyndicat(String fonctionSyndicat) {
		this.fonctionSyndicat = fonctionSyndicat;
	}
	

}