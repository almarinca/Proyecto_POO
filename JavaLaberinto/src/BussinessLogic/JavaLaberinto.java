/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLogic;

import Data.*;
import static BussinessLogic.Turno.rotarFicha;

public class JavaLaberinto {

    public static void main(String[] args) {
        Ficha ficha = new Ficha();
        ficha.setFicha(ficha.fichaRecta());
        Ficha ficha1 = new Ficha();
        ficha1.setFicha(ficha.fichaT());
        Ficha ficha2 = new Ficha();
        ficha2.setFicha(ficha.fichaEsquina());
        System.out.println(ficha.toString());
        System.out.println(ficha1.toString());
        System.out.println(ficha2.toString());
        rotarFicha(ficha2);
        System.out.println(ficha2.toString());
        Tablero tablero = new Tablero();
    }

}
