package dao.interfaces;

import java.util.Vector;

import beans.Usuario;

public interface UsuarioDao {
	
	public Usuario validate(Usuario object) throws Exception;
	public int create(Usuario object) throws Exception;
	public boolean delete(int id) throws Exception;
	public Vector<Usuario> findAll() throws Exception;
	public Usuario findOneById(String id) throws Exception;
	public int update(Usuario object) throws Exception;
	
}
