package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import codigonegocio.Producto;
import conexion.TestConexion;
import interfaz.VentanaPrincipal;

public class Controlador implements ActionListener {
	
	Producto producto;
	TestConexion Consultas;
	VentanaPrincipal ventanaPrincipal;
	
	
	public Controlador( TestConexion consulta, VentanaPrincipal vist) {
		
		Consultas = consulta;
		ventanaPrincipal=vist;
		producto=new Producto(null, 0, null, 0, 0);
		
		
		this.ventanaPrincipal.ventanaIniciar.Ingresar.addActionListener(this);
		this.ventanaPrincipal.ventanaIniciar.bResumen.addActionListener(this);
		this.ventanaPrincipal.ventanaIniciar.usarProducto.addActionListener(this);
		this.ventanaPrincipal.ventanaIniciar.usarProductocantidad.addActionListener(this);
		this.ventanaPrincipal.ventanaIniciar.bBuscarProducto.addActionListener(this);
		this.ventanaPrincipal.ventanaInicio.BtnIniciar.addActionListener(this);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== ventanaPrincipal.ventanaIniciar.Ingresar) {
			accionBotonIngresar();
		}else if(e.getSource()==ventanaPrincipal.ventanaIniciar.bResumen) {
			accionBotonResumen();
		}else if(e.getSource()== ventanaPrincipal.ventanaIniciar.usarProducto) {
			accionBotonUsarProducto();
		}else if(e.getSource()==ventanaPrincipal.ventanaIniciar.usarProductocantidad) {
			accionBotonUsarCantidad();
		}else if(e.getSource() == ventanaPrincipal.ventanaIniciar.bBuscarProducto) {
			accionbtnBuscarProducto();
		}else if(e.getSource() == ventanaPrincipal.ventanaInicio.BtnIniciar) {
			ventanaPrincipal.crearIniciar();
		}
		}

private void accionbtnBuscarProducto() {
	try {
		int indice = ventanaPrincipal.ventanaIniciar.cBuscarUnProducto.getSelectedIndex();
		if(indice==0)
			throw new IllegalArgumentException("No seleccionaste un criterio valido");
		if(indice==1)
			ventanaPrincipal.ventanaIniciar.txpResumen.setText(Consultas.BuscarProductoPorPrecio(Integer.parseInt( ventanaPrincipal.ventanaIniciar.tBuscarUnProducto.getText())));
		if(indice==2)
			ventanaPrincipal.ventanaIniciar.txpResumen.setText(Consultas.BuscarProductoPorId(Integer.parseInt(ventanaPrincipal.ventanaIniciar.tBuscarUnProducto.getText())));
		if(indice==3)
			ventanaPrincipal.ventanaIniciar.txpResumen.setText(Consultas.BuscarProductoPorNombre(ventanaPrincipal.ventanaIniciar.tBuscarUnProducto.getText()));
		}
		catch (Exception ex) {
			if (ex.getClass().equals(NumberFormatException.class)) {
				ventanaPrincipal.ventanaIniciar.lblExcepcionesbuscar.setText("**Quisiste pasar una cadena como numero o tal vez no escribiste nada**");
			}
			else{
				ventanaPrincipal.ventanaIniciar.lblExcepcionesbuscar.setText("**"+ex.getMessage()+"**");
			}
		}
		
	}


	private void accionBotonUsarCantidad() {
		try {
		producto.setId(Integer.parseInt(ventanaPrincipal.ventanaIniciar.idDelProductoAusar.getText()));
		producto.setCantidad(Integer.parseInt(ventanaPrincipal.ventanaIniciar.idDelProductoAusarCantidad.getText()));
		
		Consultas.usarUnproducto(producto.getId(), producto.getCantidad());
		
		ventanaPrincipal.ventanaIniciar.idDelProductoAusar.setText("");
		ventanaPrincipal.ventanaIniciar.usarProducto.setVisible(true);
		ventanaPrincipal.ventanaIniciar.idDelProductoAusar.setVisible(true);
		ventanaPrincipal.ventanaIniciar.usarProductocantidad.setVisible(false);
		ventanaPrincipal.ventanaIniciar.idDelProductoAusarCantidad.setVisible(false);
		}catch (Exception ex) {
			if (ex.getClass().equals(NumberFormatException.class)) {
				ventanaPrincipal.ventanaIniciar.lblExcepciones.setText("**Te olvidaste de agregar algun dato**");
				
			}else {
				ventanaPrincipal.ventanaIniciar.lblExcepcionesbuscar.setText("**"+ex.getMessage()+"**");
			}
		}
		
	}



	private void accionBotonUsarProducto() {
		try {
			if(ventanaPrincipal.ventanaIniciar.idDelProductoAusar.getText().equals("") )
				throw new IllegalArgumentException("debes ingresar algun id");
			ventanaPrincipal.ventanaIniciar.usarProducto.setVisible(false);
			ventanaPrincipal.ventanaIniciar.idDelProductoAusar.setVisible(false);
			ventanaPrincipal.ventanaIniciar.usarProductocantidad.setVisible(true);
			ventanaPrincipal.ventanaIniciar.idDelProductoAusarCantidad.setVisible(true);
		} catch (Exception ex) {
			if (ex.getClass().equals(NumberFormatException.class)) {
				ventanaPrincipal.ventanaIniciar.lblExcepciones.setText("**Te olvidaste de agregar algun dato**");
				
			}else {
				ventanaPrincipal.ventanaIniciar.lblExcepcionesbuscar.setText("**"+ex.getMessage()+"**");
			}
		}
		
	}



	private void accionBotonResumen() {
		ventanaPrincipal.ventanaIniciar.txpResumen.setText(Consultas.consultarResumen());
	}



	private void accionBotonIngresar() {
		try {
			producto.setNombre(ventanaPrincipal.ventanaIniciar.ProductoNombre.getText()); producto.setCategoria(ventanaPrincipal.ventanaIniciar.ProductoCategoria.getText());
			producto.setCantidad(Integer.parseInt(ventanaPrincipal.ventanaIniciar.ProductoCantidad.getText())); producto.setPrecio(Integer.parseInt(ventanaPrincipal.ventanaIniciar.ProductoPrecio.getText()));;
			Consultas.añadirProducto(producto);
			limpiarCajasDeTexto();
		}
		catch(Exception ex) {
			if (ex.getClass().equals(NumberFormatException.class)) {
				ventanaPrincipal.ventanaIniciar.lblExcepciones.setText("**Te olvidaste de agregar algun dato**");
			}
			else {
				ventanaPrincipal.ventanaIniciar.lblExcepciones.setText("**"+ex.getMessage()+"**");
			}
		}
	}



	private void limpiarCajasDeTexto() {
		ventanaPrincipal.ventanaIniciar.ProductoNombre.setText("");
		ventanaPrincipal.ventanaIniciar.ProductoCategoria.setText("");
		ventanaPrincipal.ventanaIniciar.ProductoCantidad.setText("");
		ventanaPrincipal.ventanaIniciar.ProductoPrecio.setText("");
		
		ventanaPrincipal.ventanaIniciar.lblExcepciones.setText("");
	}
		
	}


