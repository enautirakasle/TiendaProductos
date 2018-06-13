package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductoModelo extends Conector{

	public ArrayList<Producto> sellectAll() {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		try {
			
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from productos");
			
			while(rs.next()){
				Producto producto = new Producto();
				producto.setId(rs.getInt("id"));
				producto.setNombre(rs.getString("nombre"));
				producto.setFechaCompra(rs.getDate("fecha_compra"));
				producto.setPrecio(rs.getDouble("precio"));
				
				productos.add(producto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productos;
		
	}

	public Producto select(int idProducto) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("select * from productos where id=?");
			pst.setInt(1,idProducto);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				Producto producto= new Producto();
				producto.setId(rs.getInt("id"));
				producto.setNombre(rs.getString("nombre"));
				producto.setFechaCompra(rs.getDate("fecha_compra"));
				producto.setPrecio(rs.getDouble("precio"));
				return producto;
			}else{
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}