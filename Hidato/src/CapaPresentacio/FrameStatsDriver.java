package CapaPresentacio;

import CapaDomini.Tauler.HidatoManagerController;
import CapaDomini.Tauler.HidatoSet;
import CapaDomini.Usuari.HidatoUser;
import CapaDomini.Usuari.HidatoUserController;

/**
 *
 * @author felix.axel.gimeno
 */
public class FrameStatsDriver {
    public static void main(String[] args){
        final String foo = "fy";
        final String name =  "Hidato->"+foo+"<-1";
        
        java.awt.EventQueue.invokeLater(() -> {
            HidatoUserController huc = new HidatoUserController();
            HidatoSet hs = new HidatoSet(); 
            HidatoManagerController hmc = new HidatoManagerController(hs, null, huc);
            try {
                
                huc.createUser(foo,foo);
                huc.login(foo,foo);
                huc.updateUser();
                
                ((HidatoUser)huc.getLoggedUser()).addHidato(name);
                //((HidatoUser)huc.getLoggedUser()).addHidato("felix");
                CapaDomini.Tauler.Hidato h = new CapaDomini.Tauler.Hidato(5,5);
                h.setBoardName(name);
                hs.addHidato(h);
                System.out.println(hs.getHidatoByName(name));
            } catch (Exception e){
                System.out.println("Couldn't do login");
            }
            
            new FrameStats(new CapaDomini.Domini(), huc, hmc).setVisible(true);
        });    
    
    }
    
}