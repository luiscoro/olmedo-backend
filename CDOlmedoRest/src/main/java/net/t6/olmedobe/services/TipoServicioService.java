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

import net.t6.olmedobe.repositories.TipoServicioRepository;
import net.t6.olmedobe.RecordNotFoundException;
import net.t6.olmedobe.entities.TipoServicio;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TipoServicioService {

	@Autowired
	TipoServicioRepository repo;

	public List<TipoServicio> getAll(){
		List<TipoServicio> tipoServicioList = repo.findAll();
		if(tipoServicioList.size() > 0) {
			return tipoServicioList;
		} else {
			return new ArrayList<TipoServicio>();
		}
	}
     		
	public TipoServicio findById(Long id) throws RecordNotFoundException{
		Optional<TipoServicio> tipoServicio = repo.findById(id);
		if(tipoServicio.isPresent()) {
			return tipoServicio.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public TipoServicio createTipoServicio(TipoServicio tipoServicio){
		return repo.save(tipoServicio);
	}

	public TipoServicio updateTipoServicio(TipoServicio tipoServicio) throws RecordNotFoundException {
		Optional<TipoServicio> tipoServicioTemp = repo.findById(tipoServicio.getId());
	
		if(tipoServicioTemp.isPresent()){
			return repo.save(tipoServicio);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteTipoServicioById(Long id) throws RecordNotFoundException{
		Optional<TipoServicio> tipoServicio = repo.findById(id);
		if(tipoServicio.isPresent()) {
		repo.deleteById(id);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
