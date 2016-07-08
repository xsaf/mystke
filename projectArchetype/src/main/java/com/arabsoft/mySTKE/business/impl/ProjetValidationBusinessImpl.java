package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.ProjetValidationBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.ProjetValidation;

@Service("projetValidationBusiness")
public class ProjetValidationBusinessImpl implements ProjetValidationBusiness {

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public void createProjetValid(ProjetValidation projetValidation) {
		genericDao.save(projetValidation);
	}

	@Override
	public ProjetValidation findProjetValidationByIdProjet(int idProj, int etat) {
		List<ProjetValidation> l = genericDao.findByPropriety("ProjetValidation", "PROJET_IDPROJ", "" + idProj,
				"ETATVALID", "" + etat);
		return l.get(0);
	}

	@Override
	public void updateProjetValid(ProjetValidation projetValidation) {
		genericDao.update(projetValidation);
	}

}
