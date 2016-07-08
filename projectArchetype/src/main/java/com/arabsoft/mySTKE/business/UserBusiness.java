package com.arabsoft.mySTKE.business;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

public interface UserBusiness {
	@Transactional
	void createUser(Utilisateur utilisateur);

}
