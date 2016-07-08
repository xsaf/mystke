package com.arabsoft.mySTKE.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.entity.PlanningActivite;

@Transactional
public interface PlanningActiviteBusiness {
	
	void createPlanningActivite(PlanningActivite planningActivite);
	List<PlanningActivite> findPlanningActiviteByIdPlanningGlobal(int idPlanningGlobal);
	void updatePlanningActivite(PlanningActivite planningActivite);

}
