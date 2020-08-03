																
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
import javax.persistence.Column;

import org.hibernate.annotations.CreationTimestamp;
	
@Entity
@Table(name = "`publicacion`")
public class Publicacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_publicacion")
	private Long id;
	
	@Column(name="nombre_publicacion")
	private String nombre;
	
	@Column(name="detalle_publicacion")
	private String detalle;
	
	@Column(name="autor_publicacion")
	private String autor;
	
	@Basic
	@CreationTimestamp
	@Column(name="fecha_publicacion")
	private Date fecha;
	
	@Type(type = "uuid-char")
	@Column(name="foto_publicacion")
	private UUID foto;
	
	@Column(name="id_tipo_publicacion")
	private int idTipoPublicacion;
	
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
	
	/*public int getidUsuario() {
		return idUsuario;
	}
	
	public void setidUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	} */
	 
	public int getIdTipoPublicacion() {
		return idTipoPublicacion;
	}
	
	public void setIdTipoPublicacion(int idTipoPublicacion) {
		this.idTipoPublicacion = idTipoPublicacion;
	}
	
}
