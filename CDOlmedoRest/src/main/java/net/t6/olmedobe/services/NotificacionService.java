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
import net.t6.olmedobe.entities.Notificacion;
import net.t6.olmedobe.repositories.NotificacionRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotificacionService {

	@Autowired
	NotificacionRepository repo;

	public List<Notificacion> getAll(){
		List<Notificacion> notificacionList = repo.findAll();
		if(notificacionList.size() > 0) {
			return notificacionList;
		} else {
			return new ArrayList<Notificacion>();
		}
	}
     		
	public Notificacion findById(Long id) throws RecordNotFoundException{
		Optional<Notificacion> notificacion = repo.findById(id);
		if(notificacion.isPresent()) {
			return notificacion.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public Notificacion createNotificacion(Notificacion notificacion){
		return repo.save(notificacion);
	}

	public Notificacion updateNotificacion(Notificacion notificacion) throws RecordNotFoundException {
		Optional<Notificacion> notificacionTemp = repo.findById(notificacion.getId());
	
		if(notificacionTemp.isPresent()){
			return repo.save(notificacion);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteNotificacionById(Long id) throws RecordNotFoundException{
		Optional<Notificacion> notificacion = repo.findById(id);
		if(notificacion.isPresent()) {
		repo.deleteById(id);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
