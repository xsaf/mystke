package com.arabsoft.mySTKE.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.dao.IAxeAmeliorationDao;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.AxeAmelioration;

@Repository("axeAmeliorationDao")
public class AxeAmeliorationDaoImpl implements IAxeAmeliorationDao{

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public void save(AxeAmelioration axeAmelioration) {
		genericDao.save(axeAmelioration);
	}

	@Override
	public List<AxeAmelioration> findByIdProjet(int idProj) {
		return 	genericDao.findByPropriety(AxeAmelioration.class.getName(), "PROJET_IDPROJ", ""+idProj); 
	}
	
		
	
}
