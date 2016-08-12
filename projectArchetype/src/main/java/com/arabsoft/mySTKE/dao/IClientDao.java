package com.arabsoft.mySTKE.dao;

import java.util.List;

import com.arabsoft.mySTKE.entity.Client;

public interface IClientDao {

	void updateClient(Client client);

	List<Client> findByIdProjet(int value);

}
