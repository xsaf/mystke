package com.arabsoft.mySTKE.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.dao.IAbsDocDao;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.AbsDoc;
import com.arabsoft.mySTKE.entity.Document;
import com.arabsoft.mySTKE.entity.Dossier;

@Repository("absDocDao")
public class AbsDocDaoImpl implements IAbsDocDao{

	@Autowired
	@Qualifier(value = "genericDao")
	private IDao genericDao;

	@Override
	public void save(AbsDoc absDoc) {
		genericDao.save(absDoc);
	}

	@Override
	public List<Dossier> findDossierByNumeroAbsDoc(String value) {
		return genericDao.findByPropriety(AbsDoc.class.getName(),"NUMABSDOC", "'" + value + "'");
	}

	@Override
	public List<Document> findDocumentByNumeroAbsDoc(String value) {
		return genericDao.findByPropriety(AbsDoc.class.getName(),"NUMABSDOC", "'" + value + "'");
	}

	@Override
	public List<Dossier> findByIdProjet(int value) {
		return genericDao.findByPropriety(AbsDoc.class.getName(),"PROJET_IDPROJ", "" + value);
	}
	
	@Override
	public List<Dossier> findByIdProjet(int value, String value1) {
		return genericDao.findByPropriety(AbsDoc.class.getName(),"PROJET_IDPROJ", "" + value, "NOMABSDOC", "'"+value1+"'");
	}

	

}
