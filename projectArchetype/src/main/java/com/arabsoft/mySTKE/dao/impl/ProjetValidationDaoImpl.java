package com.arabsoft.mySTKE.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.dao.IProjetValidationDao;
import com.arabsoft.mySTKE.entity.ProjetValidation;

@Repository("projetValidationDao")
public class ProjetValidationDaoImpl implements IProjetValidationDao{

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public void save(ProjetValidation projetValidation) {
		genericDao.save(projetValidation);
	}

	@Override
	public List<ProjetValidation> findByIdProjetAndEtat(int idProj, int etat) {
		return genericDao.findByPropriety(ProjetValidation.class.getName(), "PROJET_IDPROJ", "" + idProj,
				"ETATVALID", "" + etat);
	}

	@Override
	public void update(ProjetValidation projetValidation) {
		genericDao.update(projetValidation);
	}
	
}
