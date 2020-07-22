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
package net.t6.olmedobe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.TimeZone;
import javax.annotation.PostConstruct;					

@SpringBootApplication
public class OlmedobeApplication {
	public static void main(String[] args) {
		SpringApplication.run(OlmedobeApplication.class, args);
		System.out.println("Active resources for Rol entity");
		System.out.println("GET");
		System.out.println("/api/rol");
		System.out.println("/api/rol/{id}");
		System.out.println("POST");
		System.out.println("/api/rol");
		System.out.println("PUT");
		System.out.println("/api/rol");
		System.out.println("DELETE");
		System.out.println("/api/rol/{id}");
		System.out.println("Active resources for Localidad entity");
		System.out.println("GET");
		System.out.println("/api/localidad");
		System.out.println("/api/localidad/{id}");
		System.out.println("POST");
		System.out.println("/api/localidad");
		System.out.println("PUT");
		System.out.println("/api/localidad");
		System.out.println("DELETE");
		System.out.println("/api/localidad/{id}");
		System.out.println("Active resources for Usuario entity");
		System.out.println("GET");
		System.out.println("/api/usuario");
		System.out.println("/api/usuario/{id}");
		System.out.println("/api/usuario/findbysexo/{sexo}");
		System.out.println("/api/usuario/findbypuntajeBeneficio/{puntajeBeneficio}");
		System.out.println("POST");
		System.out.println("/api/usuario");
		System.out.println("PUT");
		System.out.println("/api/usuario");
		System.out.println("DELETE");
		System.out.println("/api/usuario/{id}");
		System.out.println("Active resources for IntegranteClub entity");
		System.out.println("GET");
		System.out.println("/api/integranteClub");
		System.out.println("/api/integranteClub/{id}");
		System.out.println("/api/integranteClub/findbyperfil/{perfil}");
		System.out.println("/api/integranteClub/findbypaisProcedencia/{paisProcedencia}");
		System.out.println("POST");
		System.out.println("/api/integranteClub");
		System.out.println("PUT");
		System.out.println("/api/integranteClub");
		System.out.println("DELETE");
		System.out.println("/api/integranteClub/{id}");
		System.out.println("Active resources for Notificacion entity");
		System.out.println("GET");
		System.out.println("/api/notificacion");
		System.out.println("/api/notificacion/{id}");
		System.out.println("POST");
		System.out.println("/api/notificacion");
		System.out.println("PUT");
		System.out.println("/api/notificacion");
		System.out.println("DELETE");
		System.out.println("/api/notificacion/{id}");
		System.out.println("Active resources for Pago entity");
		System.out.println("GET");
		System.out.println("/api/pago");
		System.out.println("/api/pago/{id}");
		System.out.println("/api/pago/findbyestado/{estado}");
		System.out.println("POST");
		System.out.println("/api/pago");
		System.out.println("PUT");
		System.out.println("/api/pago");
		System.out.println("DELETE");
		System.out.println("/api/pago/{id}");
		System.out.println("Active resources for Publicacion entity");
		System.out.println("GET");
		System.out.println("/api/publicacion");
		System.out.println("/api/publicacion/{id}");
		System.out.println("/api/publicacion/findbyfecha/{fecha}");
		System.out.println("POST");
		System.out.println("/api/publicacion");
		System.out.println("PUT");
		System.out.println("/api/publicacion");
		System.out.println("DELETE");
		System.out.println("/api/publicacion/{id}");
		System.out.println("Active resources for Servicio entity");
		System.out.println("GET");
		System.out.println("/api/servicio");
		System.out.println("/api/servicio/{id}");
		System.out.println("/api/servicio/findbyestado/{estado}");
		System.out.println("POST");
		System.out.println("/api/servicio");
		System.out.println("PUT");
		System.out.println("/api/servicio");
		System.out.println("DELETE");
		System.out.println("/api/servicio/{id}");
		System.out.println("Active resources for TipoPublicacion entity");
		System.out.println("GET");
		System.out.println("/api/tipoPublicacion");
		System.out.println("/api/tipoPublicacion/{id}");
		System.out.println("POST");
		System.out.println("/api/tipoPublicacion");
		System.out.println("PUT");
		System.out.println("/api/tipoPublicacion");
		System.out.println("DELETE");
		System.out.println("/api/tipoPublicacion/{id}");
		System.out.println("Active resources for TipoServicio entity");
		System.out.println("GET");
		System.out.println("/api/tipoServicio");
		System.out.println("/api/tipoServicio/{id}");
		System.out.println("POST");
		System.out.println("/api/tipoServicio");
		System.out.println("PUT");
		System.out.println("/api/tipoServicio");
		System.out.println("DELETE");
		System.out.println("/api/tipoServicio/{id}");
		System.out.println("Active resources for UsuarioServicio entity");
		System.out.println("GET");
		System.out.println("/api/usuarioServicio");
		System.out.println("/api/usuarioServicio/{id}");
		System.out.println("POST");
		System.out.println("/api/usuarioServicio");
		System.out.println("PUT");
		System.out.println("/api/usuarioServicio");
		System.out.println("DELETE");
		System.out.println("/api/usuarioServicio/{id}");
	}
	
	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("America/Guayaquil"));
	}						
}
