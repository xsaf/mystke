package com.arabsoft.mySTKE.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.ProjetBusiness;
import com.arabsoft.mySTKE.dao.IEquipeDao;
import com.arabsoft.mySTKE.dao.IProjetDao;
import com.arabsoft.mySTKE.entity.Equipe;
import com.arabsoft.mySTKE.entity.Projet;

@Service("projetBusiness")
public class ProjetBusinessImpl implements ProjetBusiness {

	@Autowired
	@Qualifier("projetDao")
	IProjetDao projetDao;
	
	@Autowired
	@Qualifier("equipeDao")
	IEquipeDao equipeDao;

	@Override
	public Projet createProjet(Projet projet) {
		return (Projet) projetDao.save(projet);
	}

	@Override
	public Projet findProjetById(int idProj) {
		return (Projet) projetDao.findById(idProj);
	}

	@Override
	public Projet updateProjet(Projet projet) {
		return (Projet) projetDao.update(projet);
	}

	@Override
	public Projet findProjetByName(String nomProj) {
		List<Projet> projList = projetDao.findByName(nomProj);
		return projList.get(0);
	}

	@Override
	public List<Projet> findAllProjetByUser(String numMatrUser) {
		List<Projet> projList = new ArrayList<Projet>();
		List<Equipe> eqList = equipeDao.findByIdUser(numMatrUser);
		for (int i = 0; i < eqList.size(); i++) {
			Projet pr = projetDao.findById(eqList.get(i).getProjet().getIdProj());
			projList.add(pr);
		}
		return projList;
	}


}
