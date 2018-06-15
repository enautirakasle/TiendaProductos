package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductoModelo extends Conector{

	public ArrayList<Producto> sellectAll() {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		MarcaModelo marcaModelo = new MarcaModelo();
		try {
			
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from productos");
			
			while(rs.next()){
				Producto producto = new Producto();
				producto.setId(rs.getInt("id"));
				producto.setNombre(rs.getString("nombre"));
				producto.setFechaCompra(rs.getDate("fecha_compra"));
				producto.setPrecio(rs.getDouble("precio"));
				
				Marca marca = marcaModelo.select(rs.getInt("id_marca"));
				producto.setMarca(marca);
				
				productos.add(producto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productos;
		
	}

	public Producto select(int idProducto) {
		PreparedStatement pst;
		MarcaModelo marcaModelo = new MarcaModelo();
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
				
				Marca marca = marcaModelo.select(rs.getInt("id_marca"));
				producto.setMarca(marca);
				
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

	public void update(Producto producto) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("update productos set nombre=?, fecha_compra=?, precio=? where id=?");
			pst.setString(1, producto.getNombre());
			pst.setDate(2, new java.sql.Date(producto.getFechaCompra().getTime()));
			pst.setDouble(3, producto.getPrecio());
			pst.setInt(4, producto.getId());
			
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void delete(int id) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("delete from productos where id=?");
			pst.setInt(1, id);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void insert(Producto producto) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("insert into productos (nombre, fecha_compra, precio, id_marca) values(?, ?, ?, ?)");
			pst.setString(1, producto.getNombre());
			pst.setDate(2, new java.sql.Date(producto.getFechaCompra().getTime()));
			pst.setDouble(3, producto.getPrecio());
			pst.setInt(4, producto.getMarca().getId());
			pst.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
