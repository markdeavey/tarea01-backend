package com.mdb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdb.model.Persona;
import com.mdb.repo.IGenericRepo;
import com.mdb.repo.IPersonaRepo;
import com.mdb.service.IPersonaService;
@Service
public class PersonaServiceImpl extends CRUDimpl <Persona, Integer> implements IPersonaService {

	@Autowired
	IPersonaRepo repo;
	
	@Override
	protected IGenericRepo<Persona, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}



}
