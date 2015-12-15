/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacio;

import CapaDomini.Misc.Colors;
import CapaDomini.Misc.Fonts;
import CapaDomini.Partida.GameManagerController;
import CapaDomini.Tauler.HidatoManagerController;
import CapaDomini.Tauler.HidatoSet;
import CapaDomini.Usuari.HidatoUserController;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Vista que serveix com a diàleg per escollir d'entre una llista de
 * hidatos o partides
 * @author David
 */
public class FrameLlista extends javax.swing.JFrame {

    /**
     * Creadora amb parametres
     */
    public FrameLlista(RetornadorString ret, HidatoManagerController hmc) {
        initComponents();
        inici(ret, hmc);
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
        label_nom = new javax.swing.JLabel();
        label_autor = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<String>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Hidatos guardats");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        label_nom.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        label_nom.setText("Hidato:");

        label_autor.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        label_autor.setText("Autor");

        jButton1.setText("Selecciona");

        jButton2.setText("Boto 2");

        jButton4.setText("Cancel·la");

        jButton3.setText("Boto 3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_nom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_autor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_autor)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Hola", "com", "estas", "mes", "elements", "hooahoahoahaohoaa", "dfase", "gaefsedga", "fgaesfsada", "geafaesg", "aefaesgae" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
     * Funció que es crida abans de tancar, és com pitjar el botó endarrere
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        retorna(false);
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    protected javax.swing.JButton jButton2;
    protected javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    protected javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    protected javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_autor;
    protected javax.swing.JLabel label_nom;
    // End of variables declaration//GEN-END:variables

    /*
     * Objecte que té els mètodes que s'efectuen al frame que ha creat aquest
     * quan es pitgi algun botó
     */
    protected RetornadorString ret;
    
    /*
     * Controlador HidatoManagerController
     */
    private HidatoManagerController hmc;
    
    /*
     * Paraula seleccionada de la jList1
     */
    protected String selected;
    
    /*
     * Array de les SquareCellRapida que conformen el taulell
     */
    protected ArrayList<ArrayList<SquareCellRapida>> panels;
    
    /*
     * Thread que escriu els números al taulell.
     * S'escriuen en un thread perquè a vegades triga bastant en fer-se.
     */
    private Thread t;
    
    /*
     * Booleà que serveix per controlar les accions del thread
     */
    protected boolean seguir;
    
    /*
     * Funció que es duu a terme al principi.
     * Configura el frame, els listeners, els components i els paràmetres
     */
    private void inici(RetornadorString ret, HidatoManagerController hmc) {
        this.ret = ret;
        this.hmc = hmc;
        label_nom.setText("");
        label_nom.setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 48));
        label_autor.setText("");
        label_autor.setFont(Fonts.getFont("OpenSans-Light", Font.ITALIC, 24));
        selected = null;
        jList1.setSelectionBackground(Colors.c(1));
        jList1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged (ListSelectionEvent evt) {
                if (!jList1.getSelectedValue().equals(selected)) {
                    selected = jList1.getSelectedValue();
                    seleccio();
                }
            }
        });
        jList1.setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 18));
        jButton1.setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 18));
        jButton2.setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 18));
        jButton3.setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 18));
        jButton4.setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 18));
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent evt) {
                retorna(true);
            }
        });
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent evt) {
                retorna(false);
            }
        });
        setIconImage((new ImageIcon("icon.png")).getImage());
    }
    
    /*
     * Crida la funció retorna de ret i elimina aquest frame
     */
    protected void retorna(boolean b) {
        if (b) ret.retorna(jList1.getSelectedValue());
        else ret.retorna(null);
        this.dispose();
    }
    
    /*
     * Demana un nom per al hidato, i si no hi ha cap altre amb aquest nom,
     * crida la funció de ret per a canviar el nom del hidato.
     */
    protected void canviaNom() {
        String newName = JOptionPane.showInputDialog(this, "Escriu un nou nom pel hidato "
                + jList1.getSelectedValue() + ":");
        if (newName == null) return;
        if (newName.equals("")) {
            msgError("Escriu algun nom!");
            return;
        }
        if (hmc.usedName(newName)) {
            msgError("Ja existeix un hidato amb aquest nom");
            return;
        }
        ret.canviaNom(jList1.getSelectedValue(), newName);
        this.dispose();
    }
    
    /*
     * Crida la funció de ret per eliminar el hidato
     */
    protected void elimina() {
        ret.elimina(jList1.getSelectedValue());
        this.dispose();
    }
    
    /*
     * Carrega a la llista els hidatos de l'usuari loggejat i configura els
     * botons que són per una llista de hidatos d'un usuari (és a dir, per una
     * on es poden editar, canviar de nom, i eliminar)
     */
    public void loadHidatosUsuari () {
        ArrayList<String> llista = hmc.getUserHidatoList();
        jList1.setListData(llista.toArray(new String[]{}));
        if (!llista.isEmpty()) jList1.setSelectedIndex(0);
        jButton1.setText("Edita");
        jButton2.setVisible(true);
        jButton2.setText("Nom nou");
        jButton3.setVisible(true);
        jButton3.setText("Elimina");
        jButton4.setText("Endarrere");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent evt) {
                canviaNom();
            }
        });
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent evt) {
                elimina();
            }
        });
    }
    
    /*
     * Carrega a la llista els hidatos de tots els usuaris
     */
    public void loadHidatosTots () {
        ArrayList<String> llista = hmc.getAllHidatoList();
        jList1.setListData(llista.toArray(new String[]{}));
        if (!llista.isEmpty()) jList1.setSelectedIndex(0);
    }

    /*
     * Carrega el hidato seleccionat a hmc, el dibuixa en pantalla, i actualitza
     * les dades que surten en pantalla
     */
    protected void seleccio() {
        seguir = false;
        boolean result = hmc.loadHidato(selected);
        if (!result) {
            msgError("No s'ha trobat l'element");
            return;
        }
        label_nom.setText(selected);
        label_autor.setText("By: " + hmc.getTempUsername());
        dibuixarHidato();
    }

    /*
     * Getter del tipus de la cel·la (i,j)
     */
    protected CapaDomini.Tauler.Type getType(int i, int j){
        return hmc.getTempCellType(i,j);
    }
    
    /*
     * Getter del valor de la cel·la (i,j)
     */
    protected int getVal(int i, int j){
        return hmc.getTempCellVal(i,j);
    }
    
    /*
     * Setter del valor de la cel·la (i,j) a la pantalla
     * Només escriu el valor de les cel·les de tipus GIVEN
     */
    protected void setVal(int i, int j, int i0, int j0){
        int val = hmc.getTempCellVal(i,j);
        if (hmc.getTempCellType(i,j) == CapaDomini.Tauler.Type.GIVEN) panels.get(i0).get(j0).setVal(val);
                            
    }
    
    /*
     * Getter del nombre de files del hidato que s'ha carregat a hmc
     */
    protected int hidatoX(){
        return hmc.getTempSizeX();
    }
    
    /*
     * Getter del nombre de columnes del hidato que s'ha carregat a hmc
     */
    protected int hidatoY(){
        return hmc.getTempSizeY();
    }
    
    /*
     * Dibuixa el hidato carregat a hmc a la pantalla. Primer posa els tipus de
     * cel·les i després crea un thread que posa els números
     */
    protected void dibuixarHidato() {
        int N = hidatoX();
        int M = hidatoY();
        jPanel2.removeAll();
        jPanel2.updateUI();
        int maxim, N1, N2, M1, M2;
        maxim = Math.max(N,M); 
        N1 = (maxim-N)/2;
        N2 = N + N1;
        M1 = (maxim-M)/2;
        M2 = M + M1;
        jPanel2.setLayout(new GridLayout(maxim, maxim));
        panels = new ArrayList<>();
        int valMin = 1;
        int valMax = 1;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (valMax < getVal(i, j)) valMax = getVal(i, j);
            }
        }
        for (int i0 = 0; i0 < maxim; ++i0) {
            panels.add(new ArrayList<>());
            for (int j0 = 0; j0 < maxim; ++j0) {
                if (N1 <= i0 && i0 < N2 && M1 <= j0 && j0 < M2) {
                    int i = i0-N1, j = j0-M1;
                    CapaDomini.Tauler.Type type = getType(i,j);
                    //CapaDomini.Tauler.Type type = hmc.getTempCellType(i,j);
                    Color c = Colors.c(1);
                    if (getVal(i, j) == valMin || getVal(i, j) == valMax) c = Colors.c(3);
                    SquareCellRapida p = new SquareCellRapida(0,type,Colors.c(2),c,Colors.c(0), 400/maxim*5/10);
                    jPanel2.add(p, i0*maxim+j0);
                    panels.get(i0).add(p);
                }
                else {
                    JPanel p = new JPanel();
                    jPanel2.add(p,i0*maxim+j0);
                    panels.get(i0).add(null);
                }
            }
        }
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                seguir = true;
                for (int i0 = 0; i0 < maxim; ++i0) {
                    for (int j0 = 0; j0 < maxim; ++j0) {
                        if (N1 <= i0 && i0 < N2 && M1 <= j0 && j0 < M2) {
                            int i = i0-N1, j = j0-M1;
                            if (!seguir) return;
                            try {
                                setVal(i,j,i0,j0);
                            }
                            catch(Exception e) {}
                        }
                    }
                }
            }
        });
        t.start();
    }
    
    /*
     * Mostra un missatge d'error amb la informació text
     */
    protected void msgError(String text) {
        JOptionPane.showMessageDialog(this,text,"Error",JOptionPane.ERROR_MESSAGE);
    }
}
