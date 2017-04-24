package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.sql.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import beans.*;

//import beans.Usuario;

import dao.interfaces.*;
import daofactory.DaoFactory;
import util.UFormat;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/cierre-caja")
public class CierreCajaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
	private HttpSession session;
	private Usuario usuario;
	private Gson gson;
	private DaoFactory dao;
	private CierreCajaDao cierreCajaDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CierreCajaServlet() {
        super();
        gson = new GsonBuilder().setPrettyPrinting().create();
        dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
        cierreCajaDao = dao.getCierreCajaDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession();
		usuario = (Usuario) session.getAttribute("usuario");
		
		if(usuario != null){
			
			try {

				String totalBoleta = cierreCajaDao.totalComprobanteVenta("BOLETA");
				String totalFactura = cierreCajaDao.totalComprobanteVenta("FACTURA");
								
				request.setAttribute("total_boleta", totalBoleta);
				request.setAttribute("total_factura", totalFactura);
				
			} catch (Exception e) {
				out.print(e.getMessage());
			}
			
			getServletContext().getRequestDispatcher("/pages/view/cierre-caja.jsp").forward(request, response);
		}else{
			response.sendRedirect(request.getContextPath() + "/login");
		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		out = response.getWriter();
		try {
			
			String formData = request.getParameter("formData");
			Type listType = new TypeToken<List<FormDataOrdenIngreso>>() {}.getType();
			List<FormDataOrdenIngreso> list = gson.fromJson(formData, listType);
	  
			session = request.getSession();
			CierreCaja object = getCierreCaja(list);
			int id = cierreCajaDao.create(object);

			out.println(id);
			
		} catch (Exception e) {
			out.print(e.getMessage());
		}
		
	}
	
	private CierreCaja getCierreCaja(List<FormDataOrdenIngreso> list){

		/*
		for (FormDataOrdenIngreso w : list){
			System.out.println(w.getValue());
		}
		*/
		

		CierreCaja object = new CierreCaja();
		object.setUsuario(usuario);
		object.setAperturaCaja(UFormat.bigDecimal(list.get(0).getValue()));
		object.setTurno(list.get(1).getValue());
		//object.setHora(UFormat.time(list.get(2).getValue()));
		object.setObservacion(list.get(4).getValue());
		object.setMontoEsperado(UFormat.bigDecimal(list.get(5).getValue()));
		object.setMontoTotal(UFormat.bigDecimal(list.get(6).getValue()));

		return object;
		
	}
	
	
	
}
