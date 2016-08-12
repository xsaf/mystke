package com.arabsoft.mySTKE.dao;

import java.util.List;

import com.arabsoft.mySTKE.entity.Avis;

public interface IAvisDao {

	void save(Avis avis);

	List<Avis> findByIdProjet(int value);

	void update(Avis selectedAvis);

}
