package com.arabsoft.mySTKE.business;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.entity.Planning;

@Transactional
public interface PlanningBusiness {

	void createPlanning(Planning planning);
	Planning SelectPlanningByProjet(int idProj);
	void updatePlanning(Planning planning);
	
	

}
