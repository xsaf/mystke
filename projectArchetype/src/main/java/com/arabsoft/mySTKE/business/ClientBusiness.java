package com.arabsoft.mySTKE.business;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.arabsoft.mySTKE.entity.Client;

@Transactional
public interface ClientBusiness {

	public void updateClient(Client client);
	public List<Client> findClientsByIdProjet(int idProj);
}
