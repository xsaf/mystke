package com.arabsoft.mySTKE.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.entity.Equipe;
import com.arabsoft.mySTKE.entity.Utilisa;

@Transactional
public interface EquipeBusiness {

	void createEquipe(Equipe equipe);
	List<Utilisa> selectAllUserByFonction(String value);
	Equipe findEquipeByIdProjet(int idProj);
	List<Utilisa> selectAllUserByEquipe(int idProj);
	Utilisa selectArchitecteByEquipe(int idProj);
	void updateEquipe(Equipe equipe);
	


}
