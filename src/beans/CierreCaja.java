package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the cierre_caja database table.
 * 
 */
@Entity
@Table(name="cierre_caja")
@NamedQuery(name="CierreCaja.findAll", query="SELECT c FROM CierreCaja c")
public class CierreCaja implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CierreCajaPK id;

	private byte activo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date actualizado;

	@Column(name="apertura_caja")
	private BigDecimal aperturaCaja;

	private String codigo;

	private Timestamp creado;

	private Time hora;

	@Column(name="monto_esperado")
	private BigDecimal montoEsperado;

	@Column(name="monto_total")
	private BigDecimal montoTotal;

	@Lob
	private String observacion;

	@Column(name="saldo_faltante")
	private BigDecimal saldoFaltante;

	private String turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	public CierreCaja() {
	}

	public CierreCajaPK getId() {
		return this.id;
	}

	public void setId(CierreCajaPK id) {
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

	public BigDecimal getAperturaCaja() {
		return this.aperturaCaja;
	}

	public void setAperturaCaja(BigDecimal aperturaCaja) {
		this.aperturaCaja = aperturaCaja;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Timestamp getCreado() {
		return this.creado;
	}

	public void setCreado(Timestamp creado) {
		this.creado = creado;
	}

	public Time getHora() {
		return this.hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public BigDecimal getMontoEsperado() {
		return this.montoEsperado;
	}

	public void setMontoEsperado(BigDecimal montoEsperado) {
		this.montoEsperado = montoEsperado;
	}

	public BigDecimal getMontoTotal() {
		return this.montoTotal;
	}

	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public BigDecimal getSaldoFaltante() {
		return this.saldoFaltante;
	}

	public void setSaldoFaltante(BigDecimal saldoFaltante) {
		this.saldoFaltante = saldoFaltante;
	}

	public String getTurno() {
		return this.turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}