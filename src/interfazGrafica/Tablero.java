package interfazGrafica;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import codigoDeNegocio.TableroNegocio;

@SuppressWarnings("serial")
public class Tablero extends JPanel {
	private TableroNegocio tableroNegocio;
	private Celda[][] celdas;
	public Integer[][] valoresCeldas;
	public Boolean gano;
	public Integer mejorPuntaje = 0;
	public Integer puntos = 0;
	public JLabel labelPuntaje;
	public JLabel labelMejor;
	public boolean juegoNuevo;
	
	public Tablero(JLabel labelPuntaje, JLabel labelMejor) 
	{	
		
		this.celdas = new Celda[4][4];
		this.valoresCeldas = new Integer[4][4];
		this.labelPuntaje = labelPuntaje;
		this.labelMejor = labelMejor;
		this.gano= false;
		this.juegoNuevo= false;
		this.tableroNegocio = new TableroNegocio(valoresCeldas, gano);
		iniciarTablero();
	}
	

	public void actualizarValores() {
		if(finDelJuego()){
			gameOver();
		}
		for (int i = 0; i < 4; i++) 
		{
			for (int j = 0; j < 4; j++) 				
			{
				celdas[i][j].redibujar(valoresCeldas[i][j]);
			}		
		}
	}
	
	public void agregarNumerosIniciales() {
		//Se agregan los dos números iniciales
		nuevoNumero();
		nuevoNumero();
		
	}

	public boolean finDelJuego() {
		return tableroNegocio.finDelJuego();
		
	}
	

	public void iniciarTablero() {
		llenarMatriz();
		agregarNumerosIniciales();
		setLayout(new GridLayout(4,4,4,4));	
		setBackground(new Color(245, 245, 220));
	}
	

	public void llenarMatriz() {
		for (int i = 0; i < 4; i++) 
		{
			for (int j = 0; j < 4; j++) 				
			{
				valoresCeldas[i][j] = null;
				celdas[i][j] = new Celda(new Point(i,j));
				add(celdas[i][j]);
			}
			
		}		
	}
	
	
	public void nuevoNumero() {
		Point coordenadaAleatoria = tableroNegocio.coordenadaAleatoriaVacia();
		if(coordenadaAleatoria == null)
			return;
		Integer numAleatorio = numeroAleatorio();
		celdas[coordenadaAleatoria.x][coordenadaAleatoria.y].setNumero(numAleatorio.intValue());
		celdas[coordenadaAleatoria.x][coordenadaAleatoria.y].redibujar(numAleatorio.intValue());
		valoresCeldas[coordenadaAleatoria.x][coordenadaAleatoria.y] = numAleatorio.intValue();
	}
	
	public int numeroAleatorio () {
		//Devuelve un número aleatorio entre 2 y 4 para agregar al tablero
		return tableroNegocio.numeroAleatorio();
	}
	
	public boolean sinMovimientos () {
		//El tablero está lleno y no puede combinar números
		return tableroNegocio.sinMovimientos();
	}

	public boolean tableroLleno() {
		return tableroNegocio.tableroLleno();
	}
	
	private void gameOver() {
		setPuntos(0);
		if(gano)
		{
			JOptionPane.showMessageDialog(this, "CONGRATULATIONS", "Game Over", 1, null);
		}
		else 
		{
			JOptionPane.showMessageDialog(this, "LOOOOSER", "Game Over", 1, null);
		}
		juegoNuevo = true;
		gano = false;
		vaciarMatriz();//Reinicia la matriz
		nuevoNumero();
	}

	public void vaciarMatriz() {
		for (int i = 0; i < 4; i++) 
		{
			for (int j = 0; j < 4; j++) 				
			{
				celdas[i][j].vaciar();
				valoresCeldas[i][j] = null;
			}		
		}
	}
	public Celda[][] getCeldas() {
		return celdas;
	}

	public void setCeldas(Celda[][] celdas) {
		this.celdas = celdas;
	}


	public void setPuntos(Integer puntosActualizados) {
		puntos = puntosActualizados;
		if(puntos>mejorPuntaje)
			mejorPuntaje=puntos;
			labelMejor.setText("Mejor: " + mejorPuntaje);
		labelPuntaje.setText("Puntos: " + puntos);
		
	}


	public int getPuntos() {
		
		return this.puntos;
	}


	
}
