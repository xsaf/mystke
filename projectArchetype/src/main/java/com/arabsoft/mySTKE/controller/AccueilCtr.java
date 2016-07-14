package com.arabsoft.mySTKE.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.arabsoft.mySTKE.business.AbsDocBusiness;
import com.arabsoft.mySTKE.business.ProjetBusiness;
import com.arabsoft.mySTKE.entity.AbsDoc;
import com.arabsoft.mySTKE.entity.Document;
import com.arabsoft.mySTKE.entity.Dossier;
import com.arabsoft.mySTKE.entity.Projet;
import com.arabsoft.mySTKE.entity.Utilisa;
import com.arabsoft.utils.FacesUtil;
import com.arabsoft.utils.Theme;
import com.arabsoft.utils.ThemeService;

@ManagedBean(name = "accueilCtr")
@ViewScoped
public class AccueilCtr {

	private Utilisa utilisa = new Utilisa();
	private Projet projet = new Projet();
	private List<Projet> projets = new ArrayList<Projet>();
	private Dossier dossier = new Dossier();
	private Document document = new Document();
	private Dossier dossierParent = new Dossier();
	private AbsDoc absDoc;
	
	@ManagedProperty(value = "#{projetBusiness}")
	private ProjetBusiness projetBusiness;
	
	@ManagedProperty(value = "#{absDocBusiness}")
	private AbsDocBusiness absDocBusiness;

	private List<Theme> themes;
	private Theme theme;

	@ManagedProperty("#{themeService}")
	private ThemeService service;

	private String saa;
	private String idFolder;
	private String typeFolder;
	private String parentFolder;
	private String nameFolder;
	private String dateFolder;
	private String levelFolder;

	private String yes = "no";

	@PostConstruct
	public void initialisation() {
		utilisa.setIdUti(4);
		themes = new ArrayList<Theme>();
		projets = projetBusiness.findAllProjetByUser(utilisa.getIdUti());
		for (int i = 0; i < projets.size(); i++) {
			themes.add(new Theme(i, projets.get(i).getNomProj(), projets.get(i).getNomProj()));
		}
	}

	public void createProjet(String nomProj) {
		projet.setNomProj(nomProj);
		projet.setDescEtat(11);
		projet = projetBusiness.createProjet(projet);
		FacesUtil.setSessionMapValue("AccueilCtr.idprojet", projet.getIdProj());

		yes = "yes";
	}

	public void goToDetails() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> map = context.getExternalContext().getRequestParameterMap();
		idFolder = (String) map.get("idFolder");
		nameFolder = (String) map.get("nameFolder");
		dateFolder = (String) map.get("dateFolder");
		typeFolder = (String) map.get("typeFolder");
		levelFolder = (String) map.get("levelFolder");
		parentFolder = (String) map.get("parentFolder");
		
		dossierParent = absDocBusiness.findFolderByNum(parentFolder);
				
		String day = dateFolder.substring(0,10);
		String hour = dateFolder.substring(11,19);
		day = day+" "+hour;
		DateFormat formatter ; 
		Date date = null ; 
		   formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   try {
			date = formatter.parse(day);
			System.out.println("vvvvvv +"+date.toString());

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		if(typeFolder.equals("folder"))
		{
			absDoc = new Dossier();
			absDoc.setNumAbsDoc(idFolder);
			absDoc.setNomAbsDoc(nameFolder);
			absDoc.setDateCreationAbsDoc(date);
			absDoc.setNiveauAbsDoc(Integer.parseInt(levelFolder));
			absDoc.setDossier(dossierParent);
			absDoc.setProjet(projet);
			absDocBusiness.createDossier((Dossier) absDoc);
		}
		
		if(typeFolder.equals("file"))
		{
			absDoc = new Document();
			absDoc.setNumAbsDoc(idFolder);
			absDoc.setNomAbsDoc(nameFolder);
			absDoc.setDateCreationAbsDoc(date);
			absDoc.setNiveauAbsDoc(Integer.parseInt(levelFolder));
			absDoc.setDossier(dossierParent);
			absDoc.setProjet(projet);
			absDocBusiness.createDocument((Document) absDoc);
		}
		

		FacesUtil.setSessionMapValue("AccueilCtr.newfolder", idFolder);
		System.out.println("id: " + idFolder + " !! type: " + typeFolder + " !! parent: " + parentFolder + " !! name: "
				+ nameFolder + " !! date: " + dateFolder+ " !! level: " + levelFolder);

		if (yes.equals("yes")) {

			yes = "no";
		}

	}

	public String test123() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "test";
	}

	@PreDestroy
	public void hey() {
		System.out.println("lllllll + " + idFolder);
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

	public List<Theme> getThemes() {
		return themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}

	public ThemeService getService() {
		return service;
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

	public List<Projet> getProjets() {
		return projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public String getSaa() {
		return saa;
	}

	public void setSaa(String saa) {
		this.saa = saa;
	}

	public AbsDocBusiness getAbsDocBusiness() {
		return absDocBusiness;
	}

	public void setAbsDocBusiness(AbsDocBusiness absDocBusiness) {
		this.absDocBusiness = absDocBusiness;
	}
	
	

}
