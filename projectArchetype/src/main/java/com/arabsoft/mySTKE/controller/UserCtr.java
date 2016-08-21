package com.arabsoft.mySTKE.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.arabsoft.mySTKE.business.ProfilBusiness;
import com.arabsoft.mySTKE.business.UserBusiness;
import com.arabsoft.mySTKE.entity.Projet;
import com.arabsoft.mySTKE.security.habilitation.model.Profil;
import com.arabsoft.mySTKE.security.habilitation.model.UserRole;
import com.arabsoft.mySTKE.security.habilitation.model.UserRoleId;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

@ManagedBean(name = "userCtr")
@ViewScoped
public class UserCtr {

	private Projet projet = new Projet();
	private List<Utilisateur> utilisateurs;
	private Utilisateur selectedUtilisateur = new Utilisateur();
	private Utilisateur utilisateur = new Utilisateur();
	private List<String> profils;
	private String[] selectedProfils;
	private List<Profil> listProfil;

	@ManagedProperty(value = "#{profilBusiness}")
	private ProfilBusiness profilBusiness;

	@ManagedProperty(value = "#{userBusiness}")
	private UserBusiness userBusiness;

	@PostConstruct
	public void initialisation() {

		utilisateurs = userBusiness.findAllUser();
		
		listProfil = profilBusiness.findAllProfil();
		
		profils = new ArrayList<String>();
		for(int i=0; i<listProfil.size(); i++)
			profils.add(listProfil.get(i).getCodPflPfl());
		

	}
	
	public void createUser(){
		Profil profil = new Profil();
		UserRole userRole = new UserRole();

		utilisateur = userBusiness.createUser(utilisateur);
		
		for(int i=0; i<selectedProfils.length;i++){
			profil.setCodPflPfl(selectedProfils[i]);
			userRole.setId(new UserRoleId(profil.getCodPflPfl(), utilisateur.getNumMatrUser()));
			userRole.setBoolEtatUtpr(true);
			userRole.setProfil(profil);
			userRole.setUtilisateur(utilisateur);
			userBusiness.createUserRole(userRole);
		}
	}
	
	public void deleteUser(){
		UserRole userRole1 = new UserRole();
		userRole1.setUtilisateur(selectedUtilisateur);
		userBusiness.deleteUserRole(userRole1);
	
		userBusiness.deleteUser(selectedUtilisateur);
	}
	
	public void updateUser(){
		UserRole userRole1 = new UserRole();
		userRole1.setUtilisateur(selectedUtilisateur);
		userBusiness.deleteUserRole(userRole1);
		
		Profil profil = new Profil();
		UserRole userRole = new UserRole();

		utilisateur = userBusiness.updateUser(selectedUtilisateur);
		
		for(int i=0; i<selectedProfils.length;i++){
			profil.setCodPflPfl(selectedProfils[i]);
			userRole.setId(new UserRoleId(profil.getCodPflPfl(), utilisateur.getNumMatrUser()));
			userRole.setBoolEtatUtpr(true);
			userRole.setProfil(profil);
			userRole.setUtilisateur(utilisateur);
			userBusiness.createUserRole(userRole);
		}
		
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Utilisateur getSelectedUtilisateur() {
		return selectedUtilisateur;
	}

	public void setSelectedUtilisateur(Utilisateur selectedUtilisateur) {
		this.selectedUtilisateur = selectedUtilisateur;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Profil> getListProfil() {
		return listProfil;
	}

	public void setListProfil(List<Profil> listProfil) {
		this.listProfil = listProfil;
	}

	public ProfilBusiness getProfilBusiness() {
		return profilBusiness;
	}

	public void setProfilBusiness(ProfilBusiness profilBusiness) {
		this.profilBusiness = profilBusiness;
	}

	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	public List<String> getProfils() {
		return profils;
	}

	public void setProfils(List<String> profils) {
		this.profils = profils;
	}

	public String[] getSelectedProfils() {
		return selectedProfils;
	}

	public void setSelectedProfils(String[] selectedProfils) {
		this.selectedProfils = selectedProfils;
	}

	
}
