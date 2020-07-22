package net.t6.olmedobe.entities;
import javax.persistence.*;
import java.sql.Date;

	
@Entity
@Table(name = "`integrante_club`")
public class IntegranteClub {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_integrante")
	private Long id;
	
	@Column(name="nombre_integrante")
	private String nombre;
	
	@Column(name="perfil_integrante")
	private String perfil;
	
	@Basic
	@Column(name="fecha_nacimiento_integrante")
	private Date fechaNacimiento;
	
	@Column(name="equipo_procedencia")
	private String equipoProcedencia;
	
	@Column(name="pais_procedencia")
	private String paisProcedencia;
	
	@Column(name="estatura_integrante")
	private Double estatura;
	
	@Column(name="peso_integrante")
	private Double peso;
	
	@Column(name="funcion_integrante")
	private String funcion;
	
	@Lob
	@Column(name="foto_integrante")
	private byte[] foto;
	
	@ManyToOne
    @JoinColumn(name="id_usuario", nullable=false)
	private Usuario usuario;
	
	public IntegranteClub() {}

	public IntegranteClub(Usuario usuario) {
		this.usuario = usuario;
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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
