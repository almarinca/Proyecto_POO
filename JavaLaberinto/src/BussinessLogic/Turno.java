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
            int x = 0;
            int y = 0;
            int mx = 0;
            int my = 0;
            switch (casilla) {
                case 1:
                case 2:
                case 3:
                    x = (casilla * 2) - 1;
                    my = 1;
                    break;
                case 4:
                case 6:
                case 8:
                    y = casilla - 3;
                    mx = 1;
                    break;
                case 5:
                case 7:
                case 9:
                    x = -6;
                    y = casilla - 4;
                    mx = 1;
                    break;
                case 10:
                case 11:
                case 12:
                    x = (casilla - 9) * 2 - 1;
                    y = -6;
                    my = 1;
                    break;
                default:
                    salir = false;
                    break;
            }
            for (int i = 0; i <= 6; i++) {
                fichasSobrantes.add(tablero.getTablero()[Math.abs(i * my + y)][Math.abs(i * mx + x)]);
            }
            evaluarJugadorEnFichas(fichasSobrantes, tablero, casilla);
            for (int i = 0; i <= 6; i++) {
                tablero.getTablero()[Math.abs(i * my + y)][Math.abs(i * mx + x)] = fichasSobrantes.get(0);
                fichasSobrantes.remove(0);
            }
            tablero.setFichasSobrantes(fichasSobrantes);
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
                        } catch (Exception e) {
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
                char centro = tablero.getTablero()[Y][X].getFicha()[1][1];
                if (centro != '1' && centro != '2' && centro != '3' && centro != '4') {
                    tablero.getTablero()[Y][X].setCaracter(centro);
                }

            } else {
                printMovInvalido();
            }

            jugador.setX(X);
            jugador.setY(Y);
            redibujarJugadores();
        }
    }

    public static void redibujarJugadores() {

        Tablero.getTablero()[Jugador.jugador4.getY()][Jugador.jugador4.getX()].getFicha()[1][1] = Jugador.jugador4.getNumero();
        Tablero.getTablero()[Jugador.jugador3.getY()][Jugador.jugador3.getX()].getFicha()[1][1] = Jugador.jugador3.getNumero();
        Tablero.getTablero()[Jugador.jugador2.getY()][Jugador.jugador2.getX()].getFicha()[1][1] = Jugador.jugador2.getNumero();
        Tablero.getTablero()[Jugador.jugador1.getY()][Jugador.jugador1.getX()].getFicha()[1][1] = Jugador.jugador1.getNumero();

    }

    public static void moverJugadorConFicha(Jugador jugador, int casilla, Tablero tablero) {
        int X = jugador.getX();
        int Y = jugador.getY();
        switch (casilla) {
            case 1:
            case 2:
            case 3:
                actualizarPosJugador(Y, 6, 1, 0, X, 0, casilla, jugador, tablero);
                break;
            case 4:
            case 6:
            case 8:
                actualizarPosJugador(X, 6, 0, 1, 0, Y, casilla, jugador, tablero);
                break;
            case 5:
            case 7:
            case 9:
                actualizarPosJugador(X, 0, 0, -1, 6, Y, casilla, jugador, tablero);
                break;
            case 10:
            case 11:
            case 12:
                actualizarPosJugador(Y, 0, -1, 0, X, 6, casilla, jugador, tablero);
                break;
            default:
                break;
        }
        tablero.modificarTesoros();
    }

    public static void actualizarPosJugador(int filaOColumna, int extremo, int cambioY, int cambioX, int x, int y, int casilla, Jugador jugador, Tablero tablero) {
        int X = jugador.getX();
        int Y = jugador.getY();
        if (filaOColumna != extremo) {
            jugador.setY(Y + 1 * cambioY);
            jugador.setX(X + 1 * cambioX);
        } else {

            tablero.getTablero()[Y][X].getFicha()[1][1] = tablero.getTablero()[Y][X].getCaracter();
            jugador.setY(y);
            jugador.setX(x);
            char centro = tablero.getFichasSobrantes().get(0).getFicha()[1][1];
            if (centro != '1' && centro != '2' && centro != '3' && centro != '4') {
                tablero.getFichasSobrantes().get(0).setCaracter(tablero.getFichasSobrantes().get(0).getFicha()[1][1]);
            }
            tablero.getFichasSobrantes().get(0).getFicha()[1][1] = jugador.getNumero();
        }
    }

    public static void evaluarJugadorEnFichas(ArrayList<Ficha> fichasSobrantes, Tablero tablero, int casilla) {

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
