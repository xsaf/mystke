package com.arabsoft.mySTKE.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.security.core.context.SecurityContextHolder;

import com.arabsoft.mySTKE.business.EquipeBusiness;
import com.arabsoft.mySTKE.business.NotificationBusiness;
import com.arabsoft.mySTKE.business.ProjetBusiness;
import com.arabsoft.mySTKE.entity.Notification;
import com.arabsoft.mySTKE.entity.Projet;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

@ManagedBean(name = "templateCtr")
@ViewScoped
public class TemplateCtr {

	private Utilisateur user = new Utilisateur();
	private List<Notification> notifications;
	private List<Projet> projets;

	@ManagedProperty(value = "#{notificationBusiness}")
	private NotificationBusiness notificationBusiness;

	@PostConstruct
	public void initialisation() {
		user = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		notifications = notificationBusiness.findNotificationByUser(user.getNumMatrUser());
		for (int i = 0; i < notifications.size(); i++) {
			switch (notifications.get(i).getProjet().getEtapeProj()) {
			case "Etude de rentabilité":
				notifications.get(i).setAvancement(notifications.get(i).getAvancement() * 100 / 12);
				break;
			case "Planification du projet":
				notifications.get(i).setAvancement((notifications.get(i).getAvancement()-12) * 100 / 28);
				break;
			case "Suivi réunion du projet":
				notifications.get(i).setAvancement((notifications.get(i).getAvancement()-40) * 100 / 2);
				break;
			case "Réception	finale":
				notifications.get(i).setAvancement((notifications.get(i).getAvancement()-42) * 100 / 16);
				break;
			case "Analyse du cloture projet":
				notifications.get(i).setAvancement((notifications.get(i).getAvancement()-58) * 100 / 9);
				break;
			default:
				break;
			}
		}
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public List<Projet> getProjets() {
		return projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	public NotificationBusiness getNotificationBusiness() {
		return notificationBusiness;
	}

	public void setNotificationBusiness(NotificationBusiness notificationBusiness) {
		this.notificationBusiness = notificationBusiness;
	}

}
