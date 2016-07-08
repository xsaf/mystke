package com.arabsoft.mySTKE.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.arabsoft.mySTKE.business.AvantProjetDetailleBusiness;
import com.arabsoft.mySTKE.business.AvantProjetSommaireBusiness;
import com.arabsoft.mySTKE.business.EquipeBusiness;
import com.arabsoft.mySTKE.business.PlanningActiviteBusiness;
import com.arabsoft.mySTKE.business.PlanningGlobalBusiness;
import com.arabsoft.mySTKE.business.ProgrammeBusiness;
import com.arabsoft.mySTKE.business.ProjetBusiness;
import com.arabsoft.mySTKE.business.ProjetValidationBusiness;
import com.arabsoft.mySTKE.entity.AvantProjetDetaille;
import com.arabsoft.mySTKE.entity.AvantProjetSommaire;
import com.arabsoft.mySTKE.entity.Equipe;
import com.arabsoft.mySTKE.entity.Fonction;
import com.arabsoft.mySTKE.entity.Modification;
import com.arabsoft.mySTKE.entity.PlanningActivite;
import com.arabsoft.mySTKE.entity.PlanningGlobal;
import com.arabsoft.mySTKE.entity.Programme;
import com.arabsoft.mySTKE.entity.Projet;
import com.arabsoft.mySTKE.entity.ProjetValidation;
import com.arabsoft.mySTKE.entity.Utilisa;
import com.arabsoft.utils.Theme;
import com.arabsoft.utils.ThemeService;

@ManagedBean(name = "planCtr")
@ViewScoped
public class PlanCtr {

	private Utilisa utilisa = new Utilisa();
	private Fonction fonction = new Fonction();
	private Projet projet = new Projet();
	private Equipe equipe = new Equipe();
	private Utilisa ch = new Utilisa();
	private Programme programme = new Programme();
	private AvantProjetSommaire avantProjetSommaire = new AvantProjetSommaire();
	private AvantProjetDetaille avantProjetDetaille = new AvantProjetDetaille();
	private PlanningGlobal planningGlobal = new PlanningGlobal();
	private PlanningActivite planningActivite = new PlanningActivite();
	private Modification modification = new Modification();
	private ProjetValidation projetValidation = new ProjetValidation();
	private PlanningActivite selectedActivite = new PlanningActivite();

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

	private int chef;
	private Map<String, Integer> chefs = new HashMap<String, Integer>();

	private Theme theme;
	private List<Theme> themes;

	private List<PlanningActivite> planningActivites;

	
	@PostConstruct
	public void initialisation() {

		projet.setIdProj(11810);

		projet = projetBusiness.findProjetById(projet.getIdProj());

		
		if (projet.getDescEtat() == 223) {
			List<Utilisa> chefProj = equipeBusiness.selectAllUserByFonction("7");
			chefs = new HashMap<String, Integer>();
			for (int i = 0; i < chefProj.size(); i++) {
				chefs.put("" + chefProj.get(i).getPrenomUti() + " " + chefProj.get(i).getNomUti(),
						chefProj.get(i).getIdUti());
			}
			themes = service.getThemes();
		}
		if (projet.getDescEtat() >= 312) {
			List<Utilisa> utiList = equipeBusiness.selectAllUserByEquipe(projet.getIdProj());
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

	public void updateEquipe() {
		projet.setDescEtat(312);
		projet = projetBusiness.updateProjet(projet);
		equipe.setProjet(projet);
		ch.setIdUti(chef);
		equipe.setUtilisa(ch);
		equipeBusiness.createEquipe(equipe);
	}

	public void createCahierCharge() {
		projet.setDescEtat(313);
		projet = projetBusiness.updateProjet(projet);
	}

	public void createProgramme() {
		projet.setDescEtat(314);
		projet = projetBusiness.updateProjet(projet);
		programme.setProjet(projet);
		programmeBusiness.createProgramme(programme);
	}

	public void updateProgramme() {
		projet.setDescEtat(315);
		projet = projetBusiness.updateProjet(projet);
		programmeBusiness.updateProgramme(programme);
	}

	public void updateProgrammeValider() {
		projet.setDescEtat(316);
		projet = projetBusiness.updateProjet(projet);
		programme.setValide(true);
		programmeBusiness.updateProgramme(programme);
	}

	public void createAvantProjetSommaire() {
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

	public void createAvantProjetDetaille() {
		projet.setDescEtat(325);
		projet = projetBusiness.updateProjet(projet);
		avantProjetDetaille.setProjet(projet);
		avantProjetDetailleBusiness.createAvantProjetDetaille(avantProjetDetaille);
	}

	public void updateAvantProjetDetaille() {
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

	public void createDemandeBatir() {
		projet.setDescEtat(328);
		projet = projetBusiness.updateProjet(projet);
	}

	public void createAutorisationBatir() {
		projet.setDescEtat(329);
		projet = projetBusiness.updateProjet(projet);
	}

	public void updateBudgetFinal() {
		projet.setDescEtat(330);
		projet = projetBusiness.updateProjet(projet);
	}

	public void createPlanningGlobal() {
		projet.setDescEtat(331);
		projet = projetBusiness.updateProjet(projet);
		planningGlobal.setProjet(projet);
		planningGlobalBusiness.createPlanningGlobal(planningGlobal);
	}

	public void createPlanningActivite() {
		projet.setDescEtat(333);
		projet = projetBusiness.updateProjet(projet);
		planningActivite.setPlanningGlobal(planningGlobal);
		planningActiviteBusiness.createPlanningActivite(planningActivite);
	}
	
	public void updatePlanningActivite() {
		//modification.setLibelleMod();
        selectedActivite.setPlanningGlobal(planningGlobal);
		planningActiviteBusiness.updatePlanningActivite(selectedActivite);
	}

	public void updatePlanningGlobalValider() {
		projet.setDescEtat(333);
		projet = projetBusiness.updateProjet(projet);
		planningGlobal.setValider(true);
		planningGlobalBusiness.updatePlanningActivite(planningGlobal);
	}
	
	public void createProjetValid(){
		projet.setDescEtat(334);
		projet = projetBusiness.updateProjet(projet);
		projetValidation.setEtatValid(334);
		projetValidation.setProjet(projet);
		projetValidationBusiness.createProjetValid(projetValidation);
	}
	
	public void createPVReunion(){
		projet.setDescEtat(335);
		projet = projetBusiness.updateProjet(projet);
	}
	
	public void updatePlanningGlobalValiderConseil() {
		projet.setDescEtat(336);
		projet = projetBusiness.updateProjet(projet);
		planningGlobal.setValideConseil(true);
		planningGlobalBusiness.updatePlanningActivite(planningGlobal);
	}
	
	public void createFicheProjet(){
		projet.setDescEtat(337);
		projet = projetBusiness.updateProjet(projet);
	}
	
	public void updatePlanningGlobalValiderRST() {
		projet.setDescEtat(338);
		projet = projetBusiness.updateProjet(projet);
		planningGlobal.setValideRST(true);
		planningGlobalBusiness.updatePlanningActivite(planningGlobal);
	}
	
	public void updateProjet() {
		projet.setDescEtat(339);
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

	public int getChef() {
		return chef;
	}

	public void setChef(int chef) {
		this.chef = chef;
	}

	public Map<String, Integer> getChefs() {
		return chefs;
	}

	public void setChefs(Map<String, Integer> chefs) {
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

	public Utilisa getUtilisa() {
		return utilisa;
	}

	public void setUtilisa(Utilisa utilisa) {
		this.utilisa = utilisa;
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

	public Utilisa getCh() {
		return ch;
	}

	public void setCh(Utilisa ch) {
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


}
