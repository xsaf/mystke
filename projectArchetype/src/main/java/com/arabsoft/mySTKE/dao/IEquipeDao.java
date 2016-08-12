package com.arabsoft.mySTKE.dao;

import java.util.List;

import com.arabsoft.mySTKE.entity.Equipe;

public interface IEquipeDao {

	void save(Equipe equipe);

	void update(Equipe equipe);

	List<Equipe> findByIdProjet(int value);

	List<Equipe> findByIdUser(String s);

}
