
package net.t6.olmedobe.services;

import net.t6.olmedobe.repositories.LocalidadRepository;
import net.t6.olmedobe.repositories.UsuarioRepository;
import net.t6.olmedobe.RecordNotFoundException;
import net.t6.olmedobe.entities.Localidad;
import net.t6.olmedobe.entities.Usuario;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository repou;
	
	@Autowired
	LocalidadRepository repol;
	
	
	@Autowired
	private PasswordEncoder PasswordEncoder;

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
		Localidad loc = repol.findById(usuario.getLocalidad().getId()).orElse(null);
        if (null == loc) {
            loc = new Localidad();
        }
        usuario.setContrasenia(PasswordEncoder.encode(usuario.getContrasenia()));
        loc.setPais(usuario.getLocalidad().getPais());
        loc.setCiudad(usuario.getLocalidad().getCiudad());
        usuario.setLocalidad(loc);
       // usuario.setRoles(new Rol("hincha"));
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
