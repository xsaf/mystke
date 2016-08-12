package com.arabsoft.mySTKE.dao;

import java.util.List;

import com.arabsoft.mySTKE.entity.AvantProjetDetaille;

public interface IAvantProjetDetailleDao {

	void save(AvantProjetDetaille avantProjetDetaille);

	List<AvantProjetDetaille> findByIdProjet(int value);

	void update(AvantProjetDetaille avantProjetDetaille);

}
