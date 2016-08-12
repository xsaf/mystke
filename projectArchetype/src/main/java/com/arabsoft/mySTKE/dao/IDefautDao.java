package com.arabsoft.mySTKE.dao;

import java.util.List;

import com.arabsoft.mySTKE.entity.Defaut;

public interface IDefautDao {

	void save(Defaut defaut);

	void update(Defaut defaut);

	List<Defaut> findByIdProjet(int value);

}
