package domini.Tauler;

import domini.Partida.Difficulty;
import domini.Misc.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * @author David
 * 
 */

public class GeneratorController {
    
    private Hidato h;
    private int n, m;
    private int iter, val_ref;
    private int D[][];
    private Position L[];
    private int nextGiven[];
    private int totalCaselles;
    private boolean controlarPart;
    
    /**
     * Pre: sizeX, sizeY >= 0
     * Post: crea una instancia de HidatoGenerator que partira d'un hidato buit
    */
    public GeneratorController(int sizeX, int sizeY) {
        this.h = new Hidato(sizeX, sizeY);
        n = sizeX;
        m = sizeY;
        h.getCell(0,0).setVal(0);
        h.getCell(n-1, m-1).setVal(0);
        h.getCell(randomNum(0,n-1), randomNum(0,m-1)).setVal(1);
        totalCaselles = sizeX*sizeY;
    }
    
    /**
     * Pre: h != null
     * Post: crea una instancia de HidatoGenerator que partira del hidato h
     *  h s'interpreta de la manera seguent:
     *      * si el valor d'una casella es 0 es que hi pot anar qualsevol nombre
     *      * si el valor d'una casella no es 0, hi ha d'anar aquell nombre
     *      * si el tipus d'una casella es VOID, haura de ser VOID
     *      * si el tipus d'una casella es GIVEN, haura de ser GIVEN
     *      * si el tipus d'una casella es BLANK, sera BLANK o GIVEN, depenent
     *        de si cal donar mes nombres inicials per satisfer la dificultat
    */
    public GeneratorController(Hidato h) {
        this.h = new Hidato(h);
        n = h.getSizeX();
        m = h.getSizeY();
        comptaCaselles();
    }
    
    /**
     * Pre: cert
     * Post: retorna el hidato generat amb dificultat difficulty
     *  retorna null si no hi ha casella inicial, o si es impossible de generar
    */
    public Hidato generateHidato(Difficulty difficulty) {
        controlarPart = true;
        if (hidatoValid() == false) return null;
        if (completarCami() == false) {
            controlarPart = false;
            if (completarCami() == false) return null;
        }
        posarPistes(difficulty);
        return h;
    }
    
    
    private boolean backtracking (int val, Position p) {
        if (massaLluny(val,p)) return false;
        L[val-1] = p;
        if (val == totalCaselles) return true;
        if (controlarPart) {
            if (!controlParticionament(val)) return false;
        }
        Position veiObligat = buscaVeiObligat(val, p);
        if (veiObligat != null) return backtracking(val+1, veiObligat);
        LinkedList<Position> veins = buscaVeins(p);
        if (veins.size() == 0) return false;
        int random;
        if (probabilitatCamiSegur()) {
            veins.sort((p1, p2) -> D[p1.getX()][p1.getY()] - D[p2.getX()][p2.getY()]);
            random = 0;
        }
        else random = randomNum(0,veins.size()-1);
        for (int i = 0; i < veins.size(); ++i) {
            Position next = veins.get((i+random)%veins.size());
            int antVal = GC(next.getX(),next.getY());
            SC(next.getX(),next.getY(),val+1);
            sumarVoltantD(next.getX(),next.getY(),-1);
            boolean result = backtracking(val+1,next);
            if (result) return true;
            sumarVoltantD(next.getX(),next.getY(),1);
            SC(next.getX(),next.getY(),antVal);
            if (val_ref != 0) {
                if (val > val_ref*1/2) return false;
                if (particionat(val)) {
                    val_ref = val;
                    return false;
                }
                val_ref = 0;
            }
        }
        return false;
    }
    
    private Position buscaCasellaInicial() {
        for (int i = 0; i < n; ++i){
            for (int j = 0; j < m; ++j) {
                if (h.getCell(i,j).getVal() == 1) return new Position(i,j);
            }
        }
        return null;
    }
    
    private LinkedList<Position> buscaVeins(Position p) {
        LinkedList<Position> ret = new LinkedList<>();
        for (int i = Math.max(p.getX()-1, 0); i <= Math.min(p.getX()+1, n-1); ++i) {
            for (int j = Math.max(p.getY()-1, 0); j <= Math.min(p.getY()+1, m-1); ++j) {
                if (i == p.getX() && j == p.getY()) continue;
                if (GC(i,j) == 0 && !h.getCell(i,j).getType().equals(Type.VOID)) {
                    ret.addLast(new Position(i,j));
                }
            }
        }
        return ret;
    }
    
    private Position buscaVeiObligat(int val, Position p) {
        for (int i = Math.max(p.getX()-1, 0); i <= Math.min(p.getX()+1, n-1); ++i) {
            for (int j = Math.max(p.getY()-1, 0); j <= Math.min(p.getY()+1, m-1); ++j) {
                if (i == p.getX() && j == p.getY()) continue;
                if (GC(i,j) == val+1 && h.getCell(i,j).getType() != Type.VOID) {
                    return new Position(i,j);
                }
            }
        }
        return null;
    }
    
    private int calculaNumPistes(Difficulty difficulty) {
        if (difficulty == Difficulty.EASY) return totalCaselles/3;
        else if (difficulty == Difficulty.MEDIUM) return totalCaselles/4;
        return totalCaselles/5;
    }
    
    private boolean completarCami() {
        Position casellaInicial = buscaCasellaInicial();
        if (casellaInicial == null) return false;
        L = new Position[totalCaselles];
        omplirD();
        omplirNextGivenIL();
        iter = 0;
        val_ref = 0;
        return backtracking(1, casellaInicial);
    }
    
    private void comptaCaselles() {
        totalCaselles = 0;
        for (int i = 0; i < h.getSizeX(); ++i) {
            for (int j = 0; j < h.getSizeY(); ++j) {
                if (h.getCell(i,j).getType() != Type.VOID) ++totalCaselles;
            }
        }
    }
    
    private boolean controlParticionament(int val) {
        if (++iter == 30) {
            iter = 0;
            if (particionat(val-1)) {
                val_ref = val;
                return false;
            }
        }
        return true;
    }
    
    private int GC (int i, int j) {
        return h.getCell(i, j).getVal();
    }
    
    /** comprova que cada numero apareixi com a molt un cop, que no estigui
     * particionat, i que els numeros estiguin dins del rang
     */
    private boolean hidatoValid() {
        if (particionat(0)) return false;
        ArrayList<Integer> aparicions = new ArrayList<>();
        for (int i = 0; i < totalCaselles; ++i) aparicions.add(0);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (h.getCell(i,j).getType() == Type.VOID) continue;
                if (h.getCell(i,j).getVal() == 0) continue;
                int valor = h.getCell(i,j).getVal()-1;
                if (valor < 0 || valor >= totalCaselles) return false;
                aparicions.set(valor, aparicions.get(valor)+1);
            }
        }
        for (int i = 0; i < totalCaselles; ++i) {
            if (aparicions.get(i) > 1) return false;
        }
        return true;
    }
    
    private boolean massaLluny(int val, Position p) {
        int valNextGiven = nextGiven[val-1];
        if (valNextGiven == 0) return false;
        return (Position.distance(p, L[valNextGiven-1]) > valNextGiven-val);
    }
    
    private void omplirD () {
        D = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if(GC(i,j) == 0) sumarVoltantD(i,j,1);
            }
        }
    }
    
    private void omplirNextGivenIL() {
        nextGiven = new int[totalCaselles];
        ArrayList<Integer> donats = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (h.getCell(i,j).getType() == Type.VOID) continue;
                int valor = h.getCell(i, j).getVal();
                if (valor != 0) {
                    donats.add(valor);
                    L[valor-1] = new Position(i,j);
                }
            }
        }
        for (int i = 0; i < donats.size(); ++i) {
            int valor = donats.get(i);
            int j = valor-1;
            while (nextGiven[j] == 0 || nextGiven[j] > valor) {
                nextGiven[j] = valor;
                if (--j < 0) break;
            }
        }
    }
    
    private boolean particionat(int val) {
        if (val >= totalCaselles) return false;
        int x0 = 0, y0 = 0;
        boolean BFS[][] = new boolean[n][m];
        for (int i = 0; i < n; ++i) {
          for (int j = 0; j < m; ++j) {
            BFS[i][j] = true;
            if ((GC(i,j) == 0 || GC(i,j) > val) && !h.getCell(i, j).getType().equals(Type.VOID)) {
              x0 = i; y0 = j;
              BFS[i][j] = false;
            }
          }
        }
        BFS[x0][y0] = true;
        LinkedList<Position> Q = new LinkedList<>();
        Q.addLast(new Position(x0,y0));
        while (Q.size() > 0) {
            int a = Q.getFirst().getX(), b = Q.getFirst().getY();
            for (int i = Math.max(a-1, 0); i <= Math.min(a+1, n-1); ++i) {
                for (int j = Math.max(b-1, 0); j <= Math.min(b+1, m-1); ++j) {
                    if (BFS[i][j] == false) {
                        BFS[i][j] = true;
                        Q.addLast(new Position(i,j));
                    }
                }
            }
            Q.removeFirst();
        }
        boolean part = false;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                part = part || !BFS[i][j];
            }
        }
        return part;
    }
    
    private void posarPistes (Difficulty difficulty) {
        h.getCell(L[0].getX(), L[0].getY()).setType(Type.GIVEN);
        h.getCell(L[totalCaselles-1].getX(), L[totalCaselles-1].getY()).setType(Type.GIVEN);
        int pistesTotals = calculaNumPistes(difficulty);
        int pistesFixades = 0;
        ArrayList<Integer> pistes = new ArrayList<>();
        for (int i = 0; i < totalCaselles; ++i) {
            if (h.getCell(L[i].getX(), L[i].getY()).getType() == Type.BLANK) pistes.add(i);
            else if (h.getCell(L[i].getX(), L[i].getY()).getType() == Type.GIVEN) ++pistesFixades;
        }
        int pistesAddicionals = pistesTotals - pistesFixades;
        for (int i = 0; i < pistesAddicionals; ++i) {
            int j = randomNum(i,pistes.size()-1);
            Integer aux = pistes.get(i);
            pistes.set(i, pistes.get(j));
            pistes.set(j,aux);
            Position p = L[pistes.get(i)];
            h.getCell(p.getX(), p.getY()).setType(Type.GIVEN);
        }
    }
    
    private boolean probabilitatCamiSegur() {
        return randomNum(1,100) <= 40; // probabilitat del 40%
    }
    
    private int randomNum (int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }
    
    private void SC (int i, int j, int val) {
        h.getCell(i, j).setVal(val);
    }
    
    private void sumarValD (int x, int y, int val) {
        if (x >= 0 && x < n && y >= 0 && y < m) D[x][y] += val;
    }
    
    private void sumarVoltantD (int x, int y, int val) {
        for (int i = x-1; i <= x+1; ++i) {
            for (int j = y-1; j <= y+1; ++j) {
                if (i == x && j == y) continue;
                    sumarValD(i, j, val);
              }
          }
    }
    
}