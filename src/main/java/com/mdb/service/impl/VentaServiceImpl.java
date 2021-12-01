package com.mdb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdb.model.Venta;
import com.mdb.repo.IGenericRepo;
import com.mdb.repo.IVentaRepo;
import com.mdb.service.IVentaService;
@Service
public class VentaServiceImpl extends CRUDimpl <Venta, Integer> implements IVentaService {

	@Autowired
	IVentaRepo repo;

	@Override
	protected IGenericRepo<Venta, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

	@Override
	public Venta registrarTransaccion(Venta venta) throws Exception {
		// TODO Auto-generated method stub
		venta.getDetalleVenta().forEach(det -> det.setVenta(venta));
		
		repo.save(venta);
		
		return  venta;
	}
	
	
	
	}



