package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.PlanningActiviteBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.PlanningActivite;

@Service("planningActiviteBusiness")
public class PlanningActiviteBusinessImpl implements PlanningActiviteBusiness {

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public void createPlanningActivite(PlanningActivite planningActivite) {
		genericDao.save(planningActivite);
	}

	@Override
	public List<PlanningActivite> findPlanningActiviteByIdPlanningGlobal(int idPlanningGlobal) {
		List<PlanningActivite> p = genericDao.findByPropriety("PlanningActivite", "PLANNINGGLOBAL_IDPLANNING",
				"" + idPlanningGlobal);
		return p;
	}

	@Override
	public void updatePlanningActivite(PlanningActivite planningActivite) {
		genericDao.update(planningActivite);
	}

}
