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

import net.t6.olmedobe.repositories.UsuarioServicioRepository;
import net.t6.olmedobe.RecordNotFoundException;
import net.t6.olmedobe.entities.UsuarioServicio;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioService {

	@Autowired
	UsuarioServicioRepository repo;

	public List<UsuarioServicio> getAll(){
		List<UsuarioServicio> usuarioServicioList = repo.findAll();
		if(usuarioServicioList.size() > 0) {
			return usuarioServicioList;
		} else {
			return new ArrayList<UsuarioServicio>();
		}
	}
     		
	public UsuarioServicio findByIdUsuario(Long idUsuario) throws RecordNotFoundException{
		Optional<UsuarioServicio> usuarioServicio = repo.findByIdUsuario(idUsuario);
		if(usuarioServicio.isPresent()) {
			return usuarioServicio.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public UsuarioServicio createUsuarioServicio(UsuarioServicio usuarioServicio){
		return repo.save(usuarioServicio);
	}

	public UsuarioServicio updateUsuarioServicio(UsuarioServicio usuarioServicio) throws RecordNotFoundException {
		Optional<UsuarioServicio> usuarioServicioTemp = repo.findByIdUsuario(usuarioServicio.getIdUsuario());
	
		if(usuarioServicioTemp.isPresent()){
			return repo.save(usuarioServicio);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteUsuarioServicioByIdUsuario(Long idUsuario) throws RecordNotFoundException{
		Optional<UsuarioServicio> usuarioServicio = repo.findByIdUsuario(idUsuario);
		if(usuarioServicio.isPresent()) {
		repo.deleteByIdUsuario(idUsuario);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
