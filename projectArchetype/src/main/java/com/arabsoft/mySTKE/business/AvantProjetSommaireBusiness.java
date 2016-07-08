package com.arabsoft.mySTKE.business;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.entity.AvantProjetSommaire;

@Transactional
public interface AvantProjetSommaireBusiness {

	void createAvantProjetSommaire(AvantProjetSommaire avantProjetSommaire);
	AvantProjetSommaire findAvantProjetSommaireByIdProjet(int idProj);
	void updateAvantProjetSommaire(AvantProjetSommaire avantProjetSommaire);

}
