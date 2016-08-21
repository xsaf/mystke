package com.arabsoft.mySTKE.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.security.habilitation.model.Profil;

@Transactional
public interface ProfilBusiness {

	List<Profil> findAllProfil();

}
