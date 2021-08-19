package interfazGrafica;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import codigoDeNegocio.MovimientoNegocio;

public class Movimiento implements KeyListener{
	Tablero tablero;
	MovimientoNegocio movNegocio;

	public Movimiento(Tablero tablero) {
		this.tablero = tablero;
		this.movNegocio = new MovimientoNegocio(tablero.valoresCeldas);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//Primero se combinan los que se deben combinar
		//Luego se mueven en la dirección correspondiente
		//Por última se agrega un nuevo número
		if(tablero.finDelJuego()) {
			movNegocio.setPuntos(0);
		}
		int teclaPresionada = e.getKeyCode();
		movNegocio.combinar(teclaPresionada);
		tablero.actualizarValores();
		movNegocio.movimiento(teclaPresionada);
		tablero.actualizarValores();
		
		tablero.setPuntos(movNegocio.getPuntos().intValue());
		tablero.nuevoNumero();
		
	}
}
