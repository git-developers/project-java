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

import dao.interfaces.UsuarioDao;
import daofactory.DaoFactory;
import util.UFormat;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private DaoFactory dao;
	private HttpSession session;
	private PrintWriter out;
	private Usuario usuario;
	private UsuarioDao usuarioDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();

        dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
        usuarioDao = dao.getUsuarioDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/pages/view/login.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		out = response.getWriter();
		
		try {
			
			session = request.getSession();
			usuario = getUsuario(request);
			usuario = usuarioDao.validate(usuario);
			
			if(usuario == null){
				session.setAttribute("loginError", "Parece que te equivocaste.");
				response.sendRedirect(request.getContextPath() +"/login");
			}else{
				session.setAttribute("usuario",  usuario);
				response.sendRedirect(request.getContextPath() +"/dashboard");
			}
			
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}
	
	private Usuario getUsuario(HttpServletRequest request){
		
		String username = request.getParameter("_username");
		String passwordPlain = request.getParameter("_password");
		
		Usuario object = new Usuario();
		object.setUsername(username);
		object.setPasswordPlain(passwordPlain);
		
		return object;
		
	}
	
	
	
	
}
