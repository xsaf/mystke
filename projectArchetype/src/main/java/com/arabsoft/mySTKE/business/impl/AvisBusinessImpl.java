package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.AvisBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.Avis;

@Service("avisBusiness")
public class AvisBusinessImpl implements AvisBusiness {

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public void createAvis(Avis avis) {
		genericDao.save(avis);
	}

	@Override
	public List<Avis> findAvisByIdProjet(int idProj) {
		List<Avis> l = genericDao.findByPropriety(Avis.class.getName(), "PROJET_IDPROJ", ""+idProj);
		return l;
	}
	
	
	
}
