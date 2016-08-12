package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.PlanningActiviteBusiness;
import com.arabsoft.mySTKE.dao.IPlanningActiviteDao;
import com.arabsoft.mySTKE.entity.PlanningActivite;

@Service("planningActiviteBusiness")
public class PlanningActiviteBusinessImpl implements PlanningActiviteBusiness {

	@Autowired
	@Qualifier("planningActiviteDao")
	IPlanningActiviteDao planningActiviteDao;

	@Override
	public void createPlanningActivite(PlanningActivite planningActivite) {
		planningActiviteDao.save(planningActivite);
	}

	@Override
	public List<PlanningActivite> findPlanningActiviteByIdPlanningGlobal(int idPlanningGlobal) {
		return planningActiviteDao.findPlanningActiviteByIdPlanningGlobal(idPlanningGlobal);
	}

	@Override
	public void updatePlanningActivite(PlanningActivite planningActivite) {
		planningActiviteDao.update(planningActivite);
	}

}
