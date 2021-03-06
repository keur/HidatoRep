/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacio;

import CapaDomini.Misc.Fonts;
import CapaDomini.Partida.CurrentGameController;
import CapaDomini.Partida.GameManagerController;
import CapaDomini.Partida.Help;
import CapaDomini.Tauler.HidatoManagerController;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Classe que consisteix en el menú principal del programa
 * @author David
 */
public class FrameMenu extends javax.swing.JFrame {
    
    /*
     * Constructora amb parametres
     */
    public FrameMenu(AdminVistes parent, HidatoManagerController hmc, GameManagerController gmc, String name) {
        this.parent = parent;
        this.hmc = hmc;
        this.gmc = gmc;
        initComponents();
        inici(name);
        if (name.equals("Convidat")) fesConvidat();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        b_jugar = new javax.swing.JButton();
        b_crear = new javax.swing.JButton();
        b_ranking = new javax.swing.JButton();
        b_perfil = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        spin_files = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        spin_columnes = new javax.swing.JSpinner();
        b_editar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        b_jugar_g = new javax.swing.JButton();
        b_continuar = new javax.swing.JButton();
        b_jugar_a = new javax.swing.JButton();
        box_ajuda = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú principal");
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 144)); // NOI18N
        jLabel1.setText("Hidato");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("Benvingut ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        b_jugar.setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 18));
        b_jugar.setText("Jugar");

        b_crear.setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 18));
        b_crear.setText("Crear");

        b_ranking.setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 18));
        b_ranking.setText("Ranking");

        b_perfil.setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 18));
        b_perfil.setText("Perfil");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b_jugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(b_crear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(b_ranking, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
            .addComponent(b_perfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(b_jugar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_crear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_ranking, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 18));
        jLabel3.setText("Escull la mida del hidato:");

        spin_files.setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 18));

        jLabel5.setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 18));
        jLabel5.setText("nº de files:");

        jLabel6.setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 18));
        jLabel6.setText("nº de columnes:");

        spin_columnes.setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 18));

        b_editar.setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 18));
        b_editar.setText("Comença a editar!");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(b_editar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 20, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spin_files)
                                    .addComponent(spin_columnes))))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spin_files, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spin_columnes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_editar)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        b_jugar_g.setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 18));
        b_jugar_g.setText("Jugar hidato guardat");

        b_continuar.setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 18));
        b_continuar.setText("Continuar partida");

        b_jugar_a.setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 18));
        b_jugar_a.setText("Jugar aleatori");

        box_ajuda.setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 18));
        box_ajuda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Baix", "Mitjà", "Alt" }));

        jLabel4.setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 18));
        jLabel4.setText("Nivell d'ajuda:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b_jugar_g, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(b_continuar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(b_jugar_a, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(box_ajuda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(b_jugar_g, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_continuar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_jugar_a, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(box_ajuda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
     * Funció que es duu a terme quan es va a tancar el formulari.
     * Guarda tot abans de tancar.
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        parent.saveBeforeClose();
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_continuar;
    private javax.swing.JButton b_crear;
    private javax.swing.JButton b_editar;
    private javax.swing.JButton b_jugar;
    private javax.swing.JButton b_jugar_a;
    private javax.swing.JButton b_jugar_g;
    private javax.swing.JButton b_perfil;
    private javax.swing.JButton b_ranking;
    private javax.swing.JComboBox box_ajuda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSpinner spin_columnes;
    private javax.swing.JSpinner spin_files;
    // End of variables declaration//GEN-END:variables

    
    /*
     * Controlador GameManagerController
     */
    private final GameManagerController gmc;
    
    /*
     * Controlador HidatoManagerController
     */
    private final HidatoManagerController hmc;
    
    /*
     * Controlador AdminVistes per fer canvis de vista
     */
    private final AdminVistes parent;
    
    /*
     * Objecte per fer les animacions
     */
    private Animacio anim;
    
    /*
     * Posicions inicials (a) i finals (b) dels panels (jPanel3, jPanel4 i
     * jPanel5) que s'han de moure en les animacions
     */
    private Point p3a, p3b, p4a, p4b, p5a, p5b;
    
    /*
     * Funció que es duu a terme al crear la vista
     * Configura els botons (font, text, listeners) i altres components
     * Prepara les animacions
     */
    public void inici(String name) {
        
        setIconImage((new ImageIcon("icon.png")).getImage());
        jLabel1.setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 144));
        jLabel2.setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 36));
        jLabel2.setText("Benvingut "+name);
        
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent evt) {
                picarBoto((JButton) evt.getSource());
            }
        };
        b_jugar.addActionListener(al);
        b_crear.addActionListener(al);
        b_ranking.addActionListener(al);
        b_perfil.addActionListener(al);
        b_editar.addActionListener(al);
        b_jugar_g.addActionListener(al);
        b_continuar.addActionListener(al);
        b_jugar_a.addActionListener(al);
        
        int min_files = 2;
        int max_files = 25;
        int min_columnes = 2;
        int max_columnes = 25;
        spin_files.setValue(8);
        spin_columnes.setValue(8);
        spin_files.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged (ChangeEvent evt) {
                if ((Integer)spin_files.getValue() < min_files) {
                    spin_files.setValue(min_files);
                }
                else if ((Integer)spin_files.getValue() > max_files) {
                    spin_files.setValue(max_files);
                }
            }
        });
        spin_columnes.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged (ChangeEvent evt) {
                if ((Integer)spin_columnes.getValue() < min_columnes) {
                    spin_columnes.setValue(min_columnes);
                }
                else if ((Integer)spin_columnes.getValue() > max_columnes) {
                    spin_columnes.setValue(max_columnes);
                }
            }
        });
        
        
        p3a = new Point(305,11);
        p3b = new Point(150,11);
        p4a = new Point(900,11);
        p4b = new Point(350,11);
        p5a = new Point(900,20);
        p5b = new Point(350,20);
        
        anim = new Animacio(1);
        anim.addElement(jPanel3);
        anim.setPoint(0, p3a);
        anim.addElement(jPanel4);
        anim.setPoint(1, p4a);
        anim.addElement(jPanel5);
        anim.setPoint(2, p5a);
        
    }
    
    /*
     * Accions a dur a terme quan hem entrat en mode convidat
     * (prohibir crear, entrar a perfil, i continuar partida guardada)
     */
    private void fesConvidat() {
        b_crear.setEnabled(false);
        b_perfil.setEnabled(false);
        b_continuar.setEnabled(false);
    }
    
    /*
     * Funció que s'executa quan es pitja algun boto. Segons el botó fa unes
     * accions o unes altres.
     * Jugar i Crear inicien animacions per mostrar els seus panels.
     * Ranking i Perfil obren les vistes corresponents.
     * Jugar hidato guardat i continuar partida guardada obren una llista per
     * escollir hidato/partida.
     * Jugar hidato aleatori obre una partida amb un hidato aleatori de nxm on
     * n i m són aleatoris entre 5 i 9
     * Crear obre l'editor amb un hidato buit de la mida indicada en els 
     * spinners
     * Les partides s'obren amb el nivell d'ajuda del comboBox
     */
    private void picarBoto(JButton b) {
        if (b.equals(b_jugar)) {
            anim.setVel(10);
            anim.setPoint(0, p3b);
            anim.setPoint(1, p4a);
            anim.setPoint(2, p5b);
        }
        else if (b.equals(b_crear)) {
            anim.setVel(10);
            anim.setPoint(0, p3b);
            anim.setPoint(1, p4b);
            anim.setPoint(2, p5a);
        }
        else if (b.equals(b_ranking)) {
            anim.setPoint(0, p3a);
            parent.obrirRanking(this);
        }
        else if (b.equals(b_perfil)) {
            anim.setPoint(0, p3a);
            parent.obrirStats(this);
        }
        else if (b.equals(b_editar)) {
            int files = (Integer)spin_files.getValue();
            int columnes = (Integer) spin_columnes.getValue();
            hmc.createRandom(files, columnes);
            parent.obrirEditor(this);
        }
        else if (b.equals(b_jugar_g)) {
            if (hmc.getAllHidatoList().isEmpty()) {
                msgError("No existeix cap hidato al repositori");
            }
            else {
                obrirLlistaHidatos();
            }
        }
        else if (b.equals(b_continuar)) {
            if (gmc.getGameList().isEmpty()) {
                msgError("No hi ha cap partida guardada");
            }
            else {
                obrirLlistaPartides();
            }
        }
        else if (b.equals(b_jugar_a)) {
            Random rand = new Random();
            int x = rand.nextInt(4)+5;
            int y = rand.nextInt(4)+5;
            hmc.createRandom(x, y);
            CurrentGameController cgc = hmc.playTempHidato(getHelp());
            parent.obrirPartida(this,cgc);
        }
    }
    
    /*
     * Funció que es crida quan la llista de Hidatos retorna una String
     * boardname per jugar. Obre la vista de partida amb el hidato boardname
     */
    private void jugarHidato (String boardname) {
        if (boardname == null) {
            this.setVisible(true);
            anim.setVel(1);
        }
        else {
            CurrentGameController cgc = gmc.createGameFromBoardName(null, boardname, getHelp());
            parent.obrirPartida(this, cgc);
        }
    }
    
    /*
     * Funció que es crida quan la llista de partides retorna una String
     * gameName per jugar. Obre la vista de partida amb la partida que toca
     */
    private void jugarPartida (String gameName) {
        if (gameName == null) {
            this.setVisible(true);
            anim.setVel(1);
        }
        else {
            CurrentGameController cgc = gmc.restoreGame(gameName);
            if (cgc == null){
                msgError("No s'ha pogut carregar la partida");
            }else{
                parent.obrirPartida(this, cgc);
            }
        }
    }
    
    /*
     * Retorna el nivell d'ajuda escollit en box_ajuda
     */
    private Help getHelp () {
        Help h;
        if (box_ajuda.getSelectedIndex() == 0) h = Help.LOW;
        else if (box_ajuda.getSelectedIndex() == 1) h = Help.MEDIUM;
        else h = Help.HIGH;
        return h;
    }
    
    /*
     * Crea la vista de llista de hidatos, i li carrega tots els hidatos
     * guardats. Crea l'objecte amb els mètodes a fer quan aquesta faci alguna
     * acció, dels quals només retorna fa alguna cosa (cridar a jugarHidato)
     */
    private void obrirLlistaHidatos() {
        FrameLlista fll = new FrameLlista(new RetornadorString() {
            @Override
            public void retorna(String s) {
                jugarHidato(s);
            }
            @Override
            public void elimina(String s) {}
            @Override
            public void canviaNom(String s1, String s2){}
        }, hmc);
        fll.setLocation(this.getLocation());
        fll.loadHidatosTots();
        fll.setVisible(true);
        this.setVisible(false);
    }
    
    /*
     * Crea la vista de llista de partides, i li carrega les partides de
     * l'usuari. Crea l'objecte amb els mètodes a fer quan aquesta faci alguna
     * acció, dels quals actuen retorna (que crida a jugarHidato), i elimina
     * (que crida deleteGame)
     */
    private void obrirLlistaPartides() {
        FrameLlistaPartides flp = new FrameLlistaPartides(new RetornadorString() {
            @Override
            public void retorna(String s) {
                jugarPartida(s);
            }
            @Override
            public void elimina(String s) {
                deleteGame(s);
            }
            @Override
            public void canviaNom(String oldName, String newName){}
        }, gmc, hmc);
        flp.setLocation(this.getLocation());
        flp.loadPartidesUsuari();
        flp.setVisible(true);
        this.setVisible(false);
    }
    
    /*
     * Esborra la partida amb nom name de l'usuari loggejat
     */
    private void deleteGame(String name) {
        gmc.deleteGame(name);
        Object[] myList = gmc.getGameList().toArray();
        if (myList.length > 0) {
            obrirLlistaPartides();
        }
        else {
            this.setVisible(true);
        }
    }

    /*
     * Mostra un missatge d'error amb la informació text
     */
    private void msgError(String text) {
        JOptionPane.showMessageDialog(this,text,"On vas flipat!",JOptionPane.ERROR_MESSAGE);
    }
}