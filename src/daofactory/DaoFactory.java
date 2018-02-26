package daofactory;

import dao.interfaces.*;

public abstract class DaoFactory {

	public static final int MYSQL 		=1;
	public static final int SQLSERVER 	=2;
	public static final int ORACLE 		=3;

	
	//**********AGREGAR************
	public abstract UsuarioDao getUsuarioDao();
	public abstract ProductoDao getProductoDao();
	public abstract ClienteDao getClienteDao();
	public abstract OrdenIngresoDao getOrdenIngresoDao();
	public abstract OrdenSalidaDao getOrdenSalidaDao();
	public abstract ComprobanteVentaDao getComprobanteVentaDao();
	public abstract CierreCajaDao getCierreCajaDao();
	//**********AGREGAR************
	

	public static DaoFactory getDAOFactory(int factory){
		
		switch (factory) {
			case MYSQL:
				return new MySqlDaoFactory();
			case SQLSERVER:
				//return new SqlDaoFactory();
			case ORACLE:
				//return new OracleDaoFactory();
			default:
				return null;
		}
	}
	
}
