package Data;

import javax.swing.ImageIcon;

public class Ficha {

    private char caracter; // me parecio mas adecuado nombrarlo caracter que tesoro por que no solo puede ser un tesoro
    private char[][] ficha;
    private ImageIcon imagen;
    private int giro;

    public int getGiro() {
        return giro;
    }

    public void setGiro(int giro) {
        this.giro = giro;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }
    public static final char muro = '#';
    public static final char[][] fichaT = {{muro, muro, muro},
    {' ', ' ', ' '},
    {muro, ' ', muro}};

    public static final char[][] fichaL = {{muro, muro, muro},
    {muro, ' ', ' '},
    {muro, ' ', muro}};

    public static final char[][] fichaR = {{muro, muro, muro},
    {' ', ' ', ' '},
    {muro, muro, muro}};

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }
    
    public char[][] getFicha() {
        return ficha;
    }

    public void setFicha(char[][] ficha) {
        this.ficha = ficha;
    }

    public String toString() {
        String imprimir = "";
        for (int i = 0; i < 3; i++) {
            imprimir = imprimir + "|";
            for (int j = 0; j < 3; j++) {
                imprimir = imprimir + ficha[i][j] + "|";
            }
            imprimir = imprimir + "\n";
        }
        return imprimir;
    }
}
