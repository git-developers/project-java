package beans;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the orden_ingreso database table.
 * 
 */
@Embeddable
public class OrdenIngresoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="usuario_id", insertable=false, updatable=false)
	private int usuarioId;

	public OrdenIngresoPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrdenIngresoPK)) {
			return false;
		}
		OrdenIngresoPK castOther = (OrdenIngresoPK)other;
		return 
			(this.id == castOther.id)
			&& (this.usuarioId == castOther.usuarioId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.usuarioId;
		
		return hash;
	}
}