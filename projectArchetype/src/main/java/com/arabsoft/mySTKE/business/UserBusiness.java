package com.arabsoft.mySTKE.business;

import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.security.habilitation.model.UserRole;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

public interface UserBusiness {
	@Transactional
	Utilisateur createUser(Utilisateur utilisateur);
	
	@Transactional
	List<Utilisateur> findAllUser();

	@Transactional
	void createUserRole(UserRole userRole);

	void deleteUserRole(UserRole userRole);

	void deleteUser(Utilisateur selectedUtilisateur);

	@Transactional
	Utilisateur updateUser(Utilisateur utilisateur);

}
