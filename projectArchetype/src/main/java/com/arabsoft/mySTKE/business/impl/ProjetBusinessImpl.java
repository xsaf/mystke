package com.arabsoft.mySTKE.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.ProjetBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.Equipe;
import com.arabsoft.mySTKE.entity.Projet;

@Service("projetBusiness")
public class ProjetBusinessImpl implements ProjetBusiness {

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public Projet createProjet(Projet projet) {
		return (Projet) genericDao.saveOrUpdate(projet);
	}

	@Override
	public Projet findProjetById(int idProj) {
		return (Projet) genericDao.findById(Projet.class, idProj);
	}

	@Override
	public Projet updateProjet(Projet projet) {
		return (Projet) genericDao.update(projet);
	}

	@Override
	public Projet findProjetByName(String nomProj) {
		List<Projet> projList = genericDao.findByPropriety("Projet", "NOMPROJ", "'" + nomProj + "'");
		return projList.get(0);
	}

	@Override
	public List<Projet> findAllProjetByUser(int idUti) {
		List<Projet> projList = new ArrayList<Projet>();
		List<Equipe> eqList = genericDao.findByPropriety("Equipe", "UTILISA_IDUTI", "" + idUti);
		for (int i = 0; i < eqList.size(); i++) {
			List<Projet> prList = genericDao.findByPropriety("Projet", "IDPROJ", "" + eqList.get(i).getProjet().getIdProj());
			projList.addAll(prList);
		}
		return projList;
	}

}
