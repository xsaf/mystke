package com.arabsoft.mySTKE.security.habilitation.model;

// Generated 25 janv. 2013 15:44:07 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

/**
 * UtilisateurProfil generated by hbm2java
 */
@Entity
@Table(name = "UTILISATEUR_PROFIL")
public class UserRole implements java.io.Serializable {

	private UserRoleId id;
	private Profil profil;
	private Utilisateur utilisateur;
	private Date datDadhUtpr;
	private Date datFadhUtpr;
	private boolean boolEtatUtpr;
	private Integer userRoleSatus = 1;
	private boolean status;
	private String userStatus;

	public UserRole() {
	}

	public UserRole(UserRoleId id, Profil profil, Utilisateur utilisateur,
			boolean boolEtatUtpr) {
		this.id = id;
		this.profil = profil;
		this.utilisateur = utilisateur;
		this.boolEtatUtpr = boolEtatUtpr;
	}

	public UserRole(UserRoleId id, Profil profil, Utilisateur utilisateur,
			Date datDadhUtpr, Date datFadhUtpr, boolean boolEtatUtpr) {
		this.id = id;
		this.profil = profil;
		this.utilisateur = utilisateur;
		this.datDadhUtpr = datDadhUtpr;
		this.datFadhUtpr = datFadhUtpr;
		this.boolEtatUtpr = boolEtatUtpr;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codPflPfl", column = @Column(name = "COD_PFL_PFL", nullable = false, length = 10)),
			@AttributeOverride(name = "numMatrUser", column = @Column(name = "NUM_MATR_USER", nullable = false, length = 10)) })
	public UserRoleId getId() {
		return this.id;
	}

	public void setId(UserRoleId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COD_PFL_PFL", nullable = false, insertable = false, updatable = false)
	public Profil getProfil() {
		return this.profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NUM_MATR_USER", nullable = false, insertable = false, updatable = false)
	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_DADH_UTPR", length = 7)
	public Date getDatDadhUtpr() {
		return this.datDadhUtpr;
	}

	public void setDatDadhUtpr(Date datDadhUtpr) {
		this.datDadhUtpr = datDadhUtpr;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_FADH_UTPR", length = 7)
	public Date getDatFadhUtpr() {
		return this.datFadhUtpr;
	}

	public void setDatFadhUtpr(Date datFadhUtpr) {
		this.datFadhUtpr = datFadhUtpr;
	}

	@Column(name = "BOOL_ETAT_UTPR", nullable = false, precision = 1, scale = 0)
	public boolean isBoolEtatUtpr() {
		return this.boolEtatUtpr;
	}

	public void setBoolEtatUtpr(boolean boolEtatUtpr) {
		this.boolEtatUtpr = boolEtatUtpr;
	}

	public void setUserRoleSatus(Integer userRoleSatus) {
		this.userRoleSatus = userRoleSatus;
	}

	@Transient
	public Integer getUserRoleSatus() {
		this.userRoleSatus = 0;
		if (boolEtatUtpr == true)
			this.userRoleSatus = 1;
		return this.userRoleSatus;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Transient
	public boolean isStatus() {
		return this.status;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	@Transient
	public String getUserStatus() {
		if (this.userRoleSatus.intValue() == 1) {
			return "activ�";
		}

		return "d�sactiv�";
	}

	

}
