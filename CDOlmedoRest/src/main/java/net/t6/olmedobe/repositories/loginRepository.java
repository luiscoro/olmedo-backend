package net.t6.olmedobe.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



import net.t6.olmedobe.entities.login;

@Repository
public interface loginRepository extends JpaRepository<login, Long>{

	
	List<login> findByCorreoContaining(String correo);
	
}
