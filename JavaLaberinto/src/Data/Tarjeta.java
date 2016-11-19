package Data;

public enum Tarjeta {

    Arana(1, 'a'),
    Mariposa(2, 'b'),
    Genio(3, 'c'),
    Dragon(4, 'd'),
    Lagartija(5, 'e'),
    Cerdo(6, 'f'),
    Buho(7, 'g'),
    Raton(8, 'h'),
    Bruja(9, 'i'),
    Murcielago(10, 'j'),
    Fantasma(11, 'k'),
    Insecto(12, 'l'),
    Veladora(13, 'm'),
    Sombrero(14, 'n'),
    Anillo(15, 'o'),
    CofreDeTesoros(16, 'p'),
    Esmeralda(17, 'q'),
    Espada(18, 'r'),
    Mapa(19, 's'),
    Corona(20, 'u'),
    Llaves(21, 'v'),
    Craneo(22, 'w'),
    Libro(23, 'x'),
    BolsaDeMonedas(24, 'y'),
    Aux(25, ' '),
    Esquina1(26, '@'),
    Esquina2(27, '$'),
    Esquina3(28, '&'),
    Esquina4(29, '€');

    private int numero;
    private char simbolo;
    
    //CONSTRUCTOR
    Tarjeta(int numero, char simbolo) {
        this.numero = numero;
        this.simbolo = simbolo;
            }

    //METODOS
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

}