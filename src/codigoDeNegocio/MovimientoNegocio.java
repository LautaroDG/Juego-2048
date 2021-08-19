package codigoDeNegocio;

public class MovimientoNegocio{
	
	Integer[][] valoresCeldas;
	Integer puntos;
	int teclaDerecha = 39;
	int teclaArriba = 38;
	int teclaIzquierda = 37;
	int teclaAbajo = 40;
	
	public MovimientoNegocio(Integer[][] valoresCeldas) {
		this.valoresCeldas = valoresCeldas;
		this.puntos = 0;
	}
	
	public void combinar(int teclaPresionada) {
		for (int f = 3; f >= 0; f--) {
			for (int c = 3; c >= 0; c--) {
				if (valoresCeldas[f][c] != null) {
					if (teclaPresionada == teclaDerecha)
						combinarDerecha(f, c);
					if (teclaPresionada == teclaAbajo)
						combinarAbajo(f, c);
				}
			}
		}
		for (int f = 0; f < 4; f++) {
			for (int c = 0; c < 4; c++) {
				if (valoresCeldas[f][c] != null) {
					if (teclaPresionada == teclaIzquierda)
						combinarIzq(f, c);
					if (teclaPresionada == teclaArriba)
						combinarArriba(f, c);
				}
			}
		}
	}
	public void movimiento(int teclaPresionada) {
		for (int f = 3; f >= 0; f--) {
			for (int c = 3; c >= 0; c--) {
				
				if (valoresCeldas[f][c] != null) {
					
					if (teclaPresionada == teclaAbajo)
						movimientoAbajo(f, c);
					if (teclaPresionada == teclaDerecha)
						movimientoDer(f, c);
				}
			}
		}
		for (int f = 0; f < 4; f++) {
			for (int c = 0; c < 4; c++) {
				if (valoresCeldas[f][c] != null) {
					if (teclaPresionada == teclaIzquierda)
						movimientoIzq(f, c);
					if (teclaPresionada == teclaArriba)
						movimientoArriba(f, c);
					
				}
			}
		}
	}

	private void movimientoAbajo(int filaOrigen, int columna) {
		if (filaOrigen == 3)
			return;
		int filaDestino = filaOrigen;
		int numero = valoresCeldas[filaOrigen][columna];
		for (int filaPosible = filaOrigen + 1; filaPosible < 4; filaPosible++) {
			if (valoresCeldas[filaPosible][columna] == null) {
				filaDestino = filaPosible;
			}
		}
		moverArribaAbajo(filaDestino, filaOrigen, columna, numero);
	}

	private void movimientoIzq(int fila, int columnaOrigen) {
		if (columnaOrigen == 0)
			return;
		int columnaDestino = columnaOrigen;
		int numero = valoresCeldas[fila][columnaOrigen];
		for (int columnaPosible = columnaOrigen - 1; columnaPosible >= 0; columnaPosible--) {
			if (valoresCeldas[fila][columnaPosible] == null ) {
				columnaDestino = columnaPosible;
			}
		}
		moverIzqDer(columnaDestino, fila, columnaOrigen, numero);
	}

	private void movimientoDer(int fila, int columnaOrigen) {
		if (columnaOrigen == 3)
			return;
		int columnaDestino = columnaOrigen;
		Integer numero = valoresCeldas[fila][columnaOrigen];
		for (int columnaPosible = columnaOrigen + 1; columnaPosible < 4; columnaPosible++) {
			if (valoresCeldas[fila][columnaPosible] == null) {
				columnaDestino = columnaPosible;
			}
		}
		moverIzqDer(columnaDestino, fila, columnaOrigen, numero);
	}

	private void movimientoArriba(int filaOrigen, int columna) {
		if (filaOrigen == 0)
			return;
		int filaDestino = filaOrigen;
		int numero = valoresCeldas[filaOrigen][columna];
		for (int filaPosible = filaOrigen - 1; filaPosible >= 0; filaPosible--) {
			if (valoresCeldas[filaPosible][columna] == null) {
				filaDestino = filaPosible;
			}
		}
		moverArribaAbajo(filaDestino, filaOrigen, columna, numero);
	}
	
	private void combinarIzq(int fila, int ccolumnaCeldaAAcumular) {

		if (ccolumnaCeldaAAcumular == 3)
			return;
		for (int columnaCeldaVecina = ccolumnaCeldaAAcumular + 1; columnaCeldaVecina < 4; columnaCeldaVecina++) {
			if (valoresCeldas[fila][columnaCeldaVecina] != null) {
				combinarIzqDer(fila, ccolumnaCeldaAAcumular, columnaCeldaVecina);
				break;
			}
		}
	}

	private void combinarAbajo(int filaCeldaAAcumular, int columna) {

		if (filaCeldaAAcumular == 0)
			return;
		for (int filaCeldaVecina = filaCeldaAAcumular - 1; filaCeldaVecina >= 0; filaCeldaVecina--) {
			if (valoresCeldas[filaCeldaVecina][columna] != null) {
				combinarArribaAbajo(filaCeldaAAcumular, columna, filaCeldaVecina);
				break;
			}
		}
	}

	private void combinarDerecha(int fila, int columnaCeldaAAcumular) {

		if (columnaCeldaAAcumular == 0)
			return;
		for (int columnaCeldaVecina = columnaCeldaAAcumular - 1; columnaCeldaVecina >= 0; columnaCeldaVecina--) {
			if (valoresCeldas[fila][columnaCeldaVecina] != null) {
				combinarIzqDer(fila, columnaCeldaAAcumular, columnaCeldaVecina);
				break;
			}
		}
		
	}

	private void combinarArriba(int filaCeldaAAcumular, int columna) {

		if (filaCeldaAAcumular == 3)
			return;
		for (int filaCeldaVecina = filaCeldaAAcumular + 1; filaCeldaVecina < 4; filaCeldaVecina++) {
			if (valoresCeldas[filaCeldaVecina][columna] != null) {
				combinarArribaAbajo(filaCeldaAAcumular, columna, filaCeldaVecina);
				break;
			}
		}
		
	}
	
	private void combinarIzqDer(int fila, int columnaCeldaAAcumular, int columnaCeldaVecina) {
		//Valida que las celdas tengan el mismo valor
		if(valoresCeldas[fila][columnaCeldaAAcumular].equals(valoresCeldas[fila][columnaCeldaVecina])) {
			valoresCeldas[fila][columnaCeldaAAcumular] = valoresCeldas[fila][columnaCeldaAAcumular] + valoresCeldas[fila][columnaCeldaVecina];
			valoresCeldas[fila][columnaCeldaVecina] = null;
			sumarPuntos(valoresCeldas[fila][columnaCeldaAAcumular]);}
	}
	
	private void combinarArribaAbajo(int filaCeldaAAcumular, int columna, int filaCeldaVecina) {
		if(valoresCeldas[filaCeldaAAcumular][columna].equals(valoresCeldas[filaCeldaVecina][columna])) {
			valoresCeldas[filaCeldaAAcumular][columna] = valoresCeldas[filaCeldaAAcumular][columna] + valoresCeldas[filaCeldaVecina][columna];
			valoresCeldas[filaCeldaVecina][columna] = null;
			sumarPuntos(valoresCeldas[filaCeldaAAcumular][columna]);}
	}
	
	
	private void moverIzqDer(int columnaDestino, int fila, int columnaOrigen, int numero) {
		if (columnaDestino != columnaOrigen) {
			valoresCeldas[fila][columnaOrigen] = null;
			valoresCeldas[fila][columnaDestino] = numero;}
	}
	
	private void moverArribaAbajo(int filaDestino, int filaOrigen, int columna, int numero) {
		if (filaDestino != filaOrigen) {
			valoresCeldas[filaOrigen][columna] = null;
			valoresCeldas[filaDestino][columna] = numero;}
	}
	private void sumarPuntos(Integer nuevosPuntos) {
		puntos+=nuevosPuntos;
	}
	
	public Integer getPuntos() {
		return puntos;
	}
	public void setPuntos(Integer num) {
		puntos = num;
	}

}