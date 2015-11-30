/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistes;


import domini.Misc.Colors;
import domini.Tauler.GeneratorController;
import domini.Tauler.Hidato;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.SoftBevelBorder;

/**
 *
 * @author David
 */
public class FrameEditor extends javax.swing.JFrame {

    /**
     * Creates new form FrameEditor
     */
    public FrameEditor() {
        initComponents();
        inici(10,10);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FrameEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    // =============================AQUI LO MEU=================================

    
    
    ArrayList<ArrayList<SquareCell>> panels;
    ArrayList<ArrayList<JLabel>> labels;
    Hidato h;
    
    public void inici(int N, int M) {
        JLabel la = new JLabel();
        jPanel2.setLayout(null);  // Eliminamos el layout
        jPanel2.add (la); // Añadimos el botón
        la.setBounds (10,10,40,20); // Botón en posicion 10,10 con ancho 40 pixels y alto 20
        la.setText("Hola món!\n");
        
        
        GeneratorController gc = new GeneratorController();
        h = new Hidato(N, M);
        panels = new ArrayList<>();
        
        int maxim, N1, N2, M1, M2;
        maxim = Math.max(N,M);
        N1 = (maxim-N)/2;
        N2 = N + N1;
        M1 = (maxim-M)/2;
        M2 = M + M1;
        jPanel1.setLayout(new GridLayout(maxim, maxim));
        
        
        for (int i0 = 0; i0 < maxim; ++i0) {
            panels.add(new ArrayList<>());
            for (int j0 = 0; j0 < maxim; ++j0) {
                if (N1 <= i0 && i0 < N2 && M1 <= j0 && j0 < M2) {
                    int i = i0-N1, j = j0-M1;
                    int val = h.getCell(i,j).getVal();
                    domini.Tauler.Type type = h.getCell(i,j).getType();
                    SquareCell p = new SquareCell(i,j,val,type,color(i,j),Colors.vermell,Colors.blau_fosc);
                    panels.get(i).add(p);
                    jPanel1.add(p, i0*maxim+j0);
                    p.setFontNum(500/maxim/2);
                    p.addMouseListener(new java.awt.event.MouseAdapter() {
                        @Override
                        public void mouseEntered(java.awt.event.MouseEvent evt) {
                            mouseIn((SquareCell) evt.getComponent());
                        }
                        @Override
                        public void mouseExited(java.awt.event.MouseEvent evt) {
                            mouseOut((SquareCell) evt.getComponent());
                        }
                        @Override
                        public void mousePressed(java.awt.event.MouseEvent evt) {
                            mousePress((SquareCell) evt.getComponent());
                        }
                        @Override
                        public void mouseReleased(java.awt.event.MouseEvent evt) {
                            mouseRelease((SquareCell) evt.getComponent());
                        }
                    });
                }
                else {
                    JPanel p = new JPanel();
                    jPanel1.add(p,i0*maxim+j0);
                }
                
            }
        }/**/
        
        
    }
    
    private void mouseIn (SquareCell p) {
        p.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
    }
    
    private void mouseOut (SquareCell p) {
        p.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        p.setLight(false);
    }
    
    private void mousePress (SquareCell p) {
        p.setLight(true);
    }
    
    private void mouseRelease (SquareCell p) {
        if(p.getLight()) {
            String input = JOptionPane.showInputDialog(null);
            try {
                int num = Integer.parseInt(input);
                h.getCell(p.getA(), p.getB()).setVal(num);
                p.changeVal(num);
            }
            catch (Exception e) {
                msgError("No és un número");
            }
            p.setLight(false);
        }
    }
    
    private Color color (int i, int j) {
        if ((i+j)%2 == 0) return Colors.blau_fluix;
        return Colors.blanc;
    }
    
    private void msgError(String text) {
        JOptionPane.showMessageDialog(this,text,"Error",JOptionPane.ERROR_MESSAGE);
    }
}
