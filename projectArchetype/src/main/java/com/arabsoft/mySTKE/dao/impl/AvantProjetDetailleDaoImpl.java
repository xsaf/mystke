package com.arabsoft.mySTKE.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.dao.IAvantProjetDetailleDao;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.AvantProjetDetaille;

@Repository("avantProjetDetailleDao")
public class AvantProjetDetailleDaoImpl implements IAvantProjetDetailleDao{

	@Autowired
	@Qualifier(value = "genericDao")
	private IDao genericDao;

	@Override
	public void save(AvantProjetDetaille avantProjetDetaille) {
		genericDao.save(avantProjetDetaille);
	}

	@Override
	public List<AvantProjetDetaille> findByIdProjet(int value) {
		return genericDao.findByPropriety(AvantProjetDetaille.class.getName(), "PROJET_IDPROJ",""+value);
	}

	@Override
	public void update(AvantProjetDetaille avantProjetDetaille) {
		genericDao.update(avantProjetDetaille);
	}
	
	
	
}
