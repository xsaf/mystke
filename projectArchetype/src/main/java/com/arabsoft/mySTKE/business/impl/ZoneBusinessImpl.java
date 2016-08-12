package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.ZoneBusiness;
import com.arabsoft.mySTKE.dao.IZoneDao;
import com.arabsoft.mySTKE.entity.Zone;

@Service("zoneBusiness")
public class ZoneBusinessImpl implements ZoneBusiness {
	
	@Autowired
	@Qualifier("zoneDao")
	IZoneDao zoneDao;

	@Override
	public void createZone(Zone zone) {
		zoneDao.save(zone);
	}

	@Override
	public Zone findZoneByIdProjet(int idProj) {
		List<Zone> l = zoneDao.findByIdProjet(idProj);
		return l.get(0);
	}
	
	

}
