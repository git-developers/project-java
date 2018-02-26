package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name="cliente")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte activo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date actualizado;

	private Timestamp creado;

	@Lob
	private String direccion;

	private String dni;

	@Lob
	private String nombre;

	private String ruc;

	//bi-directional many-to-one association to ComprobanteVenta
	@OneToMany(mappedBy="cliente")
	private List<ComprobanteVenta> comprobanteVentas;

	public Cliente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public List<ComprobanteVenta> getComprobanteVentas() {
		return this.comprobanteVentas;
	}

	public void setComprobanteVentas(List<ComprobanteVenta> comprobanteVentas) {
		this.comprobanteVentas = comprobanteVentas;
	}

	public ComprobanteVenta addComprobanteVenta(ComprobanteVenta comprobanteVenta) {
		getComprobanteVentas().add(comprobanteVenta);
		comprobanteVenta.setCliente(this);

		return comprobanteVenta;
	}

	public ComprobanteVenta removeComprobanteVenta(ComprobanteVenta comprobanteVenta) {
		getComprobanteVentas().remove(comprobanteVenta);
		comprobanteVenta.setCliente(null);

		return comprobanteVenta;
	}

}