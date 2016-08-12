package com.arabsoft.mySTKE.dao;

import java.util.List;

import com.arabsoft.mySTKE.entity.PlanningActivite;

public interface IPlanningActiviteDao {

	void save(PlanningActivite planningActivite);

	List<PlanningActivite> findPlanningActiviteByIdPlanningGlobal(int idPlanningGlobal);

	void update(PlanningActivite planningActivite);

}
