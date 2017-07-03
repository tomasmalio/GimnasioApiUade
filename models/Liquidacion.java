package models;

import java.util.Date;

public class Liquidacion {
	private int anio;
	private int mes;
	
	public Liquidacion(int anio, int mes) {
		super();
		this.setAnio(anio);
		this.setMes(mes);
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	/**
	 * Es Liquidacion
	 * 
	 * @param anio
	 * @param mes
	 * @return
	 */
	public boolean esLiquidacion (int anio, int mes) {
		return (this.anio == anio && this.mes == mes);
	}
	
}
