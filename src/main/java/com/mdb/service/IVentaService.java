package com.mdb.service;


import com.mdb.model.Venta;


public interface IVentaService extends ICRUD <Venta, Integer>{

Venta registrarTransaccion (Venta venta) throws Exception;
	
	
}
