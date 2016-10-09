package com.arabsoft.mySTKE.endpoint;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.arabsoft.mySTKE.business.LoginBusiness;
import com.arabsoft.mySTKE.business.NotificationBusiness;
import com.arabsoft.mySTKE.entity.Notification;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

@WebService(targetNamespace = "http://loginws/")
@SOAPBinding(style = Style.RPC)
public class UtilisateurNotificationWS extends SpringBeanAutowiringSupport {

	private Utilisateur utilisateur = new Utilisateur();
	private UtilisateurWS utilisateurWS = new UtilisateurWS();
	private List<Notification> notifications;
	private NotificationWS notificationWS;
	private NotificationWSs notificationWSs = new NotificationWSs();
	private List<NotificationWS> notificationWSList = new ArrayList<>();

	private String username;
	private String password;

	@Autowired
	@Qualifier(value = "loginBusiness")
	LoginBusiness loginBusiness;

	@Autowired
	@Qualifier(value = "notificationBusiness")
	private NotificationBusiness notificationBusiness;

	public UtilisateurNotificationWS() {
		super();
	}

	@WebMethod(operationName = "getLogin")
	public String getLogin(@WebParam(name = "name") String name, @WebParam(name = "pass") String pass) {
		username = name;
		password = pass;
		utilisateur = loginBusiness.findUser(username, password);

		utilisateurWS.setNumMatrUser(utilisateur.getNumMatrUser());
		utilisateurWS.setNomUti(utilisateur.getNomUti());
		utilisateurWS.setPrenomUti(utilisateur.getPrenomUti());
		utilisateurWS.setMailUti(utilisateur.getMailUti());

		String xmlString = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(UtilisateurWS.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			StringWriter sw = new StringWriter();
			JAXB.marshal(utilisateurWS, sw);
			xmlString = sw.toString();

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return xmlString;
	}

	@WebMethod(operationName = "getNotification")
	public String getNotification(@WebParam(name = "numMatrUser") String numMatrUser) {
		String xmlString = null;
		StringWriter sw = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(NotificationWS.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			sw = new StringWriter();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		notifications = notificationBusiness.findNotificationByUser(numMatrUser);

		for (int i = 0; i < notifications.size(); i++) {
			switch (notifications.get(i).getProjet().getEtapeProj()) {
			case "Détails":
				notifications.get(i).setAvancement(notifications.get(i).getAvancement() * 100 / 2);
				break;
			case "Etude de rentabilité":
				notifications.get(i).setAvancement((notifications.get(i).getAvancement() - 2) * 100 / 12);
				break;
			case "Planification du projet":
				notifications.get(i).setAvancement((notifications.get(i).getAvancement() - 14) * 100 / 28);
				break;
			case "Suivi réunion du projet":
				notifications.get(i).setAvancement((notifications.get(i).getAvancement() - 42) * 100 / 2);
				break;
			case "Réception	finale":
				notifications.get(i).setAvancement((notifications.get(i).getAvancement() - 44) * 100 / 16);
				break;
			case "Analyse du cloture projet":
				notifications.get(i).setAvancement((notifications.get(i).getAvancement() - 60) * 100 / 9);
				break;
			default:
				break;
			}
		}

		notificationWSs.setNotifications(new ArrayList<NotificationWS>());

		for (int i = 0; i < notifications.size(); i++) {
			notificationWS = new NotificationWS();
			notificationWS.setIdNoti(notifications.get(i).getIdNoti());
			notificationWS.setLibelleNoti(notifications.get(i).getProjet().getNomProj() + "   /   "
					+ notifications.get(i).getProjet().getEtapeProj());
			notificationWS.setAvancement(notifications.get(i).getAvancement());
			notificationWS.setDateNoti(notifications.get(i).getDateNoti());
			notificationWS.setEtapeProj(notifications.get(i).getProjet().getEtapeProj());
			notificationWSList.add(notificationWS);
			notificationWSs.getNotifications().add(notificationWS);
		}

		JAXB.marshal(notificationWSs, sw);
		xmlString = sw.toString();

		return xmlString;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginBusiness getLoginBusiness() {
		return loginBusiness;
	}

	public void setLoginBusiness(LoginBusiness loginBusiness) {
		this.loginBusiness = loginBusiness;
	}

	public UtilisateurWS getUtilisateurWS() {
		return utilisateurWS;
	}

	public void setUtilisateurWS(UtilisateurWS utilisateurWS) {
		this.utilisateurWS = utilisateurWS;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public NotificationBusiness getNotificationBusiness() {
		return notificationBusiness;
	}

	public void setNotificationBusiness(NotificationBusiness notificationBusiness) {
		this.notificationBusiness = notificationBusiness;
	}

}
