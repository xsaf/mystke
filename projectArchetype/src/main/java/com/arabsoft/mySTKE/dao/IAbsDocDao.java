package com.arabsoft.mySTKE.dao;

import java.util.List;

import com.arabsoft.mySTKE.entity.AbsDoc;
import com.arabsoft.mySTKE.entity.Document;
import com.arabsoft.mySTKE.entity.Dossier;

public interface IAbsDocDao {

	void save(AbsDoc absDoc);
	List<Dossier> findDossierByNumeroAbsDoc(String value);
	List<Document> findDocumentByNumeroAbsDoc(String value);
	List<Dossier> findByIdProjet(int value);
	List<Dossier> findByIdProjet(int value, String value1);

	
}
