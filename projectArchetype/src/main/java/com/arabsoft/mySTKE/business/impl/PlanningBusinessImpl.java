package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.PlanningBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.Planning;

@Service("planningBusiness")
public class PlanningBusinessImpl implements PlanningBusiness{

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;
	
	@Override
	public void createPlanning(Planning planning) {
		genericDao.save(planning);		
	}

	@Override
	public Planning SelectPlanningByProjet(int idProj) {
		List<Planning> p1 = genericDao.findByPropriety("Planning", "PROJET_IDPROJ", ""+idProj);
		return p1.get(0);
	}

}
