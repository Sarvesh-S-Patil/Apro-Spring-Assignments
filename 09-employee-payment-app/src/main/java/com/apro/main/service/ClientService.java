package com.apro.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apro.main.entity.Client;
import com.apro.main.entity.Employee;
import com.apro.main.repository.ClientRepository;

@Repository
public class ClientService {
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	EmployeeService employeeService;
	public Client addClient(Client client) {
		return clientRepository.save(client);
	}
	
	public Client getClient(long clientId) {
		Optional<Client> optionalClient = clientRepository.findById(clientId);
		if(optionalClient.isEmpty())
			return null;
		return optionalClient.get();
	}
	
	public Client addEmployeToClient(long clientId,Employee employee) {
		Client client = this.getClient(clientId);
		if(client==null)
			return null;
		List<Employee> employees = client.getEmployees();
		employees.add(employee);
		employeeService.addEmployee(employee);
		client.setEmployees(employees);
		return clientRepository.save(client);
	}
}
