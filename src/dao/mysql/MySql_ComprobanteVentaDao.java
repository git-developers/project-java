package dao.mysql;

import java.lang.reflect.Type;
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

import beans.ComprobanteVenta;
import beans.Perfil;
import beans.SysOrdenIngresoHasProducto;
import beans.ComprobanteVenta;
import daofactory.MySqlDaoFactory;
import dao.interfaces.ComprobanteVentaDao;

public class MySql_ComprobanteVentaDao extends MySqlDaoFactory implements ComprobanteVentaDao {

	@Override
	public List<ComprobanteVenta> findAll(String id) throws Exception {
		
		List<ComprobanteVenta> out = new ArrayList<ComprobanteVenta>(); 
		
		try {
			
			Connection con = MySqlDaoFactory.getMainConnection();
			Statement stmt = con.createStatement();
			
			String query = "SELECT t1.*, t2.nombre AS nombre_categoria  ";
			query += " FROM comprobante_venta t1  ";
			query += " INNER JOIN categoria t2 ON t2.id = t1.categoria_id ";
			query += "WHERE t1.activo = 1 ";
			
			if(id != null && !id.isEmpty()){
				query += " AND t1.codigo = '" + id + "' ";
			}
			
			query += "ORDER BY t1.id DESC";
			
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next()){
				
				ComprobanteVenta object = new ComprobanteVenta();
				//object.setDescuento(rs.getString("descripcion"));
				out.add(object);
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return out;

	}
	
	@Override
	public int create(ComprobanteVenta object) throws Exception {

		int flag = 0;
		int i = 0;
		int id = 0;
		
		try {

			Connection con = MySqlDaoFactory.getMainConnection();
			Statement stmt = con.createStatement();

			String query = 	"INSERT INTO comprobante_venta ";
			query += "(usuario_id, tipo_comprobante, cliente_id, sub_total, descuento, total) ";
			query += "VALUES ";
			query += "('"+object.getUsuario().getId()+"', '"+object.getTipoComprobante()+"', '"+object.getCliente().getId()+"', '"+object.getSubTotal()+"', '"+object.getDescuento()+"', '"+object.getTotal()+"')";
	
			System.out.println(query);

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
		
			int i =	stmt.executeUpdate("DELETE FROM comprobante_venta WHERE id=" + id);

			if(i==1){
				flag=true;
			}
				
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}
	
	@Override
	public ComprobanteVenta findOneById(String id) throws Exception {

		ComprobanteVenta object = null;
		
		try {
			Connection con = MySqlDaoFactory.getMainConnection();
			Statement stmt = con.createStatement();
			
			String query = "SELECT "
					+ "t2.nombre comprobante_venta, t2.id perfil_id, "
					+ "t1.* "
					+ "FROM ComprobanteVenta AS t1 INNER JOIN perfil AS t2 ON t2.id = t1.perfil_id "
					+ "WHERE t1.id = '"+id+"'";
			
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()){	
				Perfil perfil = new Perfil();
				perfil.setId(rs.getInt("perfil_id"));
				perfil.setNombre(rs.getString("perfil_nombre"));
				
				
				object = new ComprobanteVenta();
				//ComprobanteVenta.setId(rs.getString("id"));
				//object.setDescripcion(rs.getString("nombre"));
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return object;
	}

	@Override
	public int update(ComprobanteVenta object) throws Exception {
		int flag = -1;
		
		try {
			Connection con = MySqlDaoFactory.getMainConnection();
			Statement stmt = con.createStatement();
	
			String query = "UPDATE comprobante_venta SET " +
							"nombre='"+object.getTotal()+"'," +
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
	
	public int ordenComprobanteventaHasProducto(int id, String values) throws Exception {
		
		Connection con = MySqlDaoFactory.getMainConnection();
		Statement stmt = con.createStatement();

		Type listType = new TypeToken<List<SysOrdenIngresoHasProducto>>() {}.getType();
		List<SysOrdenIngresoHasProducto> yourList = new Gson().fromJson(values, listType);
		
		for(SysOrdenIngresoHasProducto a : yourList)  {
			String query = 	"INSERT INTO comprobante_venta_has_producto " +
					"(comprobante_venta_id, producto_id) " +
					"VALUES " +
					"('"+id+"','"+a.getId_item()+"')";
	
			int i = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
		}

		return -1;
	}
	
	
	
	
	
}
