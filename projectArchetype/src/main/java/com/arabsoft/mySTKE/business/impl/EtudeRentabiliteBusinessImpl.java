package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.EtudeRentabiliteBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.EtudeRentabillite;

@Service("etudeBusiness")
public class EtudeRentabiliteBusinessImpl implements EtudeRentabiliteBusiness {
	
	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public void createEtudeRentabilite(EtudeRentabillite etude) {
		genericDao.save(etude);
	}

	@Override
	public EtudeRentabillite findEtudeByIdProjet(int idProj) {
		List<EtudeRentabillite> l = genericDao.findByPropriety("EtudeRentabillite","PROJET_IDPROJ",""+idProj);
		return l.get(0);
	}

}
