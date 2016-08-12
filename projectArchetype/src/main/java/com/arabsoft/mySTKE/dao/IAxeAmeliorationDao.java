package com.arabsoft.mySTKE.dao;

import java.util.List;

import com.arabsoft.mySTKE.entity.AxeAmelioration;

public interface IAxeAmeliorationDao {

	void save(AxeAmelioration axeAmelioration);

	List<AxeAmelioration> findByIdProjet(int idProj);

}
