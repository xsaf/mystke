package com.arabsoft.mySTKE.endpoint;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Notification")
public class NotificationWS {
	
	private int idNoti;
	private String libelleNoti;
	private Date dateNoti;
	private int avancement;
	private String etapeProj;

	public int getIdNoti() {
		return idNoti;
	}

	@XmlElement(name = "idNoti")
	public void setIdNoti(int idNoti) {
		this.idNoti = idNoti;
	}
	
	public String getLibelleNoti() {
		return libelleNoti;
	}
	
    @XmlElement(name = "libelleNoti")
	public void setLibelleNoti(String libelleNoti) {
		this.libelleNoti = libelleNoti;
	}
    
	public Date getDateNoti() {
		return dateNoti;
	}
	
    @XmlElement(name = "dateNoti")
	public void setDateNoti(Date dateNoti) {
		this.dateNoti = dateNoti;
	}
    
	public int getAvancement() {
		return avancement;
	}
	
    @XmlElement(name = "avancement")
	public void setAvancement(int avancement) {
		this.avancement = avancement;
	}

	public String getEtapeProj() {
		return etapeProj;
	}

    @XmlElement(name = "etapeProj")
	public void setEtapeProj(String etapeProj) {
		this.etapeProj = etapeProj;
	}

    
	
	
}
