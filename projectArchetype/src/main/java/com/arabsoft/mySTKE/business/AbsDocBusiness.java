package com.arabsoft.mySTKE.business;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.entity.AbsDoc;
import com.arabsoft.mySTKE.entity.Document;
import com.arabsoft.mySTKE.entity.Dossier;

@Transactional
public interface AbsDocBusiness {
	
	public void createAbsDoc(AbsDoc absDoc);

	public Dossier findFolderByNum(String parentFolder);

	public void createDossier(Dossier absDoc);

	public void createDocument(Document absDoc);

}
