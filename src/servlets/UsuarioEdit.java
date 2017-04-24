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

import dao.interfaces.UsuarioDao;

import daofactory.DaoFactory;

/**
 * Servlet implementation class CategoriaEditar
 */
@WebServlet("/UsuarioEditar")
public class UsuarioEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		try {
			
			DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);

			/*
			//##### ARRAY LIST #####
			UsuarioDao USUARIODAO = dao.getUsuarioDao();
			Vector<UsuarioBean> USUARIO = USUARIODAO.listar();	
			request.setAttribute("listaApoderado", USUARIO);
			//##### ARRAY LIST #####	
			*/

			String id = request.getParameter("id");
			UsuarioDao var1 = dao.getUsuarioDao();
			Usuario var2 = var1.findOneById(id);
			request.setAttribute("USUARIO", var2);
			
			getServletContext().getRequestDispatcher("/grupo0/form/editarUsuario.jsp").forward(request, response);
			
			
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
			
			DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
			
			String id = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String email = request.getParameter("email");
			String passwordPlain = request.getParameter("password");	
			
			//UsuarioPK objectPk = new UsuarioPK();
			//objectPk.setId(Integer.parseInt(id));
			
			Usuario object = new Usuario();
			//object.setId(objectPk);
			object.setNombre(nombre);
			object.setApellido(apellido);
			object.setEmail(email);
			object.setPasswordPlain(passwordPlain);
			
			UsuarioDao var1 = dao.getUsuarioDao();
			int var2 =  var1.update(object);
			
			//SESSION
			HttpSession sesion = request.getSession();
			
			if(var2 > 0){
				sesion.setAttribute("mensaje",  "usuario actualizado");
			}else{
				sesion.setAttribute("mensaje",  "error");
			}

			UsuarioDao var3 = dao.getUsuarioDao();
			Usuario var4 = var3.findOneById(id);	
			request.setAttribute("USUARIO", var4);

			response.sendRedirect(request.getContextPath() +"/UsuarioEditar?dato="+id);
			//getServletContext().getRequestDispatcher("/form/editarUsuario.jsp").forward(request, response);
			
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

}
