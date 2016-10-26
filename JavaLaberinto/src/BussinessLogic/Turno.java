package BussinessLogic;

import Data.*;

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

}
