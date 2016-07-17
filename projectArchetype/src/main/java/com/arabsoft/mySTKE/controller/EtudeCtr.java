package com.arabsoft.mySTKE.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.arabsoft.mySTKE.business.AbsDocBusiness;
import com.arabsoft.mySTKE.business.AnalyseCoutBusiness;
import com.arabsoft.mySTKE.business.AnalyseFinanciereBusiness;
import com.arabsoft.mySTKE.business.AnalyseZoneBusiness;
import com.arabsoft.mySTKE.business.EquipeBusiness;
import com.arabsoft.mySTKE.business.EtudeRentabiliteBusiness;
import com.arabsoft.mySTKE.business.ProjetBusiness;
import com.arabsoft.mySTKE.business.ProjetValidationBusiness;
import com.arabsoft.mySTKE.business.TerrainBusiness;
import com.arabsoft.mySTKE.business.ZoneBusiness;
import com.arabsoft.mySTKE.entity.AbsDoc;
import com.arabsoft.mySTKE.entity.AnalyseCout;
import com.arabsoft.mySTKE.entity.AnalyseFinanciere;
import com.arabsoft.mySTKE.entity.AnalyseZone;
import com.arabsoft.mySTKE.entity.Dossier;
import com.arabsoft.mySTKE.entity.Equipe;
import com.arabsoft.mySTKE.entity.EtudeRentabillite;
import com.arabsoft.mySTKE.entity.Fonction;
import com.arabsoft.mySTKE.entity.Projet;
import com.arabsoft.mySTKE.entity.ProjetValidation;
import com.arabsoft.mySTKE.entity.Terrain;
import com.arabsoft.mySTKE.entity.Zone;
import com.arabsoft.mySTKE.security.habilitation.model.Utilisateur;

@ManagedBean(name = "etudeCtr")
@ViewScoped
public class EtudeCtr {

	private Utilisateur utilisateur = new Utilisateur();
	private Fonction fonction = new Fonction();
	private Projet projet = new Projet();
	private Zone zone = new Zone();
	private Terrain terrain = new Terrain();
	private Utilisateur ar = new Utilisateur();
	private Equipe equipe = new Equipe();
	private EtudeRentabillite etude = new EtudeRentabillite();
	private AnalyseCout analyseCout = new AnalyseCout();
	private AnalyseZone analyseZone = new AnalyseZone();
	private AnalyseFinanciere analyseFinanciere = new AnalyseFinanciere();
	private ProjetValidation projetValidation = new ProjetValidation();
	private AbsDoc absDoc = new Dossier();


	@ManagedProperty(value = "#{projetBusiness}")
	private ProjetBusiness projetBusiness;

	@ManagedProperty(value = "#{zoneBusiness}")
	private ZoneBusiness zoneBusiness;
	
	@ManagedProperty(value = "#{terrainBusiness}")
	private TerrainBusiness terrainBusiness;
	
	@ManagedProperty(value = "#{equipeBusiness}")
	private EquipeBusiness equipeBusiness;
	
	@ManagedProperty(value = "#{etudeBusiness}")
	private EtudeRentabiliteBusiness etudeBusiness;
	
	@ManagedProperty(value = "#{analyseCoutBusiness}")
	private AnalyseCoutBusiness analyseCoutBusiness;
	
	@ManagedProperty(value = "#{analyseZoneBusiness}")
	private AnalyseZoneBusiness analyseZoneBusiness;
	
	@ManagedProperty(value = "#{analyseFinanciereBusiness}")
	private AnalyseFinanciereBusiness analyseFinanciereBusiness;
	
	@ManagedProperty(value = "#{projetValidationBusiness}")
	private ProjetValidationBusiness projetValidationBusiness;
	
	@ManagedProperty(value = "#{absDocBusiness}")
	private AbsDocBusiness absDocBusiness;

	@ManagedProperty(value = "#{gedCtr}")
	private GedCtr gedCtr;
	
    private MapModel simpleModel1;
    
    private int architecte;
	private Map<String, Integer> architectes = new HashMap<String, Integer>();

	
	@PostConstruct
	public void initialisation() {
		// test
		projet.setIdProj(15830);

		// Projet
		projet = projetBusiness.findProjetById(projet.getIdProj());

		absDoc = absDocBusiness.findAbsDocByIdProjet(projet.getIdProj());
		gedCtr.setFolder(absDoc.getNumAbsDoc());
		
		
		if(projet.getDescEtat()>=212){
			zone = zoneBusiness.findZoneByIdProjet(projet.getIdProj());			
		}
		if(projet.getDescEtat()>=213){
			terrain = terrainBusiness.findTerrainByIdProjet(projet.getIdProj());			
			simpleModel1 = new DefaultMapModel();
			LatLng coord1 = new LatLng(Float.parseFloat(terrain.getxTerrain()), Float.parseFloat(terrain.getyTerrain()));
	        simpleModel1.addOverlay(new Marker(coord1, "Terrain de projet"));
		}
		if(projet.getDescEtat()==214){
			List<Utilisateur> archi = equipeBusiness.selectAllUserByFonction("5");
			architectes = new HashMap<String, Integer>();
			for (int i = 0; i < archi.size(); i++) {
				architectes.put("" + archi.get(i).getPrenomUti() + " " + archi.get(i).getNomUti(),
						archi.get(i).getIdUti());
			}
		}
		if(projet.getDescEtat()>=215){
			ar = equipeBusiness.selectArchitecteByEquipe(projet.getIdProj());
		}
		if(projet.getDescEtat()>=216){
			etude = etudeBusiness.findEtudeByIdProjet(projet.getIdProj());
		}
		if(projet.getDescEtat()>=217){
			analyseCout = analyseCoutBusiness.findAnalyseCoutByIdEtude(etude.getIdEtude());
		}
		if(projet.getDescEtat()>=218){
			analyseZone = analyseZoneBusiness.findAnalyseZoneByIdEtude(etude.getIdEtude());
		}
		if(projet.getDescEtat()>=219){
			analyseFinanciere = analyseFinanciereBusiness.findAnalyseFinanciereByIdEtude(etude.getIdEtude());
		}
		if(projet.getDescEtat()>=220){
			projetValidation = projetValidationBusiness.findProjetValidationByIdProjet(projet.getIdProj(),220);
		}
		
	}
	
	public void createFolder(){
		gedCtr.setProjet(projet);
		gedCtr.createFolder();
	}

	public void createZone() {
		projet.setDescEtat(212);
		projet = projetBusiness.updateProjet(projet);
		zone.setProjet(projet);
		zoneBusiness.createZone(zone);
	}
	
	public void createTerrain() {
		projet.setDescEtat(213);
		projet = projetBusiness.updateProjet(projet);
		terrain.setProjet(projet);
		terrain.setZone(zone);
		terrainBusiness.createTerrain(terrain);
	}
	
	public void updateVisiteTerrain(){
		projet.setDescEtat(214);
		projet = projetBusiness.updateProjet(projet);
		terrain.setVisite("Yes");
		terrainBusiness.updateTerrain(terrain);
	}
	
	public void updateEquipe(){
		projet.setDescEtat(215);
		projet = projetBusiness.updateProjet(projet);
		equipe.setProjet(projet);
		ar.setIdUti(architecte);
		equipe.setUtilisateur(ar);
		equipeBusiness.createEquipe(equipe);
	}
	
	public void createEtudeRentabilite(){
		projet.setDescEtat(216);
		projet = projetBusiness.updateProjet(projet);
		etude.setProjet(projet);
		etudeBusiness.createEtudeRentabilite(etude);
	}
	
	public void createAnalyseCout(){
		projet.setDescEtat(217);
		projet = projetBusiness.updateProjet(projet);
		analyseCout.setEtudeRentabillite(etude);
		analyseCoutBusiness.createAnalyseCout(analyseCout);
	}
	
	public void createAnalyseZone(){
		projet.setDescEtat(218);
		projet = projetBusiness.updateProjet(projet);
		analyseZone.setEtudeRentabillite(etude);
		analyseZoneBusiness.createAnalyseZone(analyseZone);
	}

	public void createAnalyseFinanciere(){
		projet.setDescEtat(219);
		projet = projetBusiness.updateProjet(projet);
		analyseFinanciere.setEtudeRentabillite(etude);
		analyseFinanciereBusiness.createAnalyseFinanciere(analyseFinanciere);
	}
	
	public void createProjetValid(){
		projet.setDescEtat(220);
		projet = projetBusiness.updateProjet(projet);
		projetValidation.setEtatValid(220);
		projetValidation.setProjet(projet);
		projetValidationBusiness.createProjetValid(projetValidation);
	}
	
	public void addPVReunion(){
		projet.setDescEtat(221);
		projet = projetBusiness.updateProjet(projet);
	}
	
	public void updateProjetValid(){
		projet.setDescEtat(222);
		projet = projetBusiness.updateProjet(projet);
		projetValidation.setProjet(projet);
		projetValidation.setProjValid("Validé");
		projetValidationBusiness.updateProjetValid(projetValidation);
	}
	
	public void updateAchatTerrain(){
		projet.setDescEtat(223);
		projet = projetBusiness.updateProjet(projet);
		terrainBusiness.updateTerrain(terrain);
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

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}
	
	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Utilisateur getAr() {
		return ar;
	}

	public void setAr(Utilisateur ar) {
		this.ar = ar;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
	public AnalyseCout getAnalyseCout() {
		return analyseCout;
	}

	public void setAnalyseCout(AnalyseCout analyseCout) {
		this.analyseCout = analyseCout;
	}

	public AnalyseZone getAnalyseZone() {
		return analyseZone;
	}

	public void setAnalyseZone(AnalyseZone analyseZone) {
		this.analyseZone = analyseZone;
	}

	public AnalyseFinanciere getAnalyseFinanciere() {
		return analyseFinanciere;
	}

	public void setAnalyseFinanciere(AnalyseFinanciere analyseFinanciere) {
		this.analyseFinanciere = analyseFinanciere;
	}

	public ProjetValidation getProjetValidation() {
		return projetValidation;
	}

	public void setProjetValidation(ProjetValidation projetValidation) {
		this.projetValidation = projetValidation;
	}

	public ProjetValidationBusiness getProjetValidationBusiness() {
		return projetValidationBusiness;
	}

	public void setProjetValidationBusiness(ProjetValidationBusiness projetValidationBusiness) {
		this.projetValidationBusiness = projetValidationBusiness;
	}

	public AnalyseFinanciereBusiness getAnalyseFinanciereBusiness() {
		return analyseFinanciereBusiness;
	}

	public void setAnalyseFinanciereBusiness(AnalyseFinanciereBusiness analyseFinanciereBusiness) {
		this.analyseFinanciereBusiness = analyseFinanciereBusiness;
	}

	public AnalyseZoneBusiness getAnalyseZoneBusiness() {
		return analyseZoneBusiness;
	}

	public void setAnalyseZoneBusiness(AnalyseZoneBusiness analyseZoneBusiness) {
		this.analyseZoneBusiness = analyseZoneBusiness;
	}

	public ProjetBusiness getProjetBusiness() {
		return projetBusiness;
	}

	public void setProjetBusiness(ProjetBusiness projetBusiness) {
		this.projetBusiness = projetBusiness;
	}

	public ZoneBusiness getZoneBusiness() {
		return zoneBusiness;
	}

	public void setZoneBusiness(ZoneBusiness zoneBusiness) {
		this.zoneBusiness = zoneBusiness;
	}

	public TerrainBusiness getTerrainBusiness() {
		return terrainBusiness;
	}

	public void setTerrainBusiness(TerrainBusiness terrainBusiness) {
		this.terrainBusiness = terrainBusiness;
	}

	public EquipeBusiness getEquipeBusiness() {
		return equipeBusiness;
	}

	public void setEquipeBusiness(EquipeBusiness equipeBusiness) {
		this.equipeBusiness = equipeBusiness;
	}

	public EtudeRentabiliteBusiness getEtudeBusiness() {
		return etudeBusiness;
	}

	public void setEtudeBusiness(EtudeRentabiliteBusiness etudeBusiness) {
		this.etudeBusiness = etudeBusiness;
	}
	
	public AnalyseCoutBusiness getAnalyseCoutBusiness() {
		return analyseCoutBusiness;
	}

	public void setAnalyseCoutBusiness(AnalyseCoutBusiness analyseCoutBusiness) {
		this.analyseCoutBusiness = analyseCoutBusiness;
	}

	public MapModel getSimpleModel1() {
		return simpleModel1;
	}

	public void setSimpleModel1(MapModel simpleModel1) {
		this.simpleModel1 = simpleModel1;
	}

	public int getArchitecte() {
		return architecte;
	}

	public void setArchitecte(int architecte) {
		this.architecte = architecte;
	}

	public Map<String, Integer> getArchitectes() {
		return architectes;
	}

	public void setArchitectes(Map<String, Integer> architectes) {
		this.architectes = architectes;
	}

	public EtudeRentabillite getEtude() {
		return etude;
	}

	public void setEtude(EtudeRentabillite etude) {
		this.etude = etude;
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

	
	
	
	

}
