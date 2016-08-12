package com.arabsoft.mySTKE.dao;

import com.arabsoft.mySTKE.entity.PlanningGlobal;

public interface IPlanningGlobalDao {

	void save(PlanningGlobal planningGlobal);

	PlanningGlobal findByIdProjet(int idProj);

	void update(PlanningGlobal planningGlobal);

}
