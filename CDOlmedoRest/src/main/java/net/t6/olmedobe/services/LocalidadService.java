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
import net.t6.olmedobe.entities.Localidad;
import net.t6.olmedobe.repositories.LocalidadRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocalidadService {

	@Autowired
	LocalidadRepository repo;

	public List<Localidad> getAll(){
		List<Localidad> localidadList = repo.findAll();
		if(localidadList.size() > 0) {
			return localidadList;
		} else {
			return new ArrayList<Localidad>();
		}
	}
     		
	public Localidad findById(Long id) throws RecordNotFoundException{
		Optional<Localidad> localidad = repo.findById(id);
		if(localidad.isPresent()) {
			return localidad.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public Localidad createLocalidad(Localidad localidad){
		return repo.save(localidad);
	}

	public Localidad updateLocalidad(Localidad localidad) throws RecordNotFoundException {
		Optional<Localidad> localidadTemp = repo.findById(localidad.getId());
	
		if(localidadTemp.isPresent()){
			return repo.save(localidad);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteLocalidadById(Long id) throws RecordNotFoundException{
		Optional<Localidad> localidad = repo.findById(id);
		if(localidad.isPresent()) {
		repo.deleteById(id);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
