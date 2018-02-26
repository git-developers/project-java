package beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the orden_ingreso_has_producto database table.
 * 
 */
@Entity
@Table(name="orden_ingreso_has_producto")
@NamedQuery(name="OrdenIngresoHasProducto.findAll", query="SELECT o FROM OrdenIngresoHasProducto o")
public class OrdenIngresoHasProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int orden_ingreso_id;
	
	/*
	@EmbeddedId
	private OrdenIngresoHasProductoPK id;

	public OrdenIngresoHasProducto() {
	}

	public OrdenIngresoHasProductoPK getId() {
		return this.id;
	}

	public void setId(OrdenIngresoHasProductoPK id) {
		this.id = id;
	}
	*/

}