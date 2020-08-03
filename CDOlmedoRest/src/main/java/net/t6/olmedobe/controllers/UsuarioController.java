
package net.t6.olmedobe.controllers;

import net.t6.olmedobe.services.UsuarioService;
import net.t6.olmedobe.RecordNotFoundException;
import net.t6.olmedobe.entities.Usuario;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UsuarioController {
	@Autowired
	UsuarioService service;
	@GetMapping("/login")
	public String login(){
		return "authenticated successfully" ;
	}

	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Usuario entity = service.findById(id);
		return new ResponseEntity<Usuario>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/usuario/findbysexo/{sexo}")
	public ResponseEntity<List<Usuario>> getBySexo(@PathVariable("sexo") String sexo){
		List<Usuario> list = service.findBySexoContaining(sexo);
		return new ResponseEntity<List<Usuario>>(list, new HttpHeaders(), HttpStatus.OK);
	}				
	@GetMapping("/usuario/findbypuntajeBeneficio/{puntajeBeneficio}")
	public ResponseEntity<List<Usuario>> getByPuntajeBeneficio(@PathVariable("puntajeBeneficio") String puntajeBeneficio){
		List<Usuario> list = service.findByPuntajeBeneficioContaining(puntajeBeneficio);
		return new ResponseEntity<List<Usuario>>(list, new HttpHeaders(), HttpStatus.OK);
	}				

	@PostMapping("/usuario")
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
		service.createUsuario(usuario);
		return new ResponseEntity<Usuario>(usuario, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/usuario")
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) throws RecordNotFoundException{
		service.updateUsuario(usuario);
		return new ResponseEntity<Usuario>(usuario, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/usuario/{id}")
	public HttpStatus deleteUsuarioById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteUsuarioById(id);
		return HttpStatus.OK;
	}
	
}				
