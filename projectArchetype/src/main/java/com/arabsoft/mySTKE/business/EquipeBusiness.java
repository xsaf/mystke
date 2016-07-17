package com.arabsoft.mySTKE.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.entity.Equipe;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

@Transactional
public interface EquipeBusiness {

	void createEquipe(Equipe equipe);
	List<Utilisateur> selectAllUserByFonction(String value);
	Equipe findEquipeByIdProjet(int idProj);
	List<Utilisateur> selectAllUserByEquipe(int idProj);
	Utilisateur selectArchitecteByEquipe(int idProj);
	void updateEquipe(Equipe equipe);
	


}
