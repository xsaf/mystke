package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.AnalyseCoutBusiness;
import com.arabsoft.mySTKE.dao.IAnalyseDao;
import com.arabsoft.mySTKE.entity.AnalyseCout;

@Service("analyseCoutBusiness")
public class AnalyseCoutBusinessImpl implements AnalyseCoutBusiness {

	@Autowired
	@Qualifier("analyseDao")
	IAnalyseDao analyseDao;

	@Override
	public void createAnalyseCout(AnalyseCout analyseCout) {
		analyseDao.save(analyseCout);
	}

	@Override
	public AnalyseCout findAnalyseCoutByIdEtude(int idEtude) {
		List<AnalyseCout> l = analyseDao.findAnalyseCout(idEtude);
		return l.get(0);
	}

}
