package codigonegocio;

import java.util.Objects;

public class Producto {
	String nombre;
	int id;
	String categoria;
	int cantidad;
	int precio;
	public Producto(String nombre, int id, String categoria, int cantidad, int precio) {
	
		this.nombre = nombre;
		this.id = id;
		this.categoria = categoria;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	
	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append("\n");
		ret.append("Nombre: ").append(nombre).append("\n");
		ret.append("id: ").append(id).append("\n");
		ret.append("categoria: ").append(categoria).append("\n");
		ret.append("cantidad: ").append(cantidad).append("\n");
		ret.append("precio: ").append(precio).append("\n");
		
		return  ret.toString();
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
	
}
