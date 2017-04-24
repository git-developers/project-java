package servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.Producto;
import beans.Usuario;
import dao.interfaces.ProductoDao;
import daofactory.DaoFactory;

/**
 * Servlet implementation class SlideListar
 */
@WebServlet("/producto2.json")
public class Producto2Json extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private DaoFactory dao;
	private PrintWriter out;
	private String listToJson;
	private Gson gson;
	private ProductoDao productoDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Producto2Json() {
        super();
        // 
        dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
        productoDao = dao.getProductoDao();
        gson = new GsonBuilder()
    		    .setPrettyPrinting()
                .create();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		out = response.getWriter();
		
		try {

			String id = request.getParameter("id");
		    listToJson = gson.toJson(productoDao.findAll2(id));
		    out.println(listToJson);
			
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
