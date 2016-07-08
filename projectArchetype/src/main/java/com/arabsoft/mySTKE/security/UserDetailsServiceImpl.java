package com.arabsoft.mySTKE.security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.arabsoft.mySTKE.security.habilitation.dao.UserDao;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

public class UserDetailsServiceImpl implements
		UserDetailsService {

	private UserDao userDao;
	private static final Logger logger = Logger
			.getLogger(UserDetailsServiceImpl.class);
	
	

	@Autowired
	public UserDetailsServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		Utilisateur user = (Utilisateur) userDao.loadUserByUsername(username);
		
		return user;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}



}