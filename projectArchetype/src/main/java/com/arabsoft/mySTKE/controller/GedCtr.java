package com.arabsoft.mySTKE.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.arabsoft.mySTKE.business.AbsDocBusiness;
import com.arabsoft.mySTKE.business.ProjetBusiness;
import com.arabsoft.mySTKE.entity.AbsDoc;
import com.arabsoft.mySTKE.entity.Dossier;
import com.arabsoft.mySTKE.entity.Projet;

@ManagedBean(name = "gedCtr")
@ViewScoped
public class GedCtr {

	private AbsDoc absDoc = new Dossier();
	private Projet projet = new Projet();

	@ManagedProperty(value = "#{absDocBusiness}")
	private AbsDocBusiness absDocBusiness;

	@ManagedProperty(value = "#{projetBusiness}")
	private ProjetBusiness projetBusiness;

	private String s;

//	public void goToDetails() {
//		String y = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("yuio");
//        System.out.println("qqqqqq + "+y);
//	}

	public void createFolder(String num) {
		projet = projetBusiness.findProjetByName(projet.getNomProj());
		absDoc.setNomAbsDoc(projet.getNomProj());
		absDoc.setProjet(projet);
		absDocBusiness.createAbsDoc((Dossier) absDoc);
	}

//	public void getIDFolder() {
//		absDoc.setNumAbsDoc(
//				FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idnewfolder"));
//	}

//	public void createGEDFolder() {
//		RequestContext requestContext = RequestContext.getCurrentInstance();
//		requestContext.execute("createFolder()");
//	}

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

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

}
