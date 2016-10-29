/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLogic;

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
        while (!salir) {
            printJugadores();
            jugadores = leerInt();
            if (jugadores == 2 || jugadores == 3 || jugadores == 4) {
                asignarListaTarjetas(jugadores);
                salir = true;
            } else {
                printError();
            }
        }
        salir = false;
        while (!salir) {

            printTurnoJugador(contador);
            switch (contador) {
                case 1:
                    Turno.moverFichas(tablero);
                    Turno.moverJugador(Jugador.jugador1, 'a', tablero);
                    break;
                case 2:
                    Turno.moverFichas(tablero);
                    Turno.moverJugador(Jugador.jugador2, 'a', tablero);
                    break;
                case 3:
                    Turno.moverFichas(tablero);
                    Turno.moverJugador(Jugador.jugador3, 'a', tablero);
                    break;
                case 4:
                    Turno.moverFichas(tablero);
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

    public static void asignarListaTarjetas(int jugadores) {

        int contador = 24;
        for (int contador2 = 1; contador2 <= jugadores; contador2++) {
            ArrayList<Tarjeta> listaTarjetas = new ArrayList<>();
            for (int i = 0; i < (24 / jugadores); i++) {
                if (!Tablero.getListaTarjetas().isEmpty()) {
                    int tarjeta = (int) (Math.random() * contador);
                    listaTarjetas.add(Tablero.getListaTarjetas().get(tarjeta));
                    Tablero.getListaTarjetas().remove(tarjeta);
                    contador--;
                }
            }
            switch (contador2) {
                case 1:
                    Jugador.jugador1.setListaTarjetas(listaTarjetas);
                    Jugador.jugador1.getListaTarjetas().add(Tarjeta.Esquina1);
                    break;
                case 2:
                    Jugador.jugador2.setListaTarjetas(listaTarjetas);
                    Jugador.jugador2.getListaTarjetas().add(Tarjeta.Esquina2);
                    break;
                case 3:
                    Jugador.jugador3.setListaTarjetas(listaTarjetas);
                    Jugador.jugador3.getListaTarjetas().add(Tarjeta.Esquina3);
                    break;
                case 4:
                    Jugador.jugador4.setListaTarjetas(listaTarjetas);
                    Jugador.jugador4.getListaTarjetas().add(Tarjeta.Esquina4);
                    break;
                default:
                    break;
            }
        }
    }

}
