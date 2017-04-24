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
import beans.Cliente;
import dao.interfaces.ClienteDao;

public class MySql_ClienteDao extends MySqlDaoFactory implements ClienteDao {

	@Override
	public List<Cliente> findAll(String id) throws Exception {
		
		List<Cliente> out = new ArrayList<Cliente>(); 
		
		try {
			
			Connection con = MySqlDaoFactory.getMainConnection();
			Statement stmt = con.createStatement();
			
			String query = "SELECT t1.* FROM cliente t1  ";
			query += "WHERE t1.activo = 1 ";
			
			if(id != null && !id.isEmpty()){
				query += " AND t1.dni = '" + id + "' ";
			}
			
			query += "ORDER BY t1.id DESC";
			
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next()){

				Cliente object = new Cliente();
				object.setId(Integer.parseInt(rs.getString("id")));
				object.setDni(rs.getString("dni"));
				object.setDireccion(rs.getString("direccion"));
				object.setNombre(rs.getString("nombre"));
				object.setRuc(rs.getString("ruc"));
				out.add(object);
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return out;

	}
	
	
}
