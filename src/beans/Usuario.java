package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte activo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date actualizado;

	private String apellido;

	@Column(name="clave_web")
	private String claveWeb;

	private Timestamp creado;

	private String dni;

	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	private String nombre;

	private String password;

	@Column(name="password_plain")
	private String passwordPlain;

	private String ruc;

	private String salt;

	private String username;

	//bi-directional many-to-one association to CierreCaja
	@OneToMany(mappedBy="usuario")
	private List<CierreCaja> cierreCajas;

	//bi-directional many-to-one association to ComprobanteVenta
	@OneToMany(mappedBy="usuario")
	private List<ComprobanteVenta> comprobanteVentas;

	//bi-directional many-to-one association to OrdenIngreso
	@OneToMany(mappedBy="usuario")
	private List<OrdenIngreso> ordenIngresos;

	//bi-directional many-to-one association to OrdenSalida
	@OneToMany(mappedBy="usuario")
	private List<OrdenSalida> ordenSalidas;

	//bi-directional many-to-one association to Perfil
	@ManyToOne
	private Perfil perfil;

	public Usuario() {
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

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getClaveWeb() {
		return this.claveWeb;
	}

	public void setClaveWeb(String claveWeb) {
		this.claveWeb = claveWeb;
	}

	public Timestamp getCreado() {
		return this.creado;
	}

	public void setCreado(Timestamp creado) {
		this.creado = creado;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordPlain() {
		return this.passwordPlain;
	}

	public void setPasswordPlain(String passwordPlain) {
		this.passwordPlain = passwordPlain;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<CierreCaja> getCierreCajas() {
		return this.cierreCajas;
	}

	public void setCierreCajas(List<CierreCaja> cierreCajas) {
		this.cierreCajas = cierreCajas;
	}

	public CierreCaja addCierreCaja(CierreCaja cierreCaja) {
		getCierreCajas().add(cierreCaja);
		cierreCaja.setUsuario(this);

		return cierreCaja;
	}

	public CierreCaja removeCierreCaja(CierreCaja cierreCaja) {
		getCierreCajas().remove(cierreCaja);
		cierreCaja.setUsuario(null);

		return cierreCaja;
	}

	public List<ComprobanteVenta> getComprobanteVentas() {
		return this.comprobanteVentas;
	}

	public void setComprobanteVentas(List<ComprobanteVenta> comprobanteVentas) {
		this.comprobanteVentas = comprobanteVentas;
	}

	public ComprobanteVenta addComprobanteVenta(ComprobanteVenta comprobanteVenta) {
		getComprobanteVentas().add(comprobanteVenta);
		comprobanteVenta.setUsuario(this);

		return comprobanteVenta;
	}

	public ComprobanteVenta removeComprobanteVenta(ComprobanteVenta comprobanteVenta) {
		getComprobanteVentas().remove(comprobanteVenta);
		comprobanteVenta.setUsuario(null);

		return comprobanteVenta;
	}

	public List<OrdenIngreso> getOrdenIngresos() {
		return this.ordenIngresos;
	}

	public void setOrdenIngresos(List<OrdenIngreso> ordenIngresos) {
		this.ordenIngresos = ordenIngresos;
	}

	public OrdenIngreso addOrdenIngreso(OrdenIngreso ordenIngreso) {
		getOrdenIngresos().add(ordenIngreso);
		ordenIngreso.setUsuario(this);

		return ordenIngreso;
	}

	public OrdenIngreso removeOrdenIngreso(OrdenIngreso ordenIngreso) {
		getOrdenIngresos().remove(ordenIngreso);
		ordenIngreso.setUsuario(null);

		return ordenIngreso;
	}

	public List<OrdenSalida> getOrdenSalidas() {
		return this.ordenSalidas;
	}

	public void setOrdenSalidas(List<OrdenSalida> ordenSalidas) {
		this.ordenSalidas = ordenSalidas;
	}

	public OrdenSalida addOrdenSalida(OrdenSalida ordenSalida) {
		getOrdenSalidas().add(ordenSalida);
		ordenSalida.setUsuario(this);

		return ordenSalida;
	}

	public OrdenSalida removeOrdenSalida(OrdenSalida ordenSalida) {
		getOrdenSalidas().remove(ordenSalida);
		ordenSalida.setUsuario(null);

		return ordenSalida;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}