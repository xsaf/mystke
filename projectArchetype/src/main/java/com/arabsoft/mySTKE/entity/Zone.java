package com.arabsoft.mySTKE.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Zone {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idZone;
	private String adresseZone;
	private String villeZone;
	private String paysZone;
	private String xZone;
	private String yZone;
	@OneToMany(mappedBy = "zone")
	private Set<Terrain> terrains;
	@ManyToOne
	private Projet projet;

	public Zone() {
	}

	public int getIdZone() {
		return idZone;
	}

	public void setIdZone(int idZone) {
		this.idZone = idZone;
	}

	public String getAdresseZone() {
		return adresseZone;
	}

	public void setAdresseZone(String adresseZone) {
		this.adresseZone = adresseZone;
	}

	public String getVilleZone() {
		return villeZone;
	}

	public void setVilleZone(String villeZone) {
		this.villeZone = villeZone;
	}

	public String getPaysZone() {
		return paysZone;
	}

	public void setPaysZone(String paysZone) {
		this.paysZone = paysZone;
	}

	public String getxZone() {
		return xZone;
	}

	public void setxZone(String xZone) {
		this.xZone = xZone;
	}

	public String getyZone() {
		return yZone;
	}

	public void setyZone(String yZone) {
		this.yZone = yZone;
	}

	public Set<Terrain> getTerrains() {
		return terrains;
	}

	public void setTerrains(Set<Terrain> terrains) {
		this.terrains = terrains;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	

}