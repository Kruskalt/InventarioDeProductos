package interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;
import conexion.TestConexion;
import controlador.Controlador;

public class VentanaPrincipal {

	private JFrame ventanaPrincipal;
	
	//caracteristicas
	final int posX = 50;
	final int posY = 10;
	final int ancho = 1016;
	final int alto = 689;
	
	//paneles
	public Inicio ventanaInicio;
	public Iniciar ventanaIniciar;
	
	
	//clases de negocio
	
	public TestConexion conect = new TestConexion();
	Controlador controller  ;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName());
					VentanaPrincipal window = new VentanaPrincipal();
					window.ventanaPrincipal.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public VentanaPrincipal() {
		iniciarVentana();
		iniciarPanelInicio();
		ventanaIniciar = new Iniciar(this);
		controller = new Controlador(conect, this) ;
		
	}
	
	private void iniciarVentana() {
		ventanaPrincipal = new JFrame();
		ventanaPrincipal.setResizable(false);
		ventanaPrincipal.setBounds(posX, posY, ancho, alto);
		ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	private void iniciarPanelInicio() {
		ventanaInicio = new Inicio(this);
		ventanaInicio.mostrarPanel();
		ventanaPrincipal.getContentPane().add(ventanaInicio);
	
	}
	public void volverInicio() {
		ventanaInicio.mostrarPanel();
		ventanaIniciar.ocultarPanel();
	}
	public void crearIniciar() {
		ventanaInicio.ocultarPanel();
		iniciarPanelIniciar();
		
	}
	private void iniciarPanelIniciar() {
		ventanaIniciar.mostrarPanel();
		ventanaPrincipal.getContentPane().add(ventanaIniciar);
		
	}
	

	}

	
	
	
	

