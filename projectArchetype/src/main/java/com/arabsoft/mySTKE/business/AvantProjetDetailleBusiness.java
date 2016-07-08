package com.arabsoft.mySTKE.business;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.entity.AvantProjetDetaille;

@Transactional
public interface AvantProjetDetailleBusiness {

	void createAvantProjetDetaille(AvantProjetDetaille avantProjetDetaille);
	AvantProjetDetaille findAvantProjetDetailleByIdProjet(int idProj);
	void updateAvantProjetDetaille(AvantProjetDetaille avantProjetDetaille);

}
