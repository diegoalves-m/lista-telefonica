package com.diallab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(method = RequestMethod.POST)
	public void salvar(@RequestBody Operadora operadora) {
		service.save(operadora);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Operadora> buscarTodas() {
		return service.findAll();
	}

}
