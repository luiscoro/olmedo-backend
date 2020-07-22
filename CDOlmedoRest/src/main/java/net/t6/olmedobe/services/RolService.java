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

import net.t6.olmedobe.repositories.RolRepository;
import net.t6.olmedobe.RecordNotFoundException;
import net.t6.olmedobe.entities.Rol;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RolService {

	@Autowired
	RolRepository repo;

	public List<Rol> getAll(){
		List<Rol> rolList = repo.findAll();
		if(rolList.size() > 0) {
			return rolList;
		} else {
			return new ArrayList<Rol>();
		}
	}
     		
	public Rol findById(Long id) throws RecordNotFoundException{
		Optional<Rol> rol = repo.findById(id);
		if(rol.isPresent()) {
			return rol.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public Rol createRol(Rol rol){
		return repo.save(rol);
	}

	public Rol updateRol(Rol rol) throws RecordNotFoundException {
		Optional<Rol> rolTemp = repo.findById(rol.getId());
	
		if(rolTemp.isPresent()){
			return repo.save(rol);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteRolById(Long id) throws RecordNotFoundException{
		Optional<Rol> rol = repo.findById(id);
		if(rol.isPresent()) {
		repo.deleteById(id);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
