package UI;

import Data.*;
import java.util.Scanner;

public class Interfaz {

    static Scanner in = new Scanner(System.in);

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
