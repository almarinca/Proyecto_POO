package BussinessLogic;

import Data.*;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public abstract class Inicio {

    Toolkit t = Toolkit.getDefaultToolkit();
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int y = screenSize.height / 10;
    public static int x = screenSize.width;

    public static char asignarTesoroFichasSobrantes(int i, Ficha ficha) {

        ImageIcon imagen = null;

        switch (i) {
            case 1:
                imagen = new ImageIcon("Tesoros/FichasSueltas/FichaEsquinaTesoroAraña.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(y, y, Image.SCALE_SMOOTH));
                ficha.setImagen(imagen);
                return Tarjeta.Arana.getSimbolo();
            case 2:
                imagen = new ImageIcon("Tesoros/FichasSueltas/FichaEsquinaTesoroMariposa.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(y, y, Image.SCALE_SMOOTH));
                ficha.setImagen(imagen);
                return Tarjeta.Mariposa.getSimbolo();
            case 3:
                imagen = new ImageIcon("Tesoros/FichasSueltas/FichaEsquinaTesoroGenio.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(y, y, Image.SCALE_SMOOTH));
                ficha.setImagen(imagen);
                return Tarjeta.Genio.getSimbolo();
            case 4:
                imagen = new ImageIcon("Tesoros/FichasSueltas/FichaEsquinaTesoroDragon.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(y, y, Image.SCALE_SMOOTH));
                ficha.setImagen(imagen);
                return Tarjeta.Dragon.getSimbolo();
            case 5:
                imagen = new ImageIcon("Tesoros/FichasSueltas/FichaEsquinaTesoroLagartija.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(y, y, Image.SCALE_SMOOTH));
                ficha.setImagen(imagen);
                return Tarjeta.Lagartija.getSimbolo();
            case 6:
                imagen = new ImageIcon("Tesoros/FichasSueltas/FichaEsquinaTesoroCerdito.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(y, y, Image.SCALE_SMOOTH));
                ficha.setImagen(imagen);
                return Tarjeta.Cerdo.getSimbolo();
            case 7:
                imagen = new ImageIcon("Tesoros/FichasSueltas/FichaEsquinaTesoroBuho.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(y, y, Image.SCALE_SMOOTH));
                ficha.setImagen(imagen);
                return Tarjeta.Buho.getSimbolo();
            case 8:
                imagen = new ImageIcon("Tesoros/FichasSueltas/FichaEsquinaTesoroRaton.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(y, y, Image.SCALE_SMOOTH));
                ficha.setImagen(imagen);
                return Tarjeta.Raton.getSimbolo();
            case 9:
                imagen = new ImageIcon("Tesoros/FichasSueltas/FichaEsquinaTesoroBruja.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(y, y, Image.SCALE_SMOOTH));
                ficha.setImagen(imagen);
                return Tarjeta.Bruja.getSimbolo();
            case 10:
                imagen = new ImageIcon("Tesoros/FichasSueltas/FichaEsquinaTesoroMurcielago.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(y, y, Image.SCALE_SMOOTH));
                ficha.setImagen(imagen);
                return Tarjeta.Murcielago.getSimbolo();
            case 11:
                imagen = new ImageIcon("Tesoros/FichasSueltas/FichaEsquinaTesoroFantasma.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(y, y, Image.SCALE_SMOOTH));
                ficha.setImagen(imagen);
                return Tarjeta.Fantasma.getSimbolo();
            case 12:
                imagen = new ImageIcon("Tesoros/FichasSueltas/FichaEsquinaTesoroInsecto.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(y, y, Image.SCALE_SMOOTH));
                ficha.setImagen(imagen);
                return Tarjeta.Insecto.getSimbolo();
            default:
                imagen = new ImageIcon("Tesoros/FichaEsquina.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(y, y, Image.SCALE_SMOOTH));
                ficha.setImagen(imagen);
                return ' ';
        }
    }

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
