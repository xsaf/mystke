package com.arabsoft.mySTKE.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.dao.IDefautDao;
import com.arabsoft.mySTKE.entity.Defaut;

@Repository("defautDao")
public class DefautDaoImpl implements IDefautDao {
	
	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;
	
	@Override
	public void save(Defaut defaut) {
		genericDao.save(defaut);
	}

	@Override
	public List<Defaut> findByIdProjet(int value) {
		return genericDao.findByPropriety("Defaut", "PROJET_IDPROJ",
				"" + value);
	}

	@Override
	public void update(Defaut defaut) {
		genericDao.update(defaut);
	}


}
