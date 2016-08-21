package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.ProfilBusiness;
import com.arabsoft.mySTKE.dao.IProfilDao;
import com.arabsoft.mySTKE.security.habilitation.model.Profil;

@Service("profilBusiness")
public class ProfilBusinessImpl implements ProfilBusiness {

	@Autowired
	@Qualifier("profilDao")
	IProfilDao profilDao;
	
	@Override
	public List<Profil> findAllProfil() {
		return profilDao.findAllProfil();
	}

}
