package com.mdb.exception;


@SuppressWarnings("serial")
public class ModeloNotFoundException extends RuntimeException {

	public ModeloNotFoundException(String mensaje) {
		super(mensaje);
	}
}