package com.arabsoft.mySTKE.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.dao.IProjetDao;
import com.arabsoft.mySTKE.entity.Equipe;
import com.arabsoft.mySTKE.entity.Projet;

@Repository("projetDao")
public class ProjetDaoImpl implements IProjetDao{

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public Projet save(Projet projet) {
		return (Projet) genericDao.saveOrUpdate(projet);
	}

	@Override
	public Projet findById(int idProj) {
		return (Projet) genericDao.findById(Projet.class, idProj);
	}

	@Override
	public Projet update(Projet projet) {
		return (Projet) genericDao.update(projet);
	}

	@Override
	public List<Projet> findByName(String nomProj) {
		 return genericDao.findByPropriety(Projet.class.getName(), "NOMPROJ", "'" + nomProj + "'");
	}


	
	
}
