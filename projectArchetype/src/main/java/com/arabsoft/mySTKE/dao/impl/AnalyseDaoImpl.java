package com.arabsoft.mySTKE.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.dao.IAnalyseDao;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.AnalyseCout;
import com.arabsoft.mySTKE.entity.AnalyseFinanciere;
import com.arabsoft.mySTKE.entity.AnalyseZone;

@Repository("analyseDao")
public class AnalyseDaoImpl implements IAnalyseDao {

	@Autowired
	@Qualifier(value = "genericDao")
	private IDao genericDao;

	@Override
	public void save(AnalyseCout analyseCout) {
		genericDao.save(analyseCout);
	}

	@Override
	public List<AnalyseCout> findAnalyseCout(int value) {
		return genericDao.findByPropriety("Analyse", "ETUDERENTABILLITE_IDETUDE", "" + value, "DTYPE",
				"AnalyseCout");
	}
	
	@Override
	public void save(AnalyseFinanciere analyseFinanciere) {
		genericDao.save(analyseFinanciere);
	}

	@Override
	public List<AnalyseFinanciere> findAnalyseFinanciere(int value) {
		return genericDao.findByPropriety("Analyse", "ETUDERENTABILLITE_IDETUDE", "" + value, "DTYPE",
				"AnalyseFinanciere");
	}
	
	@Override
	public void save(AnalyseZone analyseZone) {
		genericDao.save(analyseZone);
	}

	@Override
	public List<AnalyseZone> findAnalyseZone(int value) {
		return genericDao.findByPropriety("Analyse", "ETUDERENTABILLITE_IDETUDE", "" + value, "DTYPE",
				"AnalyseZone");
	}

	
}
