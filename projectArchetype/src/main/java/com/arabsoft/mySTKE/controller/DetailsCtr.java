package com.arabsoft.mySTKE.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.arabsoft.mySTKE.business.EquipeBusiness;
import com.arabsoft.mySTKE.business.PlanningBusiness;
import com.arabsoft.mySTKE.business.ProjetBusiness;
import com.arabsoft.mySTKE.entity.Equipe;
import com.arabsoft.mySTKE.entity.Planning;
import com.arabsoft.mySTKE.entity.Projet;
import com.arabsoft.mySTKE.entity.Utilisa;
import com.arabsoft.utils.FacesUtil;
import com.arabsoft.utils.Theme;
import com.arabsoft.utils.ThemeService;

@ManagedBean(name = "detailsCtr", eager = true)
@ViewScoped
public class DetailsCtr {

	private Projet projet = new Projet();
	private Planning planning = new Planning();
	private Equipe equipe = new Equipe();
	private Utilisa utilisa = new Utilisa();

	@ManagedProperty(value = "#{projetBusiness}")
	private ProjetBusiness projetBusiness;

	@ManagedProperty(value = "#{planningBusiness}")
	private PlanningBusiness planningBusiness;

	@ManagedProperty(value = "#{equipeBusiness}")
	private EquipeBusiness equipeBusiness;

	@ManagedProperty("#{themeService}")
	private ThemeService service;

	private int directeur;
	private Map<String, Integer> directeurs = new HashMap<String, Integer>();

	private int agent;
	private Map<String, Integer> agents = new HashMap<String, Integer>();

	private int respMark;
	private Map<String, Integer> respMarks = new HashMap<String, Integer>();

	private int respTec;
	private Map<String, Integer> respTecs = new HashMap<String, Integer>();

	private int architecte;
	private Map<String, Integer> architectes = new HashMap<String, Integer>();

	private int controleur;
	private Map<String, Integer> controleurs = new HashMap<String, Integer>();

	private int chef;
	private Map<String, Integer> chefs = new HashMap<String, Integer>();

	private Theme theme;
	private List<Theme> themes;

	private String dir;
	private String ag;
	private String rM;
	private String rT;
	private String ar;
	private String co;
	private String ch;

	private BarChartModel animatedModel;

	@PostConstruct
	public void initialisation() {
		
//        int idprojet = (int) FacesUtil.getSessionMapValue("AccueilCtr.idprojet");
//        String n = (String) FacesUtil.getSessionMapValue("AccueilCtr.newfolder");
//		System.out.println("réponse 11 + " + n);
//		System.out.println("safweeen + " + idprojet);

		
		
		
		
		// test
		projet.setIdProj(1736);
		//projet.setDescEtat(111);
		// Projet
		projet = projetBusiness.findProjetById(projet.getIdProj());

		if (projet.getDescEtat() == 111) {

			// Equipe
			List<Utilisa> direc = equipeBusiness.selectAllUserByFonction("1");
			List<Utilisa> agentConseil = equipeBusiness.selectAllUserByFonction("2");
			List<Utilisa> repM = equipeBusiness.selectAllUserByFonction("3");
			List<Utilisa> repT = equipeBusiness.selectAllUserByFonction("4");
			List<Utilisa> archi = equipeBusiness.selectAllUserByFonction("5");
			List<Utilisa> contr = equipeBusiness.selectAllUserByFonction("6");
			List<Utilisa> chefProj = equipeBusiness.selectAllUserByFonction("7");
			
			
			directeurs = new HashMap<String, Integer>();

			for (int i = 0; i < direc.size(); i++) {
				directeurs.put("" + direc.get(i).getPrenomUti() + " " + direc.get(i).getNomUti(),
						direc.get(i).getIdUti());
			}

			agents = new HashMap<String, Integer>();

			for (int i = 0; i < agentConseil.size(); i++) {
				agents.put("" + agentConseil.get(i).getPrenomUti() + " " + agentConseil.get(i).getNomUti(),
						agentConseil.get(i).getIdUti());
			}

			respMarks = new HashMap<String, Integer>();

			for (int i = 0; i < repM.size(); i++) {
				respMarks.put("" + repM.get(i).getPrenomUti() + " " + repM.get(i).getNomUti(), repM.get(i).getIdUti());
			}

			respTecs = new HashMap<String, Integer>();

			for (int i = 0; i < repT.size(); i++) {
				respTecs.put("" + repT.get(i).getPrenomUti() + " " + repT.get(i).getNomUti(), repT.get(i).getIdUti());
			}

			architectes = new HashMap<String, Integer>();

			for (int i = 0; i < archi.size(); i++) {
				architectes.put("" + archi.get(i).getPrenomUti() + " " + archi.get(i).getNomUti(),
						archi.get(i).getIdUti());
			}

			controleurs = new HashMap<String, Integer>();

			for (int i = 0; i < contr.size(); i++) {
				controleurs.put("" + contr.get(i).getPrenomUti() + " " + contr.get(i).getNomUti(),
						contr.get(i).getIdUti());
			}

			chefs = new HashMap<String, Integer>();

			for (int i = 0; i < chefProj.size(); i++) {
				chefs.put("" + chefProj.get(i).getPrenomUti() + " " + chefProj.get(i).getNomUti(),
						chefProj.get(i).getIdUti());
			}

			themes = service.getThemes();
		}

		if (projet.getDescEtat() >= 112) {

			// Planning
			planning = planningBusiness.SelectPlanningByProjet(projet.getIdProj());

			// Equipe
			List<Utilisa> utiList = equipeBusiness.selectAllUserByEquipe(projet.getIdProj());
			if (utiList.size() > 0) {
				for (int i = 0; i < utiList.size(); i++) {
					if (utiList.get(i).getFonction().getIdFon() == 1)
						dir = utiList.get(i).getPrenomUti() + " " + utiList.get(i).getNomUti();
					else if (utiList.get(i).getFonction().getIdFon() == 2)
						ag = utiList.get(i).getPrenomUti() + " " + utiList.get(i).getNomUti();
					else if (utiList.get(i).getFonction().getIdFon() == 3)
						rM = utiList.get(i).getPrenomUti() + " " + utiList.get(i).getNomUti();
					else if (utiList.get(i).getFonction().getIdFon() == 4)
						rT = utiList.get(i).getPrenomUti() + " " + utiList.get(i).getNomUti();
					else if (utiList.get(i).getFonction().getIdFon() == 5)
						ar = utiList.get(i).getPrenomUti() + " " + utiList.get(i).getNomUti();
					else if (utiList.get(i).getFonction().getIdFon() == 6)
						co = utiList.get(i).getPrenomUti() + " " + utiList.get(i).getNomUti();
					else
						ch = utiList.get(i).getPrenomUti() + " " + utiList.get(i).getNomUti();
				}
			}

		}

		createAnimatedModels();

		
	}

	public void createProjet() {
		projet.setDescEtat(112);
		projet = projetBusiness.createProjet(projet);
	}

	public void createPlanning() {
		planning.setProjet(projet);
		planningBusiness.createPlanning(planning);
	}

	public void createEquipe() {
		equipe.setProjet(projet);

		utilisa = new Utilisa();
		utilisa.setIdUti(directeur);
		equipe.setUtilisa(utilisa);
		equipeBusiness.createEquipe(equipe);

		utilisa = new Utilisa();
		utilisa.setIdUti(agent);
		equipe.setUtilisa(utilisa);
		equipeBusiness.createEquipe(equipe);

		utilisa = new Utilisa();
		utilisa.setIdUti(respMark);
		equipe.setUtilisa(utilisa);
		equipeBusiness.createEquipe(equipe);

		utilisa = new Utilisa();
		utilisa.setIdUti(respTec);
		equipe.setUtilisa(utilisa);
		equipeBusiness.createEquipe(equipe);

		utilisa = new Utilisa();
		utilisa.setIdUti(architecte);
		equipe.setUtilisa(utilisa);
		equipeBusiness.createEquipe(equipe);

		utilisa = new Utilisa();
		utilisa.setIdUti(controleur);
		equipe.setUtilisa(utilisa);
		equipeBusiness.createEquipe(equipe);

		utilisa = new Utilisa();
		utilisa.setIdUti(chef);
		equipe.setUtilisa(utilisa);
		equipeBusiness.createEquipe(equipe);
	}

	private void createAnimatedModels() {
		animatedModel = initBarModel();
		animatedModel.setTitle("Planning Global");
		animatedModel.setAnimate(true);
		animatedModel.setLegendPosition("ne");
		Axis yAxis = animatedModel.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(50);
	}

	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();

		ChartSeries estime = new ChartSeries();
		estime.setLabel("Délai éstimé");
		estime.set("Etude", planning.getEtudeSemaine());
		estime.set("Planification", planning.getPlanificationSemaine());
		estime.set("Réunion", planning.getReunionSemaine());
		estime.set("Cloture", planning.getClotureSemaine());
		estime.set("Analyse", planning.getAnalyseSemaine());

		ChartSeries reel = new ChartSeries();
		reel.setLabel("Délai réel");
		reel.set("Etude", planning.getEtudeSemaineReel());
		reel.set("Planification", planning.getPlanificationSemaineReel());
		reel.set("Réunion", planning.getReunionSemaineReel());
		reel.set("Cloture", planning.getClotureSemaineReel());
		reel.set("Analyse", planning.getAnalyseSemaineReel());

		model.addSeries(estime);
		model.addSeries(reel);

		return model;
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

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public EquipeBusiness getEquipeBusiness() {
		return equipeBusiness;
	}

	public void setEquipeBusiness(EquipeBusiness equipeBusiness) {
		this.equipeBusiness = equipeBusiness;
	}

	public int getdirecteur() {
		return directeur;
	}

	public void setdirecteur(int directeur) {
		this.directeur = directeur;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public void setdirecteurs(Map<String, Integer> directeurs) {
		this.directeurs = directeurs;
	}

	public Map<String, Integer> getdirecteurs() {
		return directeurs;
	}

	public int getAgent() {
		return agent;
	}

	public void setAgent(int agent) {
		this.agent = agent;
	}

	public Map<String, Integer> getAgents() {
		return agents;
	}

	public void setAgents(Map<String, Integer> agents) {
		this.agents = agents;
	}

	public int getRespMark() {
		return respMark;
	}

	public void setRespMark(int respMark) {
		this.respMark = respMark;
	}

	public Map<String, Integer> getRespMarks() {
		return respMarks;
	}

	public void setRespMarks(Map<String, Integer> respMarks) {
		this.respMarks = respMarks;
	}

	public int getRespTec() {
		return respTec;
	}

	public void setRespTec(int respTec) {
		this.respTec = respTec;
	}

	public Map<String, Integer> getRespTecs() {
		return respTecs;
	}

	public void setRespTecs(Map<String, Integer> respTecs) {
		this.respTecs = respTecs;
	}

	public int getArchitecte() {
		return architecte;
	}

	public void setArchitecte(int architecte) {
		this.architecte = architecte;
	}

	public Map<String, Integer> getArchitectes() {
		return architectes;
	}

	public void setArchitectes(Map<String, Integer> architectes) {
		this.architectes = architectes;
	}

	public int getControleur() {
		return controleur;
	}

	public void setControleur(int controleur) {
		this.controleur = controleur;
	}

	public Map<String, Integer> getControleurs() {
		return controleurs;
	}

	public void setControleurs(Map<String, Integer> controleurs) {
		this.controleurs = controleurs;
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

	public List<Theme> getThemes() {
		return themes;
	}

	public void setService(ThemeService service) {
		this.service = service;
	}

	public Utilisa getUtilisa() {
		return utilisa;
	}

	public void setUtilisa(Utilisa utilisa) {
		this.utilisa = utilisa;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getAg() {
		return ag;
	}

	public void setAg(String ag) {
		this.ag = ag;
	}

	public String getrM() {
		return rM;
	}

	public void setrM(String rM) {
		this.rM = rM;
	}

	public String getrT() {
		return rT;
	}

	public void setrT(String rT) {
		this.rT = rT;
	}

	public String getAr() {
		return ar;
	}

	public void setAr(String ar) {
		this.ar = ar;
	}

	public String getCo() {
		return co;
	}

	public void setCo(String co) {
		this.co = co;
	}

	public String getCh() {
		return ch;
	}

	public void setCh(String ch) {
		this.ch = ch;
	}

	public Planning getPlanning() {
		return planning;
	}

	public void setPlanning(Planning planning) {
		this.planning = planning;
	}

	public PlanningBusiness getPlanningBusiness() {
		return planningBusiness;
	}

	public void setPlanningBusiness(PlanningBusiness planningBusiness) {
		this.planningBusiness = planningBusiness;
	}

	public BarChartModel getAnimatedModel() {
		return animatedModel;
	}

	public int getDirecteur() {
		return directeur;
	}

	public void setDirecteur(int directeur) {
		this.directeur = directeur;
	}

	public Map<String, Integer> getDirecteurs() {
		return directeurs;
	}

	public void setDirecteurs(Map<String, Integer> directeurs) {
		this.directeurs = directeurs;
	}

	public ThemeService getService() {
		return service;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}

	public void setAnimatedModel(BarChartModel animatedModel) {
		this.animatedModel = animatedModel;
	}

}
