package interfaz;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Inicio extends Panel {
	
	private static final long serialVersionUID = 5427436349781456150L;
	
	//botones y sus caracteristicas:
	public JButton BtnIniciar;
	private JButton btnIniciarTablasYgraficos;
	

	private final int xBtn = ancho/2 - anchoBtn/2;
	private final int yBtn = alto/4 - altoBtn/2;
	
	//etiquetas

	private JLabel lblBienvenido;
	
	
	public Inicio (VentanaPrincipal vp) {
		super(vp);
		
		iniciarPanel();
		iniciarBotones();
		iniciarEtiquetas();
	}

	private void iniciarPanel() {
		setBounds(posX, posY, ancho, alto);
		setBorder(lineaBordeada);
		setBackground(colorDeFondo);

		setLayout(null);
	}
	
	private void iniciarBotones() {
		iniciarBtnIniciar();
		iniciarBtnTablasYgraficos();
		
	}
	
	private void iniciarBtnIniciar() {
		BtnIniciar = new JButton("Iniciar");
		
			
		BtnIniciar.setBackground(colorBtn);
		BtnIniciar.setFont(fuenteBtn);
		BtnIniciar.setBounds(xBtn, yBtn*2, anchoBtn, altoBtn);
		BtnIniciar.setToolTipText("Almacenar Productos, buscarlos o un resumen de lo que hay");
		
		add(BtnIniciar);
	}
	
	
	private void iniciarBtnTablasYgraficos() {
		btnIniciarTablasYgraficos = new JButton("Graficos");
		btnIniciarTablasYgraficos.setBackground(colorBtn);
		btnIniciarTablasYgraficos.setFont(fuenteBtn);
		btnIniciarTablasYgraficos.setBounds(xBtn, yBtn*2+90, anchoBtn, altoBtn);
		
		add(btnIniciarTablasYgraficos);
	}

	private void iniciarEtiquetas() {
		iniciarLblBienvenido();
		
	}

	private void iniciarLblBienvenido() {
		lblBienvenido = new JLabel("INVENTARIO DE PRODUCTOS");
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setFont(new Font("Consolas", Font.ROMAN_BASELINE, 50));
		lblBienvenido.setBounds(10, 72, ancho-20, 50);
		add(lblBienvenido);
	}

	

	@Override
	public void mostrarPanel() {
		setVisible(true);
	}


	@Override
	public void ocultarPanel() {
		setVisible(false);
	}

}
