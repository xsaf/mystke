package com.arabsoft.mySTKE.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.EquipeBusiness;
import com.arabsoft.mySTKE.dao.IEquipeDao;
import com.arabsoft.mySTKE.dao.IUserDao;
import com.arabsoft.mySTKE.entity.Equipe;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

@Service("equipeBusiness")
public class EquipeBusinessImpl implements EquipeBusiness {

	@Autowired
	@Qualifier("equipeDao")
	IEquipeDao equipeDao;
	
	@Autowired
	@Qualifier("utilisateurDao")
	IUserDao userDao;

	@Override
	public void createEquipe(Equipe equipe) {
		equipeDao.save(equipe);
	}

	@Override
	public void updateEquipe(Equipe equipe) {
		equipeDao.update(equipe);
	}

	@Override
	public List<Utilisateur> selectAllUserByFonction(String value) {
		return userDao.findByIdFonction(value);
	}

	@Override
	public Equipe findEquipeByIdProjet(int idProj) {
		return (Equipe) equipeDao.findByIdProjet(idProj).get(0);
	}

	@Override
	public List<Utilisateur> selectAllUserByEquipe(int idProj) {
		List<Equipe> eqList = equipeDao.findByIdProjet(idProj);
		List<Utilisateur> utiList = new ArrayList<Utilisateur>();
		for (int i = 0; i < eqList.size(); i++) {
			utiList.add((Utilisateur) userDao.findById(eqList.get(i).getUtilisateur().getNumMatrUser()));
		}
		return utiList;
	}

	@Override
	public Utilisateur selectArchitecteByEquipe(int idProj) {
		List<Equipe> eqList = equipeDao.findByIdProjet(idProj);
		List<Utilisateur> utiList = new ArrayList<Utilisateur>();
		for (int i = 0; i < eqList.size(); i++) {
			if (eqList.get(i).getUtilisateur().getIdUti() == 5) {
				utiList.add((Utilisateur) userDao.findById(eqList.get(i).getUtilisateur().getNumMatrUser()));
			}
		}
		return utiList.get(0);
	}

}
