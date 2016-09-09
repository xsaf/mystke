package com.arabsoft.mySTKE.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.dao.IPlanningDao;
import com.arabsoft.mySTKE.entity.Planning;

@Repository("planningDao")
public class PlanningDaoImpl implements IPlanningDao{

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;
	
	@Override
	public void save(Planning planning) {
		genericDao.save(planning);		
	}

	@Override
	public Planning findPlanningByProjet(int idProj) {
		List<Planning> p1 = genericDao.findByPropriety(Planning.class.getName(), "PROJET_IDPROJ", ""+idProj);
		return p1.get(0);
	}

	@Override
	public void update(Planning planning) {
		genericDao.update(planning);
	}
	
}
