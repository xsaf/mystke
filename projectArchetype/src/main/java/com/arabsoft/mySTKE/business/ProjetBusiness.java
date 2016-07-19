package com.arabsoft.mySTKE.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.entity.Projet;

@Transactional
public interface ProjetBusiness {
	
	Projet createProjet(Projet projet);
	Projet findProjetById(int idProj);
	Projet updateProjet(Projet projet);
	Projet findProjetByName(String nomProj);
	List<Projet> findAllProjetByUser(String string); 

}
