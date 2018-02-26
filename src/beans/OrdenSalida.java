package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the orden_salida database table.
 * 
 */
@Entity
@Table(name="orden_salida")
@NamedQuery(name="OrdenSalida.findAll", query="SELECT o FROM OrdenSalida o")
public class OrdenSalida implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrdenSalidaPK id;

	private byte activo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date actualizado;

	private Timestamp creado;

	@Lob
	private String descripcion;

	@Lob
	private String destino;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_salida")
	private Date fechaSalida;

	@Lob
	private String receptor;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	public OrdenSalida() {
	}

	public OrdenSalidaPK getId() {
		return this.id;
	}

	public void setId(OrdenSalidaPK id) {
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

	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getReceptor() {
		return this.receptor;
	}

	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}