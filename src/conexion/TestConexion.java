package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import codigonegocio.Producto;

public class TestConexion {
	Conexion conexion = new Conexion();
	
	Statement stm=null;
	ResultSet rs=null;

	public TestConexion() {
		
	}
	public  String   consultarResumen() {
		Connection cn =conexion.conectar();
		
		StringBuilder actual = new StringBuilder();
		actual.append("id "+"name "+"category "+"amount "+ "price ").append("\n");
		try {
			
			stm =cn.createStatement();		
			rs = stm.executeQuery("SELECT *FROM product ");
			
			while(rs.next()) {		
				int id=rs.getInt(1);
				String name = rs.getString(2);
				String category = rs.getString(3);
				int amount=rs.getInt(4);
				int price=rs.getInt(5);
				actual.append(id+ " "+name+ " "+ category+" "+amount+" "+ price).append("\n");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}finally {
			cerrarconexion(rs, stm, cn);
		}
		return actual.toString();		
	}
	
	
	
	
		
	
	
	public  void   añadirProducto(Producto producto) {
		Connection cn =conexion.conectar();
	        try{
	            stm =cn.createStatement();
	            stm.executeUpdate("insert into product (name,  category, amount,price) values ('"+producto.getNombre()+"', '"+producto.getCategoria()+"',"+producto.getCantidad()+","+producto.getPrecio()+"  )");            
	        }catch(SQLException e){
	        	e.printStackTrace();
	        }
	}
	
	public String BuscarProductoPorPrecio(int priceRequested) {
		Connection cn =conexion.conectar();
		StringBuilder Producto = new StringBuilder();
		Producto.append("id "+"name "+"category "+"amount "+ "price ").append("\n");
		try {
			
			stm =cn.createStatement();		
			rs = stm.executeQuery("SELECT *FROM product ");
			
			while(rs.next()) {		
				int id=rs.getInt(1);
				String name = rs.getString(2);
				String category = rs.getString(3);
				int amount=rs.getInt(4);
				int price=rs.getInt(5);
				if(price == priceRequested)
					Producto.append(id+ " "+name+ " "+ category+" "+amount+" "+ price).append("\n");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}finally {
			cerrarconexion(rs, stm, cn);
		}
		return	Producto.toString();		
		
		
	}
	
	public String BuscarProductoPorId(int idRequested) {
		Connection cn =conexion.conectar();
		StringBuilder Producto = new StringBuilder();
		Producto.append("id "+"name "+"category "+"amount "+ "price ").append("\n");
		try {
			
			stm =cn.createStatement();		
			rs = stm.executeQuery("SELECT *FROM product ");
			
			while(rs.next()) {	
				int id=rs.getInt(1);
				String name = rs.getString(2);
				String category = rs.getString(3);
				int amount=rs.getInt(4);
				int price=rs.getInt(5);
				if(id == idRequested)
					Producto.append(id+ " "+name+ " "+ category+" "+amount+" "+ price).append("\n");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}finally {
			cerrarconexion(rs, stm, cn);
		}
		return	Producto.toString();				
	}
	
	public String BuscarProductoPorNombre(String nameRequested) {
		Connection cn =conexion.conectar();
		StringBuilder Producto = new StringBuilder();
		Producto.append("id "+"name "+"category "+"amount "+ "price ").append("\n");
		try {
			
			stm =cn.createStatement();		
//			rs = stm.executeQuery("SELECT *FROM Product where name = '"+nameRequested+"'");
			rs = stm.executeQuery("SELECT *FROM Product ");
			
			while(rs.next()) {	
				int id=rs.getInt(1);
				String name = rs.getString(2);
				String category = rs.getString(3);
				int amount=rs.getInt(4);
				int price=rs.getInt(5);
				if(name.equals( nameRequested))
					Producto.append(id+ " "+name+ " "+ category+" "+amount+" "+ price).append("\n");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}finally {
			cerrarconexion(rs, stm, cn);
		}
		return	Producto.toString();				
	}
	
	public void BorrarUnProducto(int idDelProducto) {
		Connection cn =conexion.conectar();
		try {
			stm =cn.createStatement();
			stm.executeUpdate("delete from product where id = "+idDelProducto+"");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void ModificarUnProductoAmount(int id, int unidadesUsadas) {
		Connection cn =conexion.conectar();
		try {
			String sql = "UPDATE Product set amount = amount-?"+ " WHERE id=?";
			PreparedStatement ps =null;
			ps = cn.prepareStatement(sql);
			ps.setInt(1, unidadesUsadas);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void usarUnproducto(int idDelProducto, int unidadesUsadas) {
		Connection cn =conexion.conectar();
		try {
			
			stm =cn.createStatement();		
			rs = stm.executeQuery("SELECT *FROM product ");
			
			while(rs.next()) {	
				int id=rs.getInt(1);
				int amount=rs.getInt(4);
				if(id == idDelProducto) {
					if(amount-unidadesUsadas>0) {
						ModificarUnProductoAmount(id, unidadesUsadas);//este 
					}																						//y
					else if(amount-unidadesUsadas<=0){
						BorrarUnProducto(idDelProducto);                          // este cerraban el rs, mientras se seguia ejecutando en el while 
																											// y por eso tuve que sacarles el cerrarconexion();
						
					}
				}				
			}
			cerrarconexion(rs, stm, cn);
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
	}

	
	public void cerrarconexion(ResultSet rs , Statement stm, Connection cn) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(stm!=null) {
				stm.close();
			}
			if(cn!=null) {
				cn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
	
}
