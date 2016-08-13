package com.arabsoft.mySTKE.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.arabsoft.mySTKE.business.AbsDocBusiness;
import com.arabsoft.mySTKE.business.PlanningActiviteBusiness;
import com.arabsoft.mySTKE.business.PlanningGlobalBusiness;
import com.arabsoft.mySTKE.business.ProjetBusiness;
import com.arabsoft.mySTKE.business.ProjetValidationBusiness;
import com.arabsoft.mySTKE.business.ReunionChantierBusiness;
import com.arabsoft.mySTKE.entity.AbsDoc;
import com.arabsoft.mySTKE.entity.Dossier;
import com.arabsoft.mySTKE.entity.Fonction;
import com.arabsoft.mySTKE.entity.PlanningActivite;
import com.arabsoft.mySTKE.entity.PlanningGlobal;
import com.arabsoft.mySTKE.entity.Projet;
import com.arabsoft.mySTKE.entity.ProjetValidation;
import com.arabsoft.mySTKE.entity.ReunionChantier;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;
import com.arabsoft.utils.FacesUtil;

@ManagedBean(name = "reunionCtr")
@ViewScoped
public class ReunionCtr {

	private Utilisateur utilisateur = new Utilisateur();
	private Fonction fonction = new Fonction();
	private Projet projet = new Projet();
	private ReunionChantier reunionChantier = new ReunionChantier();
	private PlanningGlobal planningGlobal = new PlanningGlobal();
	private PlanningActivite planningActivite = new PlanningActivite();
	private ProjetValidation projetValidation = new ProjetValidation();
	private PlanningActivite selectedActivite = new PlanningActivite();
	private AbsDoc absDoc = new Dossier();


	@ManagedProperty(value = "#{projetBusiness}")
	private ProjetBusiness projetBusiness;

	@ManagedProperty(value = "#{reunionChantierBusiness}")
	private ReunionChantierBusiness reunionChantierBusiness;

	@ManagedProperty(value = "#{planningActiviteBusiness}")
	private PlanningActiviteBusiness planningActiviteBusiness;

	@ManagedProperty(value = "#{planningGlobalBusiness}")
	private PlanningGlobalBusiness planningGlobalBusiness;
	
	@ManagedProperty(value = "#{projetValidationBusiness}")
	private ProjetValidationBusiness projetValidationBusiness;
	
	@ManagedProperty(value = "#{absDocBusiness}")
	private AbsDocBusiness absDocBusiness;

	@ManagedProperty(value = "#{gedCtr}")
	private GedCtr gedCtr;

	private List<ReunionChantier> reunionChantiers;

	private int activité;
	private Map<String, Integer> activités = new HashMap<String, Integer>();
	List<PlanningActivite> planningActivites;

	@PostConstruct
	public void initialisation() {

		int idprojet = (int) FacesUtil.getSessionMapValue("idprojet");
		projet.setIdProj(idprojet);

		projet = projetBusiness.findProjetById(projet.getIdProj());


		if (projet.getDescEtat() >= 339) {
			absDoc = absDocBusiness.findAbsDocByIdProjet(projet.getIdProj());
			gedCtr.setProjetFolder(absDoc.getNumAbsDoc());
			absDoc = absDocBusiness.findAbsDocByEtapeProjet(projet.getIdProj(),"Suivi des réunions");
			gedCtr.setFolder(absDoc.getNumAbsDoc());
			
			reunionChantiers = reunionChantierBusiness.findReunionChantierByIdProjet(projet.getIdProj());
			planningGlobal = planningGlobalBusiness.findplanningGlobalByIdProjet(projet.getIdProj());
			planningActivites = planningActiviteBusiness.findPlanningActiviteByIdPlanningGlobal(planningGlobal.getIdPlanning());
			for (int i = 0; i < planningActivites.size(); i++) {
				activités.put("" + planningActivites.get(i).getIdPlanAct(), planningActivites.get(i).getIdPlanAct());
			}
		}

	}
	
	public void notification(Projet projet, Utilisateur utilisateur) {
	}
	
	public void createFolder(){
		gedCtr.setProjet(projet);
		gedCtr.createFolder();
	}

	public void createReunionChantierNotifier() {
		projet.setDescEtat(411);
		projet = projetBusiness.updateProjet(projet);
		planningActivite.setIdPlanAct(activité);
		reunionChantier.setPlanningActivite(planningActivite);
		reunionChantier.setProjet(projet);
		reunionChantierBusiness.createReunionChantier(reunionChantier);
	}
	
	public void updatePlanningActivite(){
		selectedActivite.setPlanningGlobal(planningGlobal);
		planningActiviteBusiness.updatePlanningActivite(selectedActivite);
	}
	
	public void updateProjetValidNotifier(){
		projet.setDescEtat(412);
		projet.setEtapeProj("Réception	finale");
		projet = projetBusiness.updateProjet(projet);
		projetValidation.setEtatValid(412);
		projetValidation.setProjet(projet);
		projetValidationBusiness.createProjetValid(projetValidation);
	}
	

	public ReunionChantier getReunionChantier() {
		return reunionChantier;
	}

	public void setReunionChantier(ReunionChantier reunionChantier) {
		this.reunionChantier = reunionChantier;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
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

	public ReunionChantierBusiness getReunionChantierBusiness() {
		return reunionChantierBusiness;
	}

	public void setReunionChantierBusiness(ReunionChantierBusiness reunionChantierBusiness) {
		this.reunionChantierBusiness = reunionChantierBusiness;
	}

	public List<ReunionChantier> getReunionChantiers() {
		return reunionChantiers;
	}

	public void setReunionChantiers(List<ReunionChantier> reunionChantiers) {
		this.reunionChantiers = reunionChantiers;
	}

	public int getActivité() {
		return activité;
	}

	public void setActivité(int activité) {
		this.activité = activité;
	}

	public Map<String, Integer> getActivités() {
		return activités;
	}

	public void setActivités(Map<String, Integer> activités) {
		this.activités = activités;
	}

	public PlanningGlobal getPlanningGlobal() {
		return planningGlobal;
	}

	public void setPlanningGlobal(PlanningGlobal planningGlobal) {
		this.planningGlobal = planningGlobal;
	}

	public PlanningActiviteBusiness getPlanningActiviteBusiness() {
		return planningActiviteBusiness;
	}

	public void setPlanningActiviteBusiness(PlanningActiviteBusiness planningActiviteBusiness) {
		this.planningActiviteBusiness = planningActiviteBusiness;
	}

	public PlanningGlobalBusiness getPlanningGlobalBusiness() {
		return planningGlobalBusiness;
	}

	public void setPlanningGlobalBusiness(PlanningGlobalBusiness planningGlobalBusiness) {
		this.planningGlobalBusiness = planningGlobalBusiness;
	}

	public List<PlanningActivite> getPlanningActivites() {
		return planningActivites;
	}

	public void setPlanningActivites(List<PlanningActivite> planningActivites) {
		this.planningActivites = planningActivites;
	}

	public PlanningActivite getPlanningActivite() {
		return planningActivite;
	}

	public void setPlanningActivite(PlanningActivite planningActivite) {
		this.planningActivite = planningActivite;
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

	public PlanningActivite getSelectedActivite() {
		return selectedActivite;
	}

	public void setSelectedActivite(PlanningActivite selectedActivite) {
		this.selectedActivite = selectedActivite;
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
