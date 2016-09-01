package com.arabsoft.mySTKE.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.dao.IUserDao;
import com.arabsoft.mySTKE.entity.User;
import com.arabsoft.mySTKE.security.habilitation.model.UserRole;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

@Repository("utilisateurDao")
public class UserDaoImpl implements IUserDao {

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public Utilisateur save(Utilisateur utilisateur) {
		utilisateur = (Utilisateur) genericDao.save(utilisateur);
		return utilisateur;
	}

	@Override
	public List<Utilisateur> findByIdFonction(String string) {
		return genericDao.findByPropriety("Utilisateur", "FONCTION_IDFON", string);
	}

	@Override
	public Utilisateur findById(String numMatrUser) {
		return (Utilisateur) genericDao.findById(Utilisateur.class, numMatrUser);
	}

	@Override
	public List<Utilisateur> findAll() {
		return genericDao.findAll(Utilisateur.class);
	}

	@Override
	public void save(UserRole userRole) {
		 genericDao.save(userRole);		
	}
	
	@Override
	public void remove(UserRole userRole) {
		 genericDao.remove(userRole,"NUM_MATR_USER",userRole.getUtilisateur().getNumMatrUser());		
	}

	@Override
	public void remove(Utilisateur utilisateur) {
		 genericDao.remove(utilisateur,"NUMMATRUSER",utilisateur.getNumMatrUser());		
	}

	@Override
	public Utilisateur update(Utilisateur utilisateur) {
		return (Utilisateur) genericDao.saveOrUpdate(utilisateur);
	}

}
