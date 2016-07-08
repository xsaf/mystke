package com.arabsoft.mySTKE.business;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.entity.AnalyseCout;

@Transactional
public interface AnalyseCoutBusiness {

	void createAnalyseCout(AnalyseCout analyseCout);
	AnalyseCout findAnalyseCoutByIdEtude(int idEtude);

}
