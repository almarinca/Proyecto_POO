/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Data.*;

/**
 *
 * @author alejomarin
 */
public class Interfaz {

    public static void dibujarFicha(Ficha f) {
        
        char[][] matriz = f.getFicha();

        String printMensaje = "\n";
        for (int i = 0; i < 3; i++) {
            printMensaje = printMensaje.concat("\t|");
            for (int j = 0; j < 3; j++) {
                printMensaje = printMensaje.concat(
                        String.valueOf(matriz[i][j]).concat("|"));
            }
            printMensaje = printMensaje.concat("\n");
        }
        System.out.println(printMensaje);

    }

}
