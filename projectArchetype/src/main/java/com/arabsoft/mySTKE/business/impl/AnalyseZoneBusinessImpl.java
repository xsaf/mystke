package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.AnalyseZoneBusiness;
import com.arabsoft.mySTKE.dao.IAnalyseDao;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.AnalyseZone;

@Service("analyseZoneBusiness")
public class AnalyseZoneBusinessImpl implements AnalyseZoneBusiness {
	
	@Autowired
	@Qualifier("analyseDao")
	IAnalyseDao analyseDao;
	
	@Override
	public void createAnalyseZone(AnalyseZone analyseZone) {
		analyseDao.save(analyseZone);
	}
	
	@Override
	public AnalyseZone findAnalyseZoneByIdEtude(int idEtude) {
		List<AnalyseZone> l = analyseDao.findAnalyseZone(idEtude);
		return l.get(0);
	}
	
	
	

}
