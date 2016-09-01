package com.arabsoft.mySTKE.endpoint;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Utilisateur")
public class UtilisateurWS {

	private String numMatrUser;
	private int idUti;
	protected String username;
	protected String userLastname;
	protected Integer userStatus;
	private boolean codStatUser;
	private String password;
	private String nomUti;
	private String prenomUti;
	private String adresseUti;
	private String villeUti;
	private String telephoneUti;
	private String mailUti;

	public UtilisateurWS() {
	}

	public String getNumMatrUser() {
		return numMatrUser;
	}

    @XmlElement(name = "numMatrUser")
	public void setNumMatrUser(String numMatrUser) {
		this.numMatrUser = numMatrUser;
	}

	public int getIdUti() {
		return idUti;
	}

	public void setIdUti(int idUti) {
		this.idUti = idUti;
	}

	public String getUsername() {
		return username;
	}

    @XmlElement(name = "username")
	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserLastname() {
		return userLastname;
	}

	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public boolean isCodStatUser() {
		return codStatUser;
	}

	public void setCodStatUser(boolean codStatUser) {
		this.codStatUser = codStatUser;
	}

	public String getPassword() {
		return password;
	}

    @XmlElement(name = "password")
	public void setPassword(String password) {
		this.password = password;
	}

	public String getNomUti() {
		return nomUti;
	}

    @XmlElement(name = "nomUti")
	public void setNomUti(String nomUti) {
		this.nomUti = nomUti;
	}

	public String getPrenomUti() {
		return prenomUti;
	}

    @XmlElement(name = "prenomUti")
	public void setPrenomUti(String prenomUti) {
		this.prenomUti = prenomUti;
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

	public String getTelephoneUti() {
		return telephoneUti;
	}

	public void setTelephoneUti(String telephoneUti) {
		this.telephoneUti = telephoneUti;
	}

	public String getMailUti() {
		return mailUti;
	}

	public void setMailUti(String mailUti) {
		this.mailUti = mailUti;
	}

}
