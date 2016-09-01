package com.arabsoft.mySTKE.endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Notifications")
@XmlAccessorType (XmlAccessType.FIELD)
public class NotificationWSs {
	
	 @XmlElement(name = "Notification")
	 private List<NotificationWS> notifications = new ArrayList<>();

	public List<NotificationWS> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<NotificationWS> notifications) {
		this.notifications = notifications;
	}
	 

}
