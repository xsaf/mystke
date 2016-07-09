package com.arabsoft.mySTKE.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arabsoft.mySTKE.business.ClientBusiness;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.Client;

@Service("clientBusiness")
public class ClientBusinessImpl implements ClientBusiness {

	@Autowired
	@Qualifier("genericDao")
	IDao genericDao;

	@Override
	public void updateClient(Client client) {
		Client cl = (Client) genericDao.findById(Client.class, client.getIdCli());
		cl.setFonctionSyndicat(client.getFonctionSyndicat());
		genericDao.update(cl);
	}

	@Override
	public List<Client> findClientsByIdProjet(int idProj) {
		List<Client> l = genericDao.findByPropriety(Client.class.getName(), "PROJET_IDPROJ",""+idProj);
		List<Client> l1 = new ArrayList<Client>();
		for(int i=0; i<l.size(); i++){
			if(l.get(i).getFonctionSyndicat()!=null && !l.get(i).getFonctionSyndicat().isEmpty() )
				l1.add(l.get(i));
		}	
		return l1;
	}
	
	
	
	
	
}
