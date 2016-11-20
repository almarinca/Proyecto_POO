package GUI;

import BussinessLogic.Inicio;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class GUIMenu extends javax.swing.JFrame {

    public GUIMenu() {
        initComponents();
    }

    static int y = Inicio.y;
    static int x = Inicio.x;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Continuar Juego");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Nuevo Juego");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setOpaque(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setOpaque(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setOpaque(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        jLabel1.setText("Elige la cantidad de jugadores:");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(267, 267, 267)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addComponent(jButton4)
                            .addComponent(jButton1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(jButton2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(265, 265, 265))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jButton1))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jButton5)
                .addContainerGap(317, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jButton3.setVisible(true);
        jButton4.setVisible(true);
        jButton5.setVisible(true);
        jLabel1.setVisible(true);
        jButton2.setEnabled(false);
        jButton1.setEnabled(false);
        this.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // este codigo se pondra cuando se guarden los archivos
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Inicio.asignarListaTarjetas(2);
        GUILaberinto laberinto = new GUILaberinto();
        laberinto.numeroJugadores = 2;
        laberinto.setSize(Inicio.x, 10 * y);
        laberinto.crearListaBotones();
        laberinto.setVisible(true);
        this.setVisible(false);
        laberinto.indicaciones();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Inicio.asignarListaTarjetas(3);
        GUILaberinto laberinto = new GUILaberinto();
        laberinto.numeroJugadores = 3;
        laberinto.setSize(Inicio.x, 10 * y);
        laberinto.crearListaBotones();
        laberinto.setVisible(true);
        this.setVisible(false);
        laberinto.indicaciones();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Inicio.asignarListaTarjetas(4);
        GUILaberinto laberinto = new GUILaberinto();
        laberinto.numeroJugadores = 4;
        laberinto.setSize(Inicio.x, 10 * y);
        laberinto.crearListaBotones();
        laberinto.setVisible(true);
        this.setVisible(false);
        laberinto.indicaciones();
    }//GEN-LAST:event_jButton5ActionPerformed

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        ImageIcon imagen;
        imagen = new ImageIcon("Tesoros/Menu.png");
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(x, 10 * y, Image.SCALE_SMOOTH));
        g.drawImage(imagen.getImage(), 0, 0, x, y * 10, null);
        jButton1.repaint();
        jButton2.repaint();
        jButton3.repaint();
        jButton4.repaint();
        jButton5.repaint();
        jLabel1.repaint();
    }

    public void crearBotones() {
        jButton3.setVisible(false);
        jButton4.setVisible(false);
        jButton5.setVisible(false);
        jButton1.setSize(3 * y, 3 * y / 2);
        jButton2.setSize(3 * y, 3 * y / 2);
        jButton1.setLocation(x / 2 - 3 * y / 2, y);
        jButton2.setLocation(x / 2 - 3 * y / 2, 3 * y);
        jButton3.setSize(2 * y, 2 * y);
        jButton4.setSize(2 * y, 2 * y);
        jButton5.setSize(2 * y, 2 * y);

        ImageIcon imagen;
        imagen = new ImageIcon("Tesoros/Botones/2.png");
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(2 * y, 2 * y, Image.SCALE_SMOOTH));
        jButton3.setIcon(imagen);
        jButton3.setContentAreaFilled(false);
        jButton3.setLocation(x / 2 - 7 * y / 2, 6 * y);

        imagen = new ImageIcon("Tesoros/Botones/3.png");
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(2 * y, 2 * y, Image.SCALE_SMOOTH));
        jButton4.setIcon(imagen);
        jButton4.setContentAreaFilled(false);
        jButton4.setLocation(x / 2 - y, 6 * y);

        imagen = new ImageIcon("Tesoros/Botones/4.png");
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(2 * y, 2 * y, Image.SCALE_SMOOTH));
        jButton5.setIcon(imagen);
        jButton5.setContentAreaFilled(false);
        jButton5.setLocation(x / 2 + 3 * y / 2, 6 * y);

        jLabel1.setLocation(x / 2 - jLabel1.getSize().width / 2, 5 * y);
        jLabel1.setVisible(false);

        this.setLayout(null);
    }

    public void this_mousePressed(JButton boton) {
        ImageIcon imagen = null;
        if (boton == jButton3) {
            imagen = new ImageIcon("Tesoros/Botones/BotonNew2.png");
        } else if (boton == jButton4) {
            imagen = new ImageIcon("Tesoros/Botones/BotonNew3.png");
        } else if (boton == jButton5) {
            imagen = new ImageIcon("Tesoros/Botones/BotonNew4.png");
        }
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(2 * y, 2 * y, Image.SCALE_SMOOTH));
        boton.setIcon(imagen);
        boton.repaint();
    }

    public void this_mouseReleased(JButton boton) {
        ImageIcon imagen = null;
        if (boton == jButton3) {
            imagen = new ImageIcon("Tesoros/Botones/2.png");
        } else if (boton == jButton4) {
            imagen = new ImageIcon("Tesoros/Botones/3.png");
        } else if (boton == jButton5) {
            imagen = new ImageIcon("Tesoros/Botones/4.png");
        }
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(2 * y, 2 * y, Image.SCALE_SMOOTH));
        boton.setIcon(imagen);
        boton.repaint();
    }

    public void inicio() {
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                this_mousePressed(jButton3);
            }

            public void mouseReleased(MouseEvent e) {
                this_mouseReleased(jButton3);
            }
        });
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                this_mousePressed(jButton4);
            }

            public void mouseReleased(MouseEvent e) {
                this_mouseReleased(jButton4);
            }
        });
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                this_mousePressed(jButton5);
            }

            public void mouseReleased(MouseEvent e) {
                this_mouseReleased(jButton5);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
