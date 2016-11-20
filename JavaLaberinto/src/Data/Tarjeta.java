package Data;

import javax.swing.ImageIcon;

public enum Tarjeta {

    Arana(1, 'a', new ImageIcon("Tesoros/Tarjetas/TarjetaAraña.png")),
    Mariposa(2, 'b', new ImageIcon("Tesoros/Tarjetas/TarjetaMariposa.png")),
    Genio(3, 'c', new ImageIcon("Tesoros/Tarjetas/TarjetaGenio.png")),
    Dragon(4, 'd', new ImageIcon("Tesoros/Tarjetas/TarjetaDragon.png")),
    Lagartija(5, 'e', new ImageIcon("Tesoros/Tarjetas/TarjetaLagartija.png")),
    Cerdo(6, 'f', new ImageIcon("Tesoros/Tarjetas/TarjetaCerdo.png")),
    Buho(7, 'g', new ImageIcon("Tesoros/Tarjetas/TarjetaBuho.png")),
    Raton(8, 'h', new ImageIcon("Tesoros/Tarjetas/TarjetRaton.png")),
    Bruja(9, 'i', new ImageIcon("Tesoros/Tarjetas/TarjetaBruja.png")),
    Murcielago(10, 'j', new ImageIcon("Tesoros/Tarjetas/TarjetaMurcielago.png")),
    Fantasma(11, 'k', new ImageIcon("Tesoros/Tarjetas/TarjetaFantasma.png")),
    Insecto(12, 'l', new ImageIcon("Tesoros/Tarjetas/TarjetaInsepto.png")),
    Veladora(13, 'm', new ImageIcon("Tesoros/Tarjetas/TarjetaVeladora.png")),
    Sombrero(14, 'n', new ImageIcon("Tesoros/Tarjetas/TarjetaSombrero.png")),
    Anillo(15, 'o', new ImageIcon("Tesoros/Tarjetas/TarjetaAnillo.png")),
    CofreDeTesoros(16, 'p', new ImageIcon("Tesoros/Tarjetas/TarjetaCofreDeTesoros.png")),
    Esmeralda(17, 'q', new ImageIcon("Tesoros/Tarjetas/TarjetaEsmeralda.png")),
    Espada(18, 'r', new ImageIcon("Tesoros/Tarjetas/TarjetaEspada.png")),
    Mapa(19, 's', new ImageIcon("Tesoros/Tarjetas/TarjetaMapa.png")),
    Corona(20, 'u', new ImageIcon("Tesoros/Tarjetas/TarjetaCorona.png")),
    Llaves(21, 'v', new ImageIcon("Tesoros/Tarjetas/TarjetaLlave.png")),
    Craneo(22, 'w', new ImageIcon("Tesoros/Tarjetas/TarjetaCraneo.png")),
    Libro(23, 'x', new ImageIcon("Tesoros/Tarjetas/TarjetaLibro.png")),
    BolsaDeMonedas(24, 'y', new ImageIcon("Tesoros/Tarjetas/TarjetaBolsaDeMonedas.png")),
    Aux(25, ' ',new ImageIcon("Tesoros/Tarjetas")),
    Esquina1(26, '@', new ImageIcon("Tesoros/Tarjetas")),
    Esquina2(27, '$',new ImageIcon("Tesoros/Tarjetas")),
    Esquina3(28, '&',new ImageIcon("Tesoros/Tarjetas")),
    Esquina4(29, '€',new ImageIcon("Tesoros/Tarjetas"));

    private int numero;
    private char simbolo;
    private ImageIcon imagen;
    
    //CONSTRUCTOR
    Tarjeta(int numero, char simbolo,ImageIcon imagen) {
        this.numero = numero;
        this.simbolo = simbolo;
        this.imagen = imagen;
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

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }
    

}