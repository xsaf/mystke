package com.arabsoft.mySTKE.security.habilitation.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.security.habilitation.dao.UserDao;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

@Repository(value = "userDao")
public class UserDaoImpl implements UserDao, UserDetailsService {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@SuppressWarnings("deprecation")
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		System.out.println("Getting access details from Utilisateur dao !!");

		/*
		 * UserDetails user = new User( username, "password", true, true, true,
		 * true, Arrays.asList((new GrantedAuthority[] { new
		 * GrantedAuthorityImpl( "ROLE_USER") })));
		 */
		Utilisateur utilisateur = (Utilisateur) sessionFactory
				.getCurrentSession().get(Utilisateur.class, username);
		if (utilisateur == null)
			throw new UsernameNotFoundException("login inexistant !");
		else
			
		return utilisateur;
	}

	@Override
	public Utilisateur getUser(String username) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Utilisateur utilisateur = (Utilisateur) session.load(Utilisateur.class,
				username);
		session.close();
		return utilisateur;
	}

	@Override
	public List getAllUsers(Utilisateur paramPersonnel) {
		return this.sessionFactory.getCurrentSession()
				.createQuery("from Utilisateur").list();
	}

	@Override
	public void addUser(Utilisateur utilisateur) {
		this.sessionFactory.getCurrentSession().save(utilisateur);

	}

	@Override
	public void updateUser(Utilisateur utilisateur) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUser(String utilisateurId) {
		Utilisateur utilisateur = (Utilisateur) sessionFactory
				.getCurrentSession().load(Utilisateur.class, utilisateurId);
		if (null != utilisateur) {
			this.sessionFactory.getCurrentSession().delete(utilisateur);
		}

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}