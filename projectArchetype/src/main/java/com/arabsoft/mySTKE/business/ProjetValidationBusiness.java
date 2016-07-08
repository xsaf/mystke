package com.arabsoft.mySTKE.business;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.entity.ProjetValidation;

@Transactional
public interface ProjetValidationBusiness {

	void createProjetValid(ProjetValidation projetValidation);
	ProjetValidation findProjetValidationByIdProjet(int idProj, int etat);
	void updateProjetValid(ProjetValidation projetValidation);

}
