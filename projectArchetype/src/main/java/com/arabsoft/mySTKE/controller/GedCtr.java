package com.arabsoft.mySTKE.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
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
import com.arabsoft.utils.FacesUtil;

@ManagedBean(name = "gedCtr")
@ViewScoped
public class GedCtr {

	private Projet projet = new Projet();
	private Dossier dossierParent = new Dossier();
	private AbsDoc absDoc;

	@ManagedProperty(value = "#{projetBusiness}")
	private ProjetBusiness projetBusiness;

	@ManagedProperty(value = "#{absDocBusiness}")
	private AbsDocBusiness absDocBusiness;

	private String idFolder;
	private String typeFolder;
	private String parentFolder;
	private String nameFolder;
	private String dateFolder;
	private String levelFolder;
	private String projetFolder;

	private String folder;

	public void createFolder() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> map = context.getExternalContext().getRequestParameterMap();
		idFolder = (String) map.get("idFolder");
		nameFolder = (String) map.get("nameFolder");
		dateFolder = (String) map.get("dateFolder");
		typeFolder = (String) map.get("typeFolder");
		levelFolder = (String) map.get("levelFolder");
		parentFolder = (String) map.get("parentFolder");
		dossierParent = absDocBusiness.findFolderByNum(parentFolder);

		String day = dateFolder.substring(0, 10);
		String hour = dateFolder.substring(11, 19);
		day = day + " " + hour;
		DateFormat formatter;
		Date date = null;
		formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = formatter.parse(day);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (typeFolder.equals("folder")) {
			absDoc = new Dossier();
			absDoc.setNumAbsDoc(idFolder);
			absDoc.setNomAbsDoc(nameFolder);
			absDoc.setDateCreationAbsDoc(date);
			absDoc.setNiveauAbsDoc(Integer.parseInt(levelFolder));
			absDoc.setDossier(dossierParent);
			absDoc.setProjet(projet);
			absDocBusiness.createDossier((Dossier) absDoc);
		}

		if (typeFolder.equals("file")) {
			absDoc = new Document();
			absDoc.setNumAbsDoc(idFolder);
			absDoc.setNomAbsDoc(nameFolder);
			absDoc.setDateCreationAbsDoc(date);
			absDoc.setNiveauAbsDoc(Integer.parseInt(levelFolder));
			absDoc.setDossier(dossierParent);
			absDoc.setProjet(projet);
			absDocBusiness.createDocument((Document) absDoc);
		}

	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public AbsDocBusiness getAbsDocBusiness() {
		return absDocBusiness;
	}

	public void setAbsDocBusiness(AbsDocBusiness absDocBusiness) {
		this.absDocBusiness = absDocBusiness;
	}

	public AbsDoc getAbsDoc() {
		return absDoc;
	}

	public void setAbsDoc(AbsDoc absDoc) {
		this.absDoc = absDoc;
	}

	public ProjetBusiness getProjetBusiness() {
		return projetBusiness;
	}

	public void setProjetBusiness(ProjetBusiness projetBusiness) {
		this.projetBusiness = projetBusiness;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public String getProjetFolder() {
		return projetFolder;
	}

	public void setProjetFolder(String projetFolder) {
		this.projetFolder = projetFolder;
	}

}
