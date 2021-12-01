package com.mdb.service.impl;

import java.util.List;

import com.mdb.repo.IGenericRepo;
import com.mdb.service.ICRUD;

public abstract class CRUDimpl<T, ID> implements ICRUD<T, ID> {
	
	protected abstract IGenericRepo <T, ID> getRepo();

	@Override
	public T registrar(T t) throws Exception {
		return getRepo().save(t);
	}

	@Override
	public T modificar(T t) throws Exception {
		return getRepo().save(t);
	}

	@Override
	public List<T> listar() throws Exception {
		return getRepo().findAll();
	}

	@Override
	public T ListarPorId(ID id) throws Exception {
		return getRepo().findById(id).orElse(null);
	}

	@Override
	public void Eliminar(ID id) throws Exception {
		getRepo().deleteById(id);
	}
	
	

}
