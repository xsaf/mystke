package com.arabsoft.mySTKE.dao;

import com.arabsoft.mySTKE.entity.Planning;

public interface IPlanningDao {

	void save(Planning planning);

	Planning findPlanningByProjet(int idProj);

	void update(Planning planning);

}
