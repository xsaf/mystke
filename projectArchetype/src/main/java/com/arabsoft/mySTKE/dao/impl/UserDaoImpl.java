package com.arabsoft.mySTKE.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.dao.IUserDao;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

@Repository("utilisateurDao")
public class UserDaoImpl implements IUserDao {

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public void save(Utilisateur utilisateur) {
		genericDao.save(utilisateur);
	}

	@Override
	public List<Utilisateur> findByIdFonction(String string) {
		return genericDao.findByPropriety("Utilisateur", "FONCTION_IDFON", string);
	}

	@Override
	public Utilisateur findById(String numMatrUser) {
		return (Utilisateur) genericDao.findById(Utilisateur.class, numMatrUser);
	}

}
