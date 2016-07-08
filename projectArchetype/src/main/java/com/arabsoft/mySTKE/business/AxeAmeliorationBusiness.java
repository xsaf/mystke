package com.arabsoft.mySTKE.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.entity.AxeAmelioration;

@Transactional
public interface AxeAmeliorationBusiness {

	void createAxeAmelioration(AxeAmelioration axeAmelioration);

	List<AxeAmelioration> findAxeAmeliorationByIdProjet(int idProj);
	

}
