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
public class Cuota {

	private int numeroCuota;
	private double importeCouta;
	private double capital;
	private double intereses;

	public Cuota(int numeroCuota, double importeCouta, double capital, double intereses) {
		this.numeroCuota = numeroCuota;
		this.importeCouta = importeCouta;
		this.capital = capital;
		this.intereses = intereses;
	}

	public int getNumeroCuota() {
		return numeroCuota;
	}

	public String getImporteCouta() {
		return String.format("%.2f", importeCouta);
	}

	public String getCapital() {
		return String.format("%.2f",capital);
	}

	public String getIntereses() {
		return String.format("%.2f",intereses);
	}

}
