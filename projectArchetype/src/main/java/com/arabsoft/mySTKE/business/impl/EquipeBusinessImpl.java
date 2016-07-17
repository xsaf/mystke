package com.arabsoft.mySTKE.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.EquipeBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.Equipe;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

@Service("equipeBusiness")
public class EquipeBusinessImpl implements EquipeBusiness {

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public void createEquipe(Equipe equipe) {
		genericDao.save(equipe);
	}
	
	@Override
	public void updateEquipe(Equipe equipe) {
		genericDao.update(equipe);
	}


	@Override
	public List<Utilisateur> selectAllUserByFonction(String value) {
		return genericDao.findByPropriety("Utilisateur", "FONCTION_IDFON", value);
	}

	@Override
	public Equipe findEquipeByIdProjet(int idProj) {
		return (Equipe) genericDao.findByPropriety("Equipe", "PROJET_IDPROJ", "" + idProj);
	}

	@Override
	public List<Utilisateur> selectAllUserByEquipe(int idProj) {
		List<Equipe> eqList = genericDao.findByPropriety("Equipe", "PROJET_IDPROJ", "" + idProj);
		List<Utilisateur> utiList = new ArrayList<Utilisateur>();
		for (int i = 0; i < eqList.size(); i++) {
			utiList.add((Utilisateur) genericDao.findById(Utilisateur.class, eqList.get(i).getUtilisateur().getIdUti()));
		}
		return utiList;
	}

	@Override
	public Utilisateur selectArchitecteByEquipe(int idProj) {
		List<Equipe> eqList = genericDao.findByPropriety("Equipe", "PROJET_IDPROJ", "" + idProj);
		List<Utilisateur> utiList = new ArrayList<Utilisateur>();
		for (int i = 0; i < eqList.size(); i++) {
			if (eqList.get(i).getUtilisateur().getIdUti() == 5) {
				utiList.add((Utilisateur) genericDao.findById(Utilisateur.class, eqList.get(i).getUtilisateur().getIdUti()));
			}
		}
		return utiList.get(0);
	}

}
