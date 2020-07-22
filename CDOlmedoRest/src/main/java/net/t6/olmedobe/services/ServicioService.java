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

import net.t6.olmedobe.repositories.ServicioRepository;
import net.t6.olmedobe.RecordNotFoundException;
import net.t6.olmedobe.entities.Servicio;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {

	@Autowired
	ServicioRepository repo;

	public List<Servicio> getAll(){
		List<Servicio> servicioList = repo.findAll();
		if(servicioList.size() > 0) {
			return servicioList;
		} else {
			return new ArrayList<Servicio>();
		}
	}
     		
	public Servicio findById(Long id) throws RecordNotFoundException{
		Optional<Servicio> servicio = repo.findById(id);
		if(servicio.isPresent()) {
			return servicio.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public List<Servicio> findByEstadoContaining(String estado){
		List<Servicio> servicioList = repo.findByEstadoContaining(estado);
		if(servicioList.size() > 0) {
			return servicioList;
		} else {
			return new ArrayList<Servicio>();
		}
	}
	
	public Servicio createServicio(Servicio servicio){
		return repo.save(servicio);
	}

	public Servicio updateServicio(Servicio servicio) throws RecordNotFoundException {
		Optional<Servicio> servicioTemp = repo.findById(servicio.getId());
	
		if(servicioTemp.isPresent()){
			return repo.save(servicio);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteServicioById(Long id) throws RecordNotFoundException{
		Optional<Servicio> servicio = repo.findById(id);
		if(servicio.isPresent()) {
		repo.deleteById(id);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
