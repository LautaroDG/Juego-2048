package codigoDeNegocio;

import java.awt.Point;

public class TableroNegocio {
	private Integer[][] valoresCeldas;
	@SuppressWarnings("unused")
	private Boolean gano;
	private int noventaPorCiento = 89;
	
	
	public TableroNegocio(Integer[][] valoresCeldas, Boolean gano) {
		this.valoresCeldas = valoresCeldas;
		this.gano = gano;
	}
		

	public Point coordenadaAleatoriaVacia() { // Genera un numero aleatorio en una posicion aleatoria
		if(finDelJuego())
		{
			return null;
		}
	
		if(tableroLleno()) 
		{
			return null;
		}
		Integer celdaAleatoriaX=0;
		Integer celdaAleatoriaY=0;
		boolean bandera= true;
		while (bandera) {
			celdaAleatoriaX = (int)(Math.random()*4);
			celdaAleatoriaY = (int)(Math.random()*4);
			if(valoresCeldas[celdaAleatoriaX][celdaAleatoriaY ] == null) {
				return new Point(celdaAleatoriaX,celdaAleatoriaY );
			}
				
		}
		return null;
	}
	
	
	public boolean finDelJuego() {

		for (int i = 0; i < 4; i++) 
		{
			for (int j = 0; j < 4; j++) 				
			{
				if(valoresCeldas[i][j] != null) 
				{ 
					if(valoresCeldas[i][j].equals(2048)) 
					{
						gano = true;
						return true;
					}			
				}
			}
		}
		if ((tableroLleno() && sinMovimientos())){
			return true;

		}
		return false;
	}
	
	
	public int numeroAleatorio ()
	{
		Integer numeroAleatorio = (int)(Math.random()*100);	
		
		//para que haya 90% de posibilidades de devolver 2
		return (numeroAleatorio <= noventaPorCiento)? 2 : 4;
	}
	
	public boolean sinMovimientos () {
		boolean sinMovimientos = true;
		for (int f = 0; f < valoresCeldas.length; f++){
			for (int c = 0; c < valoresCeldas.length; c++) {
				if(valoresCeldas[f][c] != null) 
				{
					if(f>0 && valoresCeldas[f-1][c].equals(valoresCeldas[f][c])) 
					{
						sinMovimientos = false;
					}
					if(f<3 && valoresCeldas[f+1][c].equals(valoresCeldas[f][c])) 
					{
						sinMovimientos = false;
					}
					if(c>0 && valoresCeldas[f][c-1].equals(valoresCeldas[f][c])) 
					{
						sinMovimientos = false;
					}
					if(c<3 && valoresCeldas[f][c+1].equals(valoresCeldas[f][c])) 
					{
						sinMovimientos = false;
					}
				}
			}
		}
		return sinMovimientos;
	}
	
	public int sumarPuntos(int valor1,int valor2) {
		return valor1 + valor2;
	}
	
	public boolean tableroLleno() {
		for (int f = 0; f < 4; f++) 
		{
			for (int c = 0; c < 4; c++) 				
			{
				if(valoresCeldas[f][c]==null) {	
					return false;
				}
			}		
		}
		return true;
	}
	
	
}
