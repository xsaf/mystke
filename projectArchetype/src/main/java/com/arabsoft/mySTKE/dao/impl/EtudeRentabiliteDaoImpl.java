package com.arabsoft.mySTKE.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.dao.IEtudeRentabiliteDao;
import com.arabsoft.mySTKE.entity.EtudeRentabillite;

@Repository("etudeRentabiliteDao")
public class EtudeRentabiliteDaoImpl implements IEtudeRentabiliteDao{

	@Autowired
	@Qualifier(value = "genericDao")
	private IDao genericDao;
	
	@Override
	public void save(EtudeRentabillite etude) {
		genericDao.save(etude);
	}

	@Override
	public List<EtudeRentabillite> findByIdProjet(int idProj) {
		return genericDao.findByPropriety(EtudeRentabillite.class.getName(),"PROJET_IDPROJ",""+idProj);
	}

}
