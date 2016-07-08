package com.arabsoft.mySTKE.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.UserBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

@Service("userBusiness")
public class UserBusinessImpl implements UserBusiness {
	
	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public void createUser(Utilisateur utilisateur) {
		genericDao.save(utilisateur);
	}

}
