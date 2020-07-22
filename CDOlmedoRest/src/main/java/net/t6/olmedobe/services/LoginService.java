package net.t6.olmedobe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import net.t6.olmedobe.entities.Login;
import net.t6.olmedobe.entities.Usuario;
import net.t6.olmedobe.repositories.UsuarioRepository;

public class LoginService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repou;
	
	@Override
	 public UserDetails loadUserByUsername(String correo)
	            throws UsernameNotFoundException {
	        Usuario usuario = repou.findByCorreo(correo);
	    		
	        if (usuario == null) {
	            throw new UsernameNotFoundException("Could not find user");
	        }
	         
	        return new Login(usuario);
	    }

}
