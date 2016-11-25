package GUI;

import BussinessLogic.*;
import Data.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import sun.awt.image.ToolkitImage;

public class GUILaberinto extends javax.swing.JFrame implements Serializable {

    private static ArrayList<javax.swing.JButton> listaBotones = new ArrayList<>();
    private static int y = Inicio.y;
    private static int x = (Inicio.x - 13 * y) / 3;
    private static int numeroJugadores;
    private static int turno;

    public GUILaberinto() {
        initComponents();
        KeyListener listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                Jugador jugador;
                switch (e.getKeyCode()) {
                    case 39: // -> derecha
                        jugador = Jugador.values()[4 - turno];
                        Turno.desplazarJugador(jugador, 'd');
                        construirTablero();
                        break;
                    case 38:	// -> arriba
                        jugador = Jugador.values()[4 - turno];
                        Turno.desplazarJugador(jugador, 'w');
                        construirTablero();
                        break;

                    case 37: 	// -> izquierda 
                        jugador = Jugador.values()[4 - turno];
                        Turno.desplazarJugador(jugador, 'a');
                        construirTablero();
                        break;

                    case 40:	// -> abajo
                        jugador = Jugador.values()[4 - turno];
                        Turno.desplazarJugador(jugador, 's');
                        construirTablero();
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        };
        arriba.addKeyListener(listener);
        abajo.addKeyListener(listener);
        izquierda.addKeyListener(listener);
        derecha.addKeyListener(listener);
    }

    public void guardar() {
        try {
            FileOutputStream archivo = new FileOutputStream("botones.laby");
            ObjectOutputStream guardar = new ObjectOutputStream(archivo);
            guardar.writeObject(numeroJugadores);
            guardar.writeObject(turno);
            guardar.writeObject(terminarTurno);
            guardar.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void cargar() {
        try {
            FileInputStream archivo = new FileInputStream("botones.laby");
            ObjectInputStream cargar = new ObjectInputStream(archivo);
            numeroJugadores = (int) cargar.readObject();
            turno = (int) cargar.readObject();
            JButton boton = (JButton) cargar.readObject();
            if (!boton.isEnabled()) {
                cambiarBotones();
            }
            turno--;
            terminarTurnoActionPerformed(new ActionEvent(terminarTurno, 0, "nothing"));
            cargar.close();
            archivo.close();
            this.repaint();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
    
    public void girarFichaLibre(int signo, int giros) {
        double rotaciones = Tablero.getFichasSobrantes().get(0).getGiro();
        for (int j = 0; j < 20; j++) {
            dibujarFichaLibre();
            rotaciones = rotaciones + 0.05 * signo;
            Tablero.getFichasSobrantes().get(0).setGiro(rotaciones);
        }
        if (rotaciones < 0) {
            rotaciones = rotaciones + 4;
        } else if (rotaciones > 3) {
            rotaciones = rotaciones - 4;
        }
        Tablero.getFichasSobrantes().get(0).setGiro(rotaciones);
        for (int i = 0; i < giros; i++) {
            Turno.rotarFicha(Tablero.getFichasSobrantes().get(0));
        }
        dibujarFichaLibre();
    }
    
    public void ingresarFichaLibre(int casilla, int columna, int fila, int cambioX, int cambioY){
        Turno.correrFila(casilla, columna, fila, cambioX, cambioY);
        cambiarBotones();
        construirTablero();
        actualizarIndicaciones();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        casilla1 = new javax.swing.JButton();
        casilla2 = new javax.swing.JButton();
        casilla3 = new javax.swing.JButton();
        casilla6 = new javax.swing.JButton();
        casilla5 = new javax.swing.JButton();
        casilla9 = new javax.swing.JButton();
        casilla7 = new javax.swing.JButton();
        casilla10 = new javax.swing.JButton();
        casilla11 = new javax.swing.JButton();
        casilla12 = new javax.swing.JButton();
        casilla4 = new javax.swing.JButton();
        casilla8 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        girarIzquierda = new javax.swing.JButton();
        girarDerecha = new javax.swing.JButton();
        fichaSobrante = new javax.swing.JLabel();
        arriba = new javax.swing.JButton();
        izquierda = new javax.swing.JButton();
        derecha = new javax.swing.JButton();
        abajo = new javax.swing.JButton();
        terminarTurno = new javax.swing.JButton();
        turnoJugador = new javax.swing.JLabel();
        tarjeta = new javax.swing.JLabel();
        indicaciones = new javax.swing.JLabel();
        turnoJugador1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconImages(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        casilla1.setText("jButton4");
        casilla1.setBorder(null);
        casilla1.setBorderPainted(false);
        casilla1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casilla1ActionPerformed(evt);
            }
        });

        casilla2.setText("jButton5");
        casilla2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casilla2ActionPerformed(evt);
            }
        });

        casilla3.setText("jButton6");
        casilla3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casilla3ActionPerformed(evt);
            }
        });

        casilla6.setText("jButton8");
        casilla6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casilla6ActionPerformed(evt);
            }
        });

        casilla5.setText("jButton13");
        casilla5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casilla5ActionPerformed(evt);
            }
        });

        casilla9.setText("jButton15");
        casilla9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casilla9ActionPerformed(evt);
            }
        });

        casilla7.setText("jButton14");
        casilla7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casilla7ActionPerformed(evt);
            }
        });

        casilla10.setText("jButton10");
        casilla10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casilla10ActionPerformed(evt);
            }
        });

        casilla11.setText("jButton11");
        casilla11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casilla11ActionPerformed(evt);
            }
        });

        casilla12.setText("jButton12");
        casilla12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casilla12ActionPerformed(evt);
            }
        });

        casilla4.setText("jButton7");
        casilla4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casilla4ActionPerformed(evt);
            }
        });

        casilla8.setText("jButton9");
        casilla8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casilla8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(casilla1)
                    .addComponent(casilla2)
                    .addComponent(casilla3)
                    .addComponent(casilla4)
                    .addComponent(casilla6)
                    .addComponent(casilla8)
                    .addComponent(casilla10)
                    .addComponent(casilla11)
                    .addComponent(casilla12)
                    .addComponent(casilla5)
                    .addComponent(casilla7)
                    .addComponent(casilla9))
                .addGap(0, 772, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(casilla1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(casilla2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(casilla3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(casilla4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(casilla6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(casilla8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(casilla10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(casilla11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(casilla12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(casilla5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(casilla7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(casilla9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true), "Controles"));

        girarIzquierda.setText("Girar Izquierda");
        girarIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                girarIzquierdaActionPerformed(evt);
            }
        });

        girarDerecha.setText("Girar Derecha");
        girarDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                girarDerechaActionPerformed(evt);
            }
        });

        fichaSobrante.setBackground(new java.awt.Color(28, 24, 24));
        fichaSobrante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        arriba.setText("Arriba");
        arriba.setEnabled(false);
        arriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arribaActionPerformed(evt);
            }
        });

        izquierda.setText("Izquierda");
        izquierda.setEnabled(false);
        izquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izquierdaActionPerformed(evt);
            }
        });

        derecha.setText("Derecha");
        derecha.setEnabled(false);
        derecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derechaActionPerformed(evt);
            }
        });

        abajo.setText("Abajo");
        abajo.setEnabled(false);
        abajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abajoActionPerformed(evt);
            }
        });

        terminarTurno.setText("Terminar Turno");
        terminarTurno.setEnabled(false);
        terminarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminarTurnoActionPerformed(evt);
            }
        });

        turnoJugador.setFont(new java.awt.Font("Comic Sans MS", 0, 22)); // NOI18N
        turnoJugador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        turnoJugador.setText("Es el turno de:");
        turnoJugador.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        indicaciones.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        indicaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        indicaciones.setText("Gira la ficha e ingresela donde desees");
        indicaciones.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        turnoJugador1.setFont(new java.awt.Font("Comic Sans MS", 0, 22)); // NOI18N
        turnoJugador1.setForeground(new java.awt.Color(0, 255, 0));
        turnoJugador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        turnoJugador1.setText("Jugador 1");
        turnoJugador1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(arriba))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(izquierda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(derecha))
                            .addComponent(fichaSobrante, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(abajo))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(terminarTurno))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addComponent(tarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(turnoJugador1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(turnoJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(indicaciones)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(girarIzquierda)
                                .addGap(64, 64, 64)
                                .addComponent(girarDerecha)))))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(turnoJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(turnoJugador1)
                .addGap(107, 107, 107)
                .addComponent(tarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(indicaciones)
                .addGap(99, 99, 99)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(girarIzquierda)
                    .addComponent(girarDerecha))
                .addGap(50, 50, 50)
                .addComponent(fichaSobrante, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(arriba)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(izquierda)
                    .addComponent(derecha))
                .addGap(33, 33, 33)
                .addComponent(abajo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(terminarTurno)
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
                .addContainerGap(289, Short.MAX_VALUE))
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

        jPanel2.getAccessibleContext().setAccessibleParent(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void girarIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_girarIzquierdaActionPerformed
        girarFichaLibre(-1, 3);
    }//GEN-LAST:event_girarIzquierdaActionPerformed

    private void girarDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_girarDerechaActionPerformed
        girarFichaLibre(1, 1);
    }//GEN-LAST:event_girarDerechaActionPerformed

    private void casilla7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casilla7ActionPerformed
        ingresarFichaLibre(7, -6, 3, 1, 0);
    }//GEN-LAST:event_casilla7ActionPerformed

    private void casilla9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casilla9ActionPerformed
                ingresarFichaLibre(9, -6, 5, 1, 0);        
    }//GEN-LAST:event_casilla9ActionPerformed

    private void casilla10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casilla10ActionPerformed
        ingresarFichaLibre(10, 1, -6, 0, 1);
    }//GEN-LAST:event_casilla10ActionPerformed

    private void casilla11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casilla11ActionPerformed
        ingresarFichaLibre(11, 3, -6, 0, 1);
    }//GEN-LAST:event_casilla11ActionPerformed

    private void casilla1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casilla1ActionPerformed
        ingresarFichaLibre(1, 1, 0, 0, 1);        
    }//GEN-LAST:event_casilla1ActionPerformed

    private void casilla2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casilla2ActionPerformed
        ingresarFichaLibre(2, 3, 0, 0, 1);        
    }//GEN-LAST:event_casilla2ActionPerformed

    private void casilla3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casilla3ActionPerformed
        ingresarFichaLibre(3, 5, 0, 0, 1);        
    }//GEN-LAST:event_casilla3ActionPerformed

    private void casilla4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casilla4ActionPerformed
        ingresarFichaLibre(4, 0, 1, 1, 0);        
    }//GEN-LAST:event_casilla4ActionPerformed

    private void casilla6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casilla6ActionPerformed
        ingresarFichaLibre(6, 0, 3, 1, 0);
    }//GEN-LAST:event_casilla6ActionPerformed

    private void casilla8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casilla8ActionPerformed
        ingresarFichaLibre(8, 0, 5, 1, 0);
    }//GEN-LAST:event_casilla8ActionPerformed

    private void casilla5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casilla5ActionPerformed
        ingresarFichaLibre(5, -6, 1, 1, 0);        
    }//GEN-LAST:event_casilla5ActionPerformed

    private void casilla12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casilla12ActionPerformed
        ingresarFichaLibre(12, 5, -6, 0, 1);
    }//GEN-LAST:event_casilla12ActionPerformed

    private void terminarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarTurnoActionPerformed
        Jugador jugador;
        try {
            jugador = Jugador.values()[4 - turno];
        } catch (ArrayIndexOutOfBoundsException e) {
            jugador = Jugador.jugador1;
        }
        turno++;
        if (turno == numeroJugadores + 1) {
            turno = 1;
        }
        cambiarBotones();
        construirTablero();
        actualizarIndicaciones();

        if (jugador.getListaTarjetas().get(0).getSimbolo() == Tablero.getTablero()[jugador.getY()][jugador.getX()].getCaracter()) {
            JOptionPane.showMessageDialog(this, "Felicitaciones jugador " + jugador.getNumero() + " has encontrado un tesoro");
            jugador.getListaTarjetas().remove(0);
            if (jugador.getListaTarjetas().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Felicitaciones jugador " + jugador.getNumero() + " eres el ganador");
                File file = new File("laberinto.laby");
                file.delete();
                file = new File("botones.laby");
                file.delete();
                System.exit(0);
            }
        }

        String color = null;
        switch (turno) {
            case 1:
                color = "Jugador 1";
                turnoJugador1.setForeground(Color.green);
                break;
            case 2:
                color = "Jugador 2";
                turnoJugador1.setForeground(Color.red);
                break;
            case 3:
                color = "Jugador 3";
                turnoJugador1.setForeground(Color.yellow);
                break;
            case 4:
                color = "Jugador 4";
                turnoJugador1.setForeground(Color.blue);
                break;
        }
        turnoJugador1.setText(color);
        turnoJugador1.repaint();
    }//GEN-LAST:event_terminarTurnoActionPerformed

    private void arribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arribaActionPerformed
        Jugador jugador = Jugador.values()[4 - turno];
        Turno.desplazarJugador(jugador, 'w');
        construirTablero();
    }//GEN-LAST:event_arribaActionPerformed

    private void abajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abajoActionPerformed
        Jugador jugador = Jugador.values()[4 - turno];
        Turno.desplazarJugador(jugador, 's');
        construirTablero();
    }//GEN-LAST:event_abajoActionPerformed

    private void izquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izquierdaActionPerformed
        Jugador jugador = Jugador.values()[4 - turno];
        Turno.desplazarJugador(jugador, 'd');
        construirTablero();
    }//GEN-LAST:event_izquierdaActionPerformed

    private void derechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derechaActionPerformed
        Jugador jugador = Jugador.values()[4 - turno];
        Turno.desplazarJugador(jugador, 'a');
        construirTablero();
    }//GEN-LAST:event_derechaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int opcion = JOptionPane.showOptionDialog(this, "¿Desea guardar la partida?", "Salir", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.YES_NO_CANCEL_OPTION, null, null, NORMAL);
        switch (opcion) {
            case 0:
                Tablero.guardar();
                guardar();
                JOptionPane.showMessageDialog(this, "Guardado Correctamente");
                System.exit(0);
                break;
            case 1:
                System.exit(0);
                break;
            case 2:
                break;
        }
    }//GEN-LAST:event_formWindowClosing

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
                Tablero tablero = new Tablero();
                Turno.desplazarJugador(Jugador.jugador1, '0');
                Turno.desplazarJugador(Jugador.jugador2, '0');
                Turno.desplazarJugador(Jugador.jugador3, '0');
                Turno.desplazarJugador(Jugador.jugador4, '0');
                GUIMenu menu = new GUIMenu();
                menu.setVisible(true);
                menu.setSize(Inicio.x, 10 * y);
                menu.iniciarComponentes();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.construirTablero();
        this.actualizarIndicaciones();
    }

    public void actualizarIndicaciones() {
        String indicacion = "";
        if (girarIzquierda.isEnabled()) {
            indicacion = ("Gira la ficha e ingresala donde desees");
        } else {
            indicacion = ("Muevete por el tablero hacia tu tesoro" + "\n");
        }
        indicaciones.setText(indicacion);

        ImageIcon ima = Jugador.values()[4 - turno].getListaTarjetas().get(0).getImagen();
        ima = new ImageIcon(ima.getImage().getScaledInstance(3 * y / 2, (2 * y), Image.SCALE_SMOOTH));
        dibujarFicha(tarjeta.getGraphics(), ima, 0, 0, 0, 0, 0);

    }

    public void construirTablero() {

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                dibujarFicha(jPanel1.getGraphics(), Tablero.getTablero()[i][j].getImagen(), (i * (y + 2)) + y, (j * (y + 2)) + y, Tablero.getTablero()[i][j].getGiro(), y / 2, y / 2);
            }
        }
        if (Jugador.values()[4 - turno].getListaTarjetas().size() == 1) {
            tarjeta.repaint();
            tarjeta.setText("Vuelve a tu punto de partida");
        } else {
            dibujarFichaLibre();
        }
        for (int p = 1; p <= numeroJugadores; p++) {
            Jugador jugador = Jugador.values()[4 - p];
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
        ima = new ImageIcon(ima.getImage().getScaledInstance(3 * y / 2, 3 * y / 2, Image.SCALE_SMOOTH));
        double a = Tablero.getFichasSobrantes().get(0).getGiro();
        dibujarFicha(fichaSobrante.getGraphics(), ima, 0, 0, a, 3 * y / 4, 3 * y / 4);
    }

    public void cambiarBotones() {
        for (int i = 0; i < 19; i++) {
            if (listaBotones.get(i).isEnabled()) {
                listaBotones.get(i).setEnabled(false);
            } else {
                listaBotones.get(i).setEnabled(true);
            }
        }
    }

    public void iniciarComponentes() {
        turno = 1;
        listaBotones.add(girarIzquierda);
        listaBotones.add(girarDerecha);
        listaBotones.add(casilla1);
        listaBotones.add(casilla2);
        listaBotones.add(casilla3);
        listaBotones.add(casilla4);
        listaBotones.add(casilla6);
        listaBotones.add(casilla8);
        listaBotones.add(casilla10);
        listaBotones.add(casilla11);
        listaBotones.add(casilla12);
        listaBotones.add(casilla5);
        listaBotones.add(casilla7);
        listaBotones.add(casilla9);
        listaBotones.add(arriba);
        listaBotones.add(izquierda);
        listaBotones.add(abajo);
        listaBotones.add(derecha);
        listaBotones.add(terminarTurno);
        arriba.setEnabled(false);
        izquierda.setEnabled(false);
        abajo.setEnabled(false);
        derecha.setEnabled(false);
        terminarTurno.setEnabled(false);
        casilla1.setLocation((1 * (y + 2)) + (2 * y / 7) + y + y / 8, (-1 * (y + 2)) + (2 * y / 7) + y + y / 8);
        casilla2.setLocation((3 * (y + 2)) + (2 * y / 7) + y + y / 8, (-1 * (y + 2)) + (2 * y / 7) + y + y / 8);
        casilla3.setLocation((5 * (y + 2)) + (2 * y / 7) + y + y / 8, (-1 * (y + 2)) + (2 * y / 7) + y + y / 8);
        casilla4.setLocation((-1 * (y + 2)) + (2 * y / 7) + y + y / 8, (1 * (y + 2)) + (2 * y / 7) + y + y / 8);
        casilla6.setLocation((-1 * (y + 2)) + (2 * y / 7) + y + y / 8, (3 * (y + 2)) + (2 * y / 7) + y + y / 8);
        casilla8.setLocation((-1 * (y + 2)) + (2 * y / 7) + y + y / 8, (5 * (y + 2)) + (2 * y / 7) + y + y / 8);
        casilla5.setLocation((7 * (y + 2)) + (2 * y / 7) + y + y / 8, (1 * (y + 2)) + (2 * y / 7) + y + y / 8);
        casilla7.setLocation((7 * (y + 2)) + (2 * y / 7) + y + y / 8, (3 * (y + 2)) + (2 * y / 7) + y + y / 8);
        casilla9.setLocation((7 * (y + 2)) + (2 * y / 7) + y + y / 8, (5 * (y + 2)) + (2 * y / 7) + y + y / 8);
        casilla10.setLocation((1 * (y + 2)) + (2 * y / 7) + y + y / 8, (7 * (y + 2)) + (2 * y / 7) + y + y / 8);
        casilla11.setLocation((3 * (y + 2)) + (2 * y / 7) + y + y / 8, (7 * (y + 2)) + (2 * y / 7) + y + y / 8);
        casilla12.setLocation((5 * (y + 2)) + (2 * y / 7) + y + y / 8, (7 * (y + 2)) + (2 * y / 7) + y + y / 8);
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
        for (int i = 14; i < 18; i++) {
            imagen = new ImageIcon("Tesoros/BotonFlecha.png");
            imagen = new ImageIcon(imagen.getImage().getScaledInstance(y / 2, y / 2, Image.SCALE_SMOOTH));
            imagen = rotarImagen(imagen, i - 14, y / 4, y / 4);
            listaBotones.get(i).setIcon(imagen);
            listaBotones.get(i).setSize(y / 2, y / 2);
            listaBotones.get(i).setText("");
            listaBotones.get(i).setContentAreaFilled(false);
            switch (i) {
                case 14:
                    imagen = new ImageIcon("Tesoros/BotonFlechaClick.png");
                    imagen = new ImageIcon(imagen.getImage().getScaledInstance(y / 2, y / 2, Image.SCALE_SMOOTH));
                    imagen = rotarImagen(imagen, i - 14, y / 4, y / 4);
                    arriba.setPressedIcon(imagen);
                    break;
                case 15:
                    imagen = new ImageIcon("Tesoros/BotonFlechaClick.png");
                    imagen = new ImageIcon(imagen.getImage().getScaledInstance(y / 2, y / 2, Image.SCALE_SMOOTH));
                    imagen = rotarImagen(imagen, i - 14, y / 4, y / 4);
                    izquierda.setPressedIcon(imagen);
                    break;
                case 16:
                    imagen = new ImageIcon("Tesoros/BotonFlechaClick.png");
                    imagen = new ImageIcon(imagen.getImage().getScaledInstance(y / 2, y / 2, Image.SCALE_SMOOTH));
                    imagen = rotarImagen(imagen, i - 14, y / 4, y / 4);
                    abajo.setPressedIcon(imagen);
                    break;
                case 17:
                    imagen = new ImageIcon("Tesoros/BotonFlechaClick.png");
                    imagen = new ImageIcon(imagen.getImage().getScaledInstance(y / 2, y / 2, Image.SCALE_SMOOTH));
                    imagen = rotarImagen(imagen, i - 14, y / 4, y / 4);
                    derecha.setPressedIcon(imagen);
                    break;
                default:
                    break;
            }
        }
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                imagen = new ImageIcon("Tesoros/FlechaMoverIzquierda.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(y, y / 2, Image.SCALE_SMOOTH));
            } else {
                imagen = new ImageIcon("Tesoros/FlechaMoverDerecha.png");
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(y, y / 2, Image.SCALE_SMOOTH));

            }
            listaBotones.get(i).setIcon(imagen);
            listaBotones.get(i).setSize(y, y / 2);
            listaBotones.get(i).setText("");
            listaBotones.get(i).setContentAreaFilled(false);
        }

        imagen = new ImageIcon("Tesoros/BotonPasarTurno.png");
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(2 * y, 2 * y / 3, Image.SCALE_SMOOTH));
        terminarTurno.setIcon(imagen);
        terminarTurno.setSize(2 * y, 2 * y / 3);
        terminarTurno.setText("");
        terminarTurno.setContentAreaFilled(false);

        imagen = new ImageIcon("Tesoros/BotonPasarTurnoClick.png");
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(2 * y, 2 * y / 3, Image.SCALE_SMOOTH));
        terminarTurno.setPressedIcon(imagen);

        turnoJugador.setSize(4 * y, y / 3);
        turnoJugador1.setSize(4 * y, y / 3);
        turnoJugador.setLocation(0, y / 2);
        turnoJugador1.setLocation(0, 3 * y / 4);
        tarjeta.setLocation(5 * y / 4, y + y / 8);
        tarjeta.setSize(3 * y / 2, 2 * y);
        indicaciones.setLocation(0, 16 * y / 5);
        indicaciones.setSize(4 * y, y / 4);
        fichaSobrante.setLocation(5 * y / 4, 17 * y / 4);
        fichaSobrante.setSize(3 * y / 2, 3 * y / 2);
        terminarTurno.setLocation(y, 8 * y);
        girarIzquierda.setLocation(2 * y - 3 * y / 2, 7 * y / 2);
        girarDerecha.setLocation(2 * y + y / 2, 7 * y / 2);
        arriba.setLocation(2 * y - y / 4, 6 * y);
        abajo.setLocation(2 * y - y / 4, 7 * y);
        izquierda.setLocation(2 * y + y / 4, 13 * y / 2);
        derecha.setLocation(2 * y - 3 * y / 4, 13 * y / 2);
        this.setLayout(null);
        fichaSobrante.setLayout(null);
        jPanel1.setLayout(null);
        jPanel2.setLayout(null);
        repaint();
    }

    public static void setNumeroJugadores(int numeroJugadores) {
        GUILaberinto.numeroJugadores = numeroJugadores;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abajo;
    private javax.swing.JButton arriba;
    private javax.swing.JButton casilla1;
    private javax.swing.JButton casilla10;
    private javax.swing.JButton casilla11;
    private javax.swing.JButton casilla12;
    private javax.swing.JButton casilla2;
    private javax.swing.JButton casilla3;
    private javax.swing.JButton casilla4;
    private javax.swing.JButton casilla5;
    private javax.swing.JButton casilla6;
    private javax.swing.JButton casilla7;
    private javax.swing.JButton casilla8;
    private javax.swing.JButton casilla9;
    private javax.swing.JButton derecha;
    private javax.swing.JLabel fichaSobrante;
    private javax.swing.JButton girarDerecha;
    private javax.swing.JButton girarIzquierda;
    private javax.swing.JLabel indicaciones;
    private javax.swing.JButton izquierda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel tarjeta;
    private javax.swing.JButton terminarTurno;
    private javax.swing.JLabel turnoJugador;
    private javax.swing.JLabel turnoJugador1;
    // End of variables declaration//GEN-END:variables

}
