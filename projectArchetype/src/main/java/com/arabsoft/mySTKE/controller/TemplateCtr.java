package com.arabsoft.mySTKE.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.security.core.context.SecurityContextHolder;

import com.arabsoft.mySTKE.business.UserBusiness;
import com.arabsoft.mySTKE.entity.Fonction;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;


@ManagedBean(name="templateCtr")
@ViewScoped
public class TemplateCtr {
	
	private Utilisateur user = new Utilisateur();
	
	
	@PostConstruct
	public void initialisation() {
		user = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}



}
