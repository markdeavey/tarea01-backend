package com.mdb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdb.model.Producto;
import com.mdb.repo.IGenericRepo;
import com.mdb.repo.IProductoRepo;
import com.mdb.service.IProductoService;
@Service
public class ProductoServiceImpl extends CRUDimpl <Producto, Integer> implements IProductoService {

	@Autowired
	IProductoRepo repo;
	
	@Override
	protected IGenericRepo<Producto, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}



}
