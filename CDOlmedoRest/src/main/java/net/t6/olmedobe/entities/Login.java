package net.t6.olmedobe.entities;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
 
@SuppressWarnings("serial")
public class Login implements UserDetails {
	private Usuario usuario;
    
    public Login(Usuario usuario) {
        this.usuario = usuario;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Rol> roles = usuario.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        for (Rol rol : roles) {
            authorities.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
         
        return authorities;
    }
 
    @Override
    public String getPassword() {
        return usuario.getContrasenia();
    }
 
    @Override
    public String getUsername() {
        return usuario.getCorreo();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    @Override
    public boolean isEnabled() {
        return true;
    }
}
