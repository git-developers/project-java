package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import beans.*;
import daofactory.MySqlDaoFactory;
import dao.interfaces.OrdenIngresoDao;

public class MySql_OrdenIngresoDao extends MySqlDaoFactory implements OrdenIngresoDao {

	@Override
	public List<OrdenIngreso> findAll(String id) throws Exception {
		
		List<OrdenIngreso> out = new ArrayList<OrdenIngreso>(); 
		
		try {
			
			Connection con = MySqlDaoFactory.getMainConnection();
			Statement stmt = con.createStatement();
			
			String query = "SELECT t1.*, t2.nombre AS nombre_categoria  ";
			query += " FROM orden_ingreso t1  ";
			query += " INNER JOIN categoria t2 ON t2.id = t1.categoria_id ";
			query += "WHERE t1.activo = 1 ";
			
			if(id != null && !id.isEmpty()){
				query += " AND t1.codigo = '" + id + "' ";
			}
			
			query += "ORDER BY t1.id DESC";
			
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next()){
				
				OrdenIngreso object = new OrdenIngreso();
				object.setDescripcion(rs.getString("descripcion"));
				out.add(object);
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return out;

	}
	
	@Override
	public int create(OrdenIngreso object) throws Exception {

		int flag = 0;
		int i = 0;
		int id = 0;
		
		try {

			Connection con = MySqlDaoFactory.getMainConnection();
			Statement stmt = con.createStatement();

			String query = 	"INSERT INTO orden_ingreso ";
			query += "(usuario_id, remitente, fecha_salida, descripcion) ";
			query += "VALUES ";
			query += "('"+object.getUsuario().getId()+"', '"+object.getRemitente()+"', '"+object.getFechaSalida()+"', '"+object.getDescripcion()+"')";
	
			//System.out.println(query);

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
		
			int i =	stmt.executeUpdate("DELETE FROM OrdenIngreso WHERE id=" + id);

			if(i==1){
				flag=true;
			}
				
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}
	
	@Override
	public OrdenIngreso findOneById(String id) throws Exception {

		OrdenIngreso object = null;
		
		try {
			Connection con = MySqlDaoFactory.getMainConnection();
			Statement stmt = con.createStatement();
			
			String query = "SELECT "
					+ "t2.nombre orden_ingreso, t2.id perfil_id, "
					+ "t1.* "
					+ "FROM OrdenIngreso AS t1 INNER JOIN perfil AS t2 ON t2.id = t1.perfil_id "
					+ "WHERE t1.id = '"+id+"'";
			
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()){	
				Perfil perfil = new Perfil();
				perfil.setId(rs.getInt("perfil_id"));
				perfil.setNombre(rs.getString("perfil_nombre"));
				
				
				object = new OrdenIngreso();
				//OrdenIngreso.setId(rs.getString("id"));
				object.setDescripcion(rs.getString("nombre"));
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return object;
	}

	@Override
	public int update(OrdenIngreso object) throws Exception {
		int flag = -1;
		
		try {
			Connection con = MySqlDaoFactory.getMainConnection();
			Statement stmt = con.createStatement();
	
			String query = "UPDATE orden_ingreso SET " +
							"nombre='"+object.getDescripcion()+"'," +
							"apellido='"+object.getDescripcion()+"', " +
							"WHERE id='"+object.getId()+"'";
			
			int i =	stmt.executeUpdate(query);
	
			//System.out.print(query);
			
			if(i==1){
				flag=1;
			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}
	
	public int ordenIngresoHasProducto(int id, String values) throws Exception {
		
		Connection con = MySqlDaoFactory.getMainConnection();
		Statement stmt = con.createStatement();

		Type listType = new TypeToken<List<SysOrdenIngresoHasProducto>>() {}.getType();
		List<SysOrdenIngresoHasProducto> yourList = new Gson().fromJson(values, listType);
		
		for(SysOrdenIngresoHasProducto a : yourList)  {
			String query = 	"INSERT INTO orden_ingreso_has_producto " +
					"(orden_ingreso_id, producto_id) " +
					"VALUES " +
					"('"+id+"','"+a.getId_item()+"')";
	
			int i = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
		}

		return -1;
	}
	
	
	
}
