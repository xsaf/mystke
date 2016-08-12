package com.arabsoft.mySTKE.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.AxeAmeliorationBusiness;
import com.arabsoft.mySTKE.dao.IAxeAmeliorationDao;
import com.arabsoft.mySTKE.entity.AxeAmelioration;

@Service("axeAmeliorationBusiness")
public class AxeAmeliorationBusinessImpl implements AxeAmeliorationBusiness {

	@Autowired
	@Qualifier("axeAmeliorationDao")
	IAxeAmeliorationDao axeAmeliorationDao;
	
	@Override
	public void createAxeAmelioration(AxeAmelioration axeAmelioration) {
		axeAmeliorationDao.save(axeAmelioration);
	}

	@Override
	public List<AxeAmelioration> findAxeAmeliorationByIdProjet(int idProj) {
		List<AxeAmelioration> l = axeAmeliorationDao.findByIdProjet(idProj);
		return l;
	}

}
