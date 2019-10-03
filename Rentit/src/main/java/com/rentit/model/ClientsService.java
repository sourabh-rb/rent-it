package com.rentit.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.rentit.test_class.TestClass;

@Service
@Transactional
public class ClientsService {
	
	
	private TestClass testData = new TestClass();
	
	public List<Clients> listAll() {
	
		return testData.getClientTestData();
	}
	
	public void save(Clients client) {
	
	}
	
	public Clients get(Long id) {
		return null;
		
		
	}
	
	public void delete(Long id) {
		
	}

	
}
