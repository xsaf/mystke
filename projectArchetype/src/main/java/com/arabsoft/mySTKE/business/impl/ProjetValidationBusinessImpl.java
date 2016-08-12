package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.ProjetValidationBusiness;
import com.arabsoft.mySTKE.dao.IProjetValidationDao;
import com.arabsoft.mySTKE.entity.ProjetValidation;

@Service("projetValidationBusiness")
public class ProjetValidationBusinessImpl implements ProjetValidationBusiness {

	@Autowired
	@Qualifier("projetValidationDao")
	IProjetValidationDao projetValidationDao;

	@Override
	public void createProjetValid(ProjetValidation projetValidation) {
		projetValidationDao.save(projetValidation);
	}

	@Override
	public ProjetValidation findProjetValidationByIdProjet(int idProj, int etat) {
		List<ProjetValidation> l = projetValidationDao.findByIdProjetAndEtat(idProj,etat);
		return l.get(0);
	}

	@Override
	public void updateProjetValid(ProjetValidation projetValidation) {
		projetValidationDao.update(projetValidation);
	}

}
