package com.arabsoft.mySTKE.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.AbsDocBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.Dossier;

@Service("absDocBusiness")
public class AbsDocBusinessImpl implements AbsDocBusiness {

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;
	
	@Override
	public void createAbsDoc(Dossier absDoc) {
		genericDao.save(absDoc);
	}
	
	
	
}
