package UI;

import Data.*;
import java.util.ArrayList;

public class Interfaz {

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
        
        
        String [][] tablero = new String[21][21];
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

}


