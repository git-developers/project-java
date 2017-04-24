package dao.mysql;


import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import daofactory.MySqlDaoFactory;

import beans.Usuario;
import beans.Perfil;
import dao.interfaces.UsuarioDao;

public class MySql_UsuarioDao extends MySqlDaoFactory implements UsuarioDao {

	
	public Usuario validate(Usuario usuario) throws Exception {

		Usuario object = null;
		
		try {

			String query = "SELECT "
							+ "t2.nombre perfil_nombre, t2.id perfil_id, "
							+ "t1.*, t1.id usuario_id "
							+ "FROM usuario AS t1 INNER JOIN perfil AS t2 ON t2.id = t1.perfil_id "
							+ "WHERE t1.username = '"+usuario.getUsername()+"' AND "
							+ "t1.password_plain = '"+usuario.getPasswordPlain()+"'";
			
			
			//--------DAO-------
			Connection con = MySqlDaoFactory.getMainConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			//--------DAO-------
			
			
			if(rs.next()){
				
				Perfil perfil = new Perfil();
				perfil.setId(rs.getInt("perfil_id"));
				perfil.setNombre(rs.getString("perfil_nombre"));
				
				
				object = new Usuario();
				object.setId(Integer.valueOf(rs.getString("usuario_id")));
				object.setNombre(rs.getString("nombre"));
				object.setApellido(rs.getString("apellido"));
				object.setEmail(rs.getString("email"));
				object.setDni(rs.getString("dni"));
				object.setUsername(rs.getString("username"));
				object.setClaveWeb(rs.getString("clave_web"));
				object.setPerfil(perfil);
				
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return object;
	}

	@Override
	public Vector<Usuario> findAll() throws Exception {
		
		Vector<Usuario> out = null;
		
		try {
			
			Connection con = MySqlDaoFactory.getMainConnection();
			Statement stmt = con.createStatement();
			
			String query = "SELECT "
					+ "t2.nombre perfil_nombre, t2.id perfil_id, "
					+ "t1.* "
					+ "FROM usuario AS t1 INNER JOIN perfil AS t2 ON t2.id = t1.perfil_id "
					+ "ORDER BY t1.id DESC";
			
			ResultSet rs = stmt.executeQuery(query);
			out = new Vector<Usuario>();
			
			while(rs.next()){			
				Perfil perfil = new Perfil();
				perfil.setId(rs.getInt("perfil_id"));
				perfil.setNombre(rs.getString("perfil_nombre"));
				
				
				Usuario object = new Usuario();
				//USUARIO.setId(rs.getString("id"));
				object.setNombre(rs.getString("nombre"));
				object.setApellido(rs.getString("apellido"));
				object.setEmail(rs.getString("email"));
				object.setDni(rs.getString("dni"));
				object.setPerfil(perfil);
				
				out.add(object);
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return out;
		
	}
	
	@Override
	public int create(Usuario object) throws Exception {
		
		int flag = 0;
		int i = 0;
		int id = 0;
		
		try {

			Connection con = MySqlDaoFactory.getMainConnection();
			Statement stmt = con.createStatement();

			String query = 	"INSERT INTO usuario " +
							"(nombre,apellido,email) " +
							"VALUES " +
							"(" +
							"'"+object.getNombre()+"',"
							+ "'"+object.getApellido()+"',"
							+ "'"+object.getEmail()+"'" +
							")";
			
			i = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			
			if(i == 1){
				flag = 1;
				
				ResultSet rs = null;
				rs = stmt.getGeneratedKeys();
	            rs.next();
	            id = rs.getInt(1);
				System.out.print(id);
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		if(flag == 1)
			return id;
		else
			return flag;
	}

	@Override
	public boolean delete(int id) throws Exception {

		boolean flag = false;
		
		try {
			
			Connection con = MySqlDaoFactory.getMainConnection();
			Statement stmt = con.createStatement();
		
			int i =	stmt.executeUpdate("DELETE FROM usuario WHERE id=" + id);

			if(i==1){
				flag=true;
			}
				
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}
	
	
	@Override
	public Usuario findOneById(String id) throws Exception {

		Usuario object = null;
		
		try {
			Connection con = MySqlDaoFactory.getMainConnection();
			Statement stmt = con.createStatement();
			
			String query = "SELECT "
					+ "t2.nombre perfil_nombre, t2.id perfil_id, "
					+ "t1.* "
					+ "FROM usuario AS t1 INNER JOIN perfil AS t2 ON t2.id = t1.perfil_id "
					+ "WHERE t1.id = '"+id+"'";
			
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()){	
				Perfil perfil = new Perfil();
				perfil.setId(rs.getInt("perfil_id"));
				perfil.setNombre(rs.getString("perfil_nombre"));
				
				
				object = new Usuario();
				//USUARIO.setId(rs.getString("id"));
				object.setNombre(rs.getString("nombre"));
				object.setApellido(rs.getString("apellido"));
				object.setEmail(rs.getString("email"));
				object.setDni(rs.getString("dni"));
				object.setPerfil(perfil);
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return object;
	}

	@Override
	public int update(Usuario object) throws Exception {
		int flag = -1;
		
		try {
			Connection con = MySqlDaoFactory.getMainConnection();
			Statement stmt = con.createStatement();
	
			String query = "UPDATE usuario SET " +
							"nombre='"+object.getNombre()+"'," +
							"apellido='"+object.getApellido()+"', " +
							"email='"+object.getEmail()+"', " +
							"WHERE id='"+object.getId()+"'";
			
			int i =	stmt.executeUpdate(query);
	
			System.out.print(query);
			
			if(i==1){
				flag=1;
			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}
	
}
