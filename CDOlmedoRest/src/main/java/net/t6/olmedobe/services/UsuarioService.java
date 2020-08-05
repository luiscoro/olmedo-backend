
package net.t6.olmedobe.services;

import net.t6.olmedobe.repositories.LocalidadRepository;
import net.t6.olmedobe.repositories.UsuarioRepository;
import net.t6.olmedobe.repositories.loginRepository;
import net.t6.olmedobe.RecordNotFoundException;
import net.t6.olmedobe.entities.Localidad;
import net.t6.olmedobe.entities.Usuario;
import net.t6.olmedobe.entities.login;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository repou;
	
	@Autowired
	loginRepository repou1;
	
	@Autowired
	LocalidadRepository repol;

	public List<Usuario> getAll(){
		List<Usuario> usuarioList = repou.findAll();
		if(usuarioList.size() > 0) {
			return usuarioList;
		} else {
			return new ArrayList<Usuario>();
		}
	}
     		
	public Usuario findById(Long id) throws RecordNotFoundException{
		Optional<Usuario> usuario = repou.findById(id);
		if(usuario.isPresent()) {
			return usuario.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public List<login> findByCorreoContaining(String correo){
		List<login> usuarioList = repou1.findByCorreoContaining(correo);
		if(usuarioList.size() > 0) {
			return usuarioList;
		} else {
			return new ArrayList<login>();
		}
	}
	/*
	public List<login> findByContraseniaContaining(String contrasenia){
		List<login> usuarioList = repou.findByCorreoContaining(contrasenia);
		if(usuarioList.size() > 0) {
			return usuarioList;
		} else {
			return new ArrayList<login>();
		}
	}*/
	
	
	public List<Usuario> findBySexoContaining(String sexo){
		List<Usuario> usuarioList = repou.findBySexoContaining(sexo);
		if(usuarioList.size() > 0) {
			return usuarioList;
		} else {
			return new ArrayList<Usuario>();
		}
	}
	
	public List<Usuario> findByPuntajeBeneficioContaining(String puntajeBeneficio){
		List<Usuario> usuarioList = repou.findByPuntajeBeneficioContaining(puntajeBeneficio);
		if(usuarioList.size() > 0) {
			return usuarioList;
		} else {
			return new ArrayList<Usuario>();
		}
	}
	
	public Usuario createUsuario(Usuario usuario) {

		return repou.save(usuario);
	}

	public Usuario updateUsuario(Usuario usuario) throws RecordNotFoundException {
		Optional<Usuario> usuarioTemp = repou.findById(usuario.getId());
	
		if(usuarioTemp.isPresent()){
			return repou.save(usuario);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteUsuarioById(Long id) throws RecordNotFoundException{
		Optional<Usuario> usuario = repou.findById(id);
		if(usuario.isPresent()) {
		repou.deleteById(id);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

}
