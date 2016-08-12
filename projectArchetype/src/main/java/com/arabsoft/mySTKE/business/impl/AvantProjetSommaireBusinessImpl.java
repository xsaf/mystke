package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.AvantProjetSommaireBusiness;
import com.arabsoft.mySTKE.dao.IAvantProjetSommaireDao;
import com.arabsoft.mySTKE.entity.AvantProjetSommaire;

@Service("avantProjetSommaireBusiness")
public class AvantProjetSommaireBusinessImpl implements AvantProjetSommaireBusiness{

	@Autowired
	@Qualifier("avantProjetSommaireDao")
	IAvantProjetSommaireDao avantProjetSommaireDao;
	
	@Override
	public void createAvantProjetSommaire(AvantProjetSommaire avantProjetSommaire) {
		avantProjetSommaireDao.save(avantProjetSommaire);
	}

	@Override
	public AvantProjetSommaire findAvantProjetSommaireByIdProjet(int idProj) {
		List<AvantProjetSommaire> l = avantProjetSommaireDao.findByIdProjet(idProj);
		return l.get(0);
	}

	@Override
	public void updateAvantProjetSommaire(AvantProjetSommaire avantProjetSommaire) {
		avantProjetSommaireDao.update(avantProjetSommaire);
	}

}
