package com.arabsoft.mySTKE.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.arabsoft.mySTKE.business.AvisBusiness;
import com.arabsoft.mySTKE.business.AxeAmeliorationBusiness;
import com.arabsoft.mySTKE.business.ProjetBusiness;
import com.arabsoft.mySTKE.business.ProjetValidationBusiness;
import com.arabsoft.mySTKE.entity.Avis;
import com.arabsoft.mySTKE.entity.AxeAmelioration;
import com.arabsoft.mySTKE.entity.Projet;
import com.arabsoft.mySTKE.entity.ProjetValidation;

@ManagedBean(name = "analyseCtr")
@ViewScoped
public class AnalyseCtr {
	
	private Projet projet = new Projet();
	private AxeAmelioration axeAmelioration = new AxeAmelioration();
	private ProjetValidation projetValidation = new ProjetValidation();
	private Avis avis = new Avis();

	private List<AxeAmelioration> axeAmeliorations;
	private List<Avis> aviss;
	
	@ManagedProperty(value = "#{projetBusiness}")
	private ProjetBusiness projetBusiness;
	
	@ManagedProperty(value = "#{axeAmeliorationBusiness}")
	private AxeAmeliorationBusiness axeAmeliorationBusiness;
	
	@ManagedProperty(value = "#{projetValidationBusiness}")
	private ProjetValidationBusiness projetValidationBusiness;
	
	@ManagedProperty(value = "#{avisBusiness}")
	private AvisBusiness avisBusiness;
	
	
	@PostConstruct
	public void initialisation(){
		
		projet.setIdProj(1);
		projet.setDescEtat(611);
		
		// projet = projetBusiness.findProjetById(projet.getIdProj());
		
		if(projet.getDescEtat()>=511){
			axeAmeliorations = axeAmeliorationBusiness.findAxeAmeliorationByIdProjet(projet.getIdProj());
		}
		if(projet.getDescEtat()>=614){
			projetValidation = projetValidationBusiness.findProjetValidationByIdProjet(projet.getIdProj(),614);
		}
		if(projet.getDescEtat()>=618){
			aviss = avisBusiness.findAvisByIdProjet(projet.getIdProj());
		}
			
		
	}
	
	public void createClotureProjet(){
		projet.setDescEtat(611);
		projet = projetBusiness.updateProjet(projet);
	}
	
	public void createRapportClotureProjet(){
		projet.setDescEtat(612);
		projet = projetBusiness.updateProjet(projet);
	}
	
	public void createAxeAmelioration(){
		axeAmeliorationBusiness.createAxeAmelioration(axeAmelioration);
		projet.setDescEtat(613);
		projet = projetBusiness.updateProjet(projet);
	}
	
	public void createProjetValid(){
		projet.setDescEtat(614);
		projet = projetBusiness.updateProjet(projet);
		projetValidation.setEtatValid(614);
		projetValidation.setProjet(projet);
		projetValidationBusiness.createProjetValid(projetValidation);
	}
	
	public void createPVReunion(){
		projet.setDescEtat(615);
		projet = projetBusiness.updateProjet(projet);
	}
	
	public void createValiderRapport(){
		if(projet.getDescEtat()==615)
			projet.setDescEtat(616);
		else projet.setDescEtat(617);
		projet = projetBusiness.updateProjet(projet);
	}
	
	public void createRecommandation(){
		projet.setDescEtat(618);
		projet = projetBusiness.updateProjet(projet);
		avisBusiness.createAvis(avis);
	}


	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public AxeAmelioration getAxeAmelioration() {
		return axeAmelioration;
	}

	public void setAxeAmelioration(AxeAmelioration axeAmelioration) {
		this.axeAmelioration = axeAmelioration;
	}

	public ProjetBusiness getProjetBusiness() {
		return projetBusiness;
	}

	public void setProjetBusiness(ProjetBusiness projetBusiness) {
		this.projetBusiness = projetBusiness;
	}

	public List<AxeAmelioration> getAxeAmeliorations() {
		return axeAmeliorations;
	}

	public void setAxeAmeliorations(List<AxeAmelioration> axeAmeliorations) {
		this.axeAmeliorations = axeAmeliorations;
	}

	public AxeAmeliorationBusiness getAxeAmeliorationBusiness() {
		return axeAmeliorationBusiness;
	}

	public void setAxeAmeliorationBusiness(AxeAmeliorationBusiness axeAmeliorationBusiness) {
		this.axeAmeliorationBusiness = axeAmeliorationBusiness;
	}

	public ProjetValidation getProjetValidation() {
		return projetValidation;
	}

	public void setProjetValidation(ProjetValidation projetValidation) {
		this.projetValidation = projetValidation;
	}

	public ProjetValidationBusiness getProjetValidationBusiness() {
		return projetValidationBusiness;
	}

	public void setProjetValidationBusiness(ProjetValidationBusiness projetValidationBusiness) {
		this.projetValidationBusiness = projetValidationBusiness;
	}

	public Avis getAvis() {
		return avis;
	}

	public void setAvis(Avis avis) {
		this.avis = avis;
	}

	public List<Avis> getAviss() {
		return aviss;
	}

	public void setAviss(List<Avis> aviss) {
		this.aviss = aviss;
	}

	public AvisBusiness getAvisBusiness() {
		return avisBusiness;
	}

	public void setAvisBusiness(AvisBusiness avisBusiness) {
		this.avisBusiness = avisBusiness;
	}
	
	
	
	
	
	

}
