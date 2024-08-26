package com.apro.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.apro.main.entity.Client;
import com.apro.main.exceptions.ClientNotfoundException;
import com.apro.main.repository.ClientRepository;


@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientRepository;
	
	public Page<Client> getClients(int pageNumber,int pageSize){
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("clientId").descending());
		return clientRepository.findAll(pageable);
	}
	
	public Client findClientById(int clientId) {
		Optional<Client> clientById = clientRepository.findById(clientId);
		if(!clientById.isPresent()) {
			throw new ClientNotfoundException();
		}
		return clientById.get();
	}
	
	public Page<Client> getClientsByCompanyName(int pageNumber,int pageSize,String companyName){
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("clientId").descending());
		return clientRepository.findByCompanyName(companyName,pageable);
	}
	
	public void addClient(Client client) {
		clientRepository.save(client);
	}
	
	public void deleteClientById(int clientId) {
		clientRepository.deleteById(clientId);
	}

}
