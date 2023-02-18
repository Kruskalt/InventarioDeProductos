package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class Iniciar extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public JLabel IngresarProducto;
	public JLabel almacenarNombre;
	public JLabel almacenarCategoria;
	public JLabel almacenarCantidad;
	public JLabel almacenarPrecio;
	
	
	public JTextField ProductoNombre;
	public JTextField ProductoCategoria;
	public JTextField ProductoCantidad;
	public JTextField ProductoPrecio;
	public JTextField tBuscarUnProducto;
	public JComboBox<String> cBuscarUnProducto;
	public JButton Ingresar;
	
	public JButton bBuscarProducto;
	public JLabel jResumen;
	public JButton bResumen;
	public JTextPane txpResumen;
	public JScrollPane spResumen;
	
	
	public final int casillaAncho = 240;
	public final int casillaAlto = 440;
	public final Color colorCampoTexto = new Color(200, 225, 255);
	
	
	public final Font fuenteEtiqueta = new Font("Consolas", Font.BOLD | Font.ITALIC, 18);
	public final Font fuenteCampoTexto = new Font("Consolas", Font.ITALIC, 12);
	
	public JLabel lblExcepcionesbuscar;
	public JLabel lblExcepciones;
	public JButton usarProducto;
	public JTextField idDelProductoAusar;
	public JButton usarProductocantidad;
	public JTextField idDelProductoAusarCantidad;
	
	
	public Iniciar(VentanaPrincipal vp) {
		super(vp);
		iniciarPanel();
		iniciarBtnVolverInicio();
		iniciarAlmacenajeDePROductosBotones();
		iniciarbotonesextras();
		iniciarBotonesResumen();
		
		ignorarCaracteres();
		
	}
	private void iniciarAlmacenajeDePROductosBotones() {
		IngresarProducto = new JLabel("--Ingresar Productos--");
		IngresarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		IngresarProducto.setFont(fuenteEtiqueta);
		IngresarProducto.setBounds(ancho-970, 30,300, 30);
		add(IngresarProducto);
		
		almacenarNombre = new JLabel("Nombre");
		almacenarNombre.setFont(fuenteEtiqueta);
		almacenarNombre.setBounds(ancho-970, 80, 100, 30);
		add(almacenarNombre);
		
		ProductoNombre = new JTextField();  
		ProductoNombre.setFont(fuenteCampoTexto);
		ProductoNombre.setBounds(ancho-850, 80, 100, 20);
		add(ProductoNombre);
		
		
		
		
		almacenarCategoria = new JLabel("Categoria");
		almacenarCategoria.setFont(fuenteEtiqueta);
		almacenarCategoria.setBounds(ancho-970, 140, 100, 30);
		add(almacenarCategoria);
		
		
		ProductoCategoria = new JTextField();
		ProductoCategoria.setFont(fuenteCampoTexto);
		ProductoCategoria.setBounds(ancho-850, 140, 100, 20);
		add(ProductoCategoria);
		
		almacenarCantidad = new JLabel("Cantidad");
		almacenarCantidad.setFont(fuenteEtiqueta);
		almacenarCantidad.setBounds(ancho-970, 170, 100, 30);
		add(almacenarCantidad);
		
		ProductoCantidad= new JTextField();
		ProductoCantidad.setFont(fuenteCampoTexto);
		ProductoCantidad.setBounds(ancho-850, 170, 100, 20);
		add(ProductoCantidad);
		
		almacenarPrecio = new JLabel("Precio");
		almacenarPrecio.setFont(fuenteEtiqueta);
		almacenarPrecio.setBounds(ancho-970, 200, 100, 30);
		add(almacenarPrecio);
		
		ProductoPrecio= new JTextField();
		ProductoPrecio.setFont(fuenteCampoTexto);
		ProductoPrecio.setBounds(ancho-850, 200, 100, 20);
		add(ProductoPrecio);
		
		Ingresar= new JButton("Ingresar");
		Ingresar.setFont(fuenteCampoTexto);
		Ingresar.setBounds(ancho-850, 230, 100, 20);
//		accionBtnIngresarProductos();
		add(Ingresar);
		
	}
	private void iniciarbotonesextras() {
		lblExcepciones = new JLabel();
		lblExcepciones.setFont(new Font("Consolas", Font.BOLD, 15));
		lblExcepciones.setBounds(ancho-930, 260, 980, 50);
		add(lblExcepciones);
		
		usarProducto= new JButton("Usar");
		usarProducto.setFont(fuenteCampoTexto);
		usarProducto.setBounds(ancho-900, 400, 100, 20);
		add(usarProducto);
		
		
		idDelProductoAusar = new JTextField();
		idDelProductoAusar.setFont(fuenteCampoTexto);
		idDelProductoAusar.setBounds(ancho-760, 400, 300, 20);
		add(idDelProductoAusar);
		
		usarProductocantidad= new JButton("UsarCantidad");
		usarProductocantidad.setFont(fuenteCampoTexto);
		usarProductocantidad.setBounds(ancho-900, 400, 100, 20);
		add(usarProductocantidad);
		usarProductocantidad.setVisible(false);
		
		
		
		idDelProductoAusarCantidad = new JTextField();
		idDelProductoAusarCantidad.setFont(fuenteCampoTexto);
		idDelProductoAusarCantidad.setBounds(ancho-760, 400, 300, 20);
		add(idDelProductoAusarCantidad);
		idDelProductoAusarCantidad.setVisible(false);
		
		tBuscarUnProducto = new JTextField("ingrese el producto a buscar");
		tBuscarUnProducto.setFont(fuenteCampoTexto);
		tBuscarUnProducto.setBounds(ancho-760, 450, 300, 20);
		add(tBuscarUnProducto);
		
		
		cBuscarUnProducto = new JComboBox<String>();
		cBuscarUnProducto.setFont(fuenteCampoTexto);
		cBuscarUnProducto.setBounds(ancho-900, 480, 100, 20);
		add(cBuscarUnProducto);
		cBuscarUnProducto.setModel(new DefaultComboBoxModel<>( new String[] {"Buscar por","precio","id","nombre"}));
		
		bBuscarProducto= new JButton("Buscar");
		bBuscarProducto.setFont(fuenteCampoTexto);
		bBuscarProducto.setBounds(ancho-900, 450, 100, 20);
		add(bBuscarProducto);
		
		
		lblExcepcionesbuscar = new JLabel();
		lblExcepcionesbuscar.setFont(new Font("Consolas", Font.BOLD, 15));
		lblExcepcionesbuscar.setBounds(ancho-760, 480, 980, 50);
		add(lblExcepcionesbuscar);
		
		
	}
	
	
	
	
	
	
	private void iniciarBotonesResumen() {
		jResumen = new JLabel("Resumen de Inventario Actual");
		jResumen.setFont(fuenteEtiqueta);
		jResumen.setBounds(ancho-360,30,300, 30);
		add(jResumen);
		
		bResumen= new JButton("Resumen");
		bResumen.setFont(fuenteBtn);
		bResumen.setBounds(ancho-360, 60, 280, 30);
		add(bResumen);
		
		
		txpResumen = new JTextPane();
		txpResumen.setEditable(false);
		txpResumen.setFont(fuenteCampoTexto);
		txpResumen.setBackground(colorCampoTexto);
		txpResumen.setBounds(ancho-360, 100, casillaAncho, casillaAlto);
		add(txpResumen);
		
		spResumen = new JScrollPane(txpResumen);
		spResumen.setBounds(ancho-360, 100, casillaAncho, casillaAlto);
		add(spResumen);
		
		
	}
	
	
	

	
	
	private void ignorarCaracteres() {
		ignorarLetras(ProductoCantidad);
		ignorarLetras(ProductoPrecio);
		ignorarLetras(idDelProductoAusar);
		ignorarLetras(idDelProductoAusarCantidad);
		ignorarNumeros(ProductoNombre);
		ignorarNumeros(ProductoCategoria);
	}

	
	private void ignorarNumeros(JTextField texto) {
		texto.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
			    if ( ((c < 'A') || (c > 'z')) && (c != 'ñ') && (c != KeyEvent.VK_BACK_SPACE)) {
			       e.consume();
			    }
			}
		});
	}
	

	@Override
	public void mostrarPanel() {
		setVisible(true);
		btnVolverInicio.setVisible(true);
		
	}

	@Override
	public void ocultarPanel() {
		setVisible(false);
		btnVolverInicio.setVisible(false);
		
	}
	
	private void iniciarPanel() {
		setBounds(posX, posY, ancho, alto);
		setBorder(lineaBordeada);
		setBackground(colorDeFondo);
		setLayout(null);
	}

}
