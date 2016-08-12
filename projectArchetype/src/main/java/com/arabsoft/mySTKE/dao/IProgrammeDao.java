package com.arabsoft.mySTKE.dao;

import java.util.List;

import com.arabsoft.mySTKE.entity.Programme;

public interface IProgrammeDao {

	void save(Programme programme);

	List<Programme> findByIdProjet(int idProj);

	void update(Programme programme);

}
