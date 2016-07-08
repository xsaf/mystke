package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.AnalyseZoneBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.AnalyseZone;

@Service("analyseZoneBusiness")
public class AnalyseZoneBusinessImpl implements AnalyseZoneBusiness {
	
	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public void createAnalyseZone(AnalyseZone analyseZone) {
		genericDao.save(analyseZone);
	}
	
	@Override
	public AnalyseZone findAnalyseZoneByIdEtude(int idEtude) {
		List<AnalyseZone> l = genericDao.findByPropriety("Analyse", "ETUDERENTABILLITE_IDETUDE", "" + idEtude, "DTYPE",
				"AnalyseZone");
		return l.get(0);
	}
	
	
	

}
