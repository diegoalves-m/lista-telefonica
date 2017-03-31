package com.diallab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.diallab.model.Contato;
import com.diallab.sevice.ContatoService;

@RestController
@RequestMapping("/listatelefonica")
public class ContatoController {
	
	@Autowired
	private ContatoService service;
	
	@RequestMapping()
    public ModelAndView show() {
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject(service.contatos());
        return mv;
    }
	
	@RequestMapping(value = "/all" ,method = RequestMethod.GET)
	public List<Contato> buscarTodos() {
		
		return service.contatos();	
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody Contato contato) {
		
		service.save(contato);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		
		service.delete(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
