package com.diallab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diallab.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
	
}
