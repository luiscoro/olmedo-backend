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
import net.t6.olmedobe.security.PictureService;
import net.t6.olmedobe.services.PublicacionService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;	
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.text.ParseException;
import java.text.SimpleDateFormat;	


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class PublicacionController {
	@Autowired
	PublicacionService service;
	
	@Autowired
	PictureService picService;
	
	//@Value("${upload.path}")
	//public String uploadDir;	
	
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
	public ResponseEntity<Publicacion> createPublicacion(@RequestParam("publicacion") String s, @RequestParam("img") LinkedList<MultipartFile> file)throws JsonMappingException, JsonProcessingException{
		
		ObjectMapper om = new ObjectMapper();
		Publicacion publicacion = om.readValue(s, Publicacion[].class)[0];	
		/*
		if (!file.isEmpty()) {
			UUID idPic = UUID.randomUUID();
			picService.uploadPicture(file.get(0), idPic);
			publicacion.setFoto(idPic);		
		} */
		
		publicacion.setidUsuario(4);
		publicacion.setIdTipoPublicacion(1);
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
