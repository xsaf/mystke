package com.arabsoft.mySTKE.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.arabsoft.mySTKE.business.UserBusiness;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;


@ManagedBean(name="userCtr")
@ViewScoped
public class UserCtr {
	
	private Utilisateur utilisateur = new Utilisateur();
	
	@ManagedProperty(value = "#{userBusiness}")
	private UserBusiness userBusiness;
	
	public void create() {
		//userBusiness.createUser(utilisateur);
		System.out.println("nosdhdfu js");

	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {

	}

	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

}
