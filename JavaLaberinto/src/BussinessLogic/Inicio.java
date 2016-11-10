/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLogic;

import Data.Jugador;
import Data.Tablero;
import Data.Tarjeta;
import java.util.ArrayList;

/**
 *
 * @author alejomarin
 */
public class Inicio {
    
    public static void asignarListaTarjetas(int jugadores) {

        int contador = 24;
        for (int contador2 = 1; contador2 <= jugadores; contador2++) {
            ArrayList<Tarjeta> listaTarjetas = new ArrayList<>();
            for (int i = 0; i < (24 / jugadores); i++) {
                if (!Tablero.getListaTarjetas().isEmpty()) {
                    int tarjeta = (int) (Math.random() * contador);
                    listaTarjetas.add(Tablero.getListaTarjetas().get(tarjeta));
                    Tablero.getListaTarjetas().remove(tarjeta);
                    contador--;
                }
            }
            switch (contador2) {
                case 1:
                    Jugador.jugador1.setListaTarjetas(listaTarjetas);
                    Jugador.jugador1.getListaTarjetas().add(Tarjeta.Esquina1);
                    break;
                case 2:
                    Jugador.jugador2.setListaTarjetas(listaTarjetas);
                    Jugador.jugador2.getListaTarjetas().add(Tarjeta.Esquina2);
                    break;
                case 3:
                    Jugador.jugador3.setListaTarjetas(listaTarjetas);
                    Jugador.jugador3.getListaTarjetas().add(Tarjeta.Esquina3);
                    break;
                case 4:
                    Jugador.jugador4.setListaTarjetas(listaTarjetas);
                    Jugador.jugador4.getListaTarjetas().add(Tarjeta.Esquina4);
                    break;
                default:
                    break;
            }
        }
    }
    
}
