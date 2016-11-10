package BussinessLogic;

import static BussinessLogic.Turno.*;
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
        desplazarJugador(Jugador.jugador1, '0');
        desplazarJugador(Jugador.jugador2, '0');
        desplazarJugador(Jugador.jugador3, '0');
        desplazarJugador(Jugador.jugador4, '0');
        printBienvenida();
        int instrucciones;
        boolean inicioInstrucciones = true;
        while (inicioInstrucciones) {
            printInstruccionesOpcion();
            instrucciones = leerInt();
            if (instrucciones == 1) {
                printInstrucciones();
                break;
            } else if (instrucciones == 2) {
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
                    movimientoJugador(Jugador.jugador1, 'a', tablero);
                    evaluarGanador(Jugador.jugador1);
                    break;
                case 2:
                    movimientoJugador(Jugador.jugador2, 'a', tablero);
                    evaluarGanador(Jugador.jugador2);
                    break;
                case 3:
                    movimientoJugador(Jugador.jugador3, 'a', tablero);
                    evaluarGanador(Jugador.jugador3);
                    break;
                case 4:
                    movimientoJugador(Jugador.jugador4, 'a', tablero);
                    evaluarGanador(Jugador.jugador4);
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
    
    public static void movimientoJugador(Jugador jugador, char mover, Tablero tablero) {

        boolean salir = false;
        while (!salir) {
            dibujarTablero(tablero);
            printMoverFicha();
            String a = leerString();
            mover = a.charAt(0);
            salir = (mover == 'f') ? true : false;
            boolean valido = desplazarJugador(jugador, mover);
            if(!valido){
                printMovInvalido();
            }

        }
    }
    
    public static void evaluarGanador(Jugador jugador){
        if (jugador.getListaTarjetas().get(0).getSimbolo() == Tablero.getTablero()[jugador.getY()][jugador.getX()].getCaracter()) {
                        printTesoroEncontrado(jugador);
                        jugador.getListaTarjetas().remove(0);
                        if (jugador.getListaTarjetas().isEmpty()) {
                            printGanador(jugador);
                            JavaLaberinto.salir = true;
                        }
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
