/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLogic;

import static BussinessLogic.Turno.correrFila;
import static BussinessLogic.Turno.rotarFicha;
import Data.*;
import static UI.Interfaz.*;
import java.util.ArrayList;

public class JavaLaberinto {

    static boolean salir = false;
    
    public static void main(String[] args) {
        
        Tablero tablero = new Tablero();
        int contador = 1;
        salir = false;
        int jugadores = 0;
        Turno.moverJugador(Jugador.jugador1, 'q', tablero);
        Turno.moverJugador(Jugador.jugador2, 'q', tablero);
        Turno.moverJugador(Jugador.jugador3, 'q', tablero);
        Turno.moverJugador(Jugador.jugador4, 'q', tablero);
        printBienvenida();
        int instrucciones;
        boolean inicioInstrucciones = true;
        while(inicioInstrucciones){
            printInstruccionesOpcion();
            instrucciones = leerInt();
            if(instrucciones == 1){
                printInstrucciones();                
                break;
            }else if(instrucciones == 2){                
                break;
            }
        }
        
        while (!salir) {
            printJugadores();
            jugadores = leerInt();
            if (jugadores == 2 || jugadores == 3 || jugadores == 4) {
                Inicio.asignarListaTarjetas(jugadores);
                salir = true;
            } else {
                printError();
            }
        }
        salir = false;
        while (!salir) {

            printTurnoJugador(contador);
            moverFichas(tablero);
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

    
    
        public static void moverFichas(Tablero tablero) {
        int girar = 0;
        while (girar != 3) {
            dibujarTablero(tablero);
            printMensajeFichaLibre();
            printFicha(tablero.getFichasSobrantes().get(0));
            printDeseaGirar();
            girar = leerInt();
            switch (girar) {
                case 1:
                    rotarFicha(tablero.getFichasSobrantes().get(0));
                    rotarFicha(tablero.getFichasSobrantes().get(0));
                    rotarFicha(tablero.getFichasSobrantes().get(0));
                    break;
                case 2:
                    rotarFicha(tablero.getFichasSobrantes().get(0));
                    break;
                case 3:
                    break;
                default:
                    printError();
                    break;
            }
        }
        boolean salir = false;
        while (!salir) {
            printIngreseFicha();
            salir = true;
            int casilla = leerInt();

            switch (casilla) {
                case 1:
                case 2:
                case 3:
                    correrFila(tablero, casilla, (casilla * 2) - 1, 0, 0, 1);
                    break;
                case 4:
                case 6:
                case 8:
                    correrFila(tablero, casilla, 0, casilla - 3, 1, 0);
                    break;
                case 5:
                case 7:
                case 9:
                    correrFila(tablero, casilla, -6, casilla - 4, 1, 0);
                    break;
                case 10:
                case 11:
                case 12:
                    correrFila(tablero, casilla, (casilla - 9) * 2 - 1, -6, 0, 1);
                    break;
                default:
                    salir = false;
                    break;
            }

        }

    }

}
