package com.arabsoft.mySTKE.security.habilitation.dao;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;


public abstract interface UserDao {

	public abstract Utilisateur getUser(String paramString);
	
	@Transactional(value="transactionManager",readOnly=true)
	public abstract UserDetails loadUserByUsername(String paramString)
			throws UsernameNotFoundException;

	public abstract List getAllUsers(Utilisateur paramPersonnel);

	public abstract void addUser(Utilisateur paramPersonnel);

	public abstract void updateUser(Utilisateur paramPersonnel);

	public abstract void removeUser(String paramString);

	public abstract Utilisateur getUser(String username, String password);

}