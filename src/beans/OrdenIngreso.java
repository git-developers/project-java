package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the orden_ingreso database table.
 * 
 */
@Entity
@Table(name="orden_ingreso")
@NamedQuery(name="OrdenIngreso.findAll", query="SELECT o FROM OrdenIngreso o")
public class OrdenIngreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrdenIngresoPK id;

	private byte activo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date actualizado;

	private Timestamp creado;

	@Lob
	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_salida")
	private Date fechaSalida;

	@Lob
	private String remitente;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	public OrdenIngreso() {
	}

	public OrdenIngresoPK getId() {
		return this.id;
	}

	public void setId(OrdenIngresoPK id) {
		this.id = id;
	}

	public byte getActivo() {
		return this.activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}

	public Date getActualizado() {
		return this.actualizado;
	}

	public void setActualizado(Date actualizado) {
		this.actualizado = actualizado;
	}

	public Timestamp getCreado() {
		return this.creado;
	}

	public void setCreado(Timestamp creado) {
		this.creado = creado;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getRemitente() {
		return this.remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}