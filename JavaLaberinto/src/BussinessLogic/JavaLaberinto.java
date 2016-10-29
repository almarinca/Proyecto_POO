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
        int contador = 1;
        boolean salir = false;
        int jugadores = 0;
        Turno.moverJugador(Jugador.jugador1, 'q', tablero);
        Turno.moverJugador(Jugador.jugador2, 'q', tablero);
        Turno.moverJugador(Jugador.jugador3, 'q', tablero);
        Turno.moverJugador(Jugador.jugador4, 'q', tablero);
        printBienvenida();
        while (!salir) {
            printJugadores();
            jugadores = leerInt();
            if (jugadores == 2 || jugadores == 3 || jugadores == 4) {
                salir = true;
            } else {
                printError();
            }
        }
        salir = false;
        while (!salir) {
            
            printTurnoJugador(contador);
            Turno.moverFichas(tablero);
            switch (contador) {
                case 1:
                    Turno.moverJugador(Jugador.jugador1, 'a', tablero);
                    break;
                case 2:
                    Turno.moverJugador(Jugador.jugador2, 'a', tablero);
                    break;
                case 3:
                    Turno.moverJugador(Jugador.jugador3, 'a', tablero);
                    break;
                case 4:
                    Turno.moverJugador(Jugador.jugador4, 'a', tablero);
                    break;
                default:
                    break;
            }
            if (contador == jugadores) {
                contador = 0;
            }
            contador++;
        }
    }

}
