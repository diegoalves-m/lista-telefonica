package com.diallab.sevice;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diallab.model.Contato;
import com.diallab.repository.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	public void save(Contato contato) {
		contato.setDate(LocalDate.now());
		contatoRepository.save(contato);
	}
	
	public List<Contato> contatos() {
		return contatoRepository.findAll();
	}
	
	public void delete(Long id) {
		contatoRepository.delete(id);
	}
	
	
}
