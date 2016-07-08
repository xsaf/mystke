package com.arabsoft.mySTKE.business;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.entity.EtudeRentabillite;

@Transactional
public interface EtudeRentabiliteBusiness {

	void createEtudeRentabilite(EtudeRentabillite etude);
	EtudeRentabillite findEtudeByIdProjet(int idProj);
	
}
