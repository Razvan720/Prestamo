/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author DAW209
 */
public class Utilidades {

	public static ArrayList<String> getLista() {
		ArrayList<String> meses = new ArrayList<String>();
		int cantidad = 12;
		for (int i = 1; i <= 15; i++) {
			meses.add(String.valueOf(cantidad));
			cantidad = cantidad + 12;
		}
		return meses;
	}

	public static ArrayList<Cuota> generaListaCuotas(int num_cuotas, double importeTotal) {
		ArrayList<Cuota> cuotas = new ArrayList<Cuota>();
		double importePorCuota = importeTotal / num_cuotas;
		for (int i = 1; i <= num_cuotas; i++) {
			double interesesCuota = importePorCuota - importePorCuota * (i - 1) / num_cuotas;
			double capitalCuota = importePorCuota - interesesCuota;
			Cuota miCuota = new Cuota(i, importePorCuota, capitalCuota, interesesCuota);
			cuotas.add(miCuota);
		}
		return cuotas;
	}
}
