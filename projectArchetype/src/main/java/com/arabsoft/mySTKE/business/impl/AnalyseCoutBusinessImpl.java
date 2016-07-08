package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.AnalyseCoutBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.Analyse;
import com.arabsoft.mySTKE.entity.AnalyseCout;

@Service("analyseCoutBusiness")
public class AnalyseCoutBusinessImpl implements AnalyseCoutBusiness {

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public void createAnalyseCout(AnalyseCout analyseCout) {
		genericDao.save(analyseCout);
	}

	@Override
	public AnalyseCout findAnalyseCoutByIdEtude(int idEtude) {
		List<AnalyseCout> l = genericDao.findByPropriety("Analyse", "ETUDERENTABILLITE_IDETUDE", "" + idEtude, "DTYPE",
				"AnalyseCout");
		return l.get(0);
	}

}
