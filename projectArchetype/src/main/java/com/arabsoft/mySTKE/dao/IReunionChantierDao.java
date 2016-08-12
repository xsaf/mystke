package com.arabsoft.mySTKE.dao;

import java.util.List;

import com.arabsoft.mySTKE.entity.ReunionChantier;

public interface IReunionChantierDao {

	void save(ReunionChantier reunionChantier);

	List<ReunionChantier> findByIdProjet(int idProj);

}
