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

import net.t6.olmedobe.entities.TipoPublicacion;

import java.util.Optional;

@Repository
public interface TipoPublicacionRepository extends JpaRepository<TipoPublicacion, Long> {

	Optional <TipoPublicacion> findById(Long id);
	
	void deleteById(Long id);
	
}
