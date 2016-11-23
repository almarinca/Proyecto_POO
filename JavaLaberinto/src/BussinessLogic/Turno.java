package BussinessLogic;

import Data.*;
import java.util.ArrayList;

public abstract class Turno {

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

    public static void correrFila(int casilla, int x, int y, int mx, int my) {

        ArrayList<Ficha> fichasSobrantes = Tablero.getFichasSobrantes();
        for (int i = 0; i <= 6; i++) {
            fichasSobrantes.add(Tablero.getTablero()[Math.abs(i * my + y)][Math.abs(i * mx + x)]);
        }

        moverJugadorConFicha(casilla, fichasSobrantes);

        for (int i = 0; i <= 6; i++) {
            Tablero.getTablero()[Math.abs(i * my + y)][Math.abs(i * mx + x)] = fichasSobrantes.get(0);
            fichasSobrantes.remove(0);
        }
        Tablero.setFichasSobrantes(fichasSobrantes);
    }

    

    public static boolean desplazarJugador(Jugador jugador, char mover) {
        boolean movimientoValido = true;
        int X = jugador.getX();
        int Y = jugador.getY();
        int pasoX = 0;
        int pasoY = 0;
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
            default: // las fichas quedan en su posicion inicial
                pasoX = 0;
                pasoY = 0;
                break;
        }
        boolean muro;
        try {
            muro = Ficha.muro != Tablero.getTablero()[Y][X].getFicha()[pasoY + 1][pasoX + 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            muro = true;
        }

        int pasoT = (pasoX != 0) ? (X + pasoX) : (Y + pasoY);

        if ((pasoT < 7 && pasoT >= 0) && muro
                && Ficha.muro != Tablero.getTablero()[Y + pasoY][X + pasoX].getFicha()[1 - pasoY][1 - pasoX]) {

            Tablero.getTablero()[Y][X].getFicha()[1][1] = Tablero.getTablero()[Y][X].getCaracter();
            X = X + pasoX;
            Y = Y + pasoY;
            char centro = Tablero.getTablero()[Y][X].getFicha()[1][1];
            if (centro != '1' && centro != '2' && centro != '3' && centro != '4') {
                Tablero.getTablero()[Y][X].setCaracter(centro);
            }
            jugador.setX(X);
            jugador.setY(Y);
            redibujarJugadores();

        } else {
            movimientoValido = false;
        }
        return movimientoValido;
    }

    public static void redibujarJugadores() {

        Tablero.getTablero()[Jugador.jugador4.getY()][Jugador.jugador4.getX()].getFicha()[1][1] = Jugador.jugador4.getNumero();
        Tablero.getTablero()[Jugador.jugador3.getY()][Jugador.jugador3.getX()].getFicha()[1][1] = Jugador.jugador3.getNumero();
        Tablero.getTablero()[Jugador.jugador2.getY()][Jugador.jugador2.getX()].getFicha()[1][1] = Jugador.jugador2.getNumero();
        Tablero.getTablero()[Jugador.jugador1.getY()][Jugador.jugador1.getX()].getFicha()[1][1] = Jugador.jugador1.getNumero();

    }

    public static void moverJugadorConFicha(int casilla, ArrayList<Ficha> fichasSobrantes) {

        for (Jugador jugador : Jugador.values()) {
            if (fichasSobrantes.contains(Tablero.getTablero()[jugador.getY()][jugador.getX()])) {
                int X = jugador.getX();
                int Y = jugador.getY();
                switch (casilla) {
                    case 1:
                    case 2:
                    case 3:
                        actualizarPosJugador(Y, 6, 1, 0, X, 0, casilla, jugador);
                        break;
                    case 4:
                    case 6:
                    case 8:
                        actualizarPosJugador(X, 6, 0, 1, 0, Y, casilla, jugador);
                        break;
                    case 5:
                    case 7:
                    case 9:
                        actualizarPosJugador(X, 0, 0, -1, 6, Y, casilla, jugador);
                        break;
                    case 10:
                    case 11:
                    case 12:
                        actualizarPosJugador(Y, 0, -1, 0, X, 6, casilla, jugador);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public static void actualizarPosJugador(int filaOColumna, int extremo, int cambioY, int cambioX, int x, int y, int casilla, Jugador jugador) {
        int X = jugador.getX();
        int Y = jugador.getY();
        if (filaOColumna != extremo) {
            jugador.setY(Y + 1 * cambioY);
            jugador.setX(X + 1 * cambioX);
        } else {

            Tablero.getTablero()[Y][X].getFicha()[1][1] = Tablero.getTablero()[Y][X].getCaracter();
            jugador.setY(y);
            jugador.setX(x);
            char centro = Tablero.getFichasSobrantes().get(0).getFicha()[1][1];
            if (centro != '1' && centro != '2' && centro != '3' && centro != '4') {
                Tablero.getFichasSobrantes().get(0).setCaracter(Tablero.getFichasSobrantes().get(0).getFicha()[1][1]);
            }
            Tablero.getFichasSobrantes().get(0).getFicha()[1][1] = jugador.getNumero();
        }
    }
}
