package com.arabsoft.mySTKE.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.security.core.context.SecurityContextHolder;

import com.arabsoft.mySTKE.business.EquipeBusiness;
import com.arabsoft.mySTKE.business.ProjetBusiness;
import com.arabsoft.mySTKE.entity.Equipe;
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
	private Equipe equipe = new Equipe();

	@ManagedProperty(value = "#{projetBusiness}")
	private ProjetBusiness projetBusiness;
	
	@ManagedProperty(value = "#{equipeBusiness}")
	private EquipeBusiness equipeBusiness;

	@ManagedProperty(value = "#{gedCtr}")
	private GedCtr gedCtr;

	@PostConstruct
	public void initialisation() {

		gedCtr.setFolder("0B_KzijCYeJPvalRhMFVpYjl2bTA");

		user = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		projets = projetBusiness.findAllProjetByUser(user.getNumMatrUser());

	}
	
	public void notification(Projet projet) {
	}

	public void createProjetNotifier(String nomProj) {
		projet.setNomProj(nomProj);
		projet.setDescEtat(111);
		projet.setDateProj(new Date());
		projet.setEtapeProj("Détails");
		projet = projetBusiness.createProjet(projet);
		
		equipe.setProjet(projet);
		equipe.setUtilisateur(user);
		equipeBusiness.createEquipe(equipe);
		
		notification(projet);
	}

	public void createFolder() {
		gedCtr.setProjet(projet);
		gedCtr.createFolder();
	}
	
	public String toIndex() {
		return "index?faces-redirect=true";
	}

	public String selectProjet() {
		FacesUtil.setSessionMapValue("idprojet", selectedProjet.getIdProj());
		return "details?faces-redirect=true";
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

	public EquipeBusiness getEquipeBusiness() {
		return equipeBusiness;
	}

	public void setEquipeBusiness(EquipeBusiness equipeBusiness) {
		this.equipeBusiness = equipeBusiness;
	}

	
}
