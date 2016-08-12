package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.AvisBusiness;
import com.arabsoft.mySTKE.dao.IAvisDao;
import com.arabsoft.mySTKE.entity.Avis;

@Service("avisBusiness")
public class AvisBusinessImpl implements AvisBusiness {

	@Autowired
	@Qualifier("avisDao")
	IAvisDao avisDao;

	@Override
	public void createAvis(Avis avis) {
		avisDao.save(avis);
	}

	@Override
	public List<Avis> findAvisByIdProjet(int idProj) {
		List<Avis> l = avisDao.findByIdProjet(idProj);
		return l;
	}

	@Override
	public void updateAvis(Avis selectedAvis) {
		avisDao.update(selectedAvis);
	}
	
	
	
	
	
}
