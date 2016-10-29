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
                    for (int i = 0; i < 8; i++) {
                        char a = fichasSobrantes.get(i).getFicha()[1][1];
                        if (a == '1' || a == '2' || a == '3' || a == '4') {
                            moverJugadorConFicha(a, casilla);
                        }
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
                    for (int i = 0; i < 8; i++) {
                        char a = fichasSobrantes.get(i).getFicha()[1][1];
                        if (a == '1' || a == '2' || a == '3' || a == '4') {
                            moverJugadorConFicha(a, casilla);
                        }
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
                    for (int i = 0; i < 8; i++) {
                        char a = fichasSobrantes.get(i).getFicha()[1][1];
                        if (a == '1' || a == '2' || a == '3' || a == '4') {
                            moverJugadorConFicha(a, casilla);
                        }
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
                    for (int i = 0; i < 8; i++) {
                        char a = fichasSobrantes.get(i).getFicha()[1][1];
                        if (a == '1' || a == '2' || a == '3' || a == '4') {
                            moverJugadorConFicha(a, casilla);
                        }
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
                muro = Ficha.muro != tablero.getTablero()[Y][X].getFicha()[pasoY + 1][pasoX + 1];
            } catch (ArrayIndexOutOfBoundsException e) {
                muro = true;
            }

            int pasoT = (pasoX != 0) ? (X + pasoX) : (Y + pasoY);

            if ((pasoT < 7 && pasoT >= 0) && muro
                    && Ficha.muro != tablero.getTablero()[Y + pasoY][X + pasoX].getFicha()[1 - pasoY][1 - pasoX]) {

                tablero.getTablero()[Y][X].getFicha()[1][1] = tablero.getTablero()[Y][X].getTesoro();
                X = X + pasoX;
                Y = Y + pasoY;
                tablero.getTablero()[Y][X].setTesoro(tablero.getTablero()[Y][X].getFicha()[1][1]);

            } else {
                printMovInvalido();
            }

            jugador.setPosXEnTablero(X);
            jugador.setPosYEnTablero(Y);
            tablero.getTablero()[Y][X].getFicha()[1][1] = jugador.getNumero();
        }
    }

    public static void moverJugadorConFicha(char a, int casilla) {
        if (casilla >= 1 && casilla <= 3) {
            switch (a) {
                case '1':
                    try {
                        Jugador.jugador1.setPosYEnTablero(Jugador.jugador1.getPosYEnTablero() + 1);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        Jugador.jugador1.setPosYEnTablero(0);
                    }
                    break;
                case '2':
                    try {
                        Jugador.jugador2.setPosYEnTablero(Jugador.jugador2.getPosYEnTablero() + 1);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        Jugador.jugador2.setPosYEnTablero(0);
                    }
                    break;
                case '3':
                    try {
                        Jugador.jugador3.setPosYEnTablero(Jugador.jugador3.getPosYEnTablero() + 1);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        Jugador.jugador3.setPosYEnTablero(0);
                    }
                    break;
                case '4':
                    try {
                        Jugador.jugador4.setPosYEnTablero(Jugador.jugador4.getPosYEnTablero() + 1);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        Jugador.jugador4.setPosYEnTablero(0);
                    }
                    break;
                default:
                    break;
            }
        } else if (casilla >= 4 && casilla <= 6) {
            switch (a) {
                case '1':
                    try {
                        Jugador.jugador1.setPosXEnTablero(Jugador.jugador1.getPosXEnTablero() + 1);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        Jugador.jugador1.setPosXEnTablero(0);
                    }
                    break;
                case '2':
                    try {
                        Jugador.jugador2.setPosXEnTablero(Jugador.jugador2.getPosXEnTablero() + 1);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        Jugador.jugador2.setPosXEnTablero(0);
                    }
                    break;
                case '3':
                    try {
                        Jugador.jugador3.setPosXEnTablero(Jugador.jugador3.getPosXEnTablero() + 1);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        Jugador.jugador3.setPosXEnTablero(0);
                    }
                    break;
                case '4':
                    try {
                        Jugador.jugador4.setPosXEnTablero(Jugador.jugador4.getPosXEnTablero() + 1);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        Jugador.jugador4.setPosXEnTablero(0);
                    }
                    break;
                default:
                    break;
            }
        } else if (casilla >= 7 && casilla <= 9) {
            switch (a) {
                case '1':
                    try {
                        Jugador.jugador1.setPosXEnTablero(Jugador.jugador1.getPosXEnTablero() - 1);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        Jugador.jugador1.setPosXEnTablero(6);
                    }
                    break;
                case '2':
                    try {
                        Jugador.jugador2.setPosXEnTablero(Jugador.jugador2.getPosXEnTablero() - 1);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        Jugador.jugador2.setPosXEnTablero(6);
                    }
                    break;
                case '3':
                    try {
                        Jugador.jugador3.setPosXEnTablero(Jugador.jugador3.getPosXEnTablero() - 1);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        Jugador.jugador3.setPosXEnTablero(6);
                    }
                    break;
                case '4':
                    try {
                        Jugador.jugador4.setPosXEnTablero(Jugador.jugador4.getPosXEnTablero() - 1);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        Jugador.jugador4.setPosXEnTablero(6);
                    }
                    break;
                default:
                    break;
            }
        } else if (casilla >= 10 && casilla <= 12) {
            switch (a) {
                case '1':
                    try {
                        Jugador.jugador1.setPosYEnTablero(Jugador.jugador1.getPosYEnTablero() - 1);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        Jugador.jugador1.setPosYEnTablero(6);
                    }
                    break;
                case '2':
                    try {
                        Jugador.jugador2.setPosYEnTablero(Jugador.jugador2.getPosYEnTablero() - 1);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        Jugador.jugador2.setPosYEnTablero(6);
                    }
                    break;
                case '3':
                    try {
                        Jugador.jugador3.setPosYEnTablero(Jugador.jugador3.getPosYEnTablero() - 1);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        Jugador.jugador3.setPosYEnTablero(6);
                    }
                    break;
                case '4':
                    try {
                        Jugador.jugador4.setPosYEnTablero(Jugador.jugador4.getPosYEnTablero() - 1);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        Jugador.jugador4.setPosYEnTablero(6);
                    }
                    break;
                default:
                    break;
            }
        }
    }

}
