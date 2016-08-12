package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.AvantProjetDetailleBusiness;
import com.arabsoft.mySTKE.dao.IAvantProjetDetailleDao;
import com.arabsoft.mySTKE.entity.AvantProjetDetaille;

@Service("avantProjetDetailleBusiness")
public class AvantProjetDetailleBusinessImpl implements AvantProjetDetailleBusiness{

	@Autowired 
	@Qualifier("avantProjetDetailleDao")
	IAvantProjetDetailleDao avantProjetDetailleDao;

	@Override
	public void createAvantProjetDetaille(AvantProjetDetaille avantProjetDetaille) {
		avantProjetDetailleDao.save(avantProjetDetaille);
	}

	@Override
	public AvantProjetDetaille findAvantProjetDetailleByIdProjet(int idProj) {
		List<AvantProjetDetaille> l = avantProjetDetailleDao.findByIdProjet(idProj);
		return l.get(0);
	}

	@Override
	public void updateAvantProjetDetaille(AvantProjetDetaille avantProjetDetaille) {
		avantProjetDetailleDao.update(avantProjetDetaille);
	}
	
	
}
