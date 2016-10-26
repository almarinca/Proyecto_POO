package Data;

import java.util.ArrayList;
import static BussinessLogic.Turno.rotarFicha;

public class Tablero {
    //ATRIBUTOS	

    private Ficha[][] tablero = new Ficha[7][7];
    ArrayList<Ficha> listaFichas = new ArrayList<>();
    ArrayList<Ficha> fichasSobrantes = new ArrayList<>();

    public Tablero() {

        for (int i = 0; i < 13; i++) {
            Ficha ficha = new Ficha();
            ficha.setFicha(ficha.fichaRecta());
            listaFichas.add(ficha);
        }

        for (int i = 0; i < 17; i++) {
            Ficha ficha1 = new Ficha();
            ficha1.setFicha(ficha1.fichaT());
            listaFichas.add(ficha1);
        }

        for (int i = 0; i < 20; i++) {
            Ficha ficha2 = new Ficha();
            ficha2.setFicha(ficha2.fichaEsquina());
            listaFichas.add(ficha2);
        }
        fichasSobrantes = (ArrayList<Ficha>) listaFichas.clone();

        tablero[0][0] = listaFichas.get(30);
        fichasSobrantes.remove(30);
        rotarFicha(listaFichas.get(31));
        tablero[0][6] = listaFichas.get(31);
        fichasSobrantes.remove(30);
        rotarFicha(listaFichas.get(32));
        rotarFicha(listaFichas.get(32));
        tablero[6][6] = listaFichas.get(32);
        fichasSobrantes.remove(30);
        rotarFicha(listaFichas.get(33));
        rotarFicha(listaFichas.get(33));
        rotarFicha(listaFichas.get(33));
        tablero[6][0] = listaFichas.get(33);
        fichasSobrantes.remove(30);
        tablero[0][2] = listaFichas.get(13);
        fichasSobrantes.remove(13);
        tablero[0][4] = listaFichas.get(14);
        fichasSobrantes.remove(13);
        tablero[2][4] = listaFichas.get(15);
        fichasSobrantes.remove(13);
        rotarFicha(listaFichas.get(16));
        rotarFicha(listaFichas.get(17));
        rotarFicha(listaFichas.get(18));
        tablero[2][6] = listaFichas.get(16);
        fichasSobrantes.remove(13);
        tablero[4][6] = listaFichas.get(17);
        fichasSobrantes.remove(13);
        tablero[4][4] = listaFichas.get(18);
        fichasSobrantes.remove(13);
        rotarFicha(listaFichas.get(19));
        rotarFicha(listaFichas.get(20));
        rotarFicha(listaFichas.get(21));
        rotarFicha(listaFichas.get(19));
        rotarFicha(listaFichas.get(20));
        rotarFicha(listaFichas.get(21));
        tablero[6][2] = listaFichas.get(19);
        fichasSobrantes.remove(13);
        tablero[6][4] = listaFichas.get(20);
        fichasSobrantes.remove(13);
        tablero[4][2] = listaFichas.get(21);
        fichasSobrantes.remove(13);
        rotarFicha(listaFichas.get(22));
        rotarFicha(listaFichas.get(23));
        rotarFicha(listaFichas.get(24));
        rotarFicha(listaFichas.get(22));
        rotarFicha(listaFichas.get(23));
        rotarFicha(listaFichas.get(24));
        rotarFicha(listaFichas.get(22));
        rotarFicha(listaFichas.get(23));
        rotarFicha(listaFichas.get(24));
        tablero[2][0] = listaFichas.get(22);
        fichasSobrantes.remove(13);
        tablero[4][0] = listaFichas.get(23);
        fichasSobrantes.remove(13);
        tablero[2][2] = listaFichas.get(24);
        fichasSobrantes.remove(13);

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
