package com.mdb.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mdb.dto.VentaDTO;
import com.mdb.model.Venta;
import com.mdb.service.IVentaService;

@RestController
@RequestMapping("/ventas")
public class VentaController {

	@Autowired
	IVentaService service;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<VentaDTO>> listar() throws Exception{
		List<VentaDTO> lista = service.listar().stream().map(p -> mapper.map(p, VentaDTO.class)).collect(Collectors.toList());
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody VentaDTO dtoRequest) throws Exception{
		Venta v = mapper.map(dtoRequest, Venta.class);
		Venta obj = service.registrarTransaccion(v);
		VentaDTO dtoResponse = mapper.map(obj, VentaDTO.class);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dtoResponse.getIdVenta()).toUri();
		return ResponseEntity.created(location).build();
	}
	
}
