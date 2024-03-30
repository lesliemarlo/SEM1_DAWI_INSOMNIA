package com.empresa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Modalidad;
import com.empresa.service.ModalidadService;

@RestController
@RequestMapping("/url/modalidad")
public class ModalidadController {

	@Autowired
	private ModalidadService service;
	
	
	@GetMapping
	public List<Modalidad> lista(){
		List<Modalidad> lstSalida = service.listaModalidad();
		return lstSalida;
	}
	
	
	@PostMapping
	public ResponseEntity<?> inserta(@RequestBody Modalidad obj){
		List<String> lstMensaje = new ArrayList<String>();
		
		//Por convencion al registrar
		//1 el estado es 1
		//2 la fecha de registro es la del sistema
		//3 lafecha de actualizacion del sistema
		
		obj.setEstado(1);
		obj.setFechaRegistro(new Date());
		obj.setFechaActualizacion(new Date());
		Modalidad objSalida = service.insertaModalidad(obj);
		if (objSalida == null) {
			lstMensaje.add("Error en el registro");
		}else {
			lstMensaje.add("Se registró la modalidad de id = " + obj.getIdModalidad());	
		}
		return ResponseEntity.ok(lstMensaje);
	}
	
	
	
}