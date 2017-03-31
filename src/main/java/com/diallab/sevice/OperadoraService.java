package com.diallab.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diallab.model.Operadora;
import com.diallab.repository.OperadoraRepository;

@Service
public class OperadoraService {

	@Autowired
	private OperadoraRepository operadoraRepository;
	
	public void save(Operadora operadora) {
		operadoraRepository.save(operadora);
	}
	
	public List<Operadora> findAll() {
		return operadoraRepository.findAll();
	}
	
}
