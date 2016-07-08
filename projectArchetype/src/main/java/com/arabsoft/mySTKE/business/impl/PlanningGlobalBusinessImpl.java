package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.PlanningGlobalBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.PlanningGlobal;
import com.arabsoft.mySTKE.entity.Zone;

@Service("planningGlobalBusiness")
public class PlanningGlobalBusinessImpl implements PlanningGlobalBusiness {

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;
	
	@Override
	public void createPlanningGlobal(PlanningGlobal planningGlobal) {
		genericDao.save(planningGlobal);
	}

	@Override
	public PlanningGlobal findplanningGlobalByIdProjet(int idProj) {
		List<PlanningGlobal> l = genericDao.findByPropriety("PlanningGlobal","PROJET_IDPROJ",""+idProj);
		return l.get(0);
	}

	@Override
	public void updatePlanningActivite(PlanningGlobal planningGlobal) {
		genericDao.update(planningGlobal);
	}

}
