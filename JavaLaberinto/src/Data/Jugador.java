package Data;

import java.util.ArrayList;

public enum Jugador {

    jugador1('1', '@', 0, 0, null),
    jugador2('2', '$', 0, 6, null),
    jugador3('3', '&', 6, 0, null),
    jugador4('4', '€', 6, 6, null);

    private final char numero;
    private final char base;
    private int X;
    private int Y;
    private ArrayList<Tarjeta> listaTarjetas;

    private Jugador(char numero, char base, int X, int Y, ArrayList<Tarjeta> listaTarjetas) {
        this.numero = numero;
        this.base = base;
        this.X = X;
        this.Y = Y;
        this.listaTarjetas = listaTarjetas;
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public ArrayList<Tarjeta> getListaTarjetas() {
        return listaTarjetas;
    }

    public void setListaTarjetas(ArrayList<Tarjeta> listaTarjetas) {
        this.listaTarjetas = listaTarjetas;
    }

    public char getNumero() {
        return numero;
    }

    public char getBase() {
        return base;
    }
    
    

}
