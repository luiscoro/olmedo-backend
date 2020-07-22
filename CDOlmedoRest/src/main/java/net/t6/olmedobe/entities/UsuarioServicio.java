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
package net.t6.olmedobe.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;	
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Date;
import javax.persistence.Basic;
import org.hibernate.annotations.CreationTimestamp;
	
@Entity
@Table(name = "usuarioServicio_table")
public class UsuarioServicio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	private Long idServicio;
	@Basic
	@CreationTimestamp
	private Date fecha;
	private String nombrePromocion;
	private String detallePromocion;
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public Long getIdServicio() {
		return idServicio;
	}
	
	public void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getNombrePromocion() {
		return nombrePromocion;
	}
	
	public void setNombrePromocion(String nombrePromocion) {
		this.nombrePromocion = nombrePromocion;
	}
	
	public String getDetallePromocion() {
		return detallePromocion;
	}
	
	public void setDetallePromocion(String detallePromocion) {
		this.detallePromocion = detallePromocion;
	}
	
}
