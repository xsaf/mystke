package com.arabsoft.mySTKE.dao;

import java.util.List;

import com.arabsoft.mySTKE.entity.Projet;

public interface IProjetDao {

	Projet save(Projet projet);

	Projet findById(int idProj);

	Projet update(Projet projet);

	List<Projet> findByName(String nomProj);

}
