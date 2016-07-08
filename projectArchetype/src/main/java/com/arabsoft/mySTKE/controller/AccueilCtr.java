package com.arabsoft.mySTKE.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.arabsoft.mySTKE.business.ProjetBusiness;
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

	@ManagedProperty(value = "#{projetBusiness}")
	private ProjetBusiness projetBusiness;

	private List<Theme> themes;
	private Theme theme;

	@ManagedProperty("#{themeService}")
	private ThemeService service;

	private String saa;
	private String soverwrite;

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

	}

	public void goToDetails() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> map = context.getExternalContext().getRequestParameterMap();
		soverwrite = (String) map.get("newfolder");
		System.out.println("yyyyyy + " + soverwrite);
		FacesUtil.setSessionMapValue("AccueilCtr.newfolder", soverwrite);

	}

	public String test123() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "details-new";
	}

	@PreDestroy
	public void hey() {
		System.out.println("lllllll + " + soverwrite);
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

}
