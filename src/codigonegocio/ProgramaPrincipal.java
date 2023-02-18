package codigonegocio;

import java.util.ArrayList;



public class ProgramaPrincipal {
	ArrayList<Producto> Inventario;
	
	public ProgramaPrincipal(){
		Inventario= new ArrayList<>();
		
	}
	
	public void agregarProducto(Producto producto) {
		excepcionId(producto);
		Inventario.add(producto);
	}
	
	private void excepcionId(Producto otroProducto) {
		for (Producto producto : Inventario) {
			if(producto.getId() == (otroProducto.getId()))
				throw new IllegalArgumentException("ese id ya existe"+producto.toString()+"ya lo tiene");
		}
		
	}
	public void eliminarunProducto(Producto pro) {
		if(Inventario.size()==1)
			Inventario.remove(0);
		for (Producto producto : Inventario) {
			if(producto.getId() == pro.getId())
				Inventario.remove(producto);
		}
	}
	
	public Producto dameunProducto(int id) {
		for (Producto producto : Inventario) {
			if(producto.getId() == id)
				return producto;
		}
		return null;
	}

	public ArrayList<Producto> BuscarPorPrecio(int preciobuscado) {
		ArrayList<Producto> ret = new ArrayList<Producto>();
		
		Inventario.stream().filter(p -> p.getPrecio()==preciobuscado).forEach(p-> ret.add(p));
		
		return ret;
		
	}
	public String BuscarPorID(int Id) {
		
		for (Producto producto : Inventario) {
			if(producto.getId() == Id)
				return producto.toString();
		}
		
		return " ese id no esta";
		
	}
	public ArrayList<Producto> BuscarPorNombre(String nombreBuscado) {
		ArrayList<Producto> ret = new ArrayList<Producto>();
		
		Inventario.stream().filter(p -> p.getNombre().equals(nombreBuscado)).forEach(p-> ret.add(p));
		
		return ret;
		
	}
	
	public String resumenInventarioActual() {
		StringBuilder actual = new StringBuilder();
		actual.append("inventario actual :").append("\n");
		Inventario.stream().sorted((una,otra) -> una.getCategoria().compareTo(otra.getCategoria())).forEach(p->actual.append(p.toString()));; 
		
		
		
		
		return actual.toString();
	}
	

	
	public void usarUnproducto (int id) {
		
		for (Producto producto : Inventario) {
			if(producto.getId() == id) {
				if(producto.getCantidad()>0  && producto.getCantidad()==1 ) {
					producto.setCantidad(producto.getCantidad()-1);
					eliminarunProducto(producto);
					break;
				}
				if(producto.getCantidad()>0 ) {
					producto.setCantidad(producto.getCantidad()-1);
					
				}else if(producto.getCantidad()==0 ) {
					eliminarunProducto(producto);
					break;
				}
			}
		}
	}
//	public void EliminarProductosCantidadCero() {
//		for (Producto producto : Inventario) {
//			if
//		}
//	}
//	
	

}
