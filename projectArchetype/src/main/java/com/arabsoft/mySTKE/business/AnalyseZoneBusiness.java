package com.arabsoft.mySTKE.business;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.entity.AnalyseZone;

@Transactional
public interface AnalyseZoneBusiness {

	void createAnalyseZone(AnalyseZone analyseZone);
	AnalyseZone findAnalyseZoneByIdEtude(int idEtude);

}
