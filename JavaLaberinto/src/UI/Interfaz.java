package UI;

import Data.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Interfaz {

    static Scanner in = new Scanner(System.in);

    public static void dibujarTablero(Tablero tab) {

        ArrayList<String> listaCaracteres = new ArrayList<String>();

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                for (int k = 0; k < 3; k++) {
                    char[][] matrizCaracteres = tab.getTablero()[i][j].getFicha();
                    listaCaracteres.add(String.valueOf(matrizCaracteres[0][k]));
                }
            }
            for (int j = 0; j < 7; j++) {
                for (int k = 0; k < 3; k++) {
                    char[][] matrizCaracteres = tab.getTablero()[i][j].getFicha();
                    listaCaracteres.add(String.valueOf(matrizCaracteres[1][k]));
                }
            }
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    char[][] matrizCaracteres = tab.getTablero()[i][j].getFicha();
                    listaCaracteres.add(String.valueOf(matrizCaracteres[2][k]));
                }
            }

        }

        //HASTA ACA EL METODO PASA CADA CARACTER DEL TABLERO A UN ARRAYLIST
        String[][] tablero = new String[21][21];
        int z = 0;
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                tablero[i][j] = listaCaracteres.get(z++);
                if (z > (20)) {
                    break;
                }
            }
            if (z > (20)) { //ESTOS BREAKS SON PARA EVITAR QUE AL FINAL SE PASE DEL TAMAÑO
                break;
            }
        }

        //ESTA SEGUNDA PARTE PASA EL ARRAYLIST A UNA MATRIZ 21X21
        String printMatriz = "\n";

        for (int i = 0; i < 21; i++) {
            printMatriz = printMatriz.concat("\t|");
            for (int j = 0; j < 21; j++) {
                printMatriz = printMatriz.concat(
                        String.valueOf(tablero[i][j]).concat("|"));
            }
            printMatriz = printMatriz.concat("\n");
        }

        System.out.println(printMatriz);

        //ESTA ULTIMA PARTE DIBUJA YA TODO EL TABLERO COMO UNA MATRIZ GRANDE
    }

    public static int leerInt() {
        int a;
        String b = in.next();
        try {
            a = Integer.valueOf(b);
        } catch (Exception e) {
            a = -1;
        }
        return a;
    }

    public static String leerString() {
        String a;
        try {
            a = in.next();
        } catch (Exception e) {
            a = null;
        }
        return a;
    }

    public static void printBienvenida() {
        System.out.println("Juego de estrategia. Búsqueda de tesoros en un laberinto en movimiento.\n"
                + "Un laberinto de pasadizos que uno puede mover a su antojo para encontrar la mayor cantidad posible de tesoros y secretos. \n"
                + "El ganador será el que mueva más hábilmente los pasadizos. \n"
                + "¿Quién logrará desbaratar las trampas de este célebre laberinto para ser el primero en obtener todos sus tesoros? \n"
                + "\n"
                + "[Explicación mas completa del juego](https://www.youtube.com/watch?v=rV9ZULvLudg \"Explicacion del juego\")\n\n");
    }

    public static void printMensajeFichaLibre() {
        System.out.println("La ficha libre que debes usar para modificar el tablero es la siguiente:\n");
    }

    public static void printFicha(Ficha ficha) {
        System.out.println(ficha.toString());
    }
}
