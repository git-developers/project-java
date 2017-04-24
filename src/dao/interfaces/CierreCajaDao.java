package dao.interfaces;

import java.util.List;
import java.util.Vector;

import beans.CierreCaja;

public interface CierreCajaDao {
	
	public List<CierreCaja> findAll(String id) throws Exception;
	public int create(CierreCaja object) throws Exception;
	public boolean delete(int id) throws Exception;
	public CierreCaja findOneById(String id) throws Exception;
	public int update(CierreCaja object) throws Exception;
	public String totalComprobanteVenta(String tipoComprobante) throws Exception;
}
