/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLogic;

import Data.*;
import static UI.Interfaz.*;
import java.util.Scanner;

public class JavaLaberinto {

    public static void main(String[] args) {

        Tablero tablero = new Tablero();
        Turno.moverJugador(Jugador.jugador1, 'q', tablero);
        Turno.moverJugador(Jugador.jugador2, 'q', tablero);
        Turno.moverJugador(Jugador.jugador3, 'q', tablero);
        Turno.moverJugador(Jugador.jugador4, 'q', tablero);
        printBienvenida();
        boolean salir = false;
        while (!salir) {
            
            dibujarTablero(tablero);
            
            String a = leerString();
            char c;
            c = a.charAt(0);

            dibujarTablero(tablero);
            Turno.moverJugador(Jugador.jugador1, c, tablero);
            dibujarTablero(tablero);
            printMensajeFichaLibre();
            printFicha(tablero.getFichasSobrantes().get(0));
            salir = false;
        }
    }

}
