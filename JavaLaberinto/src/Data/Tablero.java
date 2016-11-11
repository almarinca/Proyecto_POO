package Data;

import BussinessLogic.Inicio;
import java.util.ArrayList;
import static BussinessLogic.Turno.rotarFicha;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Tablero {
    //ATRIBUTOS	

    private static Ficha[][] tablero = new Ficha[7][7];
    private static ArrayList<Ficha> listaFichas = new ArrayList<>();
    private ArrayList<Ficha> fichasSobrantes = new ArrayList<>();
    private static ArrayList<Tarjeta> listaTarjetas = new ArrayList<>();

    public Tablero() {

        crearFichaFija(Ficha.fichaR, 13);
        crearFichaFija(Ficha.fichaT, 17);
        crearFichaFija(Ficha.fichaL, 20);

        fichasSobrantes = (ArrayList<Ficha>) listaFichas.clone();

        //FICHAS DONDE ESTAN UBICADOS LOS TESOROS
        asignarFichaFija(0, 0, 0, 30, Tarjeta.Esquina1, new ImageIcon("src/Tesoros/FichasDeInicio/FichaJugadorVerde.png"));
        asignarFichaFija(1, 0, 6, 31, Tarjeta.Esquina3, new ImageIcon("src/Tesoros/FichasDeInicio/FichaJugadorRojo.png"));
        asignarFichaFija(2, 6, 6, 32, Tarjeta.Esquina4, new ImageIcon("src/Tesoros/FichasDeInicio/FichaJugadorAmarillo.png"));
        asignarFichaFija(3, 6, 0, 33, Tarjeta.Esquina2, new ImageIcon("src/Tesoros/FichasDeInicio/FichaJugadorAzul.png"));
        asignarFichaFija(0, 0, 2, 13, Tarjeta.Anillo, new ImageIcon("src/Tesoros/FichasEstaticas/FichaTTesoroAnillo.png"));
        asignarFichaFija(0, 0, 4, 14, Tarjeta.Mapa, new ImageIcon("src/Tesoros/FichasEstaticas/FichaTTesoroMapa.png"));
        asignarFichaFija(0, 2, 4, 15, Tarjeta.Corona, new ImageIcon("src/Tesoros/FichasEstaticas/FichaTTesoroCorona.png"));
        asignarFichaFija(1, 2, 6, 16, Tarjeta.Libro, new ImageIcon("src/Tesoros/FichasEstaticas/FichaTTesoroLibro.png"));
        asignarFichaFija(1, 4, 6, 17, Tarjeta.BolsaDeMonedas, new ImageIcon("src/Tesoros/FichasEstaticas/FichaTTesoroBolsaDeMonedas.png"));
        asignarFichaFija(1, 4, 4, 18, Tarjeta.Llaves, new ImageIcon("src/Tesoros/FichasEstaticas/FichaTTesoroLlave.png"));
        asignarFichaFija(2, 6, 2, 19, Tarjeta.Espada, new ImageIcon("src/Tesoros/FichasEstaticas/FichaTTesoroEspada.png"));
        asignarFichaFija(2, 6, 4, 20, Tarjeta.Craneo, new ImageIcon("src/Tesoros/FichasEstaticas/FichaTTesoroCraneo.png"));
        asignarFichaFija(2, 4, 2, 21, Tarjeta.Esmeralda, new ImageIcon("src/Tesoros/FichasEstaticas/FichaTTesoroEsmeralda.png"));
        asignarFichaFija(3, 2, 0, 22, Tarjeta.Veladora, new ImageIcon("src/Tesoros/FichasEstaticas/FichaTTesoroVeladora.png"));
        asignarFichaFija(3, 4, 0, 23, Tarjeta.Sombrero, new ImageIcon("src/Tesoros/FichasEstaticas/FichaTTesoroSombrero.png"));
        asignarFichaFija(3, 2, 2, 24, Tarjeta.CofreDeTesoros, new ImageIcon("src/Tesoros/FichasEstaticas/FichaTTesoroCofre.png"));

        int contador = fichasSobrantes.size();

        while (contador != 0) {
            int posFicha = (int) (Math.random() * contador);
            int rotar = (int) (Math.random() * 3);

            fichasSobrantes.get(posFicha).setGiro(rotar);

            ImageIcon imagen = null;
            if (fichasSobrantes.get(posFicha).getFicha() == Ficha.fichaL) {
                imagen = new ImageIcon("src/Tesoros/FichaEsquina.png");
            } else if (fichasSobrantes.get(posFicha).getFicha() == Ficha.fichaR) {
                imagen = new ImageIcon("src/Tesoros/FichaRecta.png");
            } else if (fichasSobrantes.get(posFicha).getFicha() == Ficha.fichaT) {
                imagen = new ImageIcon("src/Tesoros/FichaT.png");
            } else {
                imagen = new ImageIcon("src/FichasEstaticas/Espadas.png");
            }
            imagen = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
            fichasSobrantes.get(posFicha).setImagen(imagen);

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

        ImageIcon imagen = null;
        if (fichasSobrantes.get(0).getFicha() == Ficha.fichaL) {
            imagen = new ImageIcon("src/Tesoros/FichaEsquina.png");
        } else if (fichasSobrantes.get(0).getFicha() == Ficha.fichaR) {
            imagen = new ImageIcon("src/Tesoros/FichaRecta.png");
        } else if (fichasSobrantes.get(0).getFicha() == Ficha.fichaT) {
            imagen = new ImageIcon("src/Tesoros/FichaT.png");
        } else {
            imagen = new ImageIcon("src/FichasEstaticas/Espadas.png");
        }
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        fichasSobrantes.get(0).setImagen(imagen);

        for (int i = 0; i < 24; i++) {
            listaTarjetas.add(Tarjeta.values()[i]);
        }

    }

    public void crearFichaFija(char[][] tipo, int cantidad) {

        for (int k = 0; k < cantidad; k++) {

            char[][] matrizFicha = new char[3][3];  // esta matriz la añadi por que cada ficha debe tener su matriz,
            for (int i = 0; i < 3; i++) {      // sino al modificarla se modificarian todas las fichas del mismo tipo,
                for (int j = 0; j < 3; j++) {  // ya que lo que se modifica es la matriz
                    matrizFicha[i][j] = tipo[i][j];
                }
            }
            Ficha ficha = new Ficha();
            if (tipo == Ficha.fichaL && k > 4) {
                matrizFicha[1][1] = Inicio.asignarTesoroFichasSobrantes(k - 4, ficha);
            }
            ficha.setFicha(matrizFicha);
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
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
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

    public ArrayList<Ficha> getFichasSobrantes() {
        return fichasSobrantes;
    }

    public void setFichasSobrantes(ArrayList<Ficha> fichasSobrantes) {
        this.fichasSobrantes = fichasSobrantes;
    }
}
