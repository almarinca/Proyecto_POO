package BussinessLogic;

import Data.*;
import static UI.Interfaz.printMovInvalido;

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

        return tablero;
    }

    public static void moverJugador(Jugador jugador, char mover, Tablero tablero) {

        int X = jugador.getPosXEnTablero();
        int Y = jugador.getPosYEnTablero();
        int x = jugador.getPosXEnFicha();
        int y = jugador.getPosYEnFicha();
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
            muro = Ficha.muro != tablero.getTablero()[Y][X].getFicha()[y + pasoY][x + pasoX];
        } catch (ArrayIndexOutOfBoundsException e) {
            muro = true;
        }
        int pasoF = (pasoX != 0) ? (x + pasoX) : (y + pasoY);
        int pasoT = (pasoX != 0) ? (X + pasoX) : (Y + pasoY);
        if ((pasoF < 3 && pasoF >= 0) && muro) {
            tablero.getTablero()[Y][X].getFicha()[y][x] = ' ';
            x = x + pasoX;
            y = y + pasoY;
        } else if ((pasoT < 7 && pasoT >= 0) && muro
                && Ficha.muro != tablero.getTablero()[Y + pasoY][X + pasoX].getFicha()[y - pasoY * 2][x - pasoX * 2]) {

            tablero.getTablero()[Y][X].getFicha()[y][x] = ' ';
            X = X + pasoX;
            Y = Y + pasoY;
            x = (x - pasoX * 2);
            y = (y - pasoY * 2);
        } else {
            printMovInvalido();
        }

        jugador.setPosXEnTablero(X);
        jugador.setPosYEnTablero(Y);
        jugador.setPosXEnFicha(x);
        jugador.setPosYEnFicha(y);
        tablero.getTablero()[Y][X].getFicha()[y][x] = jugador.getNumero();

    }

}
