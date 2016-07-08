package com.arabsoft.mySTKE.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.entity.Avis;

@Transactional
public interface AvisBusiness {

	void createAvis(Avis avis);

	List<Avis> findAvisByIdProjet(int idProj);

}
