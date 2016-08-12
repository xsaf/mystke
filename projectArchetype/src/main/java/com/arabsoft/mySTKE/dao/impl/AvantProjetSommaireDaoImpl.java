package com.arabsoft.mySTKE.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.dao.IAvantProjetSommaireDao;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.AvantProjetSommaire;

@Repository("avantProjetSommaireDao")
public class AvantProjetSommaireDaoImpl implements IAvantProjetSommaireDao{

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public void save(AvantProjetSommaire avantProjetSommaire) {
		genericDao.save(avantProjetSommaire);
	}

	@Override
	public List<AvantProjetSommaire> findByIdProjet(int value) {
		return genericDao.findByPropriety("AvantProjetSommaire","PROJET_IDPROJ",""+value);
	}

	@Override
	public void update(AvantProjetSommaire avantProjetSommaire) {
		genericDao.update(avantProjetSommaire);
	}

	
	
	
}
