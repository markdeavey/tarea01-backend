package com.mdb.dto;

import javax.validation.constraints.Size;

public class ProductoDTO {
	
	private Integer idProducto;
	
	@Size(min = 3, message = "{nombre.size}")
	private String nombre;
	
	@Size(min = 3, message = "{marca.size}")
	private String marca;
	
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
 
	
}
