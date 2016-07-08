package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.TerrainBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.Terrain;

@Service("terrainBusiness")
public class TerrainBusinessImpl implements TerrainBusiness {
	
	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public void createTerrain(Terrain terrain) {
		genericDao.save(terrain);
	}

	@Override
	public Terrain findTerrainByIdProjet(int idProj) {
		List<Terrain> l = genericDao.findByPropriety("Terrain","PROJET_IDPROJ",""+idProj);
		return l.get(0);
	}

	@Override
	public void updateTerrain(Terrain terrain) {
		genericDao.update(terrain);
	}
	
	

}
