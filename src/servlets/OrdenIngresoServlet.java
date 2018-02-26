package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import java.lang.reflect.Type;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import beans.FormDataOrdenIngreso;
import beans.Usuario;
import beans.OrdenIngreso;
import dao.interfaces.OrdenIngresoDao;

//import beans.Usuario;

import dao.interfaces.UsuarioDao;
import daofactory.DaoFactory;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/mercaderia-orden-ingreso")
public class OrdenIngresoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
	private HttpSession session;
	private Usuario usuario;
	private Gson gson;
	private DaoFactory dao;
	private OrdenIngresoDao ordenIngresoDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdenIngresoServlet() {
        super();

        gson = new GsonBuilder().setPrettyPrinting().create();
        dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
        ordenIngresoDao = dao.getOrdenIngresoDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession();
		usuario = (Usuario) session.getAttribute("usuario");
		
		if(usuario != null){
			getServletContext().getRequestDispatcher("/pages/view/orden-ingreso.jsp").forward(request, response);
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
			OrdenIngreso object = getOrdenIngreso(list);
			int id = ordenIngresoDao.create(object);

			String values = request.getParameter("values");
			ordenIngresoDao.ordenIngresoHasProducto(id, values);
			
			out.println(id);
			
		} catch (Exception e) {
			out.print(e.getMessage());
		}
		
	}
	
	private OrdenIngreso getOrdenIngreso(List<FormDataOrdenIngreso> list){

		
		for (FormDataOrdenIngreso w : list){
			System.out.println(w.getValue());
		}
		 
		
		OrdenIngreso object = new OrdenIngreso();
		object.setUsuario(usuario);
		object.setRemitente(list.get(0).getValue());
		object.setFechaSalida(Date.valueOf(list.get(1).getValue()));
		object.setDescripcion(list.get(2).getValue());
		
		return object;
		
	}

	
}
