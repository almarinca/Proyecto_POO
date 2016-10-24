/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;


public class Tablero {
	//ATRIBUTOS
	private static Ficha ficha;                   //7X7
	private static Ficha[][] tablero ={{ ficha,ficha,ficha,ficha,ficha,ficha,ficha },
			                           { ficha,ficha,ficha,ficha,ficha,ficha,ficha },
			                           { ficha,ficha,ficha,ficha,ficha,ficha,ficha },
			                           { ficha,ficha,ficha,ficha,ficha,ficha,ficha },
			                           { ficha,ficha,ficha,ficha,ficha,ficha,ficha },
			                           { ficha,ficha,ficha,ficha,ficha,ficha,ficha },
			                           { ficha,ficha,ficha,ficha,ficha,ficha,ficha },
			                           };     
	//METODOS
	public Ficha[][] getTablero() {
		return tablero;
	}
	public static Ficha getFicha() {
		return ficha;
	}
	public static void setFicha(Ficha ficha) {
		Tablero.ficha = ficha;
	}
    
}
