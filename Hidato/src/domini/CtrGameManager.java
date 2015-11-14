package domini;
//lin 49
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Controlador de totes les partides. Quan la vista vol crear/recuperar una partida,
 * aquest controlador li proporciona el controlador de partida corresponent. Hi ha
 * un d'aquests controladors per cada usuari loguejat -> si es fa logout i login
 * amb un altre usuari, s'ha de crear un altre objecte CtrGameManager
 * @author Pau Surrell
 */

public class CtrGameManager {
    /**
     * Declara els parametres i controladors de la classe
     */
    private final HidatoSet hidatoSet;
    private final User loggedUser;
    private final CtrDBGame ctrDBGame;
    private final Solver solver;
    private final CtrRanking ctrRanking;
    
    /**
     * Creadora del controlador
     */
    public CtrGameManager(HidatoSet hidatoSet, User loggedUser, CtrDBGame ctrDBGame, Solver solver, CtrRanking ctrRanking){
        this.hidatoSet = hidatoSet;
        this.loggedUser = loggedUser;
        this.ctrDBGame = ctrDBGame;
        this.solver = solver;
        this.ctrRanking = ctrRanking;
    }
    
    /**
     * Crea una partida
     * @param name Nom de la partida
     * @param hidatoName Nom del tauler sobre el qual es crea la partida
     * @param help Nivell d'ajuda
     * @return el controlador de la partida creada
     */
    
    public CtrCurrentGame createGame(String name, String hidatoName, Help help){
        Hidato hidato = hidatoSet.getHidatoByName(hidatoName);
        Game game = new Game(name, hidato, loggedUser, help, hidato.getDifficult());
        CtrCurrentGame ctrCurrentGame = new CtrCurrentGame(game, ctrDBGame, solver,ctrRanking);
        //treure ctrHidato
        return ctrCurrentGame;
    }
    /**
     * Recupera una partida que s'havia guardat amb nom 'name'
     * @return el controlador de la partida recuperada
     */
    public CtrCurrentGame restoreGame(String name){
        Game game = ctrDBGame.getGame(name, loggedUser);
        ctrDBGame.deleteGame(name, loggedUser);
        CtrCurrentGame ctrCurrentGame = new CtrCurrentGame(game, ctrDBGame, solver, ctrRanking);
        return ctrCurrentGame;
    }
    
    /**
     * Elimina la partida del repositori amb nom 'name' i usuari 'loggedUser'
     * @return 0
     */
    
    public int deleteGame(String name){
        ctrDBGame.deleteGame(name, loggedUser);
        return 0;
    }
}