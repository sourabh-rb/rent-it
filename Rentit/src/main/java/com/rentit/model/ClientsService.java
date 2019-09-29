package com.rentit.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientsService {
	
	@Autowired
	private ClientsRepository repo;
	
	public List<Clients> listAll() {
		return repo.findAll();
	}
	
	public void save(Clients client) {
		repo.save(client);
	}
	
	public Clients get(Long id) {
		
		return repo.getOne(id);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

	
}
