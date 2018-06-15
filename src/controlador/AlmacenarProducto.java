package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Marca;
import modelo.Producto;
import modelo.ProductoModelo;

/**
 * Servlet implementation class AlmacenarProducto
 */
@WebServlet("/AlmacenarProducto")
public class AlmacenarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlmacenarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recoger parametros
		try {
			String nombre = request.getParameter("nombre");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaCompra = sdf.parse(request.getParameter("fecha_compra"));
			double precio = Double.parseDouble(request.getParameter("precio"));
			int idMarca = Integer.parseInt(request.getParameter("marca"));
			
			//crear el objeto producto
			Producto producto = new Producto();
			producto.setNombre(nombre);
			producto.setFechaCompra(fechaCompra);
			producto.setPrecio(precio);
			
			Marca marca = new Marca();
			marca.setId(idMarca);
			producto.setMarca(marca);
			
			//crear modelo
			ProductoModelo productoModelo = new ProductoModelo();
			
			//ejecutar insert
			productoModelo.insert(producto);

			//ver producto o listado o lo que sea
			response.sendRedirect("Listar");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
