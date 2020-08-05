package net.t6.olmedobe.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.t6.olmedobe.entities.Usuario;
import net.t6.olmedobe.entities.login;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional <Usuario> findById(Long id);
	
	@Transactional
	void deleteById(Long id);
	
	//@Query(value= "SELECT u FROM Usuario u WHERE u.correo_usuario = :correo", nativeQuery=true)
	@Query(value = "SELECT * FROM Usuario WHERE correo_usuario = ?1", nativeQuery = true)
	 Usuario findByCorreo(String correo);
	
   //public Usuario getUsuarioByCorreo(@Param("correo") String correo);
	
	//@Query(value = "SELECT u.id_usuario, u.correo_usuario FROM Usuario u WHERE u.correo_usuario =?1 AND u.contrasenia_usuario = ?2", nativeQuery = true)
	//Usuario findByEmailPass(String correo_usuario,String contrasenia_usuario);
	
	List<login> findByCorreoContaining(String correo);
	
	List<Usuario> findBySexoContaining(String sexo);
	
	List<Usuario> findByPuntajeBeneficioContaining(String puntajeBeneficio);
	
	
}
