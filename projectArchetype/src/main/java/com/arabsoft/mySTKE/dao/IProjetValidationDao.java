package com.arabsoft.mySTKE.dao;

import java.util.List;

import com.arabsoft.mySTKE.entity.ProjetValidation;

public interface IProjetValidationDao {

	void save(ProjetValidation projetValidation);

	List<ProjetValidation> findByIdProjetAndEtat(int idProj, int etat);

	void update(ProjetValidation projetValidation);

}
