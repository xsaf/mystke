package com.arabsoft.mySTKE.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import com.arabsoft.mySTKE.business.AbsDocBusiness;
import com.arabsoft.mySTKE.business.ClientBusiness;
import com.arabsoft.mySTKE.business.DefautBusiness;
import com.arabsoft.mySTKE.business.PlanningBusiness;
import com.arabsoft.mySTKE.business.ProjetBusiness;
import com.arabsoft.mySTKE.entity.AbsDoc;
import com.arabsoft.mySTKE.entity.Appartement;
import com.arabsoft.mySTKE.entity.Bureau;
import com.arabsoft.mySTKE.entity.Client;
import com.arabsoft.mySTKE.entity.Defaut;
import com.arabsoft.mySTKE.entity.Dossier;
import com.arabsoft.mySTKE.entity.Fonction;
import com.arabsoft.mySTKE.entity.Immeuble;
import com.arabsoft.mySTKE.entity.Planning;
import com.arabsoft.mySTKE.entity.Projet;
import com.arabsoft.mySTKE.entity.ProjetValidation;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;
import com.arabsoft.utils.FacesUtil;

@ManagedBean(name = "receptionCtr")
@ViewScoped
public class ReceptionCtr {

	private Utilisateur utilisateur = new Utilisateur();
	private Fonction fonction = new Fonction();
	private Projet projet = new Projet();
	private Client client = new Client();
	private ProjetValidation projetValidation = new ProjetValidation();
	private Blocs blocs = new Blocs();
	private String immAppBur;
	private int idImmAppBur;
	private Defaut defaut = new Defaut();
	private List<Defaut> defauts;
	private List<Client> clients;
	private Defaut selectedDefaut = new Defaut();
	private String selectedReserve;
	private String selectedTravaux;
	private AbsDoc absDoc = new Dossier();
	private Planning planning = new Planning();

	@ManagedProperty(value = "#{planningBusiness}")
	private PlanningBusiness planningBusiness;

	@ManagedProperty(value = "#{projetBusiness}")
	private ProjetBusiness projetBusiness;

	@ManagedProperty(value = "#{defautBusiness}")
	private DefautBusiness defautBusiness;

	@ManagedProperty(value = "#{clientBusiness}")
	private ClientBusiness clientBusiness;

	@ManagedProperty(value = "#{absDocBusiness}")
	private AbsDocBusiness absDocBusiness;

	@ManagedProperty(value = "#{gedCtr}")
	private GedCtr gedCtr;

	@PostConstruct
	public void initialisation() {

		int idprojet = (int) FacesUtil.getSessionMapValue("idprojet");
		projet.setIdProj(idprojet);

		projet = projetBusiness.findProjetById(projet.getIdProj());

		if (projet.getDescEtat() >= 412) {
			absDoc = absDocBusiness.findAbsDocByIdProjet(projet.getIdProj());
			gedCtr.setProjetFolder(absDoc.getNumAbsDoc());
			absDoc = absDocBusiness.findAbsDocByEtapeProjet(projet.getIdProj(), "Cloture du projet");
			gedCtr.setFolder(absDoc.getNumAbsDoc());
		}
		if (projet.getDescEtat() >= 511) {
			defauts = defautBusiness.findDefautsByIdProjet(projet.getIdProj());
		}
		if (projet.getDescEtat() >= 523) {
			clients = clientBusiness.findClientsByIdProjet(projet.getIdProj());
		}

	}
	
	public void notification(Projet projet) {
	}

	public void createFolder() {
		gedCtr.setProjet(projet);
		gedCtr.createFolder();
	}

	public void createVisiteNotifier() {
		projet.setDescEtat(511);
		projet = projetBusiness.updateProjet(projet);
	}

	public void createDefaut() {
		switch (immAppBur) {
		case "Immeuble":
			Immeuble immeuble = new Immeuble();
			immeuble.setIdImm(idImmAppBur);
			defaut.setImmeuble(immeuble);
			break;
		case "Appartement":
			Appartement appartement = new Appartement();
			appartement.setIdApp(idImmAppBur);
			defaut.setAppartement(appartement);
			break;
		case "Bureau":
			Bureau bureau = new Bureau();
			bureau.setIdBur(idImmAppBur);
			defaut.setBureau(bureau);
			break;
		}
		defaut.setProjet(projet);
		defautBusiness.createDefaut(defaut);
	}

	public void updateDefautTravaux() {
		selectedDefaut.setTravauxDefaut(selectedTravaux);
		defautBusiness.updateDefaut(selectedDefaut);
	}

	public void updateDefautReserve() {
		selectedDefaut.setLeveeReserve(selectedReserve);
		defautBusiness.updateDefaut(selectedDefaut);
	}

	public void createReceptionProvisoireNotifier() {
		projet.setDescEtat(512);
		projet = projetBusiness.updateProjet(projet);
	}

	public void createReceptionFinaleNotifier() {
		projet.setDescEtat(513);
		projet = projetBusiness.updateProjet(projet);
	}

	public void createPlanRecollementNotifier() {
		projet.setDescEtat(514);
		projet = projetBusiness.updateProjet(projet);
	}

	public void validerCorrespondanceTravauxPlansNotifier() {
		projet.setDescEtat(515);
		projet = projetBusiness.updateProjet(projet);
	}

	public void createDemandeOccupationNotifier() {
		projet.setDescEtat(516);
		projet = projetBusiness.updateProjet(projet);
	}

	public void createPermisOccupationNotifier() {
		projet.setDescEtat(517);
		projet = projetBusiness.updateProjet(projet);
	}

	public void createDemandeImmatriculationNotifier() {
		projet.setDescEtat(518);
		projet = projetBusiness.updateProjet(projet);
	}

	public void createPermisImmatriculationNotifier() {
		projet.setDescEtat(519);
		projet = projetBusiness.updateProjet(projet);
	}

	public void createDefautClientNotifier() {
		switch (immAppBur) {
		case "Immeuble":
			Immeuble immeuble = new Immeuble();
			immeuble.setIdImm(idImmAppBur);
			defaut.setImmeuble(immeuble);
			break;
		case "Appartement":
			Appartement appartement = new Appartement();
			appartement.setIdApp(idImmAppBur);
			defaut.setAppartement(appartement);
			break;
		case "Bureau":
			Bureau bureau = new Bureau();
			bureau.setIdBur(idImmAppBur);
			defaut.setBureau(bureau);
			break;
		}
		defaut.setProjet(projet);
		defautBusiness.createDefaut(defaut);
		projet.setDescEtat(520);
		projet = projetBusiness.updateProjet(projet);
	}

	public void updateDefautClientValidationNotifier() {
		selectedDefaut.setValidationDefaut("validé");
		defautBusiness.updateDefaut(selectedDefaut);
	}

	public void validerDefautsNotifier() {
		projet.setDescEtat(521);
		projet = projetBusiness.updateProjet(projet);
	}

	public void updateDefautClient() {
		selectedDefaut.setTravauxDefaut(selectedTravaux);
		defautBusiness.updateDefaut(selectedDefaut);
	}

	public void updateDefautLeveeReserve() {
		selectedDefaut.setLeveeReserve(selectedReserve);
		defautBusiness.updateDefaut(selectedDefaut);
	}

	public void validerLeveeReservesNotifier() {
		projet.setDescEtat(522);
		projet = projetBusiness.updateProjet(projet);
	}

	public void createReceptionDefinitiveNotifier() {
		projet.setDescEtat(523);
		projet = projetBusiness.updateProjet(projet);
	}

	public void createSyndicat() {
		clientBusiness.updateClient(client);
	}

	public void createDefautClientFinaleNotifier() {
		switch (immAppBur) {
		case "Immeuble":
			Immeuble immeuble = new Immeuble();
			immeuble.setIdImm(idImmAppBur);
			defaut.setImmeuble(immeuble);
			break;
		case "Appartement":
			Appartement appartement = new Appartement();
			appartement.setIdApp(idImmAppBur);
			defaut.setAppartement(appartement);
			break;
		case "Bureau":
			Bureau bureau = new Bureau();
			bureau.setIdBur(idImmAppBur);
			defaut.setBureau(bureau);
			break;
		}
		defaut.setProjet(projet);
		defautBusiness.createDefaut(defaut);
		projet.setDescEtat(524);
		projet = projetBusiness.updateProjet(projet);
	}

	public void updateDefautClientValidationFinale() {
		selectedDefaut.setValidationDefaut("validé");
		defautBusiness.updateDefaut(selectedDefaut);
	}

	public void validerDefautsFinaleNotifier() {
		projet.setDescEtat(525);
		projet = projetBusiness.updateProjet(projet);
	}

	public void updateDefautClientFinale() {
		selectedDefaut.setTravauxDefaut(selectedTravaux);
		defautBusiness.updateDefaut(selectedDefaut);
	}

	public void updateDefautLeveeReserveFinale() {
		selectedDefaut.setLeveeReserve(selectedReserve);
		defautBusiness.updateDefaut(selectedDefaut);
	}

	public void validerLeveeReservesFinaleNotifier() {
		projet.setDescEtat(526);
		projet.setEtapeProj("Analyse du cloture projet");
		projet = projetBusiness.updateProjet(projet);
		
		Date dateDebut = new Date();
		planning = planningBusiness.SelectPlanningByProjet(projet.getIdProj());
		int d = Days.daysBetween(new LocalDate(planning.getDateDebut()), new LocalDate(dateDebut)).getDays();
		planning.setEtudeSemaineReel(d/7);		
		planning.setDateDebut(dateDebut);
		planning.setProjet(projet);
		planningBusiness.updatePlanning(planning);
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public ProjetValidation getProjetValidation() {
		return projetValidation;
	}

	public void setProjetValidation(ProjetValidation projetValidation) {
		this.projetValidation = projetValidation;
	}

	public Blocs getBlocs() {
		return blocs;
	}

	public void setBlocs(Blocs blocs) {
		this.blocs = blocs;
	}

	public ProjetBusiness getProjetBusiness() {
		return projetBusiness;
	}

	public void setProjetBusiness(ProjetBusiness projetBusiness) {
		this.projetBusiness = projetBusiness;
	}

	public String getImmAppBur() {
		return immAppBur;
	}

	public void setImmAppBur(String immAppBur) {
		this.immAppBur = immAppBur;
	}

	public int getIdImmAppBur() {
		return idImmAppBur;
	}

	public void setIdImmAppBur(int idImmAppBur) {
		this.idImmAppBur = idImmAppBur;
	}

	public Defaut getDefaut() {
		return defaut;
	}

	public void setDefaut(Defaut defaut) {
		this.defaut = defaut;
	}

	public List<Defaut> getDefauts() {
		return defauts;
	}

	public void setDefauts(List<Defaut> defauts) {
		this.defauts = defauts;
	}

	public DefautBusiness getDefautBusiness() {
		return defautBusiness;
	}

	public void setDefautBusiness(DefautBusiness defautBusiness) {
		this.defautBusiness = defautBusiness;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public ClientBusiness getClientBusiness() {
		return clientBusiness;
	}

	public void setClientBusiness(ClientBusiness clientBusiness) {
		this.clientBusiness = clientBusiness;
	}

	public Defaut getSelectedDefaut() {
		return selectedDefaut;
	}

	public void setSelectedDefaut(Defaut selectedDefaut) {
		this.selectedDefaut = selectedDefaut;
	}

	public String getSelectedReserve() {
		return selectedReserve;
	}

	public void setSelectedReserve(String selectedReserve) {
		this.selectedReserve = selectedReserve;
	}

	public String getSelectedTravaux() {
		return selectedTravaux;
	}

	public void setSelectedTravaux(String selectedTravaux) {
		this.selectedTravaux = selectedTravaux;
	}

	public AbsDoc getAbsDoc() {
		return absDoc;
	}

	public void setAbsDoc(AbsDoc absDoc) {
		this.absDoc = absDoc;
	}

	public AbsDocBusiness getAbsDocBusiness() {
		return absDocBusiness;
	}

	public void setAbsDocBusiness(AbsDocBusiness absDocBusiness) {
		this.absDocBusiness = absDocBusiness;
	}

	public GedCtr getGedCtr() {
		return gedCtr;
	}

	public void setGedCtr(GedCtr gedCtr) {
		this.gedCtr = gedCtr;
	}

	public Planning getPlanning() {
		return planning;
	}

	public void setPlanning(Planning planning) {
		this.planning = planning;
	}

	public PlanningBusiness getPlanningBusiness() {
		return planningBusiness;
	}

	public void setPlanningBusiness(PlanningBusiness planningBusiness) {
		this.planningBusiness = planningBusiness;
	}
	

}
