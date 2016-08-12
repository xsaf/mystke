package com.arabsoft.mySTKE.dao;

import java.util.List;

import com.arabsoft.mySTKE.entity.AnalyseCout;
import com.arabsoft.mySTKE.entity.AnalyseFinanciere;
import com.arabsoft.mySTKE.entity.AnalyseZone;

public interface IAnalyseDao {

	void save(AnalyseCout analyseCout);

	List<AnalyseCout> findAnalyseCout(int value);

	void save(AnalyseFinanciere analyseFinanciere);

	List<AnalyseFinanciere> findAnalyseFinanciere(int idEtude);

	void save(AnalyseZone analyseZone);

	List<AnalyseZone> findAnalyseZone(int idEtude);

}
