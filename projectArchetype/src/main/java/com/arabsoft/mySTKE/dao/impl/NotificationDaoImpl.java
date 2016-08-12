package com.arabsoft.mySTKE.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.dao.INotificationDao;
import com.arabsoft.mySTKE.entity.Notification;

@Repository("notificationDao")
public class NotificationDaoImpl implements INotificationDao {

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public void save(Notification notification) {
		List<Notification> listNotif = genericDao
				.findByPropriety(Notification.class.getName(), "PROJET_IDPROJ", "" + notification.getProjet().getIdProj());
		if(listNotif!= null && listNotif.size() > 0)
			notification.setIdNoti(listNotif.get(0).getIdNoti());
		genericDao.saveOrUpdate(notification);
	}

	@Override
	public Notification findByIdProjet(int value) {
		List<Notification> listNotif = genericDao
				.findByPropriety(Notification.class.getName(), "PROJET_IDPROJ", "" + value);
		if(listNotif!= null && listNotif.size() > 0)
			return listNotif.get(0);
		return null;
	}

}
