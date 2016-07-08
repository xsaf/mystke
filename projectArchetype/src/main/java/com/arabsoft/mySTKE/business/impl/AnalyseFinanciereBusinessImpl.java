package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.AnalyseFinanciereBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.AnalyseFinanciere;

@Service("analyseFinanciereBusiness")
public class AnalyseFinanciereBusinessImpl implements AnalyseFinanciereBusiness {

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public void createAnalyseFinanciere(AnalyseFinanciere analyseFinanciere) {
		genericDao.save(analyseFinanciere);
	}
	
	@Override
	public AnalyseFinanciere findAnalyseFinanciereByIdEtude(int idEtude) {
		List<AnalyseFinanciere> l = genericDao.findByPropriety("Analyse", "ETUDERENTABILLITE_IDETUDE", "" + idEtude, "DTYPE",
				"AnalyseFinanciere");
		return l.get(0);
	}
	
}
