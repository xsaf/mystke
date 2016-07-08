package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.ZoneBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.Zone;

@Service("zoneBusiness")
public class ZoneBusinessImpl implements ZoneBusiness {
	
	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public void createZone(Zone zone) {
		genericDao.save(zone);
	}

	@Override
	public Zone findZoneByIdProjet(int idProj) {
		List<Zone> l = genericDao.findByPropriety("Zone","PROJET_IDPROJ",""+idProj);
		return l.get(0);
	}
	
	

}
