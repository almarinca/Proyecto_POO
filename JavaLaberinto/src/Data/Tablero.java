package Data;

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
        asignarFichaFija(0, 0, 0, 30, Tarjeta.Esquina1, new ImageIcon("/Tesoros/FichasDeInicio/FichaJugadorVerde.png"));
        asignarFichaFija(1, 0, 6, 31, Tarjeta.Esquina3, new ImageIcon("/Tesoros/FichasDeInicio/FichaJugadorRojo.png"));
        asignarFichaFija(2, 6, 6, 32, Tarjeta.Esquina4, new ImageIcon("/Tesoros/FichasDeInicio/FichaJugadorAmarillo.png"));
        asignarFichaFija(3, 6, 0, 33, Tarjeta.Esquina2, new ImageIcon("/Tesoros/FichasDeInicio/FichaJugadorAzul.png"));
        asignarFichaFija(0, 0, 2, 13, Tarjeta.Anillo, new ImageIcon("/Tesoros/FichasEstaticas/FichaTTesoroAnillo.png"));
        asignarFichaFija(0, 0, 4, 14, Tarjeta.Mapa, new ImageIcon("/Tesoros/FichasEstaticas/FichaTTesoroMapa.png"));
        asignarFichaFija(0, 2, 4, 15, Tarjeta.Corona, new ImageIcon("/Tesoros/FichasEstaticas/FichaTTesoroCorona.png"));
        asignarFichaFija(1, 2, 6, 16, Tarjeta.Libro, new ImageIcon("/Tesoros/FichasEstaticas/FichaTTesoroLibro.png"));
        asignarFichaFija(1, 4, 6, 17, Tarjeta.BolsaDeMonedas, new ImageIcon("/Tesoros/FichasEstaticas/FichaTTesoroBolsaDeMonedas.png"));
        asignarFichaFija(1, 4, 4, 18, Tarjeta.Llaves, new ImageIcon("/Tesoros/FichasEstaticas/FichaTTesoroLlave.png"));
        asignarFichaFija(2, 6, 2, 19, Tarjeta.Espada, new ImageIcon("/Tesoros/FichasEstaticas/FichaTTesoroEspada.png"));
        asignarFichaFija(2, 6, 4, 20, Tarjeta.Craneo, new ImageIcon("/Tesoros/FichasEstaticas/FichaTTesoroCraneo.png"));
        asignarFichaFija(2, 4, 2, 21, Tarjeta.Esmeralda, new ImageIcon("/Tesoros/FichasEstaticas/FichaTTesoroEsmeralda.png"));
        asignarFichaFija(3, 2, 0, 22, Tarjeta.Veladora, new ImageIcon("/Tesoros/FichasEstaticas/FichaTTesoroVeladora.png"));
        asignarFichaFija(3, 4, 0, 23, Tarjeta.Sombrero, new ImageIcon("/Tesoros/FichasEstaticas/FichaTTesoroSombrero.png"));
        asignarFichaFija(3, 2, 2, 24, Tarjeta.CofreDeTesoros, new ImageIcon("/Tesoros/FichasEstaticas/FichaTTesoroCofre.png"));

        int contador = fichasSobrantes.size();

        while (contador != 0) {
            int posFicha = (int) (Math.random() * contador);
            int rotar = (int) (Math.random() * 3);
            while (rotar != 0) {
                rotarFicha(fichasSobrantes.get(posFicha));
                rotar--;
            }
            fichasSobrantes.add(fichasSobrantes.get(posFicha));
            fichasSobrantes.remove(posFicha);
            contador--;
        }
        contador = 33;

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
    //METODOS

    public static ArrayList<Tarjeta> getListaTarjetas() {
        return listaTarjetas;
    }

    public static void setListaTarjetas(ArrayList<Tarjeta> listaTarjetas) {
        Tablero.listaTarjetas = listaTarjetas;
    }

    public void crearFichaFija(char[][] tipo, int cantidad) {

        for (int k = 0; k < cantidad; k++) {

            char[][] matriz = new char[3][3];  // esta matriz la añadi por que cada ficha debe tener su matriz,
            for (int i = 0; i < 3; i++) {      // sino al modificarla se modificarian todas las fichas del mismo tipo,
                for (int j = 0; j < 3; j++) {  // ya que lo que se modifica es la matriz
                    matriz[i][j] = tipo[i][j];
                }
            }
            Ficha ficha = new Ficha();
            if (tipo == Ficha.fichaL && k > 4) {
                matriz[1][1] = tesoroFichasSobrante(k - 4, ficha);
            }
            ficha.setFicha(matriz);
            listaFichas.add(ficha);
        }

    }

    public void asignarFichaFija(int rotaciones, int fila, int columna, int ficha, Tarjeta tarjeta, ImageIcon imagen) {
        while (rotaciones != 0) {
            rotarFicha(listaFichas.get(ficha));
            rotaciones--;
        }
        int borrar = (ficha >= 30) ? 30 : 13;
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        listaFichas.get(ficha).setImagen(imagen);
        tablero[fila][columna] = listaFichas.get(ficha);
        listaFichas.get(ficha).getFicha()[1][1] = tarjeta.getSimbolo();
        fichasSobrantes.remove(borrar);
    }

    public static Ficha[][] getTablero() {
        return tablero;
    }

    public ArrayList<Ficha> getFichasSobrantes() {
        return fichasSobrantes;
    }

    public void setFichasSobrantes(ArrayList<Ficha> fichasSobrantes) {
        this.fichasSobrantes = fichasSobrantes;
    }

    public void setTablero(Ficha[][] tablero) {
        this.tablero = tablero;
    }

    public char tesoroFichasSobrante(int i, Ficha ficha) {

        ImageIcon imagen = null;

        switch (i) {
            case 1:
                imagen = new ImageIcon("/Tesoros/FichasSueltas/FichaEsquinaTesoroAraña.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                ficha.setImagen(imagen);
                return Tarjeta.Arana.getSimbolo();
            case 2:
                imagen = new ImageIcon("/Tesoros/FichasSueltas/FichaEsquinaTesoroMariposa.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                ficha.setImagen(imagen);
                return Tarjeta.Mariposa.getSimbolo();
            case 3:
                imagen = new ImageIcon("/Tesoros/FichasSueltas/FichaEsquinaTesoroGenio.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                ficha.setImagen(imagen);
                return Tarjeta.Genio.getSimbolo();
            case 4:
                imagen = new ImageIcon("/Tesoros/FichasSueltas/FichaEsquinaTesoroDragon.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                ficha.setImagen(imagen);
                return Tarjeta.Dragon.getSimbolo();
            case 5:
                imagen = new ImageIcon("/Tesoros/FichasSueltas/FichaEsquinaTesoroLagartija.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                ficha.setImagen(imagen);
                return Tarjeta.Lagartija.getSimbolo();
            case 6:
                imagen = new ImageIcon("/Tesoros/FichasSueltas/FichaEsquinaTesoroCerdo.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                ficha.setImagen(imagen);
                return Tarjeta.Cerdo.getSimbolo();
            case 7:
                imagen = new ImageIcon("/Tesoros/FichasSueltas/FichaEsquinaTesoroBuho.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                ficha.setImagen(imagen);
                return Tarjeta.Buho.getSimbolo();
            case 8:
                imagen = new ImageIcon("/Tesoros/FichasSueltas/FichaEsquinaTesoroRaton.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                ficha.setImagen(imagen);
                return Tarjeta.Raton.getSimbolo();
            case 9:
                imagen = new ImageIcon("/Tesoros/FichasSueltas/FichaEsquinaTesoroBruja.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                ficha.setImagen(imagen);
                return Tarjeta.Bruja.getSimbolo();
            case 10:
                imagen = new ImageIcon("/Tesoros/FichasSueltas/FichaEsquinaTesoroMurcielago.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                ficha.setImagen(imagen);
                return Tarjeta.Murcielago.getSimbolo();
            case 11:
                imagen = new ImageIcon("/Tesoros/FichasSueltas/FichaEsquinaTesoroFantasma.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                ficha.setImagen(imagen);
                return Tarjeta.Fantasma.getSimbolo();
            case 12:
                imagen = new ImageIcon("/Tesoros/FichasSueltas/FichaEsquinaTesoroInsecto.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                ficha.setImagen(imagen);
                return Tarjeta.Insecto.getSimbolo();
            default:
                return ' ';
        }
    }

}
