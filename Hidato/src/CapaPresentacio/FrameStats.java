package CapaPresentacio;

import CapaDomini.Misc.Fonts;
import CapaDomini.Tauler.HidatoManagerController;
import CapaDomini.Usuari.HidatoUserController;
import CapaDomini.Usuari.UserController;
import CapaDomini.Usuari.UserStatsController;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Profile management use case
 * <p>
 * To use do: new FrameStats(uc,hmc).setVisible(true); where uc is a valid
 * usercontroller
 *
 * @author felix.axel.gimeno
 * @version 0.31
 * @since 05-12-2015
 */
@SuppressWarnings("serial")
public class FrameStats extends javax.swing.JFrame {

    private final static Integer sizeX = 800;
    private final static Integer sizeY = 600;
    private final static Font myFont = Fonts.getFont("OpenSans-Light", Font.PLAIN, 18);

    private static String convertToMultiline(final String orig) {
        return "<html>" + orig.replaceAll("\n", "<br>") + "</html>";
    }

    private static String convertToString(String[] myArray) {
        String ret = "";
        for (String s : myArray) {
            ret = ret.concat(s).concat("\n\n");
        }
        return ret;
    }

    private static String[] getStats(final HidatoUserController uc) {
        UserStatsController usc = uc.getStatsController();
        String[] ret = new String[]{"Estadístiques de " + usc.getUsername(),
            "Hidatos resolts: " + String.valueOf(usc.getSolvedGames()),
            "Percentatge de resolts: ",
            "Puntuació mitjana: ",
            "Puntuació màxima en un hidato: ",
            "Temps de resolució mitjà: ",
            "Resolució més ràpida d'un hidato: ",
            "Hidatos creats: " + String.valueOf(usc.getTotalCreatedBoards())
        };
        if (usc.getSolvedGames() != 0) {
            ret[2] += String.valueOf(usc.getSolvedPercentage()) + "%";
            ret[3] += String.valueOf(usc.getAverageScore()) + " punts";
            ret[4] += String.valueOf(usc.getBestScore()) + " punts";
            ret[5] += String.valueOf(usc.getAverageTimePerSolve()/60) + " minuts, " + 
                usc.getAverageTimePerSolve()%60 + " segons";
            ret[6] += String.valueOf(usc.getBestTime()/60) + " minuts, " + 
                String.valueOf(usc.getBestTime()%60) + " segons";
        }
        else {
            ret[2] += "--"; ret[3] += "--"; ret[4] += "--"; ret[5] += "--"; ret[6] += "--";
        }
        return ret;
    }

    private static javax.swing.JButton createButton(final String text, final java.awt.event.ActionListener l) {
        javax.swing.JButton myButton = new javax.swing.JButton(text);
        myButton.setFont(myFont);
        myButton.addActionListener(l);
        return myButton;
    }

    private static String askPassword(javax.swing.JFrame myFrame, String extra) {
        javax.swing.JPanel panel = new javax.swing.JPanel();
        javax.swing.JLabel label = new javax.swing.JLabel("Introdueix contrasenya " + extra + " :");
        javax.swing.JPasswordField pass = new javax.swing.JPasswordField(20);
        panel.add(label);
        panel.add(pass);
        String[] options = new String[]{"OK", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panel, null,
                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[1]);
        if (0 == option) {
            return new String(pass.getPassword());
        }
        return null;
    }

    private static void buttonDeleteActionPerformed(javax.swing.JFrame myJFrame, final UserController uc) {
        String Password = FrameStats.askPassword(myJFrame, "actual \ni pressiona ok per borrar l'usuari, \npressiona cancel per cancelar");
        Boolean truePass = uc.getLoggedUser().getPassword().equals(Password);
        if (truePass) {
            uc.deleteUser(Password);
            JOptionPane.showMessageDialog(myJFrame, "Usuari borrat", "Usuari borrat", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        } else if (null != Password) {
            JOptionPane.showMessageDialog(myJFrame, "Contrasenya incorrecta", "Contrasenya incorrecta", JOptionPane.ERROR_MESSAGE);
        }
    }
    private HidatoManagerController hmc;
    private CapaDomini.Domini parent;
    private String hidatoName;

    private FrameStats() {
        throw new UnsupportedOperationException();
    }

    public FrameStats(CapaDomini.Domini parent, final HidatoUserController uc, HidatoManagerController hmc) {
        super("Gestió del perfil de l'usuari");
        this.parent = parent;
        this.hmc = hmc;
        this.parent = parent;
        this.initComponents(uc);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                parent.saveBeforeClose();
            }
        });
    }

    private void buttonModifyPasswordActionPerformed(final UserController uc) {
        String OldPassword = FrameStats.askPassword(this, "actual");
        Boolean truePass = uc.getLoggedUser().getPassword().equals(OldPassword);
        if (truePass) {
            String NewPassword = FrameStats.askPassword(this, "nova");
            if (null != NewPassword) {
                uc.modifyPassword(OldPassword, NewPassword);
                JOptionPane.showMessageDialog(this, "Contraseña canviada", "Contraseña canviada", JOptionPane.PLAIN_MESSAGE);
            }

        } else if (null != OldPassword) {
            JOptionPane.showMessageDialog(this, "Contraseñya incorrecta", "Contraseñya incorrecta", JOptionPane.ERROR_MESSAGE);
        }

    }

    private Object[] getHidatos(final UserController uc) {
        String[] ret = hmc.getUserHidatoList().toArray(new String[]{});
        return ret;
    }

    private void buttonSelectHidatoToEditActionPerformed(final UserController uc) {
        Object[] myList = getHidatos(uc);
        if (myList.length > 0) {
            //                            FELIX NO HAGAS LO DE LA LAMBDA AQUÍ
            FrameLlista fll = new FrameLlista(new RetornadorString() {
                public void retorna(String s) {
                    openSelectedHidato(s);
                }
            }, hmc);
            fll.setLocation(this.getLocation());
            fll.loadHidatosUsuari();
            fll.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "No hidatos trobats", "L'usuari no te hidatos guardats", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openSelectedHidato(String hidatoName) {
        if (null != hidatoName && hmc.loadHidato(hidatoName)) {
            parent.obrirEditor(this);
        } else {
            JOptionPane.showMessageDialog(this, "No se ha pogut carregar", "No se ha pogut carregar", JOptionPane.PLAIN_MESSAGE);
        }
    }

    @SuppressWarnings(value = "unchecked")
    private void initComponents(final HidatoUserController uc) {
        javax.swing.JLabel[] myJLabels = new javax.swing.JLabel[8]; //SwingConstants.CENTER is for centering the jlabel text
        String [] text = getStats(uc);
        for (int i = 0; i < 8; ++i) {
            myJLabels[i] = new javax.swing.JLabel(text[i],javax.swing.SwingConstants.CENTER);
            myJLabels[i].setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 18));
        }
        myJLabels[0].setFont(Fonts.getFont("OpenSans-Light", Font.PLAIN, 36));
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setPreferredSize(new java.awt.Dimension(sizeX, sizeY));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        this.getContentPane().setLayout(layout);

        final JButton buttonReturnToMenu = createButton("Volver al Menu", (java.awt.event.ActionEvent evt) -> {
            parent.obrirMenu(this);
        });
        final JButton buttonDelete = createButton("Borrar usuari", (java.awt.event.ActionEvent evt) -> {
            buttonDeleteActionPerformed(this, uc);
        });
        final JButton buttonModifyPassword = createButton("Canviar contrasenya", (java.awt.event.ActionEvent evt) -> {
            buttonModifyPasswordActionPerformed(uc);
        });
        final JButton buttonSelectHidatoToEdit = createButton("Editar hidato guardat", (java.awt.event.ActionEvent evt) -> {
            buttonSelectHidatoToEditActionPerformed(uc);
        });

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER, true)
                        .addComponent(myJLabels[0], javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(myJLabels[1], javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(myJLabels[2], javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(myJLabels[3], javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(myJLabels[4], javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(myJLabels[5], javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(myJLabels[6], javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(myJLabels[7], javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                )
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER, true)
                        .addComponent(buttonReturnToMenu, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonDelete, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonModifyPassword, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonSelectHidatoToEdit, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                )
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonReturnToMenu)
                        .addComponent(buttonDelete)
                        .addComponent(buttonModifyPassword)
                        .addComponent(buttonSelectHidatoToEdit)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(myJLabels[0], javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(myJLabels[1], javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(myJLabels[2], javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(myJLabels[3], javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(myJLabels[4], javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(myJLabels[5], javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(myJLabels[6], javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(myJLabels[7], javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                )
                
        );

        this.pack();
    }

}
