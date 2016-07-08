package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.AvantProjetSommaireBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.AvantProjetSommaire;
import com.arabsoft.mySTKE.entity.Programme;

@Service("avantProjetSommaireBusiness")
public class AvantProjetSommaireBusinessImpl implements AvantProjetSommaireBusiness{

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;
	
	@Override
	public void createAvantProjetSommaire(AvantProjetSommaire avantProjetSommaire) {
		genericDao.save(avantProjetSommaire);
	}

	@Override
	public AvantProjetSommaire findAvantProjetSommaireByIdProjet(int idProj) {
		List<AvantProjetSommaire> l = genericDao.findByPropriety("AvantProjetSommaire","PROJET_IDPROJ",""+idProj);
		return l.get(0);
	}

	@Override
	public void updateAvantProjetSommaire(AvantProjetSommaire avantProjetSommaire) {
		genericDao.update(avantProjetSommaire);
	}

}
