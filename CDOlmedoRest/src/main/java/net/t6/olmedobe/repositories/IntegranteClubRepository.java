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
package net.t6.olmedobe.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.t6.olmedobe.entities.IntegranteClub;

import java.util.Optional;

@Repository
public interface IntegranteClubRepository extends JpaRepository<IntegranteClub, Long> {

	Optional <IntegranteClub> findById(Long id);
	
	void deleteById(Long id);
	
	List<IntegranteClub> findByPerfilContaining(String perfil);
	
	List<IntegranteClub> findByPaisProcedenciaContaining(String paisProcedencia);
	
}
