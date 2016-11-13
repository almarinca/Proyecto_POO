/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BussinessLogic.Inicio;
import static BussinessLogic.Inicio.y;
import BussinessLogic.Turno;
import static BussinessLogic.Turno.correrFila;
import Data.Jugador;
import Data.Tablero;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import sun.awt.image.ToolkitImage;

/**
 *
 * @author Danilo
 */
public class GUILaberinto extends javax.swing.JFrame {

    public GUILaberinto() {
        initComponents();
    }

    private static final ArrayList<javax.swing.JButton> listaBotones = new ArrayList<>();
    static int y = Inicio.y;
    static int x = (Inicio.x-13*y)/3;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jButton4.setText("jButton4");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("jButton5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("jButton6");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setText("jButton8");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton13.setText("jButton13");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton15.setText("jButton15");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton14.setText("jButton14");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton10.setText("jButton10");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("jButton11");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("jButton12");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton7.setText("jButton7");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setText("jButton9");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9)
                    .addComponent(jButton10)
                    .addComponent(jButton11)
                    .addComponent(jButton12)
                    .addComponent(jButton13)
                    .addComponent(jButton14)
                    .addComponent(jButton15))
                .addGap(0, 772, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true), "Controles"));

        jButton2.setText("Girar Izquierda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Girar Derecha");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(28, 24, 24));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton16.setText("Arriba");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("Izquierda");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton19.setText("Derecha");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton18.setText("Abajo");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton1.setText("Terminar Turno");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jButton2)
                        .addGap(64, 64, 64)
                        .addComponent(jButton3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jButton16))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton19))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jButton18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jButton1)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jButton16)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17)
                    .addComponent(jButton19))
                .addGap(33, 33, 33)
                .addComponent(jButton18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(128, 128, 128))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(380, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        double i = Tablero.getFichasSobrantes().get(0).getGiro();
        for (int j = 0; j < 20; j++) {
            dibujarFichaLibre();
            i = i - 0.05;
            Tablero.getFichasSobrantes().get(0).setGiro(i);
        }
        if (i < 0) {
            i = i + 4;
        }
        Tablero.getFichasSobrantes().get(0).setGiro(i);
        Turno.rotarFicha(Tablero.getFichasSobrantes().get(0));
        Turno.rotarFicha(Tablero.getFichasSobrantes().get(0));
        Turno.rotarFicha(Tablero.getFichasSobrantes().get(0));
        dibujarFichaLibre();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        double i = Tablero.getFichasSobrantes().get(0).getGiro();
        for (int j = 0; j < 20; j++) {
            dibujarFichaLibre();
            i = i + 0.05;
            Tablero.getFichasSobrantes().get(0).setGiro(i);
        }
        if (i > 3) {
            i = i - 4;
        }
        Tablero.getFichasSobrantes().get(0).setGiro(i);
        Turno.rotarFicha(Tablero.getFichasSobrantes().get(0));
        dibujarFichaLibre();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        correrFila(7, -6, 3, 1, 0);
        cambiarBotones();
        construirTablero();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        cambiarBotones();
        correrFila(9, -6, 5, 1, 0);
        construirTablero();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        correrFila(10, 1, -6, 0, 1);
        cambiarBotones();
        construirTablero();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        correrFila(11, 3, -6, 0, 1);
        cambiarBotones();
        construirTablero();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        cambiarBotones();
        correrFila(1, 1, 0, 0, 1);
        construirTablero();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        correrFila(2, 3, 0, 0, 1);
        cambiarBotones();
        construirTablero();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        correrFila(3, 5, 0, 0, 1);
        cambiarBotones();
        construirTablero();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        correrFila(4, 0, 1, 1, 0);
        cambiarBotones();
        construirTablero();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        correrFila(6, 0, 3, 1, 0);
        cambiarBotones();
        construirTablero();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        correrFila(8, 0, 5, 1, 0);
        cambiarBotones();
        construirTablero();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        correrFila(5, -6, 1, 1, 0);
        cambiarBotones();
        construirTablero();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        correrFila(12, 5, -6, 0, 1);
        cambiarBotones();
        construirTablero();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Se debe poner el codigo para que vaya el siguiente jugador
        construirTablero();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        Turno.desplazarJugador(Jugador.jugador1, 'w');
        construirTablero();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        Turno.desplazarJugador(Jugador.jugador1, 's');
        construirTablero();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        Turno.desplazarJugador(Jugador.jugador1, 'a');
        construirTablero();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        Turno.desplazarJugador(Jugador.jugador1, 'd');
        construirTablero();
    }//GEN-LAST:event_jButton19ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUILaberinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUILaberinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUILaberinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUILaberinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUILaberinto laberinto = new GUILaberinto();
                laberinto.setVisible(true);
                laberinto.crearListaBotones();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.construirTablero();
    }

    public void construirTablero() {

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                dibujarFicha(jPanel1.getGraphics(), Tablero.getTablero()[i][j].getImagen(), (i * (y + 2)) + y, (j * (y + 2)) + y, Tablero.getTablero()[i][j].getGiro(), y / 2, y / 2);
            }
        }
        dibujarFichaLibre();
        for (Jugador jugador : Jugador.values()) {
            int j = jugador.getX();
            int i = jugador.getY();
            dibujarFicha(jPanel1.getGraphics(), jugador.getImagen(), (i * (y + 2)) + (2 * y / 7) + y, (j * (y + 2)) + (2 * y / 7) + y, 0, 0, 0);
        }
    }

    public void dibujarFicha(Graphics g, ImageIcon image, int posx, int posy, double girar, int centrox, int centroy) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform tx = new AffineTransform();
        tx.translate(posy, posx);
        tx.rotate(Math.toRadians(girar * 90), centrox, centroy);;
        g2d.drawImage(image.getImage(), tx, this);
    }

    public ImageIcon rotarImagen(ImageIcon imagen, double giro, int x, int y) {

        BufferedImage bimagen = ((ToolkitImage) imagen.getImage()).getBufferedImage();
        AffineTransform transform = AffineTransform.getRotateInstance(Math.toRadians(90) * giro, x, y);
        AffineTransformOp transformOp = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
        ImageIcon imagenRotada = new ImageIcon(transformOp.filter(bimagen, null));
        return imagenRotada;
    }

    public void dibujarFichaLibre() {
        ImageIcon ima = Tablero.getFichasSobrantes().get(0).getImagen();
        ima = new ImageIcon(ima.getImage().getScaledInstance(2 * y, 2 * y, Image.SCALE_SMOOTH));
        double a = Tablero.getFichasSobrantes().get(0).getGiro();
        dibujarFicha(jLabel1.getGraphics(), ima, 0, 0, a, y, y);
    }

    public void cambiarBotones() {
        for (int i = 0; i < 18; i++) {
            if (listaBotones.get(i).isEnabled()) {
                listaBotones.get(i).setEnabled(false);
            } else {
                listaBotones.get(i).setEnabled(true);
            }
        }
    }

    private void crearListaBotones() {
        listaBotones.add(jButton2);
        listaBotones.add(jButton3);
        listaBotones.add(jButton4);
        listaBotones.add(jButton5);
        listaBotones.add(jButton6);
        listaBotones.add(jButton7);
        listaBotones.add(jButton8);
        listaBotones.add(jButton9);
        listaBotones.add(jButton10);
        listaBotones.add(jButton11);
        listaBotones.add(jButton12);
        listaBotones.add(jButton13);
        listaBotones.add(jButton14);
        listaBotones.add(jButton15);
        listaBotones.add(jButton16);
        listaBotones.add(jButton17);
        listaBotones.add(jButton18);
        listaBotones.add(jButton19);
        jButton16.setEnabled(false);
        jButton17.setEnabled(false);
        jButton18.setEnabled(false);
        jButton19.setEnabled(false);
        for (int i = 0; i < 14; i++) {
            listaBotones.get(i).getAccessibleContext().setAccessibleParent(jPanel1);
        }
        jButton4.setLocation((1 * (y + 2)) + (2 * y / 7) + y + y / 8, (-1 * (y + 2)) + (2 * y / 7) + y + y / 8);
        jButton5.setLocation((3 * (y + 2)) + (2 * y / 7) + y + y / 8, (-1 * (y + 2)) + (2 * y / 7) + y + y / 8);
        jButton6.setLocation((5 * (y + 2)) + (2 * y / 7) + y + y / 8, (-1 * (y + 2)) + (2 * y / 7) + y + y / 8);
        jButton7.setLocation((-1 * (y + 2)) + (2 * y / 7) + y + y / 8, (1 * (y + 2)) + (2 * y / 7) + y + y / 8);
        jButton8.setLocation((-1 * (y + 2)) + (2 * y / 7) + y + y / 8, (3 * (y + 2)) + (2 * y / 7) + y + y / 8);
        jButton9.setLocation((-1 * (y + 2)) + (2 * y / 7) + y + y / 8, (5 * (y + 2)) + (2 * y / 7) + y + y / 8);
        jButton13.setLocation((7 * (y + 2)) + (2 * y / 7) + y + y / 8, (1 * (y + 2)) + (2 * y / 7) + y + y / 8);
        jButton14.setLocation((7 * (y + 2)) + (2 * y / 7) + y + y / 8, (3 * (y + 2)) + (2 * y / 7) + y + y / 8);
        jButton15.setLocation((7 * (y + 2)) + (2 * y / 7) + y + y / 8, (5 * (y + 2)) + (2 * y / 7) + y + y / 8);
        jButton10.setLocation((1 * (y + 2)) + (2 * y / 7) + y + y / 8, (7 * (y + 2)) + (2 * y / 7) + y + y / 8);
        jButton11.setLocation((3 * (y + 2)) + (2 * y / 7) + y + y / 8, (7 * (y + 2)) + (2 * y / 7) + y + y / 8);
        jButton12.setLocation((5 * (y + 2)) + (2 * y / 7) + y + y / 8, (7 * (y + 2)) + (2 * y / 7) + y + y / 8);
        jPanel1.setSize(9 * y + 12, 9 * y + 12);
        jPanel1.setLocation(x, 6);
        jPanel2.setSize(4 * y, 9 * y + 12);
        jPanel2.setLocation(jPanel1.getLocation().x + 9 * y + x, jPanel1.getLocation().y);
        ImageIcon imagen = null;
        for (int i = 2; i < 5; i++) {
            imagen = new ImageIcon("Tesoros/tri1.png");
            imagen = new ImageIcon(imagen.getImage().getScaledInstance(y / 4, y / 4, Image.SCALE_SMOOTH));
            imagen = rotarImagen(imagen, 2, y / 8, y / 8);
            listaBotones.get(i).setIcon(imagen);
            listaBotones.get(i).setSize(y / 4, y / 4);
            listaBotones.get(i).setText("");
            listaBotones.get(i).setContentAreaFilled(false);
        }
        for (int i = 5; i < 8; i++) {
            imagen = new ImageIcon("Tesoros/tri1.png");
            imagen = new ImageIcon(imagen.getImage().getScaledInstance(y / 4, y / 4, Image.SCALE_SMOOTH));
            imagen = rotarImagen(imagen, 1, y / 8, y / 8);
            listaBotones.get(i).setIcon(imagen);
            listaBotones.get(i).setSize(y / 4, y / 4);
            listaBotones.get(i).setText("");
            listaBotones.get(i).setContentAreaFilled(false);
        }
        for (int i = 8; i < 11; i++) {
            imagen = new ImageIcon("Tesoros/tri1.png");
            imagen = new ImageIcon(imagen.getImage().getScaledInstance(y / 4, y / 4, Image.SCALE_SMOOTH));
            imagen = rotarImagen(imagen, 0, y / 8, y / 8);
            listaBotones.get(i).setIcon(imagen);
            listaBotones.get(i).setSize(y / 4, y / 4);
            listaBotones.get(i).setText("");
            listaBotones.get(i).setContentAreaFilled(false);
        }
        for (int i = 11; i < 14; i++) {
            imagen = new ImageIcon("Tesoros/tri1.png");
            imagen = new ImageIcon(imagen.getImage().getScaledInstance(y / 4, y / 4, Image.SCALE_SMOOTH));
            imagen = rotarImagen(imagen, 3, y / 8, y / 8);
            listaBotones.get(i).setIcon(imagen);
            listaBotones.get(i).setSize(y / 4, y / 4);
            listaBotones.get(i).setText("");
            listaBotones.get(i).setContentAreaFilled(false);
        }
        jLabel1.setLocation(y, 5 * y / 3);
        jButton1.setLocation(2 * y - 61, 8 * y);
        jButton2.setLocation(2 * y - 130, y);
        jButton3.setLocation(2 * y + 25, y);
        jButton16.setLocation(2 * y - 25, 4 * y);
        jButton18.setLocation(2 * y - 25, 5 * y);
        jButton17.setLocation(2 * y - 100, 9 * y / 2);
        jButton19.setLocation(2 * y + 35, 9 * y / 2);
        this.setLayout(null);
        jLabel1.setLayout(null);
        jPanel1.setLayout(null);
        jPanel2.setLayout(null);
        repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

}
