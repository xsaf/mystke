package com.arabsoft.mySTKE.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.dao.IPlanningGlobalDao;
import com.arabsoft.mySTKE.entity.PlanningGlobal;

@Repository("planningGlobalDao")
public class PlanningGlobalDaoImpl implements IPlanningGlobalDao {

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;
	
	@Override
	public void save(PlanningGlobal planningGlobal) {
		genericDao.save(planningGlobal);
	}

	@Override
	public PlanningGlobal findByIdProjet(int idProj) {
		List<PlanningGlobal> l = genericDao.findByPropriety(PlanningGlobal.class.getName(),"PROJET_IDPROJ",""+idProj);
		return l.get(0);
	}

	@Override
	public void update(PlanningGlobal planningGlobal) {
		genericDao.update(planningGlobal);
	}

	
}
