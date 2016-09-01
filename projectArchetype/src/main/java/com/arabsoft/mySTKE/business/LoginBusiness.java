package com.arabsoft.mySTKE.business;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

public interface LoginBusiness {
	@Transactional
	public Utilisateur findUser(String matriculeUser);

	@Transactional
	public Utilisateur findUser(String username, String password);
}
