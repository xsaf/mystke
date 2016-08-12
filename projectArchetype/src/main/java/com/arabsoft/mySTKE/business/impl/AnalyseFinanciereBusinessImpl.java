package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.AnalyseFinanciereBusiness;
import com.arabsoft.mySTKE.dao.IAnalyseDao;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.AnalyseFinanciere;

@Service("analyseFinanciereBusiness")
public class AnalyseFinanciereBusinessImpl implements AnalyseFinanciereBusiness {

	@Autowired
	@Qualifier("analyseDao")
	IAnalyseDao analyseDao;

	@Override
	public void createAnalyseFinanciere(AnalyseFinanciere analyseFinanciere) {
		analyseDao.save(analyseFinanciere);
	}
	
	@Override
	public AnalyseFinanciere findAnalyseFinanciereByIdEtude(int idEtude) {
		List<AnalyseFinanciere> l = analyseDao.findAnalyseFinanciere(idEtude);
		return l.get(0);
	}
	
}
