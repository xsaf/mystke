package com.arabsoft.mySTKE.business;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.entity.Programme;

@Transactional
public interface ProgrammeBusiness {
	
	void createProgramme(Programme programme);
	Programme findProgrammeByIdProjet(int idProj);
	void updateProgramme(Programme programme);

}
