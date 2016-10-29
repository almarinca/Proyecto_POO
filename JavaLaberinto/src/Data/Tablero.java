package Data;

import java.util.ArrayList;
import static BussinessLogic.Turno.rotarFicha;

public class Tablero {
    //ATRIBUTOS	

    private static Ficha[][] tablero = new Ficha[7][7];
    ArrayList<Ficha> listaFichas = new ArrayList<>();
    ArrayList<Ficha> fichasSobrantes = new ArrayList<>();
    static ArrayList<Tarjeta> listaTarjetas = new ArrayList<>();

    public Tablero() {

        crearFichaFija(Ficha.fichaR, 13);
        crearFichaFija(Ficha.fichaT, 17);
        crearFichaFija(Ficha.fichaL, 20);

        fichasSobrantes = (ArrayList<Ficha>) listaFichas.clone();

        //FICHAS DONDE ESTAN UBICADOS LOS TESOROS
        asignarFichaFija(0, 0, 0, 30, Tarjeta.Esquina1);
        asignarFichaFija(1, 0, 6, 31, Tarjeta.Esquina3);
        asignarFichaFija(2, 6, 6, 32, Tarjeta.Esquina4);
        asignarFichaFija(3, 6, 0, 33, Tarjeta.Esquina2);
        asignarFichaFija(0, 0, 2, 13, Tarjeta.Anillo);
        asignarFichaFija(0, 0, 4, 14, Tarjeta.Mapa);
        asignarFichaFija(0, 2, 4, 15, Tarjeta.Corona);
        asignarFichaFija(1, 2, 6, 16, Tarjeta.Libro);
        asignarFichaFija(1, 4, 6, 17, Tarjeta.BolsaDeMonedas);
        asignarFichaFija(1, 4, 4, 18, Tarjeta.Llaves);
        asignarFichaFija(2, 6, 2, 19, Tarjeta.Espada);
        asignarFichaFija(2, 6, 4, 20, Tarjeta.Craneo);
        asignarFichaFija(2, 4, 2, 21, Tarjeta.Esmeralda);
        asignarFichaFija(3, 2, 0, 22, Tarjeta.Veladora);
        asignarFichaFija(3, 4, 0, 23, Tarjeta.Sombrero);
        asignarFichaFija(3, 2, 2, 24, Tarjeta.CofreDeTesoros);

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
        listaTarjetas.add(Tarjeta.Arana);
        listaTarjetas.add(Tarjeta.Mariposa);
        listaTarjetas.add(Tarjeta.Genio);
        listaTarjetas.add(Tarjeta.Dragon);
        listaTarjetas.add(Tarjeta.Lagartija);
        listaTarjetas.add(Tarjeta.Cerdo);
        listaTarjetas.add(Tarjeta.Buho);
        listaTarjetas.add(Tarjeta.Raton);
        listaTarjetas.add(Tarjeta.Bruja);
        listaTarjetas.add(Tarjeta.Murcielago);
        listaTarjetas.add(Tarjeta.Fantasma);
        listaTarjetas.add(Tarjeta.Insecto);
        listaTarjetas.add(Tarjeta.Veladora);
        listaTarjetas.add(Tarjeta.Sombrero);
        listaTarjetas.add(Tarjeta.Anillo);
        listaTarjetas.add(Tarjeta.CofreDeTesoros);
        listaTarjetas.add(Tarjeta.Esmeralda);
        listaTarjetas.add(Tarjeta.Espada);
        listaTarjetas.add(Tarjeta.Mapa);
        listaTarjetas.add(Tarjeta.Corona);
        listaTarjetas.add(Tarjeta.Llaves);
        listaTarjetas.add(Tarjeta.Craneo);
        listaTarjetas.add(Tarjeta.Libro);
        listaTarjetas.add(Tarjeta.BolsaDeMonedas);
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
            if (tipo == Ficha.fichaL && k>4) {
                matriz[1][1] = tesoroFichasSobrante(k-4);
            }
            Ficha ficha = new Ficha();
            ficha.setFicha(matriz);
            listaFichas.add(ficha);
        }

    }

    public void asignarFichaFija(int rotaciones, int fila, int columna, int ficha, Tarjeta tarjeta) {
        while (rotaciones != 0) {
            rotarFicha(listaFichas.get(ficha));
            rotaciones--;
        }
        int borrar = (ficha >= 30) ? 30 : 13;
        tablero[fila][columna] = listaFichas.get(ficha);
        Ficha fichaAux = listaFichas.get(ficha);
        fichaAux.getFicha()[1][1] = tarjeta.getSimbolo();
        fichasSobrantes.remove(borrar);
    }

    public Ficha[][] getTablero() {
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

    public char tesoroFichasSobrante(int i) {

        switch (i) {
            case 1:
                return Tarjeta.Arana.getSimbolo();
            case 2:
                return Tarjeta.Mariposa.getSimbolo();
            case 3:
                return Tarjeta.Genio.getSimbolo();
            case 4:
                return Tarjeta.Dragon.getSimbolo();
            case 5:
                return Tarjeta.Lagartija.getSimbolo();
            case 6:
                return Tarjeta.Cerdo.getSimbolo();
            case 7:
                return Tarjeta.Buho.getSimbolo();
            case 8:
                return Tarjeta.Raton.getSimbolo();
            case 9:
                return Tarjeta.Bruja.getSimbolo();
            case 10:
                return Tarjeta.Murcielago.getSimbolo();
            case 11:
                return Tarjeta.Fantasma.getSimbolo();
            case 12:
                return Tarjeta.Insecto.getSimbolo();
            default:
                return ' ';
        }
    }
}
