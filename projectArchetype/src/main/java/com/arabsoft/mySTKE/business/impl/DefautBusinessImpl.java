package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.DefautBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.Defaut;

@Service("defautBusiness")
public class DefautBusinessImpl implements DefautBusiness {

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;
	
	@Override
	public void createDefaut(Defaut defaut) {
		genericDao.save(defaut);
	}

	@Override
	public List<Defaut> findDefautsByIdProjet(int idProj) {
		List<Defaut> d = genericDao.findByPropriety("Defaut", "PROJET_IDPROJ",
				"" + idProj);
		return d;
	}

	@Override
	public void updateDefaut(Defaut defaut) {
		genericDao.update(defaut);
	}

}
