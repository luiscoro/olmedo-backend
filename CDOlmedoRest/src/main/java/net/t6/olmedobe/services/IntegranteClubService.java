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
import net.t6.olmedobe.entities.IntegranteClub;
import net.t6.olmedobe.repositories.IntegranteClubRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IntegranteClubService {

	@Autowired
	IntegranteClubRepository repo;

	public List<IntegranteClub> getAll(){
		List<IntegranteClub> integranteClubList = repo.findAll();
		if(integranteClubList.size() > 0) {
			return integranteClubList;
		} else {
			return new ArrayList<IntegranteClub>();
		}
	}
     		
	public IntegranteClub findById(Long id) throws RecordNotFoundException{
		Optional<IntegranteClub> integranteClub = repo.findById(id);
		if(integranteClub.isPresent()) {
			return integranteClub.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public List<IntegranteClub> findByPerfilContaining(String perfil){
		List<IntegranteClub> integranteClubList = repo.findByPerfilContaining(perfil);
		if(integranteClubList.size() > 0) {
			return integranteClubList;
		} else {
			return new ArrayList<IntegranteClub>();
		}
	}
	
	public List<IntegranteClub> findByPaisProcedenciaContaining(String paisProcedencia){
		List<IntegranteClub> integranteClubList = repo.findByPaisProcedenciaContaining(paisProcedencia);
		if(integranteClubList.size() > 0) {
			return integranteClubList;
		} else {
			return new ArrayList<IntegranteClub>();
		}
	}
	
	public IntegranteClub createIntegranteClub(IntegranteClub integranteClub){
		return repo.save(integranteClub);
	}

	public IntegranteClub updateIntegranteClub(IntegranteClub integranteClub) throws RecordNotFoundException {
		Optional<IntegranteClub> integranteClubTemp = repo.findById(integranteClub.getId());
	
		if(integranteClubTemp.isPresent()){
			return repo.save(integranteClub);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteIntegranteClubById(Long id) throws RecordNotFoundException{
		Optional<IntegranteClub> integranteClub = repo.findById(id);
		if(integranteClub.isPresent()) {
		repo.deleteById(id);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
