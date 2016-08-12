package com.arabsoft.mySTKE.dao;

import java.util.List;

import com.arabsoft.mySTKE.entity.Zone;

public interface IZoneDao {

	void save(Zone zone);

	List<Zone> findByIdProjet(int idProj);

}
