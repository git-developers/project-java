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
@WebServlet("/comprobante-de-venta")
public class ComprobanteVentaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
	private HttpSession session;
	private Usuario usuario;
	private Gson gson;
	private DaoFactory dao;
	private ComprobanteVentaDao comprobanteVentaDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComprobanteVentaServlet() {
        super();
        gson = new GsonBuilder().setPrettyPrinting().create();
        dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
        comprobanteVentaDao = dao.getComprobanteVentaDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession();
		usuario = (Usuario) session.getAttribute("usuario");
		
		if(usuario != null){
			getServletContext().getRequestDispatcher("/pages/view/comprobante-de-venta.jsp").forward(request, response);
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
			ComprobanteVenta object = getComprobanteVenta(list);
			int id = comprobanteVentaDao.create(object);

			String values = request.getParameter("values");
			comprobanteVentaDao.ordenComprobanteventaHasProducto(id, values);
			
			out.println(id);
			
		} catch (Exception e) {
			out.print(e.getMessage());
		}
		
	}
	
	private ComprobanteVenta getComprobanteVenta(List<FormDataOrdenIngreso> list){

		/*
		for (FormDataOrdenIngreso w : list){
			System.out.println(w.getValue());
		}
		*/
		
		Cliente cliente = new Cliente();
		cliente.setId(Integer.valueOf(list.get(1).getValue()));

		ComprobanteVenta object = new ComprobanteVenta();
		object.setUsuario(usuario);
		object.setTipoComprobante(list.get(0).getValue());
		object.setCliente(cliente);
		object.setSubTotal(UFormat.bigDecimal(list.get(2).getValue()));
		object.setDescuento(UFormat.bigDecimal(list.get(3).getValue()));
		object.setTotal(UFormat.bigDecimal(list.get(4).getValue()));
		
		return object;
		
	}
	
	
	
}
