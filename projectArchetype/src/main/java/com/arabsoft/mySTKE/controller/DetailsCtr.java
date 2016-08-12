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
import org.springframework.security.core.context.SecurityContextHolder;

import com.arabsoft.mySTKE.business.AbsDocBusiness;
import com.arabsoft.mySTKE.business.EquipeBusiness;
import com.arabsoft.mySTKE.business.PlanningBusiness;
import com.arabsoft.mySTKE.business.ProjetBusiness;
import com.arabsoft.mySTKE.entity.AbsDoc;
import com.arabsoft.mySTKE.entity.Dossier;
import com.arabsoft.mySTKE.entity.Equipe;
import com.arabsoft.mySTKE.entity.Planning;
import com.arabsoft.mySTKE.entity.Projet;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;
import com.arabsoft.utils.FacesUtil;
import com.arabsoft.utils.Theme;
import com.arabsoft.utils.ThemeService;

@ManagedBean(name = "detailsCtr", eager = true)
@ViewScoped
public class DetailsCtr {

	private Projet projet = new Projet();
	private Planning planning = new Planning();
	private Equipe equipe = new Equipe();
	private AbsDoc absDoc = new Dossier();
	private Utilisateur utilisateur = new Utilisateur();
	private Utilisateur user = new Utilisateur();

	@ManagedProperty(value = "#{projetBusiness}")
	private ProjetBusiness projetBusiness;

	@ManagedProperty(value = "#{planningBusiness}")
	private PlanningBusiness planningBusiness;

	@ManagedProperty(value = "#{equipeBusiness}")
	private EquipeBusiness equipeBusiness;

	@ManagedProperty(value = "#{absDocBusiness}")
	private AbsDocBusiness absDocBusiness;

	@ManagedProperty(value = "#{gedCtr}")
	private GedCtr gedCtr;

	@ManagedProperty("#{themeService}")
	private ThemeService service;

	private String directeur;
	private Map<String, Integer> directeurs = new HashMap<String, Integer>();

	private String agent;
	private Map<String, String> agents = new HashMap<String, String>();

	private String respMark;
	private Map<String, String> respMarks = new HashMap<String, String>();

	private String respTec;
	private Map<String, String> respTecs = new HashMap<String, String>();

	private String architecte;
	private Map<String, String> architectes = new HashMap<String, String>();

	private String controleur;
	private Map<String, String> controleurs = new HashMap<String, String>();

	private String chef;
	private Map<String, String> chefs = new HashMap<String, String>();

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

		user = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		int idprojet = (int) FacesUtil.getSessionMapValue("idprojet");
		projet = projetBusiness.findProjetById(idprojet);

		absDoc = absDocBusiness.findAbsDocByIdProjet(projet.getIdProj());
		gedCtr.setProjetFolder(absDoc.getNumAbsDoc());
		gedCtr.setFolder(absDoc.getNumAbsDoc());

		
		notification(projet,user);

		if (projet.getDescEtat() == 111) {
			List<Utilisateur> agentConseil = equipeBusiness.selectAllUserByFonction("2");
			List<Utilisateur> repM = equipeBusiness.selectAllUserByFonction("3");
			List<Utilisateur> repT = equipeBusiness.selectAllUserByFonction("4");
			List<Utilisateur> contr = equipeBusiness.selectAllUserByFonction("6");

			agents = new HashMap<String, String>();

			for (int i = 0; i < agentConseil.size(); i++) {
				agents.put("" + agentConseil.get(i).getPrenomUti() + " " + agentConseil.get(i).getNomUti(),
						agentConseil.get(i).getNumMatrUser());
			}

			respMarks = new HashMap<String, String>();

			for (int i = 0; i < repM.size(); i++) {
				respMarks.put("" + repM.get(i).getPrenomUti() + " " + repM.get(i).getNomUti(),
						repM.get(i).getNumMatrUser());
			}

			respTecs = new HashMap<String, String>();

			for (int i = 0; i < repT.size(); i++) {
				respTecs.put("" + repT.get(i).getPrenomUti() + " " + repT.get(i).getNomUti(),
						repT.get(i).getNumMatrUser());
			}

			controleurs = new HashMap<String, String>();

			for (int i = 0; i < contr.size(); i++) {
				controleurs.put("" + contr.get(i).getPrenomUti() + " " + contr.get(i).getNomUti(),
						contr.get(i).getNumMatrUser());
			}

			themes = service.getThemes();
		}

		if (projet.getDescEtat() >= 112) {
			planning = planningBusiness.SelectPlanningByProjet(projet.getIdProj());

			List<Utilisateur> utiList = equipeBusiness.selectAllUserByEquipe(projet.getIdProj());
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

	public void notification(Projet projet, Utilisateur utilisateur) {
	}

	public void createFolder() {
		gedCtr.setProjet(projet);
		gedCtr.createFolder();
	}

	public void createProjetNotifier() {
		projet.setDescEtat(112);
		projet = projetBusiness.createProjet(projet);
	}

	public void createPlanning() {
		planning.setProjet(projet);
		planningBusiness.createPlanning(planning);
	}

	public void createEquipe() {
		equipe.setProjet(projet);

		equipe.setUtilisateur(user);
		equipeBusiness.createEquipe(equipe);

		utilisateur = new Utilisateur();
		utilisateur.setNumMatrUser(agent);
		equipe.setUtilisateur(utilisateur);
		equipeBusiness.createEquipe(equipe);

		utilisateur = new Utilisateur();
		utilisateur.setNumMatrUser(respMark);
		equipe.setUtilisateur(utilisateur);
		equipeBusiness.createEquipe(equipe);

		utilisateur = new Utilisateur();
		utilisateur.setNumMatrUser(respTec);
		equipe.setUtilisateur(utilisateur);
		equipeBusiness.createEquipe(equipe);

		utilisateur = new Utilisateur();
		utilisateur.setNumMatrUser(controleur);
		equipe.setUtilisateur(utilisateur);
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

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public Map<String, String> getAgents() {
		return agents;
	}

	public void setAgents(Map<String, String> agents) {
		this.agents = agents;
	}

	public String getRespMark() {
		return respMark;
	}

	public void setRespMark(String respMark) {
		this.respMark = respMark;
	}

	public Map<String, String> getRespMarks() {
		return respMarks;
	}

	public void setRespMarks(Map<String, String> respMarks) {
		this.respMarks = respMarks;
	}

	public String getRespTec() {
		return respTec;
	}

	public void setRespTec(String respTec) {
		this.respTec = respTec;
	}

	public Map<String, String> getRespTecs() {
		return respTecs;
	}

	public void setRespTecs(Map<String, String> respTecs) {
		this.respTecs = respTecs;
	}

	public String getArchitecte() {
		return architecte;
	}

	public void setArchitecte(String architecte) {
		this.architecte = architecte;
	}

	public Map<String, String> getArchitectes() {
		return architectes;
	}

	public void setArchitectes(Map<String, String> architectes) {
		this.architectes = architectes;
	}

	public String getControleur() {
		return controleur;
	}

	public void setControleur(String controleur) {
		this.controleur = controleur;
	}

	public Map<String, String> getControleurs() {
		return controleurs;
	}

	public void setControleurs(Map<String, String> controleurs) {
		this.controleurs = controleurs;
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

	public void setDirecteur(String directeur) {
		this.directeur = directeur;
	}

	public List<Theme> getThemes() {
		return themes;
	}

	public void setService(ThemeService service) {
		this.service = service;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
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

	public String getDirecteur() {
		return directeur;
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
