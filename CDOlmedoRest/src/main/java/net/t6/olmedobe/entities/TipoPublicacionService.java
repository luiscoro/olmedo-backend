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
package net.t6.olmedobe.entities;

import net.t6.olmedobe.repositories.TipoPublicacionRepository;
import net.t6.olmedobe.RecordNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TipoPublicacionService {

	@Autowired
	TipoPublicacionRepository repo;

	public List<TipoPublicacion> getAll(){
		List<TipoPublicacion> tipoPublicacionList = repo.findAll();
		if(tipoPublicacionList.size() > 0) {
			return tipoPublicacionList;
		} else {
			return new ArrayList<TipoPublicacion>();
		}
	}
     		
	public TipoPublicacion findById(Long id) throws RecordNotFoundException{
		Optional<TipoPublicacion> tipoPublicacion = repo.findById(id);
		if(tipoPublicacion.isPresent()) {
			return tipoPublicacion.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public TipoPublicacion createTipoPublicacion(TipoPublicacion tipoPublicacion){
		return repo.save(tipoPublicacion);
	}

	public TipoPublicacion updateTipoPublicacion(TipoPublicacion tipoPublicacion) throws RecordNotFoundException {
		Optional<TipoPublicacion> tipoPublicacionTemp = repo.findById(tipoPublicacion.getId());
	
		if(tipoPublicacionTemp.isPresent()){
			return repo.save(tipoPublicacion);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteTipoPublicacionById(Long id) throws RecordNotFoundException{
		Optional<TipoPublicacion> tipoPublicacion = repo.findById(id);
		if(tipoPublicacion.isPresent()) {
		repo.deleteById(id);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
