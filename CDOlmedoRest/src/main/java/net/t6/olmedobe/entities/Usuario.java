package net.t6.olmedobe.entities;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;


import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "`usuario`")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Long id;
	
	@Column(name="nombre_usuario")
	private String nombre;
	
	@Column(name="contrasenia_usuario")
	private String contrasenia;
	
	@Column(name="correo_usuario")
	private String correo;
	
	@Column(name="sexo_usuario")
	private String sexo;
	
	@Basic
	@Column(name="fecha_nacimiento_usuario")
	private Date fechaNacimiento;
	
	@Column(name="telefono_usuario")
	private String telefono;
	
	@Column(name="direccion_usuario")
	private String direccion;
	
	@Column(name="puntaje_beneficio")
	private Long puntajeBeneficio;

	@Basic
	@CreationTimestamp
	@Column(name="fecha_creacion")
	private Date fechaCreacion;
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_roles",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol")
            )
	private Set<Rol> roles = new HashSet<>();
	 
	@ManyToOne
    @JoinColumn(name="id_localidad", nullable=false)
	private Localidad localidad;


	public Usuario() {}
	
	public Usuario(Localidad localidad) {
		this.localidad = localidad;
	}

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
	
	public String getContrasenia() {
		return contrasenia;
	}
	
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public Long getPuntajeBeneficio() {
		return puntajeBeneficio;
	}

	public void setPuntajeBeneficio(Long puntajeBeneficio) {
		this.puntajeBeneficio = puntajeBeneficio;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	
	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
	
	
}
