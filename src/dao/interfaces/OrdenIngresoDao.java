package dao.interfaces;

import java.util.List;
import java.util.Vector;

import beans.OrdenIngreso;

public interface OrdenIngresoDao {
	
	public List<OrdenIngreso> findAll(String id) throws Exception;
	public int create(OrdenIngreso object) throws Exception;
	public boolean delete(int id) throws Exception;
	public OrdenIngreso findOneById(String id) throws Exception;
	public int update(OrdenIngreso object) throws Exception;
	public int ordenIngresoHasProducto(int id, String values) throws Exception;
	
}
