package com.arabsoft.mySTKE.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.PlanningBusiness;
import com.arabsoft.mySTKE.dao.IPlanningDao;
import com.arabsoft.mySTKE.entity.Planning;

@Service("planningBusiness")
public class PlanningBusinessImpl implements PlanningBusiness{

	@Autowired
	@Qualifier("planningDao")
	IPlanningDao planningDao;
	
	@Override
	public void createPlanning(Planning planning) {
		planningDao.save(planning);		
	}

	@Override
	public Planning SelectPlanningByProjet(int idProj) {
		return planningDao.findPlanningByProjet(idProj);
	}

	@Override
	public void updatePlanning(Planning planning) {
		planningDao.update(planning);
	}

}
