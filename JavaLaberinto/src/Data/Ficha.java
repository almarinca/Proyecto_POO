package Data;

public class Ficha {

    private char tesoro;
    private char[][] ficha;
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

    public char getTesoro() {
        return tesoro;
    }

    public void setTesoro(char tesoro) {
        this.tesoro = tesoro;
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
