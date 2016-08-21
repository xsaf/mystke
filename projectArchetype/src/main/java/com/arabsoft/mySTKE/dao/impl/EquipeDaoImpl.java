package com.arabsoft.mySTKE.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.dao.IEquipeDao;
import com.arabsoft.mySTKE.entity.Equipe;

@Repository("equipeDao")
public class EquipeDaoImpl implements IEquipeDao {
	
	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;
	
	@Override
	public void save(Equipe equipe) {
		genericDao.save(equipe);
	}

	@Override
	public void update(Equipe equipe) {
		genericDao.update(equipe);
	}

	@Override
	public List<Equipe> findByIdProjet(int value) {
		return genericDao.findByPropriety(Equipe.class.getName(), "PROJET_IDPROJ", "" + value);
	}
	
	@Override
	public List<Equipe> findByIdUser(String s) {
		return genericDao.findByPropriety(Equipe.class.getName(), "UTILISATEUR_NUMMATRUSER", "'"+s+"'");
	}

}
