package com.arabsoft.mySTKE.dao;

import com.arabsoft.mySTKE.entity.Notification;

public interface INotificationDao {

	void save(Notification notification);

	Notification findByIdProjet(int value);

}
