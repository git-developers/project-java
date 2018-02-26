package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Usuario;

//import beans.EmpresaBean;

import dao.interfaces.UsuarioDao;
import daofactory.DaoFactory;



/**
 * Servlet implementation class SlideAgregar
 */
@WebServlet("/UsuarioAgregar")
public class UsuarioCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		try {
			
			//SESSION
			HttpSession sesion = request.getSession();
			
			getServletContext().getRequestDispatcher("/grupo0/form/registrarUsuario.jsp").forward(request,  response);

		} catch (Exception e) {
			out.print(e.getMessage());
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		try {
			
			//SESSION
			HttpSession sesion = request.getSession();
			
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String email = request.getParameter("email");
			String passwordPlain = request.getParameter("password");
			
			
			DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
			UsuarioDao USUARIO_DAO = dao.getUsuarioDao();
			int flag = -1;

			Usuario object = new Usuario();
			object.setEmail(email);
			object.setNombre(nombre);
			object.setApellido(apellido);
			object.setPasswordPlain(passwordPlain);
			
			flag = USUARIO_DAO.create(object);

			
			if(flag  > 0){
				sesion.setAttribute("mensaje",  "Usuario Creado");
			}else{
				sesion.setAttribute("mensaje",  "error");
			}
			response.sendRedirect(request.getContextPath() +"/UsuarioListar");
			
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

	
	
	
	
}
