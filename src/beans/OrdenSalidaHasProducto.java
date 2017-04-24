package beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the orden_salida_has_producto database table.
 * 
 */
@Entity
@Table(name="orden_salida_has_producto")
@NamedQuery(name="OrdenSalidaHasProducto.findAll", query="SELECT o FROM OrdenSalidaHasProducto o")
public class OrdenSalidaHasProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int orden_salida_id;
	
	/*
	@EmbeddedId
	private OrdenSalidaHasProductoPK id;

	public OrdenSalidaHasProducto() {
	}

	public OrdenSalidaHasProductoPK getId() {
		return this.id;
	}

	public void setId(OrdenSalidaHasProductoPK id) {
		this.id = id;
	}
	*/

}