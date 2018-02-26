package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@Table(name="producto")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte activo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date actualizado;

	private String codigo;

	private String color;

	private Timestamp creado;

	@Lob
	private String descripcion;

	private String nombre;

	private BigDecimal precio;

	private int stock;

	private String talla;

	@Column(name="tipo_tela")
	private String tipoTela;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	private Categoria categoria;

	public Producto() {
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

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getTalla() {
		return this.talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getTipoTela() {
		return this.tipoTela;
	}

	public void setTipoTela(String tipoTela) {
		this.tipoTela = tipoTela;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}