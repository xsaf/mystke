package com.arabsoft.mySTKE.dao;

import java.util.List;
import java.util.Set;

import com.arabsoft.mySTKE.security.habilitation.model.UserRole;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

public interface IUserDao {

	List<Utilisateur> findByIdFonction(String string);

	Utilisateur findById(String numMatrUser);

	Utilisateur save(Utilisateur utilisateur);

	List<Utilisateur> findAll();

	void save(UserRole userRole);

	void remove(UserRole userRole);

	void remove(Utilisateur utilisateur);

	Utilisateur update(Utilisateur utilisateur);

}
