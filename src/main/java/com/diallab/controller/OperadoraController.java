package com.diallab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diallab.model.Operadora;
import com.diallab.sevice.OperadoraService;

@Controller
@RestController
@RequestMapping("/operadoras")
public class OperadoraController {
	
	@Autowired
	private OperadoraService service;
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public void salvar() {
		
		Operadora operadora1 = new Operadora();
		operadora1.setNome("Claro");
		operadora1.setCodigo(21);
		
		Operadora operadora2 = new Operadora();
		operadora2.setNome("Oi");
		operadora2.setCodigo(31);
		
		Operadora operadora3 = new Operadora();
		operadora3.setNome("Vivo");
		operadora3.setCodigo(25);
		
		Operadora operadora4 = new Operadora();
		operadora4.setNome("Tim");
		operadora4.setCodigo(41);
		
		service.save(operadora1);
		service.save(operadora2);
		service.save(operadora3);
		service.save(operadora4);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Operadora> buscarTodas() {
		return service.findAll();
	}

}
