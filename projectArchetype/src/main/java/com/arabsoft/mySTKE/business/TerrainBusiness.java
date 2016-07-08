package com.arabsoft.mySTKE.business;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.entity.Terrain;

@Transactional
public interface TerrainBusiness {
	
	void createTerrain(Terrain terrain);
	Terrain findTerrainByIdProjet(int idProj);
	void updateTerrain(Terrain terrain); 

}
