package beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comprobante_venta_has_producto database table.
 * 
 */
@Entity
@Table(name="comprobante_venta_has_producto")
@NamedQuery(name="ComprobanteVentaHasProducto.findAll", query="SELECT c FROM ComprobanteVentaHasProducto c")
public class ComprobanteVentaHasProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int comprobante_venta_id;
	
	/*
	@EmbeddedId
	private ComprobanteVentaHasProductoPK id;

	public ComprobanteVentaHasProducto() {
	}

	public ComprobanteVentaHasProductoPK getId() {
		return this.id;
	}

	public void setId(ComprobanteVentaHasProductoPK id) {
		this.id = id;
	}
	*/

}