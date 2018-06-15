package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MarcaModelo extends Conector{

	public ArrayList<Marca> selectAll() {
		ArrayList<Marca> marcas = new ArrayList<Marca>();
		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from marcas");
			
			while(rs.next()){
				Marca marca = new Marca();
				marca.setId(rs.getInt("id"));
				marca.setNombre(rs.getString("nombre"));

				marcas.add(marca);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return marcas;
	}

}
