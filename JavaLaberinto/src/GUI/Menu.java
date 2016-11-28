package GUI;

import BussinessLogic.Inicio;
import static BussinessLogic.Inicio.x;
import static BussinessLogic.Inicio.y;
import Data.Tablero;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
    }

    private static final Laberinto laberinto = new Laberinto();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        continuar = new javax.swing.JButton();
        nuevo = new javax.swing.JButton();
        dosJugadores = new javax.swing.JButton();
        tresJugadores = new javax.swing.JButton();
        cuatroJugadores = new javax.swing.JButton();
        elige = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        continuar.setText("Continuar Juego");
        continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarActionPerformed(evt);
            }
        });

        nuevo.setText("Nuevo Juego");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        dosJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosJugadoresActionPerformed(evt);
            }
        });

        tresJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tresJugadoresActionPerformed(evt);
            }
        });

        cuatroJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuatroJugadoresActionPerformed(evt);
            }
        });

        elige.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        elige.setForeground(new java.awt.Color(255, 255, 255));
        elige.setText("Elige la cantidad de jugadores:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(367, 367, 367)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cuatroJugadores)
                    .addComponent(tresJugadores)
                    .addComponent(continuar)
                    .addComponent(dosJugadores)
                    .addComponent(nuevo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addComponent(elige)
                .addGap(265, 265, 265))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(continuar)
                .addGap(18, 18, 18)
                .addComponent(nuevo)
                .addGap(18, 18, 18)
                .addComponent(dosJugadores)
                .addGap(18, 18, 18)
                .addComponent(tresJugadores)
                .addGap(1, 1, 1)
                .addComponent(elige)
                .addGap(1, 1, 1)
                .addComponent(cuatroJugadores)
                .addContainerGap(317, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        dosJugadores.setVisible(true);
        tresJugadores.setVisible(true);
        cuatroJugadores.setVisible(true);
        elige.setVisible(true);
        nuevo.setEnabled(false);
        continuar.setEnabled(false);
        this.repaint();
    }//GEN-LAST:event_nuevoActionPerformed

    private void continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarActionPerformed
        Tablero.cargar();
        laberinto.setSize(x, 10 * y);
        laberinto.iniciarComponentes();
        this.setVisible(false);
        laberinto.setVisible(true);
        laberinto.actualizarIndicaciones();
        laberinto.cargar();
        laberinto.repaint();
    }//GEN-LAST:event_continuarActionPerformed

    private void dosJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosJugadoresActionPerformed
        crearLaberinto(2);
    }//GEN-LAST:event_dosJugadoresActionPerformed

    private void tresJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tresJugadoresActionPerformed
        crearLaberinto(3);
    }//GEN-LAST:event_tresJugadoresActionPerformed

    private void cuatroJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuatroJugadoresActionPerformed
        crearLaberinto(4);
    }//GEN-LAST:event_cuatroJugadoresActionPerformed

    public void crearLaberinto(int jugadores) {
        Inicio.asignarListaTarjetas(jugadores);
        laberinto.setNumeroJugadores(jugadores);
        laberinto.setSize(x, 10 * y);
        laberinto.iniciarComponentes();
        laberinto.setVisible(true);
        this.setVisible(false);
        laberinto.actualizarIndicaciones();
        JOptionPane.showMessageDialog(this, "Bienvenido al LABERINTO.\n" + "\n"
                + "Un laberinto de pasadizos que uno puede mover a su antojo para encontrar la mayor cantidad posible de tesoros y secretos. \n"
                + "El ganador será el que mueva más hábilmente los pasadizos. \n"
                + "¿Quién logrará desbaratar las trampas de este célebre laberinto para ser el primero en obtener todos sus tesoros?", " ", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Tesoros/mago.png"));
    }

    public void iniciarComponentes() {
        panel = new panelTransparente();
        panel.setLayout(new javax.swing.GroupLayout(panel));
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.add(panel);
        ImageIcon image;
        image = new ImageIcon("Tesoros/Menu.png");
        image = new ImageIcon(image.getImage().getScaledInstance(x, 10 * y, Image.SCALE_SMOOTH));
        panel.setBackgroundImage(image.getImage());
        panel.setLocation(0, 0);
        panel.setSize(this.getWidth(), this.getHeight());
        panel.add(dosJugadores);
        panel.add(tresJugadores);
        panel.add(cuatroJugadores);
        panel.add(continuar);
        panel.add(nuevo);
        panel.add(elige);
        try {
            FileInputStream archivo = new FileInputStream("laberinto.laby");
            FileInputStream archivo2 = new FileInputStream("botones.laby");
        } catch (FileNotFoundException ex) {
            continuar.setVisible(false);
        }
        dosJugadores.setVisible(false);
        tresJugadores.setVisible(false);
        cuatroJugadores.setVisible(false);
        continuar.setSize(3 * y, 3 * y / 2);
        nuevo.setSize(3 * y, 3 * y / 2);
        continuar.setLocation(x / 2 - 3 * y / 2, y);
        nuevo.setLocation(x / 2 - 3 * y / 2, 3 * y);
        dosJugadores.setSize(2 * y, 2 * y);
        tresJugadores.setSize(2 * y, 2 * y);
        cuatroJugadores.setSize(2 * y, 2 * y);

        ImageIcon imagen;

        imagen = new ImageIcon("Tesoros/Botones/CONTINUARJUEGOPRUEBA.png");
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(3 * y, 3 * y / 2, Image.SCALE_SMOOTH));
        continuar.setIcon(imagen);
        continuar.setText("");
        continuar.setContentAreaFilled(false);

        imagen = new ImageIcon("Tesoros/Botones/CONTINUARJUEGO.png");
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(3 * y, 3 * y / 2, Image.SCALE_SMOOTH));
        continuar.setPressedIcon(imagen);

        imagen = new ImageIcon("Tesoros/Botones/NEWGAMEPRUEBA.png");
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(3 * y, 3 * y / 2, Image.SCALE_SMOOTH));
        nuevo.setIcon(imagen);
        nuevo.setText("");
        nuevo.setContentAreaFilled(false);

        imagen = new ImageIcon("Tesoros/Botones/NEWGAME.png");
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(3 * y, 3 * y / 2, Image.SCALE_SMOOTH));
        nuevo.setPressedIcon(imagen);

        imagen = new ImageIcon("Tesoros/Botones/2.png");
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(2 * y, 2 * y, Image.SCALE_SMOOTH));
        dosJugadores.setIcon(imagen);
        dosJugadores.setContentAreaFilled(false);
        dosJugadores.setLocation(x / 2 - 7 * y / 2, 6 * y);

        imagen = new ImageIcon("Tesoros/Botones/BotonNew2.png");
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(2 * y, 2 * y, Image.SCALE_SMOOTH));
        dosJugadores.setPressedIcon(imagen);

        imagen = new ImageIcon("Tesoros/Botones/3.png");
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(2 * y, 2 * y, Image.SCALE_SMOOTH));
        tresJugadores.setIcon(imagen);
        tresJugadores.setContentAreaFilled(false);
        tresJugadores.setLocation(x / 2 - y, 6 * y);

        imagen = new ImageIcon("Tesoros/Botones/BotonNew3.png");
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(2 * y, 2 * y, Image.SCALE_SMOOTH));
        tresJugadores.setPressedIcon(imagen);

        imagen = new ImageIcon("Tesoros/Botones/4.png");
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(2 * y, 2 * y, Image.SCALE_SMOOTH));
        cuatroJugadores.setIcon(imagen);
        cuatroJugadores.setContentAreaFilled(false);
        cuatroJugadores.setLocation(x / 2 + 3 * y / 2, 6 * y);
        imagen = new ImageIcon("Tesoros/Botones/BotonNew4.png");
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(2 * y, 2 * y, Image.SCALE_SMOOTH));
        cuatroJugadores.setPressedIcon(imagen);

        elige.setLocation(x / 2 - elige.getSize().width / 2, 5 * y);
        elige.setVisible(false);

        this.setLayout(null);
    }

    private panelTransparente panel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton continuar;
    private javax.swing.JButton cuatroJugadores;
    private javax.swing.JButton dosJugadores;
    private javax.swing.JLabel elige;
    private javax.swing.JButton nuevo;
    private javax.swing.JButton tresJugadores;
    // End of variables declaration//GEN-END:variables
}
