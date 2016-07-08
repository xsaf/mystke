package com.arabsoft.mySTKE.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.EquipeBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.Equipe;
import com.arabsoft.mySTKE.entity.Utilisa;

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
	public List<Utilisa> selectAllUserByFonction(String value) {
		return genericDao.findByPropriety("Utilisa", "FONCTION_IDFON", value);
	}

	@Override
	public Equipe findEquipeByIdProjet(int idProj) {
		return (Equipe) genericDao.findByPropriety("Equipe", "PROJET_IDPROJ", "" + idProj);
	}

	@Override
	public List<Utilisa> selectAllUserByEquipe(int idProj) {
		List<Equipe> eqList = genericDao.findByPropriety("Equipe", "PROJET_IDPROJ", "" + idProj);
		List<Utilisa> utiList = new ArrayList<Utilisa>();
		for (int i = 0; i < eqList.size(); i++) {
			utiList.add((Utilisa) genericDao.findById(Utilisa.class, eqList.get(i).getUtilisa().getIdUti()));
		}
		return utiList;
	}

	@Override
	public Utilisa selectArchitecteByEquipe(int idProj) {
		List<Equipe> eqList = genericDao.findByPropriety("Equipe", "PROJET_IDPROJ", "" + idProj);
		List<Utilisa> utiList = new ArrayList<Utilisa>();
		for (int i = 0; i < eqList.size(); i++) {
			if (eqList.get(i).getUtilisa().getIdUti() == 5) {
				utiList.add((Utilisa) genericDao.findById(Utilisa.class, eqList.get(i).getUtilisa().getIdUti()));
			}
		}
		return utiList.get(0);
	}

}
