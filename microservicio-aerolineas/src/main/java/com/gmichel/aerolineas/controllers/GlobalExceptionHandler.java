package com.gmichel.aerolineas.controllers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<String> dataEntityViolationException(DataIntegrityViolationException e){
		Throwable cause = e.getRootCause();
		if(cause != null && cause.getMessage() != null) {
			return ResponseEntity.badRequest().body("Errpr de integridad: " + cause.getMessage());
		}
		return ResponseEntity.badRequest().body("Error en la integridad de los datos.");
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> constraintViolationException(ConstraintViolationException e){
		return ResponseEntity.badRequest().body("Violacion de restriccion: " + e.getMessage());
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> RuntimeException(RuntimeException e){
		return ResponseEntity.badRequest().body("Se termino el tiempo de conexion: " + e.getMessage());
	}
}
