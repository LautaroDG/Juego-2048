package interfazGrafica;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import java.awt.Component;

public class Pantalla {

	private JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla window = new Pantalla();
					window.frame.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pantalla()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
			
			
			
			
			frame = new JFrame();
			frame.setBounds(100, 0, 566, 800);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JPanel panelSuperior = new JPanel();
			panelSuperior.setBounds(0, 0, 550, 200);
			panelSuperior.setBackground(new Color(245, 245, 220));
			frame.getContentPane().add(panelSuperior);
			panelSuperior.setLayout(null);
			
			JLabel labelTitulo = new JLabel("2048");
			labelTitulo.setForeground(new Color(128, 128, 128));
			labelTitulo.setFont(new Font("Arial", Font.PLAIN, 60));
			labelTitulo.setBounds(28, 69, 148, 55);
			panelSuperior.add(labelTitulo);
			
			JLabel labelPuntos = new JLabel("Puntos: ");
			labelPuntos.setForeground(new Color(128, 128, 128));
			labelPuntos.setFont(new Font("Arial", Font.PLAIN, 20));
			labelPuntos.setBounds(345, 49, 145, 55);
			panelSuperior.add(labelPuntos);
			labelPuntos.setBackground(Color.BLACK);
			
		
			
			
			JLabel labelMejorPuntaje = new JLabel("Mejor: ");
			labelMejorPuntaje.setForeground(new Color(128, 128, 128));
			labelMejorPuntaje.setFont(new Font("Arial", Font.PLAIN, 20));
			labelMejorPuntaje.setBounds(345, 94, 145, 45);
			panelSuperior.add(labelMejorPuntaje);
			
			
			
			Tablero tablero = new Tablero(labelPuntos, labelMejorPuntaje);
			
			JLabel labelIzquierda = new JLabel("⬅");
			labelIzquierda.setForeground(Color.RED);
			labelIzquierda.setBorder(new LineBorder(Color.RED));
			labelIzquierda.setFont(labelIzquierda.getFont().deriveFont(60f));
			labelIzquierda.setHorizontalAlignment(SwingConstants.CENTER);
			labelIzquierda.setBounds(42, 146, 93, 54);
			panelSuperior.add(labelIzquierda);
			
			JLabel labelDerecha = new JLabel("➡");
			labelDerecha.setBorder(new LineBorder(new Color(0, 0, 0)));
			labelDerecha.setFont(labelDerecha.getFont().deriveFont(60f));
			labelDerecha.setHorizontalAlignment(SwingConstants.CENTER);
			labelDerecha.setBounds(167, 146, 93, 54);
			panelSuperior.add(labelDerecha);
			
			JLabel labelArriba = new JLabel("⬆");
			labelArriba.setAlignmentX(Component.CENTER_ALIGNMENT);
			labelArriba.setHorizontalTextPosition(SwingConstants.LEFT);
			labelArriba.setMinimumSize(new Dimension(6, 11));
			labelArriba.setMaximumSize(new Dimension(6, 11));
			labelArriba.setBorder(new LineBorder(new Color(0, 0, 0)));
			labelArriba.setFont(labelArriba.getFont().deriveFont(60f));
			labelArriba.setHorizontalAlignment(SwingConstants.CENTER);
			labelArriba.setBounds(292, 146, 93, 54);
			panelSuperior.add(labelArriba);
			
			JLabel labelAbajo = new JLabel("⬇");
			labelAbajo.setBorder(new LineBorder(new Color(0, 0, 0)));
			labelAbajo.setFont(labelAbajo.getFont().deriveFont(60f));
			labelAbajo.setHorizontalAlignment(SwingConstants.CENTER);
			labelAbajo.setBounds(417, 146, 93, 54);
			panelSuperior.add(labelAbajo);
			tablero.setBounds(25, 28, 500, 500);
			
			JPanel panelInferior = new JPanel();
			panelInferior.setBackground(new Color(245, 245, 220));
			panelInferior.setBounds(0, 200, 550, 550);
			frame.getContentPane().add(panelInferior);
			panelInferior.setLayout(null);
			panelInferior.add(tablero);
			
			
			Movimiento movimientos = new Movimiento(tablero);	
			frame.addKeyListener(movimientos);
			
	}
}

