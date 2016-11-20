package Data;

import javax.swing.ImageIcon;

public class Ficha {

    private char caracter; 
    private char[][] ficha;
    private ImageIcon imagen;
    private double giro;

    public double getGiro() {
        return giro;
    }

    public void setGiro(double giro) {
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
