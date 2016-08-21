package com.arabsoft.mySTKE.business.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.UserBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.dao.IUserDao;
import com.arabsoft.mySTKE.security.habilitation.model.UserRole;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

@Service("userBusiness")
public class UserBusinessImpl implements UserBusiness {
	
	@Autowired
	@Qualifier("utilisateurDao")
	IUserDao userDao;

	@Override
	public Utilisateur createUser(Utilisateur utilisateur) {
		utilisateur = userDao.save(utilisateur);
		return utilisateur;
	}

	@Override
	public List<Utilisateur> findAllUser() {
		return userDao.findAll();
	}

	@Override
	public void createUserRole(UserRole userRole) {
		userDao.save(userRole);
	}

	@Override
	public void deleteUserRole(UserRole userRole) {
		userDao.remove(userRole);
	}

	@Override
	public void deleteUser(Utilisateur utilisateur) {
		userDao.remove(utilisateur);
	}

	@Override
	public Utilisateur updateUser(Utilisateur utilisateur) {
		return userDao.update(utilisateur);
	}

}
