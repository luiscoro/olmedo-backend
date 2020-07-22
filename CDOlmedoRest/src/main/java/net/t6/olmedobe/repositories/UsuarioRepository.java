package net.t6.olmedobe.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.t6.olmedobe.entities.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional <Usuario> findById(Long id);
	
	@Transactional
	void deleteById(Long id);
	
	//@Query(value= "SELECT u FROM Usuario u WHERE u.correo_usuario = :correo", nativeQuery=true)
	@Query(value = "SELECT * FROM Usuario WHERE correo_usuario = ?1", nativeQuery = true)
	 Usuario findByCorreo(String correo);
   /*public Usuario getUsuarioByCorreo(@Param("correo") String correo);
	
	@Query("select u from Usuario u where u.correo_usuario =?1 and u.contrasenia_usuario = ?2")
	  Usuario findByCorreoAndContrasenia(String correo,String contrasenia);*/
	
	List<Usuario> findBySexoContaining(String sexo);
	
	List<Usuario> findByPuntajeBeneficioContaining(String puntajeBeneficio);
	
}
