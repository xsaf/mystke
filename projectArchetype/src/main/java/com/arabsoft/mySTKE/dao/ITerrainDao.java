package com.arabsoft.mySTKE.dao;

import java.util.List;

import com.arabsoft.mySTKE.entity.Terrain;

public interface ITerrainDao {

	void save(Terrain terrain);

	List<Terrain> findByIdProjet(int idProj);

	void update(Terrain terrain);

}
