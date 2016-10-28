package Data;

import java.util.ArrayList;
import static BussinessLogic.Turno.rotarFicha;

public class Tablero {
    //ATRIBUTOS	

    private static Ficha[][] tablero = new Ficha[7][7];
    ArrayList<Ficha> listaFichas = new ArrayList<>();
    ArrayList<Ficha> fichasSobrantes = new ArrayList<>();

    public Tablero() {

        crearFichaFija(Ficha.fichaR, 13);
        crearFichaFija(Ficha.fichaT, 17);
        crearFichaFija(Ficha.fichaL, 20);

        fichasSobrantes = (ArrayList<Ficha>) listaFichas.clone();

        asignarFichaFija(0, 0, 0, 30);
        asignarFichaFija(1, 0, 6, 31);
        asignarFichaFija(2, 6, 6, 32);
        asignarFichaFija(3, 6, 0, 33);
        asignarFichaFija(0, 0, 2, 13);
        asignarFichaFija(0, 0, 4, 14);
        asignarFichaFija(0, 2, 4, 15);
        asignarFichaFija(1, 2, 6, 16);
        asignarFichaFija(1, 4, 6, 17);
        asignarFichaFija(1, 4, 4, 18);
        asignarFichaFija(2, 6, 2, 19);
        asignarFichaFija(2, 6, 4, 20);
        asignarFichaFija(2, 4, 2, 21);
        asignarFichaFija(3, 2, 0, 22);
        asignarFichaFija(3, 4, 0, 23);
        asignarFichaFija(3, 2, 2, 24);

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

        /*char[][] ficha = tablero[0][4].getFicha();
        ficha[1][1] = '?';
        tablero[0][4].setFicha(ficha);*/
    }
    //METODOS

    public void crearFichaFija(char[][] tipo, int cantidad) {

        for (int k = 0; k < cantidad; k++) {

          /*char[][] matriz = new char[3][3];  // esta matriz la añadi por que cada ficha debe tener su matriz,
            for (int i = 0; i < 3; i++) {      // sino al modificarla se modificarian todas las fichas del mismo tipo,
                for (int j = 0; j < 3; j++) {  // ya que lo que se modifica es la matriz
                    matriz[i][j] = tipo[i][j];
                }
            }*/

            Ficha ficha = new Ficha();
            //ficha.setFicha(matriz); // para que funcione lo de arriba cambie la linea de abajo por esta
            ficha.setFicha(tipo);
            listaFichas.add(ficha);
        }

    }

    public void asignarFichaFija(int rotaciones, int fila, int columna, int ficha) {

        while (rotaciones != 0) {
            rotarFicha(listaFichas.get(ficha));
            rotaciones--;
        }
        int borrar = (ficha >= 30) ? 30 : 13;
        tablero[fila][columna] = listaFichas.get(ficha);
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

}
