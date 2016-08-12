package com.arabsoft.mySTKE.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.dao.IAvisDao;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.Avis;

@Repository("avisDao")
public class AvisDaoImpl implements IAvisDao{
	
	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public void save(Avis avis) {
		genericDao.save(avis);
	}

	@Override
	public List<Avis> findByIdProjet(int value) {
		return genericDao.findByPropriety(Avis.class.getName(), "PROJET_IDPROJ", ""+value);
	}

	@Override
	public void update(Avis selectedAvis) {
		genericDao.update(selectedAvis);
	}
	
	

}
