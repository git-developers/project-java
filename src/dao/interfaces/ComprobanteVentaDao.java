package dao.interfaces;

import java.util.List;
import java.util.Vector;

import beans.ComprobanteVenta;

public interface ComprobanteVentaDao {
	
	public List<ComprobanteVenta> findAll(String id) throws Exception;
	public int create(ComprobanteVenta object) throws Exception;
	public boolean delete(int id) throws Exception;
	public ComprobanteVenta findOneById(String id) throws Exception;
	public int update(ComprobanteVenta object) throws Exception;
	public int ordenComprobanteventaHasProducto(int id, String values) throws Exception;
	
}
