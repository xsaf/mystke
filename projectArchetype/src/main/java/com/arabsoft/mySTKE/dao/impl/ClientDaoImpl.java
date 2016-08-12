package com.arabsoft.mySTKE.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.dao.IClientDao;
import com.arabsoft.mySTKE.dao.IDao;
import com.arabsoft.mySTKE.entity.Client;

@Repository("clientDao")
public class ClientDaoImpl implements IClientDao {

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
	public List<Client> findByIdProjet(int value) {
		return genericDao.findByPropriety(Client.class.getName(), "PROJET_IDPROJ",""+value);
	}

	
	
}
