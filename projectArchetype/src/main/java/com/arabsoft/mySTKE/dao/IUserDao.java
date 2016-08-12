package com.arabsoft.mySTKE.dao;

import java.util.List;

import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

public interface IUserDao {

	List<Utilisateur> findByIdFonction(String string);

	Utilisateur findById(String numMatrUser);

	void save(Utilisateur utilisateur);

}
