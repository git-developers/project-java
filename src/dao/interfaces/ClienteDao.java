package dao.interfaces;

import java.util.List;

import beans.Cliente;

public interface ClienteDao {
	
	public List<Cliente> findAll(String id) throws Exception;
	
}
