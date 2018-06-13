package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Producto;
import modelo.ProductoModelo;

/**
 * Servlet implementation class Listar
 */
@WebServlet("/Listar")
public class Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//conseguir los productos de la BBDD
		ProductoModelo productoModelo = new ProductoModelo();
		
		ArrayList<Producto> productos = productoModelo.sellectAll();
		
		//enviarlos a la vista de Listado.jsp
		
		request.setAttribute("productos", productos);
		
		request.getRequestDispatcher("listado.jsp").forward(request, response);
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
