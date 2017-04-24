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
 * Servlet implementation class SlideAgregar
 */
@WebServlet("/UsuarioDetail")
public class UsuarioDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioDetail() {
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
			Usuario var2 = var1.findOneById(id);	
			request.setAttribute("USUARIO", var2);
			
			getServletContext().getRequestDispatcher("/detail/detailUsuario.jsp").forward(request,  response);
			
			
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

		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

	
}
