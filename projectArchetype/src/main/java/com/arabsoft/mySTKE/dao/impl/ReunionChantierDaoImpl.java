package com.arabsoft.mySTKE.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.dao.IReunionChantierDao;
import com.arabsoft.mySTKE.entity.ReunionChantier;

@Repository("reunionChantierDao")
public class ReunionChantierDaoImpl implements IReunionChantierDao{

	@Autowired 
	@Qualifier("genericDao")
	IDao genericDao;
	
	@Override
	public void save(ReunionChantier reunionChantier) {
		genericDao.save(reunionChantier);
	}

	@Override
	public List<ReunionChantier> findByIdProjet(int idProj) {
		return genericDao.findByPropriety(ReunionChantier.class.getName(), "PROJET_IDPROJ",
				"" + idProj);
	}

	
}
