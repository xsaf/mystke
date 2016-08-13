package com.arabsoft.mySTKE.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.arabsoft.mySTKE.business.AbsDocBusiness;
import com.arabsoft.mySTKE.business.AvantProjetDetailleBusiness;
import com.arabsoft.mySTKE.business.AvantProjetSommaireBusiness;
import com.arabsoft.mySTKE.business.EquipeBusiness;
import com.arabsoft.mySTKE.business.PlanningActiviteBusiness;
import com.arabsoft.mySTKE.business.PlanningGlobalBusiness;
import com.arabsoft.mySTKE.business.ProgrammeBusiness;
import com.arabsoft.mySTKE.business.ProjetBusiness;
import com.arabsoft.mySTKE.business.ProjetValidationBusiness;
import com.arabsoft.mySTKE.entity.AbsDoc;
import com.arabsoft.mySTKE.entity.AvantProjetDetaille;
import com.arabsoft.mySTKE.entity.AvantProjetSommaire;
import com.arabsoft.mySTKE.entity.Dossier;
import com.arabsoft.mySTKE.entity.Equipe;
import com.arabsoft.mySTKE.entity.Fonction;
import com.arabsoft.mySTKE.entity.Modification;
import com.arabsoft.mySTKE.entity.PlanningActivite;
import com.arabsoft.mySTKE.entity.PlanningGlobal;
import com.arabsoft.mySTKE.entity.Programme;
import com.arabsoft.mySTKE.entity.Projet;
import com.arabsoft.mySTKE.entity.ProjetValidation;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;
import com.arabsoft.utils.FacesUtil;
import com.arabsoft.utils.Theme;
import com.arabsoft.utils.ThemeService;

@ManagedBean(name = "planCtr")
@ViewScoped
public class PlanCtr {

	private Utilisateur utilisateur = new Utilisateur();
	private Fonction fonction = new Fonction();
	private Projet projet = new Projet();
	private Equipe equipe = new Equipe();
	private Utilisateur ch = new Utilisateur();
	private Programme programme = new Programme();
	private AvantProjetSommaire avantProjetSommaire = new AvantProjetSommaire();
	private AvantProjetDetaille avantProjetDetaille = new AvantProjetDetaille();
	private PlanningGlobal planningGlobal = new PlanningGlobal();
	private PlanningActivite planningActivite = new PlanningActivite();
	private Modification modification = new Modification();
	private ProjetValidation projetValidation = new ProjetValidation();
	private PlanningActivite selectedActivite = new PlanningActivite();
	private AbsDoc absDoc = new Dossier();

	@ManagedProperty(value = "#{projetBusiness}")
	private ProjetBusiness projetBusiness;

	@ManagedProperty(value = "#{equipeBusiness}")
	private EquipeBusiness equipeBusiness;

	@ManagedProperty("#{themeService}")
	private ThemeService service;

	@ManagedProperty(value = "#{programmeBusiness}")
	private ProgrammeBusiness programmeBusiness;

	@ManagedProperty(value = "#{avantProjetSommaireBusiness}")
	private AvantProjetSommaireBusiness avantProjetSommaireBusiness;

	@ManagedProperty(value = "#{avantProjetDetailleBusiness}")
	private AvantProjetDetailleBusiness avantProjetDetailleBusiness;

	@ManagedProperty(value = "#{planningGlobalBusiness}")
	private PlanningGlobalBusiness planningGlobalBusiness;

	@ManagedProperty(value = "#{planningActiviteBusiness}")
	private PlanningActiviteBusiness planningActiviteBusiness;
	
	@ManagedProperty(value = "#{projetValidationBusiness}")
	private ProjetValidationBusiness projetValidationBusiness;

	@ManagedProperty(value = "#{absDocBusiness}")
	private AbsDocBusiness absDocBusiness;

	@ManagedProperty(value = "#{gedCtr}")
	private GedCtr gedCtr;
	
	private String chef;
	private Map<String, String> chefs = new HashMap<String, String>();

	private Theme theme;
	private List<Theme> themes;

	private List<PlanningActivite> planningActivites;

	
	@PostConstruct
	public void initialisation() {

		int idprojet = (int) FacesUtil.getSessionMapValue("idprojet");
		projet.setIdProj(idprojet);

		projet = projetBusiness.findProjetById(projet.getIdProj());
		
		
		if (projet.getDescEtat() >= 223) {
			absDoc = absDocBusiness.findAbsDocByIdProjet(projet.getIdProj());
			gedCtr.setProjetFolder(absDoc.getNumAbsDoc());
			absDoc = absDocBusiness.findAbsDocByEtapeProjet(projet.getIdProj(),"Planification du projet");
			gedCtr.setFolder(absDoc.getNumAbsDoc());
			
			List<Utilisateur> chefProj = equipeBusiness.selectAllUserByFonction("7");
			chefs = new HashMap<String, String>();
			for (int i = 0; i < chefProj.size(); i++) {
				chefs.put("" + chefProj.get(i).getPrenomUti() + " " + chefProj.get(i).getNomUti(),
						chefProj.get(i).getNumMatrUser());
			}
			themes = service.getThemes();
		}
		if (projet.getDescEtat() >= 312) {
			List<Utilisateur> utiList = equipeBusiness.selectAllUserByEquipe(projet.getIdProj());
			if (utiList.size() > 0) {
				for (int i = 0; i < utiList.size(); i++) {
					if (utiList.get(i).getFonction().getIdFon() == 7)
						ch.setPrenomUti(utiList.get(i).getPrenomUti());
					ch.setNomUti(utiList.get(i).getNomUti());
				}
			}
		}
		if (projet.getDescEtat() >= 314) {
			programme = programmeBusiness.findProgrammeByIdProjet(projet.getIdProj());
		}
		if (projet.getDescEtat() >= 317) {
			avantProjetSommaire = avantProjetSommaireBusiness.findAvantProjetSommaireByIdProjet(projet.getIdProj());
		}
		if (projet.getDescEtat() >= 325) {
			avantProjetDetaille = avantProjetDetailleBusiness.findAvantProjetDetailleByIdProjet(projet.getIdProj());
		}
		if (projet.getDescEtat() >= 331) {
			planningGlobal = planningGlobalBusiness.findplanningGlobalByIdProjet(projet.getIdProj());
			planningActivites = planningActiviteBusiness
					.findPlanningActiviteByIdPlanningGlobal(planningGlobal.getIdPlanning());
		}
		if(projet.getDescEtat()>=334){
			projetValidation = projetValidationBusiness.findProjetValidationByIdProjet(projet.getIdProj(),334);
		}
		

	}
	
	public void notification(Projet projet) {
	}

	public void createFolder(){
		gedCtr.setProjet(projet);
		gedCtr.createFolder();
	}

	public void updateEquipeNotifier() {
		projet.setDescEtat(312);
		projet = projetBusiness.updateProjet(projet);
		equipe.setProjet(projet);
		ch.setNumMatrUser(chef);
		equipe.setUtilisateur(ch);
		equipeBusiness.createEquipe(equipe);
	}

	public void createCahierChargeNotifier() {
		projet.setDescEtat(313);
		projet = projetBusiness.updateProjet(projet);
	}

	public void createProgrammeNotifier() {
		projet.setDescEtat(314);
		projet = projetBusiness.updateProjet(projet);
		programme.setProjet(projet);
		programmeBusiness.createProgramme(programme);
	}

	public void updateProgrammeNotifier() {
		projet.setDescEtat(315);
		projet = projetBusiness.updateProjet(projet);
		programmeBusiness.updateProgramme(programme);
	}

	public void updateProgrammeValiderNotifier() {
		projet.setDescEtat(316);
		projet = projetBusiness.updateProjet(projet);
		programme.setValide(true);
		programmeBusiness.updateProgramme(programme);
	}

	public void createAvantProjetSommaireNotifier() {
		projet.setDescEtat(317);
		projet = projetBusiness.updateProjet(projet);
		avantProjetSommaire.setProjet(projet);
		avantProjetSommaireBusiness.createAvantProjetSommaire(avantProjetSommaire);
	}

	public void updateAvantProjetSommaire() {
		switch (projet.getDescEtat()) {
		case 317: {
			projet.setDescEtat(318);
			break;
		}
		case 318: {
			projet.setDescEtat(319);
			break;
		}
		case 319: {
			projet.setDescEtat(320);
			avantProjetSommaire.setValider(true);
			break;
		}
		case 320: {
			projet.setDescEtat(321);
			break;
		}
		case 321: {
			projet.setDescEtat(322);
			break;
		}
		case 322: {
			projet.setDescEtat(323);
			break;
		}
		case 323: {
			projet.setDescEtat(324);
			break;
		}
		}
		projet = projetBusiness.updateProjet(projet);
		avantProjetSommaireBusiness.updateAvantProjetSommaire(avantProjetSommaire);
	}

	public void createAvantProjetDetailleNotifier() {
		projet.setDescEtat(325);
		projet = projetBusiness.updateProjet(projet);
		avantProjetDetaille.setProjet(projet);
		avantProjetDetailleBusiness.createAvantProjetDetaille(avantProjetDetaille);
	}

	public void updateAvantProjetDetailleNotifier() {
		switch (projet.getDescEtat()) {
		case 325: {
			projet.setDescEtat(326);
			break;
		}
		case 326: {
			projet.setDescEtat(327);
			avantProjetDetaille.setValider(true);
			break;
		}
		}
		projet = projetBusiness.updateProjet(projet);
		avantProjetDetailleBusiness.updateAvantProjetDetaille(avantProjetDetaille);
	}

	public void createDemandeBatirNotifier() {
		projet.setDescEtat(328);
		projet = projetBusiness.updateProjet(projet);
	}

	public void createAutorisationBatirNotifier() {
		projet.setDescEtat(329);
		projet = projetBusiness.updateProjet(projet);
	}

	public void updateBudgetFinalNotifier() {
		projet.setDescEtat(330);
		projet = projetBusiness.updateProjet(projet);
	}

	public void createPlanningGlobalNotifier() {
		projet.setDescEtat(331);
		projet = projetBusiness.updateProjet(projet);
		planningGlobal.setProjet(projet);
		planningGlobalBusiness.createPlanningGlobal(planningGlobal);
	}

	public void createPlanningActiviteNotifier() {
		projet.setDescEtat(333);
		projet = projetBusiness.updateProjet(projet);
		planningActivite.setPlanningGlobal(planningGlobal);
		planningActiviteBusiness.createPlanningActivite(planningActivite);
	}
	
	public void updatePlanningActiviteNotifier() {
		//modification.setLibelleMod();
        selectedActivite.setPlanningGlobal(planningGlobal);
		planningActiviteBusiness.updatePlanningActivite(selectedActivite);
	}

	public void updatePlanningGlobalValiderNotifier() {
		projet.setDescEtat(333);
		projet = projetBusiness.updateProjet(projet);
		planningGlobal.setValider(true);
		planningGlobalBusiness.updatePlanningActivite(planningGlobal);
	}
	
	public void createProjetValidNotifier(){
		projet.setDescEtat(334);
		projet = projetBusiness.updateProjet(projet);
		projetValidation.setEtatValid(334);
		projetValidation.setProjet(projet);
		projetValidationBusiness.createProjetValid(projetValidation);
	}
	
	public void createPVReunionNotifier(){
		projet.setDescEtat(335);
		projet = projetBusiness.updateProjet(projet);
	}
	
	public void updatePlanningGlobalValiderConseilNotifier() {
		projet.setDescEtat(336);
		projet = projetBusiness.updateProjet(projet);
		planningGlobal.setValideConseil(true);
		planningGlobalBusiness.updatePlanningActivite(planningGlobal);
	}
	
	public void createFicheProjetNotifier(){
		projet.setDescEtat(337);
		projet = projetBusiness.updateProjet(projet);
	}
	
	public void updatePlanningGlobalValiderRSTNotifier() {
		projet.setDescEtat(338);
		projet = projetBusiness.updateProjet(projet);
		planningGlobal.setValideRST(true);
		planningGlobalBusiness.updatePlanningActivite(planningGlobal);
	}
	
	public void updateProjetNotifier() {
		projet.setDescEtat(339);
		projet.setEtapeProj("Suivi réunion du projet");
		projet = projetBusiness.updateProjet(projet);
	}

	
	public ProjetBusiness getProjetBusiness() {
		return projetBusiness;
	}

	public void setProjetBusiness(ProjetBusiness projetBusiness) {
		this.projetBusiness = projetBusiness;
	}

	public EquipeBusiness getEquipeBusiness() {
		return equipeBusiness;
	}

	public void setEquipeBusiness(EquipeBusiness equipeBusiness) {
		this.equipeBusiness = equipeBusiness;
	}

	public ThemeService getService() {
		return service;
	}

	public void setService(ThemeService service) {
		this.service = service;
	}

	public String getChef() {
		return chef;
	}

	public void setChef(String chef) {
		this.chef = chef;
	}

	public Map<String, String> getChefs() {
		return chefs;
	}

	public void setChefs(Map<String, String> chefs) {
		this.chefs = chefs;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public List<Theme> getThemes() {
		return themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
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

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Utilisateur getCh() {
		return ch;
	}

	public void setCh(Utilisateur ch) {
		this.ch = ch;
	}

	public Programme getProgramme() {
		return programme;
	}

	public void setProgramme(Programme programme) {
		this.programme = programme;
	}

	public ProgrammeBusiness getProgrammeBusiness() {
		return programmeBusiness;
	}

	public void setProgrammeBusiness(ProgrammeBusiness programmeBusiness) {
		this.programmeBusiness = programmeBusiness;
	}

	public AvantProjetSommaire getAvantProjetSommaire() {
		return avantProjetSommaire;
	}

	public void setAvantProjetSommaire(AvantProjetSommaire avantProjetSommaire) {
		this.avantProjetSommaire = avantProjetSommaire;
	}

	public AvantProjetSommaireBusiness getAvantProjetSommaireBusiness() {
		return avantProjetSommaireBusiness;
	}

	public void setAvantProjetSommaireBusiness(AvantProjetSommaireBusiness avantProjetSommaireBusiness) {
		this.avantProjetSommaireBusiness = avantProjetSommaireBusiness;
	}

	public AvantProjetDetaille getAvantProjetDetaille() {
		return avantProjetDetaille;
	}

	public void setAvantProjetDetaille(AvantProjetDetaille avantProjetDetaille) {
		this.avantProjetDetaille = avantProjetDetaille;
	}

	public AvantProjetDetailleBusiness getAvantProjetDetailleBusiness() {
		return avantProjetDetailleBusiness;
	}

	public void setAvantProjetDetailleBusiness(AvantProjetDetailleBusiness avantProjetDetailleBusiness) {
		this.avantProjetDetailleBusiness = avantProjetDetailleBusiness;
	}

	public PlanningGlobal getPlanningGlobal() {
		return planningGlobal;
	}

	public void setPlanningGlobal(PlanningGlobal planningGlobal) {
		this.planningGlobal = planningGlobal;
	}

	public PlanningGlobalBusiness getPlanningGlobalBusiness() {
		return planningGlobalBusiness;
	}

	public void setPlanningGlobalBusiness(PlanningGlobalBusiness planningGlobalBusiness) {
		this.planningGlobalBusiness = planningGlobalBusiness;
	}

	public PlanningActivite getPlanningActivite() {
		return planningActivite;
	}

	public void setPlanningActivite(PlanningActivite planningActivite) {
		this.planningActivite = planningActivite;
	}

	public PlanningActiviteBusiness getPlanningActiviteBusiness() {
		return planningActiviteBusiness;
	}

	public void setPlanningActiviteBusiness(PlanningActiviteBusiness planningActiviteBusiness) {
		this.planningActiviteBusiness = planningActiviteBusiness;
	}

	public List<PlanningActivite> getPlanningActivites() {
		return planningActivites;
	}

	public void setPlanningActivites(List<PlanningActivite> planningActivites) {
		this.planningActivites = planningActivites;
	}

	public Modification getModification() {
		return modification;
	}

	public void setModification(Modification modification) {
		this.modification = modification;
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
