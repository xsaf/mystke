package com.arabsoft.mySTKE.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.entity.Defaut;

@Transactional
public interface DefautBusiness {

	void createDefaut(Defaut defaut);
	List<Defaut> findDefautsByIdProjet(int idProj);
	void updateDefaut(Defaut defaut);

}
