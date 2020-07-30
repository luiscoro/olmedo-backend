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

import net.t6.olmedobe.services.ServicioService;
import net.t6.olmedobe.RecordNotFoundException;
import net.t6.olmedobe.entities.Servicio;

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
public class ServicioController {
	@Autowired
	ServicioService service;
	
	@GetMapping("/servicio")
	public ResponseEntity<List<Servicio>> getAll() {
		List<Servicio> list = service.getAll();
		return new ResponseEntity<List<Servicio>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/servicio/{id}")
	public ResponseEntity<Servicio> getServicioById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Servicio entity = service.findById(id);
		return new ResponseEntity<Servicio>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/servicio/findbyestado/{estado}")
	public ResponseEntity<List<Servicio>> getByEstado(@PathVariable("estado") String estado){
		List<Servicio> list = service.findByEstadoContaining(estado);
		return new ResponseEntity<List<Servicio>>(list, new HttpHeaders(), HttpStatus.OK);
	}				


	@PostMapping("/servicio")
	public ResponseEntity<Servicio> createServicio(@RequestBody Servicio servicio){
		service.createServicio(servicio);
		return new ResponseEntity<Servicio>(servicio, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/servicio")
	public ResponseEntity<Servicio> updateServicio(@RequestBody Servicio servicio) throws RecordNotFoundException{
		service.updateServicio(servicio);
		return new ResponseEntity<Servicio>(servicio, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/servicio/{id}")
	public HttpStatus deleteServicioById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteServicioById(id);
		return HttpStatus.OK;
	}
}				
