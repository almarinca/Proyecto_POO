package Data;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public enum Jugador {
    jugador4('4', '€', 6, 6, null, new ImageIcon("Tesoros/Jugadores/JugadorAzul.png")),
    jugador3('3', '&', 6, 0, null, new ImageIcon("Tesoros/Jugadores/JugadorAmarillo.png")), 
    jugador2('2', '$', 0, 6, null, new ImageIcon("Tesoros/Jugadores/JugadorRoja.png")),
    jugador1('1', '@', 0, 0, null, new ImageIcon("Tesoros/Jugadores/JugadorVerde.png"));

    private final char numero;
    private final char base;
    private int X;
    private int Y;
    private ArrayList<Tarjeta> listaTarjetas;
    private ImageIcon imagen;

    private Jugador(char numero, char base, int X, int Y, ArrayList<Tarjeta> listaTarjetas, ImageIcon imagen) {
        this.numero = numero;
        this.base = base;
        this.X = X;
        this.Y = Y;
        this.listaTarjetas = listaTarjetas;
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        this.imagen = imagen;
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

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

}
