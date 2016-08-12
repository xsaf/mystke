package com.arabsoft.mySTKE.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.dao.ITerrainDao;
import com.arabsoft.mySTKE.entity.Terrain;

@Repository("terrainDao")
public class TerrainDaoImpl implements ITerrainDao{

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public void save(Terrain terrain) {
		genericDao.save(terrain);
	}

	@Override
	public List<Terrain> findByIdProjet(int idProj) {
		return genericDao.findByPropriety("Terrain","PROJET_IDPROJ",""+idProj);
	}

	@Override
	public void update(Terrain terrain) {
		genericDao.update(terrain);
	}
	
}
