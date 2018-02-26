package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import beans.CierreCaja;
import beans.Perfil;
import beans.CierreCaja;
import daofactory.MySqlDaoFactory;
import dao.interfaces.CierreCajaDao;

public class MySql_CierreCajaDao extends MySqlDaoFactory implements CierreCajaDao {

	@Override
	public List<CierreCaja> findAll(String id) throws Exception {
		
		List<CierreCaja> out = new ArrayList<CierreCaja>(); 
		
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
				
				CierreCaja object = new CierreCaja();
				//object.setDescuento(rs.getString("descripcion"));
				out.add(object);
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return out;

	}
	
	@Override
	public int create(CierreCaja object) throws Exception {

		int flag = 0;
		int i = 0;
		int id = 0;
		
		try {

			Connection con = MySqlDaoFactory.getMainConnection();
			Statement stmt = con.createStatement();

			String query = 	"INSERT INTO cierre_caja ";
			query += "(usuario_id, apertura_caja, turno, observacion, monto_esperado, monto_total) ";
			query += "VALUES ";
			query += "('"+object.getUsuario().getId()+"', '"+object.getAperturaCaja()+"', '"+object.getTurno()+"', '"+object.getObservacion()+"', '"+object.getMontoEsperado()+"', '"+object.getMontoTotal()+"')";
	
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
	public CierreCaja findOneById(String id) throws Exception {

		CierreCaja object = null;
		
		try {
			Connection con = MySqlDaoFactory.getMainConnection();
			Statement stmt = con.createStatement();
			
			String query = "SELECT "
					+ "t2.nombre comprobante_venta, t2.id perfil_id, "
					+ "t1.* "
					+ "FROM CierreCaja AS t1 INNER JOIN perfil AS t2 ON t2.id = t1.perfil_id "
					+ "WHERE t1.id = '"+id+"'";
			
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()){	
				Perfil perfil = new Perfil();
				perfil.setId(rs.getInt("perfil_id"));
				perfil.setNombre(rs.getString("perfil_nombre"));
				
				
				object = new CierreCaja();
				//CierreCaja.setId(rs.getString("id"));
				//object.setDescripcion(rs.getString("nombre"));
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return object;
	}

	@Override
	public int update(CierreCaja object) throws Exception {
		int flag = -1;
		
		try {
			Connection con = MySqlDaoFactory.getMainConnection();
			Statement stmt = con.createStatement();
	
			String query = "UPDATE comprobante_venta SET " +
							"nombre='"+object.getCodigo()+"'," +
							"WHERE id='"+object.getCodigo()+"'";
			
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
	

	@Override
	public String totalComprobanteVenta(String tipoComprobante) throws Exception {

		String total = "0";
		
		try {
			Connection con = MySqlDaoFactory.getMainConnection();
			Statement stmt = con.createStatement();
			
			String query = "SELECT sum(total) total FROM almacenamiento_inventario.comprobante_venta WHERE tipo_comprobante = '"+tipoComprobante+"'";
			
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()){	
				total = rs.getString("total");
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return total;
	}

	
	
	
	
}
