package com.arabsoft.mySTKE.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.dao.IZoneDao;
import com.arabsoft.mySTKE.entity.Zone;

@Repository("zoneDao")
public class ZoneDaoImpl implements IZoneDao{

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public void save(Zone zone) {
		genericDao.save(zone);
	}

	@Override
	public List<Zone> findByIdProjet(int idProj) {
		return genericDao.findByPropriety(Zone.class.getName(),"PROJET_IDPROJ",""+idProj);
	}
	
}
