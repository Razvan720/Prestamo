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
		for(int i = 1; i<=15; i++){
            meses.add(String.valueOf(cantidad));
			cantidad = cantidad + 12;
        }
        return meses;
	}
}
