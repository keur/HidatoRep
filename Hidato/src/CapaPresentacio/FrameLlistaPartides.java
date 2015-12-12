/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacio;

import CapaDomini.Partida.GameManagerController;
import CapaDomini.Rank.RankingController;
import CapaDomini.Tauler.HidatoManagerController;
import CapaDomini.Tauler.HidatoSet;
import CapaDomini.Usuari.HidatoUserController;
import java.util.ArrayList;

/**
 *
 * @author Pau
 */
public class FrameLlistaPartides extends FrameLlista {

    
    private GameManagerController gmc;
    /**
     * Creates new form FrameLlistaPartides
     */
    public FrameLlistaPartides(RetornadorString ret, GameManagerController gmc, HidatoManagerController hmc) {
        super(ret,hmc);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameLlistaPartides.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameLlistaPartides.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameLlistaPartides.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameLlistaPartides.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HidatoUserController uc = new HidatoUserController();
                //uc.createUser("Usuari", "password");
                uc.login("hola","adeu");
                HidatoSet hs = new HidatoSet();
                
                GameManagerController gmc = new GameManagerController(new RankingController(), uc, new HidatoSet());
                gmc.loadAllGames();
                HidatoManagerController hmc = new HidatoManagerController(new HidatoSet(),gmc,uc);
                FrameLlistaPartides flp = new FrameLlistaPartides(new RetornadorString() {
                    @Override
                    public void retorna (String s) {
                        System.out.print("Retornaria la string " + s + "\n");
                    }
                }, gmc,hmc);
                flp.setVisible(true);
                System.out.println("Abans de load partides");
                flp.loadPartidesUsuari();
            }
        });
    }
    
    public void loadPartidesUsuari () {
        ArrayList<String> llista = gmc.getGameList();
        jList1.setListData(llista.toArray(new String[]{}));
        if (!llista.isEmpty()) jList1.setSelectedIndex(0);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
