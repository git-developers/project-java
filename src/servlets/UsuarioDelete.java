package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Usuario;

import dao.interfaces.UsuarioDao;

import daofactory.DaoFactory;

/**
 * Servlet implementation class CategoriaEliminar
 */
@WebServlet("/UsuarioEliminar")
public class UsuarioDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		try {
			
			String id = request.getParameter("id");
			
			DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
			UsuarioDao var1 = dao.getUsuarioDao();
			boolean elimino = var1.delete(Integer.parseInt(id));

			
			if(elimino){
				/*
				request.setAttribute("mensaje", "Item eliminado");
				//CREA NUEVO ARRAY
				Vector<UsuarioBean> var2 = var1.listarSolicitud();
				request.setAttribute("solicitud", var2);
				*/
				response.sendRedirect(request.getContextPath() +"/UsuarioListar");
			}else{
				request.setAttribute("mensaje", "error");
			}
			
			getServletContext().getRequestDispatcher("/grupo0/listar/listarUsuario.jsp").forward(request, response);
			
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
