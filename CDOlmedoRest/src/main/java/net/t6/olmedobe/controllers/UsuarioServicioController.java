																/*
 -------------------------------------------------------------------
|
| CRUDyLeaf	- A Domain Specific Language for generating Spring Boot 
|			REST resources from entity CRUD operations.
| Author: Omar S. G�mez (2020)
| File Date: Wed Jul 15 19:16:27 COT 2020
| 
 -------------------------------------------------------------------
																*/
package net.t6.olmedobe.controllers;

import net.t6.olmedobe.services.UsuarioServicioService;
import net.t6.olmedobe.RecordNotFoundException;
import net.t6.olmedobe.entities.UsuarioServicio;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;	
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
@RestController
@RequestMapping("/api")
public class UsuarioServicioController {
	@Autowired
	UsuarioServicioService service;
	
	@GetMapping("/usuarioServicio")
	public ResponseEntity<List<UsuarioServicio>> getAll() {
		List<UsuarioServicio> list = service.getAll();
		return new ResponseEntity<List<UsuarioServicio>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/usuarioServicio/{id}")
	public ResponseEntity<UsuarioServicio> getUsuarioServicioByIdUsuario(@PathVariable("id") Long idUsuario) throws RecordNotFoundException {
		UsuarioServicio entity = service.findByIdUsuario(idUsuario);
		return new ResponseEntity<UsuarioServicio>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/usuarioServicio")
	public ResponseEntity<UsuarioServicio> createUsuarioServicio(@RequestBody UsuarioServicio usuarioServicio){
		service.createUsuarioServicio(usuarioServicio);
		return new ResponseEntity<UsuarioServicio>(usuarioServicio, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/usuarioServicio")
	public ResponseEntity<UsuarioServicio> updateUsuarioServicio(@RequestBody UsuarioServicio usuarioServicio) throws RecordNotFoundException{
		service.updateUsuarioServicio(usuarioServicio);
		return new ResponseEntity<UsuarioServicio>(usuarioServicio, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/usuarioServicio/{id}")
	public HttpStatus deleteUsuarioServicioByIdUsuario(@PathVariable("id") Long idUsuario) throws RecordNotFoundException {
		service.deleteUsuarioServicioByIdUsuario(idUsuario);
		return HttpStatus.OK;
	}
}				
