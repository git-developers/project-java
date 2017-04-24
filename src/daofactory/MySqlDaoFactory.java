package daofactory;

import java.sql.Connection;
import java.sql.DriverManager;

import dao.interfaces.*;

import dao.mysql.*;

public class MySqlDaoFactory extends DaoFactory {

	
	//**********ADD MODULES************
	@Override
	public UsuarioDao getUsuarioDao(){
		return new MySql_UsuarioDao();
	}
	@Override
	public ProductoDao getProductoDao(){
		return new MySql_ProductoDao();
	}
	@Override
	public OrdenIngresoDao getOrdenIngresoDao(){
		return new MySql_OrdenIngresoDao();
	}
	@Override
	public OrdenSalidaDao getOrdenSalidaDao(){
		return new MySql_OrdenSalidaDao();
	}
	@Override
	public ComprobanteVentaDao getComprobanteVentaDao(){
		return new MySql_ComprobanteVentaDao();
	}
	@Override
	public ClienteDao getClienteDao(){
		return new MySql_ClienteDao();
	}
	@Override
	public CierreCajaDao getCierreCajaDao(){
		return new MySql_CierreCajaDao();
	}
	//**********ADD MODULES************
	
	
	
	
	//start database connection
	public static Connection getMainConnection(){
		Connection con = null;
		
		try {
			//database
			String host = "localhost:3306";
			String dbName = "almacenamiento_inventario";
			String dbUser = "root";
			String dbPass = "toor";
			
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + host + "/" + dbName;			
			con = DriverManager.getConnection(url, dbUser, dbPass);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			System.out.print("SYSTEM INFO::: Connection Failed!");
			e.printStackTrace();
		}
		
		return con;
	}


	
}
