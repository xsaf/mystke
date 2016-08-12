package com.arabsoft.mySTKE.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.NotificationBusiness;
import com.arabsoft.mySTKE.dao.IEquipeDao;
import com.arabsoft.mySTKE.dao.INotificationDao;
import com.arabsoft.mySTKE.entity.Equipe;
import com.arabsoft.mySTKE.entity.Notification;

@Service("notificationBusiness")
public class NotificationBusinessImpl implements NotificationBusiness {

	@Autowired
	@Qualifier("notificationDao")
	INotificationDao notificationDao;

	@Autowired
	@Qualifier("equipeDao")
	IEquipeDao equipeDao;

	@Override
	public void createNotification(Notification notification) {
		notification.setAvancement(notification.getAvancement() + 1);
		notificationDao.save(notification);
	}

	@Override
	public List<Notification> findNotificationByUser(String numMatrUser) {
		Notification notif = new Notification();
		List<Notification> listNotif = new ArrayList<Notification>();
		List<Equipe> listEquipe = equipeDao.findByIdUser(numMatrUser);
		for (int i = 0; i < listEquipe.size(); i++) {
			notif = notificationDao.findByIdProjet(listEquipe.get(i).getProjet().getIdProj());
			if (notif != null) {
				listNotif.add(notif);
			}
		}
		return listNotif;
	}

}
