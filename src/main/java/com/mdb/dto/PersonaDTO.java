package com.mdb.dto;

import javax.validation.constraints.Size;

public class PersonaDTO {
	
	
	private Integer idPersona;
	
	@Size(min = 3, message = "{nombres.size}")
	private String nombres;
	
	@Size(min = 3, message = "{apellidos.size}")
	private String apellidos;
	
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	
	
}
