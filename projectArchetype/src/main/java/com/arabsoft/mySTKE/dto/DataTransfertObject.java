package com.arabsoft.mySTKE.dto;

import java.util.List;

import com.arabsoft.mySTKE.entity.User;

public class DataTransfertObject {
	private ActionCrud action;
	private User utilisateur;
	private List<String> erreurs;

	public ActionCrud getAction() {
		return action;
	}

	public void setAction(ActionCrud action) {
		this.action = action;
	}

	public User getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<String> getErreurs() {
		return erreurs;
	}

	public void setErreurs(List<String> erreurs) {
		this.erreurs = erreurs;
	}

}
