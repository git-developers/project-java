package dao.interfaces;

import java.util.List;

import beans.Producto;

public interface ProductoDao {
	
	public List<Producto> findAll(String id) throws Exception;
	public List<Producto> findAll2(String id) throws Exception;
	
}
