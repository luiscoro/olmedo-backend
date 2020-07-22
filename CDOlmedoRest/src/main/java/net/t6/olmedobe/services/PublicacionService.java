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
package net.t6.olmedobe.services;

import net.t6.olmedobe.RecordNotFoundException;
import net.t6.olmedobe.entities.Publicacion;
import net.t6.olmedobe.repositories.PublicacionRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class PublicacionService {

	@Autowired
	PublicacionRepository repo;

	public List<Publicacion> getAll(){
		List<Publicacion> publicacionList = repo.findAll();
		if(publicacionList.size() > 0) {
			return publicacionList;
		} else {
			return new ArrayList<Publicacion>();
		}
	}
     		
	public Publicacion findById(Long id) throws RecordNotFoundException{
		Optional<Publicacion> publicacion = repo.findById(id);
		if(publicacion.isPresent()) {
			return publicacion.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public List<Publicacion> findByFecha(Date fecha){
		List<Publicacion> publicacionList = repo.findAllByFecha(fecha);		
		if(publicacionList.size() > 0) {
			return publicacionList;
		} else {
			return new ArrayList<Publicacion>();
		}
	}
	
	public Publicacion createPublicacion(Publicacion publicacion){
		return repo.save(publicacion);
	}

	public Publicacion updatePublicacion(Publicacion publicacion) throws RecordNotFoundException {
		Optional<Publicacion> publicacionTemp = repo.findById(publicacion.getId());
	
		if(publicacionTemp.isPresent()){
			return repo.save(publicacion);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deletePublicacionById(Long id) throws RecordNotFoundException{
		Optional<Publicacion> publicacion = repo.findById(id);
		if(publicacion.isPresent()) {
		repo.deleteById(id);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
