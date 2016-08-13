package com.arabsoft.mySTKE.aspect;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;

import com.arabsoft.mySTKE.business.NotificationBusiness;
import com.arabsoft.mySTKE.entity.Notification;
import com.arabsoft.mySTKE.entity.Projet;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;


@Aspect
public class NotificationAspect {
	
	private Notification notification = new Notification();
	private Projet projet = new Projet();
	private Utilisateur utilisateur = new Utilisateur();
	
	@Autowired
	@Qualifier("notificationBusiness")
	private NotificationBusiness notificationBusiness;
	
	
	@Pointcut("execution(* com.arabsoft.mySTKE.controller.*.notification(..))")
	public void pc(){}
	
	@Before("pc()")
	public void notifier(JoinPoint jp){
		Object[] ob = jp.getArgs();
		projet = (Projet) ob[0];
		utilisateur = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	@Pointcut("execution(* com.arabsoft.mySTKE.controller.*.*Notifier(..))")
	public void pc1(){}

	@AfterReturning("pc1()")
	public void notifier(){
		notification.setDateNoti(new Date());
		notification.setProjet(projet);
		notification.setUtilisateur(utilisateur);
		notificationBusiness.createNotification(notification);
	}

	public NotificationBusiness getNotificationBusiness() {
		return notificationBusiness;
	}

	public void setNotificationBusiness(NotificationBusiness notificationBusiness) {
		this.notificationBusiness = notificationBusiness;
	}

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	

	
	
	
}
