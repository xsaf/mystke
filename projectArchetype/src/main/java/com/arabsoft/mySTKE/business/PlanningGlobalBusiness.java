package com.arabsoft.mySTKE.business;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.entity.PlanningGlobal;

@Transactional
public interface PlanningGlobalBusiness {

	void createPlanningGlobal(PlanningGlobal planningGlobal);
	PlanningGlobal findplanningGlobalByIdProjet(int idProj);
	void updatePlanningActivite(PlanningGlobal planningGlobal);

}
