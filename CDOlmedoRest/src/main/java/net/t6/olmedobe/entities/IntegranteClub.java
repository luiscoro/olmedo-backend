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
import java.util.UUID;
import org.hibernate.annotations.Type;
import java.sql.Date;
import javax.persistence.Basic;
	
@Entity
@Table(name = "integranteClub_table")
public class IntegranteClub {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String perfil;
	@Basic
	private Date fechaNacimiento;
	private String equipoProcedencia;
	private String paisProcedencia;
	private Double estatura;
	private Double peso;
	private String funcion;
	@Type(type = "uuid-char")
	private UUID foto;
	private Integer gol;
	
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
	
	public String getPerfil() {
		return perfil;
	}
	
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getEquipoProcedencia() {
		return equipoProcedencia;
	}
	
	public void setEquipoProcedencia(String equipoProcedencia) {
		this.equipoProcedencia = equipoProcedencia;
	}
	
	public String getPaisProcedencia() {
		return paisProcedencia;
	}
	
	public void setPaisProcedencia(String paisProcedencia) {
		this.paisProcedencia = paisProcedencia;
	}
	
	public Double getEstatura() {
		return estatura;
	}
	
	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}
	
	public Double getPeso() {
		return peso;
	}
	
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	public String getFuncion() {
		return funcion;
	}
	
	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
	
	public UUID getFoto() {
		return foto;
	}
	
	public void setFoto(UUID foto) {
		this.foto = foto;
	}
	
	public Integer getGol() {
		return gol;
	}
	
	public void setGol(Integer gol) {
		this.gol = gol;
	}
	
}
