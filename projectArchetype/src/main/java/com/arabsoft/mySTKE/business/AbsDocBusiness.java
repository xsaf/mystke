package com.arabsoft.mySTKE.business;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.entity.Dossier;

@Transactional
public interface AbsDocBusiness {
	
	public void createAbsDoc(Dossier absDoc);

}
