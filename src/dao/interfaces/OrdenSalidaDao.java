package dao.interfaces;

import java.util.List;
import java.util.Vector;

import beans.OrdenSalida;

public interface OrdenSalidaDao {
	
	public List<OrdenSalida> findAll(String id) throws Exception;
	public int create(OrdenSalida object) throws Exception;
	public boolean delete(int id) throws Exception;
	public OrdenSalida findOneById(String id) throws Exception;
	public int update(OrdenSalida object) throws Exception;
	public int ordenSalidaHasProducto(int id, String values) throws Exception;
	
}
