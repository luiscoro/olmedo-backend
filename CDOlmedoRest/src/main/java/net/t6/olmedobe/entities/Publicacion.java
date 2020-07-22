																
package net.t6.olmedobe.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;	
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.UUID;
import org.hibernate.annotations.Type;
import java.sql.Date;
import javax.persistence.Basic;
import org.hibernate.annotations.CreationTimestamp;
	
@Entity
@Table(name = "publicacion")
public class Publicacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String detalle;
	private String autor;
	@Basic
	@CreationTimestamp
	private Date fecha;
	@Type(type = "uuid-char")
	private UUID foto;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDetalle() {
		return detalle;
	}
	
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public UUID getFoto() {
		return foto;
	}
	
	public void setFoto(UUID foto) {
		this.foto = foto;
	}
	
}
