package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.ReunionChantierBusiness;
import com.arabsoft.mySTKE.dao.IReunionChantierDao;
import com.arabsoft.mySTKE.entity.ReunionChantier;

@Service("reunionChantierBusiness")
public class ReunionChantierBusinessImpl implements ReunionChantierBusiness {

	@Autowired 
	@Qualifier("reunionChantierDao")
	IReunionChantierDao reunionChantierDao;
	
	@Override
	public void createReunionChantier(ReunionChantier reunionChantier) {
		reunionChantierDao.save(reunionChantier);
	}

	@Override
	public List<ReunionChantier> findReunionChantierByIdProjet(int idProj) {
		List<ReunionChantier> l = reunionChantierDao.findByIdProjet(idProj);
		return l;
	}

}
