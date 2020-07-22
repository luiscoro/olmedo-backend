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
import net.t6.olmedobe.entities.Notificacion;
import net.t6.olmedobe.services.NotificacionService;

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
public class NotificacionController {
	@Autowired
	NotificacionService service;
	
	@GetMapping("/notificacion")
	public ResponseEntity<List<Notificacion>> getAll() {
		List<Notificacion> list = service.getAll();
		return new ResponseEntity<List<Notificacion>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/notificacion/{id}")
	public ResponseEntity<Notificacion> getNotificacionById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Notificacion entity = service.findById(id);
		return new ResponseEntity<Notificacion>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/notificacion")
	public ResponseEntity<Notificacion> createNotificacion(@RequestBody Notificacion notificacion){
		service.createNotificacion(notificacion);
		return new ResponseEntity<Notificacion>(notificacion, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/notificacion")
	public ResponseEntity<Notificacion> updateNotificacion(@RequestBody Notificacion notificacion) throws RecordNotFoundException{
		service.updateNotificacion(notificacion);
		return new ResponseEntity<Notificacion>(notificacion, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/notificacion/{id}")
	public HttpStatus deleteNotificacionById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteNotificacionById(id);
		return HttpStatus.OK;
	}
}				
