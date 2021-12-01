package com.mdb.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mdb.model.Producto;
import com.mdb.model.Venta;

public class DetalleVentaDTO {
	
	
	
	private Integer idDetalleVenta;
	
	@JsonIgnore
	private Venta venta;

	private Producto producto;
	
	private Integer cantidad;
	
	public Integer getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(Integer idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}