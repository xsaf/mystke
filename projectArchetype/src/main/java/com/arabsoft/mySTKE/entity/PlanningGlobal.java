package com.arabsoft.mySTKE.entity;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PlanningGlobal {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idPlanning;
	private Date dateDebut;
	private Date dateFin;
	private String descPlanning;
	private Boolean valider;
	private Boolean ValideConseil;
	private Boolean ValideRST;
	@OneToMany(mappedBy = "planningGlobal")
	public Collection<PlanningActivite> planningActivites;
	@OneToMany(mappedBy = "planningGlobal")
	private Collection<Modification> modifications;
	@ManyToOne
	public Projet projet;
	
	public PlanningGlobal() {
	}

	public int getIdPlanning() {
		return idPlanning;
	}

	public void setIdPlanning(int idPlanning) {
		this.idPlanning = idPlanning;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Collection<PlanningActivite> getPlanningActivites() {
		return planningActivites;
	}

	public void setPlanningActivites(Collection<PlanningActivite> planningActivites) {
		this.planningActivites = planningActivites;
	}

	public Collection<Modification> getModifications() {
		return modifications;
	}

	public void setModifications(Collection<Modification> modifications) {
		this.modifications = modifications;
	}

	public String getDescPlanning() {
		return descPlanning;
	}

	public void setDescPlanning(String descPlanning) {
		this.descPlanning = descPlanning;
	}

	public Boolean getValider() {
		return valider;
	}

	public void setValider(Boolean valider) {
		this.valider = valider;
	}

	public Boolean getValideConseil() {
		return ValideConseil;
	}

	public void setValideConseil(Boolean valideConseil) {
		ValideConseil = valideConseil;
	}

	public Boolean getValideRST() {
		return ValideRST;
	}

	public void setValideRST(Boolean valideRST) {
		ValideRST = valideRST;
	}
	
	

}