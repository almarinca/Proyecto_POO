package Data;

public enum Tarjeta {

    Arana(1, 'a', "Arana"),
    Mariposa(2, 'b', "Mariposa"),
    Genio(3, 'c', "Genio"),
    Dragon(4, 'd', "Dragon"),
    Lagartija(5, 'e', "Lagartija"),
    Cerdo(6, 'f', "Cerdo"),
    Buho(7, 'g', "Buho"),
    Raton(8, 'h', "Raton"),
    Bruja(9, 'i', "Bruja"),
    Murcielago(10, 'j', "Murcielago"),
    Fantasma(11, 'k', "Fantasma"),
    Insecto(12, 'l', "Insecto"),
    Veladora(13, 'm', "Veladora"),
    Sombrero(14, 'n', "Sombrero"),
    Anillo(15, 'o', "Anillo"),
    CofreDeTesoros(16, 'p', "Cofre de tesoro"),
    Esmeralda(17, 'q', "Esmeralda"),
    Espada(18, 'r', "Espada"),
    Mapa(19, 's', "Mapa"),
    Corona(20, 'u', "Corona"),
    Llaves(21, 'v', "Llaves"),
    Craneo(22, 'w', "Craneo"),
    Libro(23, 'x', "Libro"),
    BolsaDeMonedas(24, 'y', "Bolsa De Monedas"),
    Aux(25, ' ', "Auxiliar"),
    Esquina1(26,'1',"Esquina jugador 1"),
    Esquina2(27,'2',"Esquina jugador 2"),
    Esquina3(28,'3',"Esquina jugador 3"),
    Esquina4(29,'4',"Esquina jugador 4");

    private int numero;
    private char simbolo;
    private String nombre;

    //CONSTRUCTOR
    Tarjeta(int numero, char simbolo, String nombre) {
        this.numero = numero;
        this.simbolo = simbolo;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
