package com.arabsoft.mySTKE.business;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.entity.Zone;

@Transactional
public interface ZoneBusiness {

	void createZone(Zone zone);
	Zone findZoneByIdProjet(int idProj);

}
