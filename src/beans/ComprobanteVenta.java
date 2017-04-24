package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the comprobante_venta database table.
 * 
 */
@Entity
@Table(name="comprobante_venta")
@NamedQuery(name="ComprobanteVenta.findAll", query="SELECT c FROM ComprobanteVenta c")
public class ComprobanteVenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ComprobanteVentaPK id;

	private byte activo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date actualizado;

	private Timestamp creado;

	private BigDecimal descuento;

	@Column(name="sub_total")
	private BigDecimal subTotal;

	@Column(name="tipo_comprobante")
	private String tipoComprobante;

	private BigDecimal total;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	private Cliente cliente;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	public ComprobanteVenta() {
	}

	public ComprobanteVentaPK getId() {
		return this.id;
	}

	public void setId(ComprobanteVentaPK id) {
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

	public BigDecimal getDescuento() {
		return this.descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public BigDecimal getSubTotal() {
		return this.subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public String getTipoComprobante() {
		return this.tipoComprobante;
	}

	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}