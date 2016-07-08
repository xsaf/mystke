package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.AvantProjetDetailleBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.AvantProjetDetaille;
import com.arabsoft.mySTKE.entity.Zone;

@Service("avantProjetDetailleBusiness")
public class AvantProjetDetailleBusinessImpl implements AvantProjetDetailleBusiness{

	@Autowired 
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public void createAvantProjetDetaille(AvantProjetDetaille avantProjetDetaille) {
		genericDao.save(avantProjetDetaille);
	}

	@Override
	public AvantProjetDetaille findAvantProjetDetailleByIdProjet(int idProj) {
		List<AvantProjetDetaille> l = genericDao.findByPropriety("AvantProjetDetaille","PROJET_IDPROJ",""+idProj);
		return l.get(0);
	}

	@Override
	public void updateAvantProjetDetaille(AvantProjetDetaille avantProjetDetaille) {
		genericDao.update(avantProjetDetaille);
	}
	
	
}
