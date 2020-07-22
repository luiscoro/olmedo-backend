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
import net.t6.olmedobe.entities.IntegranteClub;
import net.t6.olmedobe.services.IntegranteClubService;

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
public class IntegranteClubController {
	@Autowired
	IntegranteClubService service;
	
	@GetMapping("/integranteClub")
	public ResponseEntity<List<IntegranteClub>> getAll() {
		List<IntegranteClub> list = service.getAll();
		return new ResponseEntity<List<IntegranteClub>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/integranteClub/{id}")
	public ResponseEntity<IntegranteClub> getIntegranteClubById(@PathVariable("id") Long id) throws RecordNotFoundException {
		IntegranteClub entity = service.findById(id);
		return new ResponseEntity<IntegranteClub>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/integranteClub/findbyperfil/{perfil}")
	public ResponseEntity<List<IntegranteClub>> getByPerfil(@PathVariable("perfil") String perfil){
		List<IntegranteClub> list = service.findByPerfilContaining(perfil);
		return new ResponseEntity<List<IntegranteClub>>(list, new HttpHeaders(), HttpStatus.OK);
	}				
	@GetMapping("/integranteClub/findbypaisProcedencia/{paisProcedencia}")
	public ResponseEntity<List<IntegranteClub>> getByPaisProcedencia(@PathVariable("paisProcedencia") String paisProcedencia){
		List<IntegranteClub> list = service.findByPaisProcedenciaContaining(paisProcedencia);
		return new ResponseEntity<List<IntegranteClub>>(list, new HttpHeaders(), HttpStatus.OK);
	}				


	@PostMapping("/integranteClub")
	public ResponseEntity<IntegranteClub> createIntegranteClub(@RequestBody IntegranteClub integranteClub){
		service.createIntegranteClub(integranteClub);
		return new ResponseEntity<IntegranteClub>(integranteClub, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/integranteClub")
	public ResponseEntity<IntegranteClub> updateIntegranteClub(@RequestBody IntegranteClub integranteClub) throws RecordNotFoundException{
		service.updateIntegranteClub(integranteClub);
		return new ResponseEntity<IntegranteClub>(integranteClub, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/integranteClub/{id}")
	public HttpStatus deleteIntegranteClubById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteIntegranteClubById(id);
		return HttpStatus.OK;
	}
}				
