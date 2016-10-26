package Data;

import Data.Ficha;
import java.util.ArrayList;
import static BussinessLogic.Turno.rotarFicha;

public class Tablero {
    //ATRIBUTOS	

    private Ficha[][] tablero = new Ficha[7][7];
    ArrayList<Ficha> listaFichas = new ArrayList<Ficha>();

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
        ArrayList<Ficha> fichasSobrantes = (ArrayList<Ficha>) listaFichas.clone();

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

        /*char[][] ficha = tablero[0][4].getFicha();
        ficha[1][1] = '?';
        tablero[0][4].setFicha(ficha);*/
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(tablero[i * 2][j * 2].toString());
            }
        }

        System.out.println(fichasSobrantes.size());
    }
    //METODOS

    public Ficha[][] getTablero() {
        return tablero;
    }

    public void setTablero(Ficha[][] tablero) {
        this.tablero = tablero;
    }

}
