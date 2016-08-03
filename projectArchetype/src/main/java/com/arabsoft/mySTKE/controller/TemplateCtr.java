package com.arabsoft.mySTKE.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.security.core.context.SecurityContextHolder;

import com.arabsoft.mySTKE.business.EquipeBusiness;
import com.arabsoft.mySTKE.business.NotificationBusiness;
import com.arabsoft.mySTKE.entity.Notification;
import com.arabsoft.mySTKE.entity.Projet;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;


@ManagedBean(name="templateCtr")
@ViewScoped
public class TemplateCtr {
	
	private Utilisateur user = new Utilisateur();
	private List<Notification> notifications;
	private List<Projet> projets;
	
	@ManagedProperty(value="notificationBusiness")
	private NotificationBusiness notificationBusiness; 
	
	
	@PostConstruct
	public void initialisation() {
		user = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();		
		notifications = notificationBusiness.findNotificationByUser(user.getNumMatrUser());
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public NotificationBusiness getNotificationBusiness() {
		return notificationBusiness;
	}

	public void setNotificationBusiness(NotificationBusiness notificationBusiness) {
		this.notificationBusiness = notificationBusiness;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
	
	



}
