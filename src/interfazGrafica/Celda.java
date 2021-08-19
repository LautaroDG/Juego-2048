package interfazGrafica;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



@SuppressWarnings("serial")
public class Celda extends JPanel
{

	private Point coord;
	private Integer numero;
	private Numero numeroJLabel;

	public Celda (Point coord)
	{
		this.coord = coord;
		dibujar();
	}

	public Celda (Point coord, Integer numero)
	{

		this.numero = numero;
		this.coord = coord;
		this.numeroJLabel = new Numero(numero);
		dibujar();

	}
	

	public void colorearFondo() {
		if(getNumero() == 2)
			setBackground(new Color(238, 228, 218));
		if(getNumero() == 4) {
			setBackground(new Color(237, 224, 200));
		}
		if(getNumero() == 8) {
			setBackground(new Color(242, 177, 121));
		}
		if(getNumero() == 16) {
			setBackground(new Color(245, 149, 99));
		}
		if(getNumero() == 32) {
			setBackground(new Color(246, 124, 95));
		}
		if(getNumero() == 64) {
			setBackground(new Color(246, 94, 59));
		}
		if(getNumero() == 128) {
			setBackground(new Color(237, 207, 114));
		}
		if(getNumero() == 256) {
			setBackground(new Color(237, 204, 97));
		}
		if(getNumero() == 512) {
			setBackground(new Color(237, 200, 80));
		}
		if(getNumero() == 1024) {
			setBackground(new Color(237, 197, 63));
		}
		if(getNumero() == 2048) {
			setBackground(new Color(237, 194, 46));
		}
	}
	
	
	public void dibujar() {
		setBorder(BorderFactory.createLineBorder(new Color(192, 192, 192)));
		setBackground(new Color(192, 192, 192));
		
		if(this.getNumero() != null) {
			colorearFondo();

			add(numeroJLabel);
		}
		
	}
	public Point getCoord() 
	{
		return coord;
	}
	
	public Integer getNumero() 
	{
		return numero;
	}
	
	public void setNumero(Integer numero) 
	{
		this.numero = numero;
		this.numeroJLabel = new Numero(numero);
		
	}
	
	public void vaciar() {
		this.remove(numeroJLabel);
		this.numeroJLabel = new Numero(null);
		this.numero = null;
		this.updateUI();
		this.dibujar();
	}
	public void redibujar(Integer numero) {
		if(this.tieneNumero())
			this.remove(numeroJLabel);
		this.numeroJLabel = new Numero(numero);
		this.numero = numero;
		this.updateUI();
		this.dibujar();
		

	}
	public boolean tieneNumero() 
	{
		return this.numero != null;
	}
}
@SuppressWarnings("serial")
class Numero extends JLabel {
	Integer numero;
	
	public Numero(Integer numero) {
		this.numero = numero;
		
		dibujar();
	}
	
	public void dibujar() {
		setPreferredSize(new Dimension(110,110));
		setBorder(null);
		setForeground(new Color(128,128,128));	
		setHorizontalTextPosition(SwingConstants.CENTER);
		setVerticalTextPosition(SwingConstants.CENTER);
		setFont(new Font(null, Font.PLAIN, 55));
		if(this.numero != null)
			setText(this.numero.toString());
	}

	
}