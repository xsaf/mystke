package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.PlanningGlobalBusiness;
import com.arabsoft.mySTKE.dao.IPlanningGlobalDao;
import com.arabsoft.mySTKE.entity.PlanningGlobal;

@Service("planningGlobalBusiness")
public class PlanningGlobalBusinessImpl implements PlanningGlobalBusiness {

	@Autowired
	@Qualifier("planningGlobalDao")
	IPlanningGlobalDao planningGlobalDao;
	
	@Override
	public void createPlanningGlobal(PlanningGlobal planningGlobal) {
		planningGlobalDao.save(planningGlobal);
	}

	@Override
	public PlanningGlobal findplanningGlobalByIdProjet(int idProj) {
		return planningGlobalDao.findByIdProjet(idProj);
	}

	@Override
	public void updatePlanningActivite(PlanningGlobal planningGlobal) {
		planningGlobalDao.update(planningGlobal);
	}

}
