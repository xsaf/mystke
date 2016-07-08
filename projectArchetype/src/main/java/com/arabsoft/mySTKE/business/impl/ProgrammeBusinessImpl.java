package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.ProgrammeBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.Programme;
import com.arabsoft.mySTKE.entity.Zone;

@Service("programmeBusiness")
public class ProgrammeBusinessImpl implements ProgrammeBusiness{

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;
	
	@Override
	public void createProgramme(Programme programme) {
		genericDao.save(programme);
	}

	@Override
	public Programme findProgrammeByIdProjet(int idProj) {
		List<Programme> l = genericDao.findByPropriety("Programme","PROJET_IDPROJ",""+idProj);
		return l.get(0);
	}

	@Override
	public void updateProgramme(Programme programme) {
		genericDao.update(programme);
	}

}
