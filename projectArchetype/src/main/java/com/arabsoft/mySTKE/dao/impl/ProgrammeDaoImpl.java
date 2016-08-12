package com.arabsoft.mySTKE.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.dao.IProgrammeDao;
import com.arabsoft.mySTKE.entity.Programme;

@Repository("programmeDao")
public class ProgrammeDaoImpl implements IProgrammeDao{

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;
	
	@Override
	public void save(Programme programme) {
		genericDao.save(programme);
	}

	@Override
	public List<Programme> findByIdProjet(int idProj) {
		return genericDao.findByPropriety("Programme","PROJET_IDPROJ",""+idProj);
	}

	@Override
	public void update(Programme programme) {
		genericDao.update(programme);
	}
	
	
}
