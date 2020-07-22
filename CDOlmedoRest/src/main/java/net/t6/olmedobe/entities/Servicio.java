package net.t6.olmedobe.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
	
@Entity
@Table(name = "`servicio`")
public class Servicio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_servicio")
	private Long id;
	
	@Column(name="nombre_servicio")
	private String nombre;
	
	@Column(name="detalle_servicio")
	private String detalle;
	
	@Lob
	@Column(name="foto_servicio")
	private byte[] foto;

	@Column(name="estado_servicio")
	private String estado;
	
	@Column(name="valor_servicio")
	private Double valor;
	
	@Column(name="descuento_servicio")
	private Long descuento;
	
	@ManyToOne
    @JoinColumn(name="id_tipo_servicio", nullable=false)
	private TipoServicio tipoServicio;
	
	public Servicio() {}
	
	public Servicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
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
	
	public String getDetalle() {
		return detalle;
	}
	
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Long getDescuento() {
		return descuento;
	}
	
	public void setDescuento(Long descuento) {
		this.descuento = descuento;
	}

	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	
	
	
}
