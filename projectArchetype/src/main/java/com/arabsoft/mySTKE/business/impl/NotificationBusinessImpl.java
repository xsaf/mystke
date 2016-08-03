package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.EquipeBusiness;
import com.arabsoft.mySTKE.business.NotificationBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.Equipe;
import com.arabsoft.mySTKE.entity.Notification;

@Service("notificationBusiness")
public class NotificationBusinessImpl implements NotificationBusiness {

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;
	
	@Autowired
	@Qualifier("equipeBusiness")
	private EquipeBusiness equipeBusiness; 

	@Override 
	public void createNotification(Notification notification) {
		genericDao.save(notification);
	}

	@Override
	public List<Notification> findNotificationByUser(String numMatrUser) {
		List<Equipe> listEquipe = genericDao.findByPropriety(Equipe.class.getName(), "UTILISATEUR_NUMMATRUSER", numMatrUser);
		genericDao.findByPropriety(Notification.class.getName(), "UTILISATEUR_NUMMATRUSER", numMatrUser);
		return null;
	}
	
	
	
}
