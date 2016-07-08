package com.arabsoft.mySTKE.security.habilitation.model;

// Generated 25 janv. 2013 15:44:07 by Hibernate Tools 3.4.0.CR1

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Personnel generated by hbm2java
 */
@Entity
@Table(name = "UTILSATEUR")
public class Utilisateur implements java.io.Serializable, UserDetails {

	private String numMatrUser;
	protected String username;
	protected String userLastname;
	protected Integer userStatus;
	private boolean codStatUser;
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);
	private String password;

	public Utilisateur() {

	}

	public Utilisateur(String numMatrUser) {

		this.numMatrUser = numMatrUser;
	}

	public Utilisateur(String numMatrUser, short codStrcStrc,
			boolean codStatUser, String codTypUser) {
		this.numMatrUser = numMatrUser;
		this.codStatUser = codStatUser;

	}

	@Id
	@Column(name = "NUM_MATR_USER", length = 10)
	public String getNumMatrUser() {
		return this.numMatrUser;
	}

	public void setNumMatrUser(String numMatrUser) {
		this.numMatrUser = numMatrUser;
	}

	@Column(name = "COD_STAT_USER", nullable = false, precision = 1, scale = 0)
	public boolean isCodStatUser() {
		return this.codStatUser;
	}

	public void setCodStatUser(boolean codStatUser) {
		this.codStatUser = codStatUser;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "utilisateur")
	public Set<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	@Transient
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return getActivRoles();

	}

	@Transient
	public Set getActivRoles() {
		Set activRoles = new HashSet();
		Iterator it = getUserRoles().iterator();
		while (it.hasNext()) {
			UserRole userRole = (UserRole) it.next();
			if (userRole.getUserRoleSatus().equals(new Integer(1))) {
				activRoles.add(userRole.getProfil());
			}
		}
		return activRoles;
	}

	public void setUsername(String username) {
		this.numMatrUser = username;
	}

	@Transient
	public String getUsername() {
		return this.numMatrUser;
	}

	public void setPassword(String password) {
		this.password =password;
	}

	@Column(name="LIB_PASSWORD_USER")
	public String getPassword() {
		return this.password;
	}

	@Transient
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Transient
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Transient
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Transient
	@Override
	public boolean isEnabled() {
		return true;
	}

	@Transient
	public String getUserLastname() {
		return userLastname;
	}

	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}

}
