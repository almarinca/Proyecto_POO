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
            int contador;
            switch (casilla) {
                case 1:
                case 2:
                case 3:
                    for (contador = 0; contador <= 6; contador++) {
                        fichasSobrantes.add(tablero.getTablero()[contador][(casilla * 2) - 1]);
                    }
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

            if (mover != 'q') {
                dibujarTablero(tablero);
                printMoverFicha();
                String a = leerString();
                mover = a.charAt(0);
            } else {
                salir = true;
            }

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
                case 'f':
                    salir = true;
                    pasoX = 0;
                    pasoY = 0;
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

}
