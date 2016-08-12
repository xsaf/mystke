package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.ProgrammeBusiness;
import com.arabsoft.mySTKE.dao.IProgrammeDao;
import com.arabsoft.mySTKE.entity.Programme;

@Service("programmeBusiness")
public class ProgrammeBusinessImpl implements ProgrammeBusiness{

	@Autowired
	@Qualifier("programmeDao")
	IProgrammeDao programmeDao;
	
	@Override
	public void createProgramme(Programme programme) {
		programmeDao.save(programme);
	}

	@Override
	public Programme findProgrammeByIdProjet(int idProj) {
		List<Programme> l = programmeDao.findByIdProjet(idProj);
		return l.get(0);
	}

	@Override
	public void updateProgramme(Programme programme) {
		programmeDao.update(programme);
	}

}
