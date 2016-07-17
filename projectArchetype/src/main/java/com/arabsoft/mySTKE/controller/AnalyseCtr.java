package com.arabsoft.mySTKE.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.arabsoft.mySTKE.business.AbsDocBusiness;
import com.arabsoft.mySTKE.business.AvisBusiness;
import com.arabsoft.mySTKE.business.AxeAmeliorationBusiness;
import com.arabsoft.mySTKE.business.ProjetBusiness;
import com.arabsoft.mySTKE.business.ProjetValidationBusiness;
import com.arabsoft.mySTKE.entity.AbsDoc;
import com.arabsoft.mySTKE.entity.Avis;
import com.arabsoft.mySTKE.entity.AxeAmelioration;
import com.arabsoft.mySTKE.entity.Dossier;
import com.arabsoft.mySTKE.entity.Projet;
import com.arabsoft.mySTKE.entity.ProjetValidation;

@ManagedBean(name = "analyseCtr")
@ViewScoped
public class AnalyseCtr {
	
	private Projet projet = new Projet();
	private AxeAmelioration axeAmelioration = new AxeAmelioration();
	private ProjetValidation projetValidation = new ProjetValidation();
	private Avis avis = new Avis();
	private AbsDoc absDoc = new Dossier();

	private List<AxeAmelioration> axeAmeliorations;
	private List<Avis> aviss;
	private Avis selectedAvis = new Avis();
	private Avis selectedAvis2 = new Avis();
	private String selectedValid;
	private String selectedValid2;
	
	@ManagedProperty(value = "#{projetBusiness}")
	private ProjetBusiness projetBusiness;
	
	@ManagedProperty(value = "#{axeAmeliorationBusiness}")
	private AxeAmeliorationBusiness axeAmeliorationBusiness;
	
	@ManagedProperty(value = "#{projetValidationBusiness}")
	private ProjetValidationBusiness projetValidationBusiness;
	
	@ManagedProperty(value = "#{avisBusiness}")
	private AvisBusiness avisBusiness;
	
	@ManagedProperty(value = "#{absDocBusiness}")
	private AbsDocBusiness absDocBusiness;

	@ManagedProperty(value = "#{gedCtr}")
	private GedCtr gedCtr;
	
	
	@PostConstruct
	public void initialisation(){
		
		projet.setIdProj(11810);
		//projet.setDescEtat(611);
		
		projet = projetBusiness.findProjetById(projet.getIdProj());
		
		absDoc = absDocBusiness.findAbsDocByIdProjet(projet.getIdProj());
		gedCtr.setFolder(absDoc.getNumAbsDoc());
		
		if(projet.getDescEtat()>=612){
			axeAmeliorations = axeAmeliorationBusiness.findAxeAmeliorationByIdProjet(projet.getIdProj());
		}
		if(projet.getDescEtat()>=614){
			projetValidation = projetValidationBusiness.findProjetValidationByIdProjet(projet.getIdProj(),614);
		}
		if(projet.getDescEtat()>=618){
			aviss = avisBusiness.findAvisByIdProjet(projet.getIdProj());
		}
			
		
	}
	
	public void createFolder(){
		gedCtr.setProjet(projet);
		gedCtr.createFolder();
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
		axeAmelioration.setProjet(projet);
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
		avis.setProjet(projet);
		avisBusiness.createAvis(avis);
	}
	
	public void updateAvisDG(){
		selectedAvis.setValidDG(selectedValid);
		avisBusiness.updateAvis(selectedAvis);
	}

	public void updateAvisRST(){
		selectedAvis.setValidRST(selectedValid2);
		avisBusiness.updateAvis(selectedAvis);
	}
	
	public void cloturerProjet(){
		projet.setDescEtat(619);
		projet = projetBusiness.updateProjet(projet);
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

	public Avis getSelectedAvis() {
		return selectedAvis;
	}

	public void setSelectedAvis(Avis selectedAvis) {
		this.selectedAvis = selectedAvis;
	}

	public String getSelectedValid() {
		return selectedValid;
	}

	public void setSelectedValid(String selectedValid) {
		this.selectedValid = selectedValid;
	}

	public String getSelectedValid2() {
		return selectedValid2;
	}

	public void setSelectedValid2(String selectedValid2) {
		this.selectedValid2 = selectedValid2;
	}

	public Avis getSelectedAvis2() {
		return selectedAvis2;
	}

	public void setSelectedAvis2(Avis selectedAvis2) {
		this.selectedAvis2 = selectedAvis2;
	}

	public AbsDoc getAbsDoc() {
		return absDoc;
	}

	public void setAbsDoc(AbsDoc absDoc) {
		this.absDoc = absDoc;
	}

	public AbsDocBusiness getAbsDocBusiness() {
		return absDocBusiness;
	}

	public void setAbsDocBusiness(AbsDocBusiness absDocBusiness) {
		this.absDocBusiness = absDocBusiness;
	}

	public GedCtr getGedCtr() {
		return gedCtr;
	}

	public void setGedCtr(GedCtr gedCtr) {
		this.gedCtr = gedCtr;
	}
	
	
	
	

}
