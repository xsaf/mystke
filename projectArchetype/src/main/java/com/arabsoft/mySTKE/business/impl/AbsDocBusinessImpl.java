package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.AbsDocBusiness;
import com.arabsoft.mySTKE.dao.IAbsDocDao;
import com.arabsoft.mySTKE.entity.AbsDoc;
import com.arabsoft.mySTKE.entity.Document;
import com.arabsoft.mySTKE.entity.Dossier;

@Service("absDocBusiness")
public class AbsDocBusinessImpl implements AbsDocBusiness {

	@Autowired
	@Qualifier("absDocDao")
	IAbsDocDao absDocDao;

	@Override
	public void createAbsDoc(AbsDoc absDoc) {
		absDocDao.save(absDoc);
	}

	@Override
	public Dossier findFolderByNum(String parentFolder) {
		List<Dossier> l = absDocDao.findDossierByNumeroAbsDoc(parentFolder);
		if(l.size()!=0)
			return l.get(0);
		else 
			return null;
	}

	@Override
	public void createDossier(Dossier absDoc) {
		List<Dossier> l = absDocDao.findDossierByNumeroAbsDoc(absDoc.getNumAbsDoc());
		if (l.size() == 0)
			absDocDao.save(absDoc);
	}

	@Override
	public void createDocument(Document absDoc) {
		List<Document> l = absDocDao.findDocumentByNumeroAbsDoc(absDoc.getNumAbsDoc());
		if (l.size() == 0)
			absDocDao.save(absDoc);
	}

	@Override
	public AbsDoc findAbsDocByIdProjet(int idProj) {
		List<Dossier> l = absDocDao.findByIdProjet(idProj);
		return l.get(0);
	}

	@Override
	public AbsDoc findAbsDocByEtapeProjet(int idProj, String s) {
		List<Dossier> l = absDocDao.findByIdProjet(idProj,s);
		return l.get(0);
	}

}
