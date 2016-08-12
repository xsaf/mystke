package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.TerrainBusiness;
import com.arabsoft.mySTKE.dao.ITerrainDao;
import com.arabsoft.mySTKE.entity.Terrain;

@Service("terrainBusiness")
public class TerrainBusinessImpl implements TerrainBusiness {
	
	@Autowired
	@Qualifier("terrainDao")
	ITerrainDao terrainDao;

	@Override
	public void createTerrain(Terrain terrain) {
		terrainDao.save(terrain);
	}

	@Override
	public Terrain findTerrainByIdProjet(int idProj) {
		List<Terrain> l = terrainDao.findByIdProjet(idProj);
		return l.get(0);
	}

	@Override
	public void updateTerrain(Terrain terrain) {
		terrainDao.update(terrain);
	}
	
	

}
