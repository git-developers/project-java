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
 * Servlet implementation class SlideListar
 */
@WebServlet("/UsuarioListar")
public class UsuarioList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioList() {
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

			//##### ARRAY LIST #####
			UsuarioDao dao_ = dao.getUsuarioDao();
			Vector<Usuario> object = dao_.findAll();	
			request.setAttribute("LIST", object);
			
			getServletContext().getRequestDispatcher("/grupo0/list/listarUsuario.jsp").forward(request,  response);
			
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
