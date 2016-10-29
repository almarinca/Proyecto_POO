package Data;

public enum Jugador {

    jugador1('1', 0, 0, 1, 1),
    jugador2('2', 0, 6, 1, 1),
    jugador3('3', 6, 0, 1, 1),
    jugador4('4', 6, 6, 1, 1);

    private final char numero;
    private int posXEnTablero;
    private int posYEnTablero;
    private int posXEnFicha;
    private int posYEnFicha;
    // private ArrayList<Tarjeta> listaTarjetas;

    private Jugador(char numero, int posXEnTablero, int posYEnTablero, int posXEnFicha, int posYEnFicha) {
        this.numero = numero;
        this.posXEnTablero = posXEnTablero;
        this.posYEnTablero = posYEnTablero;
        this.posXEnFicha = posXEnFicha;
        this.posYEnFicha = posYEnFicha;
    }

    public int getPosXEnTablero() {
        return posXEnTablero;
    }

    public void setPosXEnTablero(int posXEnTablero) {
        this.posXEnTablero = posXEnTablero;
    }

    public int getPosYEnTablero() {
        return posYEnTablero;
    }

    public void setPosYEnTablero(int posYEnTablero) {
        this.posYEnTablero = posYEnTablero;
    }

    public int getPosXEnFicha() {
        return posXEnFicha;
    }

    public void setPosXEnFicha(int posXEnFicha) {
        this.posXEnFicha = posXEnFicha;
    }

    public int getPosYEnFicha() {
        return posYEnFicha;
    }

    public void setPosYEnFicha(int posYEnFicha) {
        this.posYEnFicha = posYEnFicha;
    }

    public char getNumero() {
        return numero;
    }

}
