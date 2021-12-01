package com.mdb.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.mdb.model.Persona;

public class VentaDTO {
	
	
	
	private Integer idVenta;
	
	private LocalDateTime fecha;
	
	private Persona persona;
	
	private double importe;
	
	private List <DetalleVentaDTO> detalleVenta;

	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public List<DetalleVentaDTO> getDetalleVenta() {
		return detalleVenta;
	}

	public void setDetalleVenta(List<DetalleVentaDTO> detalleVenta) {
		this.detalleVenta = detalleVenta;
	}
	
}
