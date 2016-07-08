package com.arabsoft.mySTKE.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Utilisa {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idUti;
	private String nomUti;
	private String prenomUti;
	private String identifiantUti;
	private String motDePasseUti;
	private String adresseUti;
	private String villeUti;
	private int telephoneUti;
	private String mailUti;
	@OneToMany(mappedBy = "utilisa")
	private Set<ReunionChantier> reunionChantiers;
	@ManyToMany()
	private Set<Operation> operations;
	@OneToMany(mappedBy = "utilisa")
	private Set<EtudeRentabillite> etudeRentabillites;
	@ManyToOne
	private Fonction fonction;
	@ManyToOne
	private Departement departement;
	@OneToMany(mappedBy = "utilisa")
	private Set<Notification> notifications;
	@OneToMany(mappedBy = "utilisa")
	private Set<Equipe> equipes;

	public int getIdUti() {
		return idUti;
	}

	public void setIdUti(int idUti) {
		this.idUti = idUti;
	}

	public String getNomUti() {
		return nomUti;
	}

	public void setNomUti(String nomUti) {
		this.nomUti = nomUti;
	}

	public String getPrenomUti() {
		return prenomUti;
	}

	public void setPrenomUti(String prenomUti) {
		this.prenomUti = prenomUti;
	}

	public String getIdentifiantUti() {
		return identifiantUti;
	}

	public void setIdentifiantUti(String identifiantUti) {
		this.identifiantUti = identifiantUti;
	}

	public String getMotDePasseUti() {
		return motDePasseUti;
	}

	public void setMotDePasseUti(String motDePasseUti) {
		this.motDePasseUti = motDePasseUti;
	}

	public String getAdresseUti() {
		return adresseUti;
	}

	public void setAdresseUti(String adresseUti) {
		this.adresseUti = adresseUti;
	}

	public String getVilleUti() {
		return villeUti;
	}

	public void setVilleUti(String villeUti) {
		this.villeUti = villeUti;
	}

	public int getTelephoneUti() {
		return telephoneUti;
	}

	public void setTelephoneUti(int telephoneUti) {
		this.telephoneUti = telephoneUti;
	}

	public String getMailUti() {
		return mailUti;
	}

	public void setMailUti(String mailUti) {
		this.mailUti = mailUti;
	}

	public Set<ReunionChantier> getReunionChantiers() {
		return reunionChantiers;
	}

	public void setReunionChantiers(Set<ReunionChantier> reunionChantiers) {
		this.reunionChantiers = reunionChantiers;
	}

	public Set<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(Set<Equipe> equipes) {
		this.equipes = equipes;
	}

	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

	public Set<EtudeRentabillite> getEtudeRentabillites() {
		return etudeRentabillites;
	}

	public void setEtudeRentabillites(Set<EtudeRentabillite> etudeRentabillites) {
		this.etudeRentabillites = etudeRentabillites;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	public Set<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}
	
	public Set<Equipe> getEquipe() {
		return equipes;
	}

	public void setEquipe(Set<Equipe> equipes) {
		this.equipes = equipes;
	}

}