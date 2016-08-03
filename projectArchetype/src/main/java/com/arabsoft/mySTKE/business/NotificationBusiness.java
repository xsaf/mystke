package com.arabsoft.mySTKE.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.entity.Notification;

@Transactional
public interface NotificationBusiness {

	void createNotification(Notification notification);

	List<Notification> findNotificationByUser(String numMatrUser);

}
