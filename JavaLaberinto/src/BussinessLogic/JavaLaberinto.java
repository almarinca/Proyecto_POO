/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLogic;

import Data.Ficha;
import static Data.Ficha.setFicha;
import Data.Tablero;

public class JavaLaberinto {

    public static void main(String[] args) {
        Ficha ficha = new Ficha();
        setFicha(ficha.fichaRecta());
        System.out.println(ficha.toString());
        Ficha ficha1 = new Ficha();
        setFicha(ficha.fichaT());
        System.out.println(ficha.toString());
        Ficha ficha2 = new Ficha();
        setFicha(ficha.fichaEsquina());
        System.out.println(ficha.toString());
        Tablero tablero = new Tablero();
    }
    
}
