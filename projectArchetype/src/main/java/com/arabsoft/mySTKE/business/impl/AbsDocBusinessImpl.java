package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.AbsDocBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.AbsDoc;
import com.arabsoft.mySTKE.entity.Document;
import com.arabsoft.mySTKE.entity.Dossier;

@Service("absDocBusiness")
public class AbsDocBusinessImpl implements AbsDocBusiness {

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public void createAbsDoc(AbsDoc absDoc) {
		genericDao.save(absDoc);
	}

	@Override
	public Dossier findFolderByNum(String parentFolder) {
		List<Dossier> l = genericDao.findByPropriety(AbsDoc.class.getName(), "NUMABSDOC", "'" + parentFolder + "'");
		return l.get(0);
	}

	@Override
	public void createDossier(Dossier absDoc) {
		List<Dossier> l = genericDao.findByPropriety(AbsDoc.class.getName(), "NUMABSDOC",
				"'" + absDoc.getNumAbsDoc() + "'");
		if (l.size() == 0)
			genericDao.save(absDoc);
	}

	@Override
	public void createDocument(Document absDoc) {
		List<Document> l = genericDao.findByPropriety(AbsDoc.class.getName(), "NUMABSDOC",
				"'" + absDoc.getNumAbsDoc() + "'");
		if (l.size() == 0)
			genericDao.save(absDoc);
	}

	@Override
	public AbsDoc findAbsDocByIdProjet(int idProj) {
		List<Dossier> l = genericDao.findByPropriety(AbsDoc.class.getName(), "PROJET_IDPROJ", "" + idProj);
		return l.get(0);
	}

	@Override
	public AbsDoc findAbsDocByEtapeProjet(int idProj, String s) {
		List<Dossier> l = genericDao.findByPropriety(AbsDoc.class.getName(), "PROJET_IDPROJ", "" + idProj, "NOMABSDOC", "'"+s+"'");
		return l.get(0);
	}

}
