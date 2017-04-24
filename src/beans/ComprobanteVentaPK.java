package beans;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the comprobante_venta database table.
 * 
 */
@Embeddable
public class ComprobanteVentaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="usuario_id", insertable=false, updatable=false)
	private int usuarioId;

	@Column(name="cliente_id", insertable=false, updatable=false)
	private int clienteId;

	public ComprobanteVentaPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUsuarioId() {
		return this.usuarioId;
	}
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	public int getClienteId() {
		return this.clienteId;
	}
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ComprobanteVentaPK)) {
			return false;
		}
		ComprobanteVentaPK castOther = (ComprobanteVentaPK)other;
		return 
			(this.id == castOther.id)
			&& (this.usuarioId == castOther.usuarioId)
			&& (this.clienteId == castOther.clienteId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.usuarioId;
		hash = hash * prime + this.clienteId;
		
		return hash;
	}
}