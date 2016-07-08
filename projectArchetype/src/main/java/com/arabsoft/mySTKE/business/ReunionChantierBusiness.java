package com.arabsoft.mySTKE.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.entity.ReunionChantier;

@Transactional
public interface ReunionChantierBusiness {

	void createReunionChantier(ReunionChantier reunionChantier);
	List<ReunionChantier> findReunionChantierByIdProjet(int idProj);


}
