package com.arabsoft.mySTKE.business.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.LoginBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.security.habilitation.dao.UserDao;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

@Service(value = "loginBusiness")
public class LoginBusinessImpl implements LoginBusiness {
	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;
	JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier(value = "userDao")
	UserDao userDao;
	String s;

	@Override
	public Utilisateur findUser(String nomLoginUser) {
		return userDao.getUser(nomLoginUser);
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public IDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(IDao genericDao) {
		this.genericDao = genericDao;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public Utilisateur findUser(String username, String password) {
		return userDao.getUser(username,password);
	}

}
