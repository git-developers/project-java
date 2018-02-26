package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import daofactory.MySqlDaoFactory;
import util.UFormat;
import beans.Categoria;
import beans.Producto;
import dao.interfaces.ProductoDao;

public class MySql_ProductoDao extends MySqlDaoFactory implements ProductoDao {

	
	
	@Override
	public List<Producto> findAll(String id) throws Exception {
		
		List<Producto> out = new ArrayList<Producto>(); 
		
		try {
			
			Connection con = MySqlDaoFactory.getMainConnection();
			Statement stmt = con.createStatement();
			
			String query = "SELECT t1.*, t2.nombre AS nombre_categoria FROM producto t1  ";
			query += " INNER JOIN categoria t2 ON t2.id = t1.categoria_id ";
			query += "WHERE t1.activo = 1 ";
			
			if(id != null && !id.isEmpty()){
				query += " AND t1.codigo = '" + id + "' ";
			}
			
			query += "ORDER BY t1.id DESC";
			
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next()){
				
				Categoria categoria = new Categoria();
				categoria.setNombre(rs.getString("nombre_categoria"));
				
				Producto object = new Producto();
				object.setId(Integer.parseInt(rs.getString("id")));
				object.setPrecio(UFormat.bigDecimal(rs.getString("precio")));
				object.setCodigo(rs.getString("codigo"));
				object.setColor(rs.getString("color"));
				object.setDescripcion(rs.getString("descripcion"));
				object.setStock(Integer.valueOf(rs.getString("stock")));
				object.setTipoTela(rs.getString("tipo_tela"));
				object.setTalla(rs.getString("talla"));
				object.setCategoria(categoria);
				out.add(object);
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return out;

	}
	
	

	@Override
	public List<Producto> findAll2(String id) throws Exception {
		
		List<Producto> out = new ArrayList<Producto>(); 
		
		try {
			
			Connection con = MySqlDaoFactory.getMainConnection();
			Statement stmt = con.createStatement();
			
			String query = "SELECT t1.*, t2.nombre AS nombre_categoria FROM producto t1  ";
			query += " INNER JOIN categoria t2 ON t2.id = t1.categoria_id ";
			query += "WHERE t1.activo = 1 ";
			
			if(id != null && !id.isEmpty()){
				query += " AND t1.codigo = '" + id + "' ";
			}
			
			query += "ORDER BY t1.id DESC";
			
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next()){
				
				Categoria categoria = new Categoria();
				categoria.setNombre(rs.getString("nombre_categoria"));
				
				Producto object = new Producto();
				object.setId(Integer.parseInt(rs.getString("id")));
				object.setPrecio(UFormat.bigDecimal(rs.getString("precio")));
				object.setCodigo(rs.getString("codigo"));
				object.setColor(rs.getString("color"));
				object.setDescripcion(rs.getString("descripcion"));
				//object.setStock(Integer.valueOf(rs.getString("stock")));
				object.setStock(0);
				object.setTipoTela(rs.getString("tipo_tela"));
				object.setTalla(rs.getString("talla"));
				object.setCategoria(categoria);
				out.add(object);
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return out;

	}
	
	
	
	
	
}
