package com.arabsoft.mySTKE.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.dao.IPlanningActiviteDao;
import com.arabsoft.mySTKE.entity.PlanningActivite;

@Repository("planningActiviteDao")
public class PlanningActiviteDaoImpl implements IPlanningActiviteDao{

	@Autowired
	@Qualifier(value = "genericDao")
	private IDao genericDao;

	@Override
	public void save(PlanningActivite planningActivite) {
		genericDao.save(planningActivite);
	}

	@Override
	public List<PlanningActivite> findPlanningActiviteByIdPlanningGlobal(int idPlanningGlobal) {
		List<PlanningActivite> p = genericDao.findByPropriety("PlanningActivite", "PLANNINGGLOBAL_IDPLANNING",
				"" + idPlanningGlobal);
		return p;
	}

	@Override
	public void update(PlanningActivite planningActivite) {
		genericDao.update(planningActivite);
	}
	
	
}
