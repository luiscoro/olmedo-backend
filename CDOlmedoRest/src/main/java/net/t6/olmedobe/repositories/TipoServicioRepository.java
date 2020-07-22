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

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.t6.olmedobe.entities.TipoServicio;

import java.util.Optional;

@Repository
public interface TipoServicioRepository extends JpaRepository<TipoServicio, Long> {

	Optional <TipoServicio> findById(Long id);
	
	void deleteById(Long id);
	
}
