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
import net.t6.olmedobe.entities.Pago;
import net.t6.olmedobe.services.PagoService;

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
public class PagoController {
	@Autowired
	PagoService service;
	
	@GetMapping("/pago")
	public ResponseEntity<List<Pago>> getAll() {
		List<Pago> list = service.getAll();
		return new ResponseEntity<List<Pago>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/pago/{id}")
	public ResponseEntity<Pago> getPagoById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Pago entity = service.findById(id);
		return new ResponseEntity<Pago>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/pago/findbyestado/{estado}")
	public ResponseEntity<List<Pago>> getByEstado(@PathVariable("estado") String estado){
		List<Pago> list = service.findByEstadoContaining(estado);
		return new ResponseEntity<List<Pago>>(list, new HttpHeaders(), HttpStatus.OK);
	}				


	@PostMapping("/pago")
	public ResponseEntity<Pago> createPago(@RequestBody Pago pago){
		service.createPago(pago);
		return new ResponseEntity<Pago>(pago, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/pago")
	public ResponseEntity<Pago> updatePago(@RequestBody Pago pago) throws RecordNotFoundException{
		service.updatePago(pago);
		return new ResponseEntity<Pago>(pago, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/pago/{id}")
	public HttpStatus deletePagoById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deletePagoById(id);
		return HttpStatus.OK;
	}
}				
