package UI;

import Data.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Interfaz {

    static Scanner in = new Scanner(System.in);

    public static void dibujarTablero(Tablero tab) {

        ArrayList<String> listaCaracteres = new ArrayList<>();

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
            for (int j = 0; j < 7; j++) {
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
            }
        }

        //ESTA SEGUNDA PARTE PASA EL ARRAYLIST A UNA MATRIZ 21X21
        int cont = 4;
        String printMatriz = "\n" + "\t       |  1  |     |  2  |     |  3  |     \n";

        for (int i = 0; i < 21; i++) {
            printMatriz = printMatriz.concat("\t");
            if ((i - 2) % 3 == 0) {
                printMatriz = printMatriz.concat("_|");
            } else if ((i - 4) % 6 == 0) {
                printMatriz = printMatriz.concat(String.valueOf(cont) + "|");
                cont++;
            } else {
                printMatriz = printMatriz.concat(" |");
            }

            for (int j = 0; j < 21; j++) {
                printMatriz = printMatriz.concat(
                        String.valueOf(tablero[i][j]).concat("|"));
            }

            if ((i - 2) % 3 == 0) {
                printMatriz = printMatriz.concat("_");
            } else if ((i - 4) % 6 == 0) {
                printMatriz = printMatriz.concat(String.valueOf(cont));
                cont++;
            } else {
                printMatriz = printMatriz.concat(" ");
            }
            printMatriz = printMatriz.concat("\n");
        }
        printMatriz = printMatriz.concat("\t       |  10 |     |  11 |     |  12 |     \n");

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

    public static void printMovInvalido() {
        System.out.println("No se puede mover a esta posicion, vuelva a intentarlo");
    }

    public static void printDeseaGirar() {
        System.out.println("Deseas:\n1) Girar la ficha a la izquierda\n2) Girar la ficha a la derecha\n3) No girar la ficha\n");
    }

    public static void printIngreseFicha() {
        System.out.println("Ingresa un número del 1 al 12 para seleccionar donde deseas ingresar la ficha\n");
    }

    public static void printError() {
        System.out.println("Valor inválido, por favor inténtalo nuevamente\n");
    }

    public static void printMoverFicha() {
        System.out.println("Mueve tu ficha con wasd o termina tu turno con f\n");
    }

    public static void printJugadores() {
        System.out.println("¡Cuantos jugadores jugarán esta vez(ingresa 2, 3 o 4)?\n");
    }

    public static void printTurnoJugador(int contador) {
        char tesoro = 0;
        switch (contador) {
            case 1:
                tesoro = Jugador.jugador1.getListaTarjetas().get(0).getSimbolo();
                break;
            case 2:
                tesoro = Jugador.jugador2.getListaTarjetas().get(0).getSimbolo();
                break;
            case 3:
                tesoro = Jugador.jugador3.getListaTarjetas().get(0).getSimbolo();
                break;
            case 4:
                tesoro = Jugador.jugador4.getListaTarjetas().get(0).getSimbolo();
                break;
            default:
                break;
        }
        System.out.println("\n\n\n\n/////////////////////////////\n"
                + "Es el turno del jugador " + contador + "\n"
                + "Tienes que llegar al tesoro " + tesoro + "\n/////////////////////////////");
    }
    
    public static void printTesoroEncontrado(Jugador jugador){
    System.out.println("\n\n\n\n/////////////////////////////\n"
            + "Felicitaciones jugador "+ jugador.getNumero() + " has encontrado el tesoro"
            + " " + jugador.getListaTarjetas().get(0).getSimbolo() + "\n/////////////////////////////");
    }
    
    public static void printGanador(Jugador jugador){
        System.out.println("\n\n\n\n/////////////////////////////\n"
                + "Felicitaciones jugador "+ jugador.getNumero() + " eres el ganador\n/////////////////////////////\n");
    }
}
