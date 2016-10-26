/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLogic;

import Data.*;
import static UI.Interfaz.*;

public class JavaLaberinto {

    public static void main(String[] args) {

        Tablero tablero = new Tablero();
        printBienvenida();
        boolean salir = false;
        while (!salir) {
            dibujarTablero(tablero);
            printMensajeFichaLibre();
            printFicha(tablero.getFichasSobrantes().get(0));
            salir = true;
        }
    }

}
