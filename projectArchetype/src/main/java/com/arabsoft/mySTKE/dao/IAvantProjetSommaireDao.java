package com.arabsoft.mySTKE.dao;

import java.util.List;

import com.arabsoft.mySTKE.entity.AvantProjetSommaire;

public interface IAvantProjetSommaireDao {

	void save(AvantProjetSommaire avantProjetSommaire);

	List<AvantProjetSommaire> findByIdProjet(int value);

	void update(AvantProjetSommaire avantProjetSommaire);

}
