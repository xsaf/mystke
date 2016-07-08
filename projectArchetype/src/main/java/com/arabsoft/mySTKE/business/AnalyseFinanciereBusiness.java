package com.arabsoft.mySTKE.business;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.entity.AnalyseFinanciere;

@Transactional
public interface AnalyseFinanciereBusiness {
	
	void createAnalyseFinanciere(AnalyseFinanciere analyseFinanciere);
	AnalyseFinanciere findAnalyseFinanciereByIdEtude(int idEtude);

	
}
