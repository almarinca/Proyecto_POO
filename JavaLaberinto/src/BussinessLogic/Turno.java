package BussinessLogic;

import Data.*;
import static UI.Interfaz.*;
import java.util.ArrayList;

public class Turno {

    public static void rotarFicha(Ficha f) {

        char[][] matriz = f.getFicha();
        char[][] matrizrot = new char[3][3];
        int h = 2;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrizrot[i][j] = matriz[h - j][i];
            }
        }

        f.setFicha(matrizrot);
    }

    public static Tablero moverFichas(Tablero tablero) {
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
            ArrayList<Ficha> fichasSobrantes = tablero.getFichasSobrantes();
            int contador, Y, X;
            boolean a;
            switch (casilla) {
                case 1:
                case 2:
                case 3:
                    for (contador = 0; contador <= 6; contador++) {
                        fichasSobrantes.add(tablero.getTablero()[contador][(casilla * 2) - 1]);
                    }
                    moverJugadorConFicha2(fichasSobrantes, tablero, casilla);
                    for (contador = 0; contador <= 6; contador++) {
                        tablero.getTablero()[contador][(casilla * 2) - 1] = fichasSobrantes.get(0);
                        fichasSobrantes.remove(0);
                    }
                    tablero.setFichasSobrantes(fichasSobrantes);
                    break;
                case 4:
                case 6:
                case 8:
                    for (contador = 0; contador <= 6; contador++) {
                        fichasSobrantes.add(tablero.getTablero()[casilla - 3][contador]);
                    }
                    moverJugadorConFicha2(fichasSobrantes, tablero, casilla);
                    for (contador = 0; contador <= 6; contador++) {
                        tablero.getTablero()[casilla - 3][contador] = fichasSobrantes.get(0);
                        fichasSobrantes.remove(0);
                    }
                    tablero.setFichasSobrantes(fichasSobrantes);
                    break;
                case 5:
                case 7:
                case 9:
                    for (contador = 6; contador >= 0; contador--) {
                        fichasSobrantes.add(tablero.getTablero()[casilla - 4][contador]);
                    }
                    moverJugadorConFicha2(fichasSobrantes, tablero, casilla);
                    for (contador = 6; contador >= 0; contador--) {
                        tablero.getTablero()[casilla - 4][contador] = fichasSobrantes.get(0);
                        fichasSobrantes.remove(0);
                    }
                    tablero.setFichasSobrantes(fichasSobrantes);
                    break;
                case 10:
                case 11:
                case 12:
                    for (contador = 6; contador >= 0; contador--) {
                        fichasSobrantes.add(tablero.getTablero()[contador][((casilla - 9) * 2) - 1]);
                    }
                    moverJugadorConFicha2(fichasSobrantes, tablero, casilla);
                    for (contador = 6; contador >= 0; contador--) {
                        tablero.getTablero()[contador][((casilla - 9) * 2) - 1] = fichasSobrantes.get(0);
                        fichasSobrantes.remove(0);
                    }
                    tablero.setFichasSobrantes(fichasSobrantes);
                    break;
                default:
                    salir = false;
                    break;
            }
        }

        return tablero;
    }

    public static void moverJugador(Jugador jugador, char mover, Tablero tablero) {

        boolean salir = false;
        while (!salir) {

            int X = jugador.getX();
            int Y = jugador.getY();
            int pasoX = 0;
            int pasoY = 0;

            if (mover != 'q') {
                dibujarTablero(tablero);
                printMoverFicha();
                String a = leerString();
                mover = a.charAt(0);
            } else {
                tablero.getTablero()[Y][X].setCaracter(jugador.getBase());
                salir = true;
            }

            switch (mover) {
                case 'w':
                    pasoY = -1;
                    break;
                case 'a':
                    pasoX = -1;
                    break;
                case 's':
                    pasoY = 1;
                    break;
                case 'd':
                    pasoX = 1;
                    break;
                case 'f':
                    salir = true;
                    pasoX = 0;
                    pasoY = 0;
                    if (jugador.getListaTarjetas().get(0).getSimbolo() == tablero.getTablero()[Y][X].getCaracter()) {
                        printTesoroEncontrado(jugador);
                        try {
                            jugador.getListaTarjetas().remove(0);
                        }
                        catch(Exception e){
                            printGanador(jugador);
                            JavaLaberinto.salir = true;
                        }
                    }
                    break;
                default: // las fichas quedan en su posicion inicial
                    pasoX = 0;
                    pasoY = 0;
                    break;
            }
            boolean muro;
            try {
                muro = Ficha.muro != tablero.getTablero()[Y][X].getFicha()[pasoY + 1][pasoX + 1];
            } catch (ArrayIndexOutOfBoundsException e) {
                muro = true;
            }

            int pasoT = (pasoX != 0) ? (X + pasoX) : (Y + pasoY);

            if ((pasoT < 7 && pasoT >= 0) && muro
                    && Ficha.muro != tablero.getTablero()[Y + pasoY][X + pasoX].getFicha()[1 - pasoY][1 - pasoX]) {

                tablero.getTablero()[Y][X].getFicha()[1][1] = tablero.getTablero()[Y][X].getCaracter();
                X = X + pasoX;
                Y = Y + pasoY;
                tablero.getTablero()[Y][X].setCaracter(tablero.getTablero()[Y][X].getFicha()[1][1]);

            } else {
                printMovInvalido();
            }

            jugador.setX(X);
            jugador.setY(Y);
            tablero.getTablero()[Y][X].getFicha()[1][1] = jugador.getNumero();
        }
    }

    public static void moverJugadorConFicha(Jugador jugador, int casilla, Tablero tablero) {
        int X = jugador.getX();
        int Y = jugador.getY();
        switch (casilla) {
            case 1:
            case 2:
            case 3:
                if (Y != 6) {
                    jugador.setY(Y + 1);
                } else {
                    jugador.setY(0);
                }
                break;
            case 4:
            case 6:
            case 8:
                if (X != 6) {
                    jugador.setX(X + 1);
                } else {
                    jugador.setX(0);
                }
                break;
            case 5:
            case 7:
            case 9:
                if (X != 0) {
                    jugador.setX(X - 1);
                } else {
                    jugador.setX(6);
                }
                break;
            case 10:
            case 11:
            case 12:
                if (Y != 0) {
                    jugador.setY(Y - 1);
                } else {
                    jugador.setY(6);
                }
                break;
            default:
                break;
        }
        tablero.modificarTesoros();
    }

    public static void moverJugadorConFicha2(ArrayList<Ficha> fichasSobrantes, Tablero tablero, int casilla) {
        for (int i = 0; i < 8; i++) {
            int Y, X;
            boolean a;
            Y = Jugador.jugador1.getY();
            X = Jugador.jugador1.getX();
            a = fichasSobrantes.contains(tablero.getTablero()[Y][X]);
            if (a) {
                moverJugadorConFicha(Jugador.jugador1, casilla, tablero);
            }
            Y = Jugador.jugador2.getY();
            X = Jugador.jugador2.getX();
            a = fichasSobrantes.contains(tablero.getTablero()[Y][X]);
            if (a) {
                moverJugadorConFicha(Jugador.jugador2, casilla, tablero);
            }
            Y = Jugador.jugador3.getY();
            X = Jugador.jugador3.getX();
            a = fichasSobrantes.contains(tablero.getTablero()[Y][X]);
            if (a) {
                moverJugadorConFicha(Jugador.jugador3, casilla, tablero);
            }
            Y = Jugador.jugador4.getY();
            X = Jugador.jugador4.getX();
            a = fichasSobrantes.contains(tablero.getTablero()[Y][X]);
            if (a) {
                moverJugadorConFicha(Jugador.jugador4, casilla, tablero);
            }
        }
    }

}