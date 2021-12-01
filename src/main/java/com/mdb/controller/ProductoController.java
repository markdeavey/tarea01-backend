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

import com.mdb.dto.ProductoDTO;
import com.mdb.exception.ModeloNotFoundException;
import com.mdb.model.Producto;
import com.mdb.service.IProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	IProductoService service;
	
	@Autowired
	private ModelMapper mapper;
	@GetMapping
	public ResponseEntity<List<ProductoDTO>> listar() throws Exception{
		List<ProductoDTO> lista = service.listar().stream().map(p -> mapper.map(p, ProductoDTO.class)).collect(Collectors.toList());
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductoDTO> ListarPorId(@PathVariable("id") Integer id) throws Exception{
		ProductoDTO dtoResponse;
		Producto obj = service.ListarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+ id);
		}else {
		dtoResponse = mapper.map(obj, ProductoDTO.class);	
		}
		return new ResponseEntity<>(dtoResponse,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody ProductoDTO dtoRequest) throws Exception{
		Producto p = mapper.map(dtoRequest, Producto.class);
		Producto obj = service.registrar(p);
		ProductoDTO dtoResponse = mapper.map(obj, ProductoDTO.class);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dtoResponse.getIdProducto()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<ProductoDTO> modificar(@Valid @RequestBody ProductoDTO dtoRequest) throws Exception{
		Producto prod = service.ListarPorId(dtoRequest.getIdProducto());
		if (prod == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+ dtoRequest.getIdProducto());
			}
		Producto p = mapper.map(prod, Producto.class);		
		Producto obj = service.modificar(p);		
		ProductoDTO dtoResponse = mapper.map(obj, ProductoDTO.class);		
		return new ResponseEntity<>(dtoResponse,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> Eliminar(@PathVariable("id") Integer id) throws Exception{		
		Producto obj = service.ListarPorId(id);		
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+ id);
		}		
		service.Eliminar(id);		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
