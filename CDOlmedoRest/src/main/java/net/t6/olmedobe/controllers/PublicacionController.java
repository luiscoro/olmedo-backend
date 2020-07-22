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

import net.t6.olmedobe.RecordNotFoundException;
import net.t6.olmedobe.entities.Publicacion;
import net.t6.olmedobe.services.PublicacionService;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;	
@RestController
@RequestMapping("/api")
public class PublicacionController {
	@Autowired
	PublicacionService service;
	
	@GetMapping("/publicacion")
	public ResponseEntity<List<Publicacion>> getAll() {
		List<Publicacion> list = service.getAll();
		return new ResponseEntity<List<Publicacion>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/publicacion/{id}")
	public ResponseEntity<Publicacion> getPublicacionById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Publicacion entity = service.findById(id);
		return new ResponseEntity<Publicacion>(entity, new HttpHeaders(), HttpStatus.OK);
	}


	@GetMapping("/publicacion/findbyfecha/{fecha}")
	public ResponseEntity<List<Publicacion>> getByFecha(@PathVariable("fecha") String fecha) throws ParseException{
		List<Publicacion> list = service.findByFecha(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
		return new ResponseEntity<List<Publicacion>>(list, new HttpHeaders(), HttpStatus.OK);
	}				

	@PostMapping("/publicacion")
	public ResponseEntity<Publicacion> createPublicacion(@RequestBody Publicacion publicacion){
		service.createPublicacion(publicacion);
		return new ResponseEntity<Publicacion>(publicacion, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/publicacion")
	public ResponseEntity<Publicacion> updatePublicacion(@RequestBody Publicacion publicacion) throws RecordNotFoundException{
		service.updatePublicacion(publicacion);
		return new ResponseEntity<Publicacion>(publicacion, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/publicacion/{id}")
	public HttpStatus deletePublicacionById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deletePublicacionById(id);
		return HttpStatus.OK;
	}
}				
