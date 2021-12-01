package com.mdb.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mdb.dto.PersonaDTO;
import com.mdb.exception.ModeloNotFoundException;
import com.mdb.model.Persona;
import com.mdb.service.IPersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	IPersonaService service;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<PersonaDTO>> listar() throws Exception{
		List<PersonaDTO> lista = service.listar().stream().map(p -> mapper.map(p, PersonaDTO.class)).collect(Collectors.toList());
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PersonaDTO> ListarPorId(@PathVariable("id") Integer id) throws Exception{
		PersonaDTO dtoResponse;
		Persona obj = service.ListarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID no encontrado "+ id);
		}else {
		dtoResponse = mapper.map(obj, PersonaDTO.class);	
		}
		return new ResponseEntity<>(dtoResponse,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody PersonaDTO dtoRequest) throws Exception{
		Persona p = mapper.map(dtoRequest, Persona.class);
		Persona obj = service.registrar(p);
		PersonaDTO dtoResponse = mapper.map(obj, PersonaDTO.class);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dtoResponse.getIdPersona()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<PersonaDTO> modificar(@Valid @RequestBody PersonaDTO dtoRequest) throws Exception{
		Persona per = service.ListarPorId(dtoRequest.getIdPersona());
		if (per == null) {
			throw new ModeloNotFoundException("ID no encontrado "+ dtoRequest.getIdPersona());
			}
		Persona p = mapper.map(per, Persona.class);		
		Persona obj = service.modificar(p);		
		PersonaDTO dtoResponse = mapper.map(obj, PersonaDTO.class);		
		return new ResponseEntity<>(dtoResponse,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> Eliminar(@PathVariable("id") Integer id) throws Exception{		
		Persona obj = service.ListarPorId(id);		
		if (obj == null) {
			throw new ModeloNotFoundException("ID no encontrado "+ id);
		}		
		service.Eliminar(id);		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
