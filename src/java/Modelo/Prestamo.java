/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author DAW209
 */
public class Prestamo {

	private double cantidad;
	private double interes;
	private int tiempo;
	private double importePrestamo;

	public Prestamo(double cantidad, double interes, int tiempo) {
		this.cantidad = cantidad;
		this.interes = interes;
		this.tiempo = tiempo;
		this.importePrestamo = calculaPrestamo(cantidad, interes, tiempo);
	}

	public double calculaPrestamo(double cantidad, double interes, int tiempo) {
		double interesSimple = cantidad * interes * tiempo / 1200;
		double total = interesSimple + cantidad;
		return total;
	}

	public double getCantidad() {
		return cantidad;
	}

	public double getInteres() {
		return interes;
	}

	public int getTiempo() {
		return tiempo;
	}

	public double getImportePrestamo() {
		return importePrestamo;
	}

}
