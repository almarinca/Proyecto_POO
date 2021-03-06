package Data;

import BussinessLogic.Inicio;
import java.util.ArrayList;
import static BussinessLogic.Turno.rotarFicha;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.ImageIcon;

public class Tablero implements Serializable {

    private static Ficha[][] tablero = new Ficha[7][7];
    private static final ArrayList<Ficha> listaFichas = new ArrayList<>();
    private static ArrayList<Ficha> fichasSobrantes = new ArrayList<>();
    private static ArrayList<Tarjeta> listaTarjetas = new ArrayList<>();
    int y = Inicio.y;

    public Tablero() {

        crearFichas(Ficha.fichaR, 13);
        crearFichas(Ficha.fichaT, 17);
        crearFichas(Ficha.fichaL, 20);

        fichasSobrantes = (ArrayList<Ficha>) listaFichas.clone();

        //FICHAS DONDE ESTAN UBICADOS LOS TESOROS
        asignarFichaFija(0, 0, 0, 30, Tarjeta.Esquina1, new ImageIcon("Tesoros/FichasDeInicio/FichaJugadorVerde.png"));
        asignarFichaFija(1, 0, 6, 31, Tarjeta.Esquina3, new ImageIcon("Tesoros/FichasDeInicio/FichaJugadorAmarillo.png"));
        asignarFichaFija(2, 6, 6, 32, Tarjeta.Esquina4, new ImageIcon("Tesoros/FichasDeInicio/FichaJugadorAzul.png"));
        asignarFichaFija(3, 6, 0, 33, Tarjeta.Esquina2, new ImageIcon("Tesoros/FichasDeInicio/FichaJugadorRojo.png"));
        asignarFichaFija(0, 0, 2, 13, Tarjeta.Anillo, new ImageIcon("Tesoros/FichasEstaticas/FichaTTesoroAnillo.png"));
        asignarFichaFija(0, 0, 4, 14, Tarjeta.Mapa, new ImageIcon("Tesoros/FichasEstaticas/FichaTTesoroMapa.png"));
        asignarFichaFija(0, 2, 4, 15, Tarjeta.Corona, new ImageIcon("Tesoros/FichasEstaticas/FichaTTesoroCorona.png"));
        asignarFichaFija(1, 2, 6, 16, Tarjeta.Libro, new ImageIcon("Tesoros/FichasEstaticas/FichaTTesoroLibro.png"));
        asignarFichaFija(1, 4, 6, 17, Tarjeta.BolsaDeMonedas, new ImageIcon("Tesoros/FichasEstaticas/FichaTTesoroBolsaDeMonedas.png"));
        asignarFichaFija(1, 4, 4, 18, Tarjeta.Llaves, new ImageIcon("Tesoros/FichasEstaticas/FichaTTesoroLlave.png"));
        asignarFichaFija(2, 6, 2, 19, Tarjeta.Espada, new ImageIcon("Tesoros/FichasEstaticas/FichaTTesoroEspada.png"));
        asignarFichaFija(2, 6, 4, 20, Tarjeta.Craneo, new ImageIcon("Tesoros/FichasEstaticas/FichaTTesoroCraneo.png"));
        asignarFichaFija(2, 4, 2, 21, Tarjeta.Esmeralda, new ImageIcon("Tesoros/FichasEstaticas/FichaTTesoroEsmeralda.png"));
        asignarFichaFija(3, 2, 0, 22, Tarjeta.Veladora, new ImageIcon("Tesoros/FichasEstaticas/FichaTTesoroVeladora.png"));
        asignarFichaFija(3, 4, 0, 23, Tarjeta.Sombrero, new ImageIcon("Tesoros/FichasEstaticas/FichaTTesoroSombrero.png"));
        asignarFichaFija(3, 2, 2, 24, Tarjeta.CofreDeTesoros, new ImageIcon("Tesoros/FichasEstaticas/FichaTTesoroCofre.png"));

        int contador = fichasSobrantes.size();

        while (contador != 0) {
            int posFicha = (int) (Math.random() * contador);
            int rotar = (int) (Math.random() * 3);

            fichasSobrantes.get(posFicha).setGiro(rotar);

            while (rotar != 0) {
                rotarFicha(fichasSobrantes.get(posFicha));
                rotar--;
            }
            fichasSobrantes.add(fichasSobrantes.get(posFicha));
            fichasSobrantes.remove(posFicha);
            contador--;
        }
        contador = 32;

        for (int i = 0; i <= 3; i++) {
            tablero[i * 2][1] = fichasSobrantes.get(contador);
            fichasSobrantes.remove(contador);
            contador--;
            tablero[i * 2][3] = fichasSobrantes.get(contador);
            fichasSobrantes.remove(contador);
            contador--;
            tablero[i * 2][5] = fichasSobrantes.get(contador);
            fichasSobrantes.remove(contador);
            contador--;
        }

        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 6; j++) {
                tablero[(i * 2) + 1][j] = fichasSobrantes.get(contador);
                fichasSobrantes.remove(contador);
                contador--;
            }
        }

        for (int i = 0; i < 24; i++) {
            listaTarjetas.add(Tarjeta.values()[i]);
        }

    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void crearFichas(char[][] tipo, int cantidad) {

        for (int k = 0; k < cantidad; k++) {

            char[][] matrizFicha = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    matrizFicha[i][j] = tipo[i][j];
                }
            }
            Ficha ficha = new Ficha();
            ImageIcon imagen = null;
            if (tipo == Ficha.fichaL) {
                imagen = new ImageIcon("Tesoros/FichaEsquina.png");
            } else if (tipo == Ficha.fichaR) {
                imagen = new ImageIcon("Tesoros/FichaRecta.png");
            } else if (tipo == Ficha.fichaT) {
                imagen = new ImageIcon("Tesoros/FichaT.png");
            }
            imagen = new ImageIcon(imagen.getImage().getScaledInstance(y, y, Image.SCALE_SMOOTH));
            ficha.setImagen(imagen);
            if (tipo == Ficha.fichaL && k > 4) {
                matrizFicha[1][1] = Inicio.asignarTesoroFichasSobrantes(k - 4, ficha);
            }
            ficha.setFicha(matrizFicha);
            ficha.setCaracter(ficha.getFicha()[1][1]);
            listaFichas.add(ficha);
        }

    }

    public void asignarFichaFija(int rotaciones, int fila, int columna, int ficha, Tarjeta tarjeta, ImageIcon imagen) {
        listaFichas.get(ficha).setGiro(0);
        while (rotaciones != 0) {
            rotarFicha(listaFichas.get(ficha));
            rotaciones--;
        }
        int borrar = (ficha >= 30) ? 30 : 13;
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(y, y, Image.SCALE_SMOOTH));
        listaFichas.get(ficha).setImagen(imagen);
        tablero[fila][columna] = listaFichas.get(ficha);
        listaFichas.get(ficha).getFicha()[1][1] = tarjeta.getSimbolo();
        listaFichas.get(ficha).setCaracter(listaFichas.get(ficha).getFicha()[1][1]);
        fichasSobrantes.remove(borrar);
    }

    public static Ficha[][] getTablero() {
        return tablero;
    }

    public void setTablero(Ficha[][] tablero) {
        Tablero.tablero = tablero;
    }

    public static ArrayList<Tarjeta> getListaTarjetas() {
        return listaTarjetas;
    }

    public static void setListaTarjetas(ArrayList<Tarjeta> listaTarjetas) {
        Tablero.listaTarjetas = listaTarjetas;
    }

    public static ArrayList<Ficha> getFichasSobrantes() {
        return fichasSobrantes;
    }

    public static void setFichasSobrantes(ArrayList<Ficha> fichasSobrantes) {
        Tablero.fichasSobrantes = fichasSobrantes;
    }

    public static void guardar() {
        try {
            FileOutputStream archivo = new FileOutputStream("laberinto.maze");
            ObjectOutputStream guardar = new ObjectOutputStream(archivo);
            guardar.writeObject(tablero);
            for (Jugador jugador : Jugador.values()) {
                guardar.writeObject(jugador.getListaTarjetas());
                guardar.writeObject(jugador.getX());
                guardar.writeObject(jugador.getY());
            }
            guardar.writeObject(fichasSobrantes);
            guardar.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static void cargar() {
        try {
            FileInputStream archivo = new FileInputStream("laberinto.maze");
            ObjectInputStream cargar = new ObjectInputStream(archivo);
            tablero = (Ficha[][]) cargar.readObject();
            for (Jugador jugador : Jugador.values()) {
                jugador.setListaTarjetas((ArrayList<Tarjeta>) cargar.readObject());
                jugador.setX((int) cargar.readObject());
                jugador.setY((int) cargar.readObject());
            }
            fichasSobrantes = (ArrayList<Ficha>) cargar.readObject();
            cargar.close();
            archivo.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
}
