package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.EtudeRentabiliteBusiness;
import com.arabsoft.mySTKE.dao.IEtudeRentabiliteDao;
import com.arabsoft.mySTKE.entity.EtudeRentabillite;

@Service("etudeBusiness")
public class EtudeRentabiliteBusinessImpl implements EtudeRentabiliteBusiness {
	
	@Autowired
	@Qualifier("etudeRentabiliteDao")
	IEtudeRentabiliteDao etudeRentabiliteDao;

	@Override
	public void createEtudeRentabilite(EtudeRentabillite etude) {
		etudeRentabiliteDao.save(etude);
	}

	@Override
	public EtudeRentabillite findEtudeByIdProjet(int idProj) {
		List<EtudeRentabillite> l = etudeRentabiliteDao.findByIdProjet(idProj);
		return l.get(0);
	}

}
