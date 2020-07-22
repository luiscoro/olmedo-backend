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

import net.t6.olmedobe.services.RolService;
import net.t6.olmedobe.RecordNotFoundException;
import net.t6.olmedobe.entities.Rol;

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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class RolController {
	@Autowired
	RolService service;
	
	@GetMapping("/rol")
	public ResponseEntity<List<Rol>> getAll() {
		List<Rol> list = service.getAll();
		return new ResponseEntity<List<Rol>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/rol/{id}")
	public ResponseEntity<Rol> getRolById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Rol entity = service.findById(id);
		return new ResponseEntity<Rol>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/rol")
	public ResponseEntity<Rol> createRol(@RequestBody Rol rol){
		service.createRol(rol);
		return new ResponseEntity<Rol>(rol, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/rol")
	public ResponseEntity<Rol> updateRol(@RequestBody Rol rol) throws RecordNotFoundException{
		service.updateRol(rol);
		return new ResponseEntity<Rol>(rol, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/rol/{id}")
	public HttpStatus deleteRolById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteRolById(id);
		return HttpStatus.OK;
	}
}				
