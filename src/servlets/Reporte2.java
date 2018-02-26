package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Usuario;


/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/reporte-2")
public class Reporte2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private PrintWriter out;
	private Usuario usuario;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reporte2() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		usuario = (Usuario) session.getAttribute("usuario");
		
		if(usuario != null){
			getServletContext().getRequestDispatcher("/pages/view/reporte-2.jsp").forward(request, response);
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
			
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}	
	
}
