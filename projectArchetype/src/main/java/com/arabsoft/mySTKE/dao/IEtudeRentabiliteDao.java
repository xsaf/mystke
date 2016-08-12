package com.arabsoft.mySTKE.dao;

import java.util.List;

import com.arabsoft.mySTKE.entity.EtudeRentabillite;

public interface IEtudeRentabiliteDao {

	void save(EtudeRentabillite etude);

	List<EtudeRentabillite> findByIdProjet(int idProj);

}
