package com.arabsoft.mySTKE.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.dao.IProfilDao;
import com.arabsoft.mySTKE.security.habilitation.model.Profil;

@Repository("profilDao")
public class ProfilDaoImpl implements IProfilDao{

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public List<Profil> findAllProfil() {
		return genericDao.findAll(Profil.class);
	}
	
}
