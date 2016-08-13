package com.arabsoft.mySTKE.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.security.core.context.SecurityContextHolder;

import com.arabsoft.mySTKE.business.ProjetBusiness;
import com.arabsoft.mySTKE.entity.Projet;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;
import com.arabsoft.utils.FacesUtil;

@ManagedBean(name = "accueilCtr")
@ViewScoped
public class AccueilCtr {

	private Projet projet = new Projet();
	private List<Projet> projets;
	private Projet selectedProjet = new Projet();
	private Utilisateur user = new Utilisateur();
	
	@ManagedProperty(value = "#{projetBusiness}")
	private ProjetBusiness projetBusiness;

	@ManagedProperty(value = "#{gedCtr}")
	private GedCtr gedCtr;

	@PostConstruct
	public void initialisation() {
		// test
		FacesUtil.setSessionMapValue("idprojet", 18610);

		gedCtr.setFolder("0B_KzijCYeJPvalRhMFVpYjl2bTA");
		
		user = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		projetBusiness.findAllProjetByUser(user.getNumMatrUser());


	}

	public void createProjet(String nomProj) {
		projet.setNomProj(nomProj);
		projet.setDescEtat(111);
		projet.setEtapeProj("Détails");
		projet = projetBusiness.createProjet(projet);
	}

	public void createFolder() {
		gedCtr.setProjet(projet);
		gedCtr.createFolder();
	}

	public String toProjetImmobiliere() {

		// try {
		// Thread.sleep(3000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }

		FacesUtil.setSessionMapValue("AccueilCtr.idprojet", selectedProjet.getIdProj());

		return "details";
	}
	
	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public ProjetBusiness getProjetBusiness() {
		return projetBusiness;
	}

	public void setProjetBusiness(ProjetBusiness projetBusiness) {
		this.projetBusiness = projetBusiness;
	}

	public GedCtr getGedCtr() {
		return gedCtr;
	}

	public void setGedCtr(GedCtr gedCtr) {
		this.gedCtr = gedCtr;
	}

	public List<Projet> getProjets() {
		return projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	public Projet getSelectedProjet() {
		return selectedProjet;
	}

	public void setSelectedProjet(Projet selectedProjet) {
		this.selectedProjet = selectedProjet;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}



}
