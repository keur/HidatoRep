package domini;
/**
 * Utility class providing added functionality to classes Cell, Hidato 
 * @author felix.axel.gimeno
 * @since 2015-11-14
 * @see Cell
 * @see Hidato
 */
public final class Utils {

    private Utils() {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param myCell Cell to get value from
     * @return value of the cell, except if its type is VOID, then -1
     */
    public static int toInt(final Cell myCell) {
        if (Type.VOID == myCell.getType()) {
            return -1;
        }
        return myCell.getVal();
    }
    /**
     *
     * @param myCell Cell to get value from
     * @return value of the cell, except if its type is VOID, then -1
     */
    public static int toIntZero(final Cell myCell) {
        if (Type.VOID == myCell.getType()) {
            return -1;
        }
        if (Type.BLANK == myCell.getType()){return 0;}
        return myCell.getVal();
    }
    /**
     * converts cell to string for printing purposes 
     * 
     * @param myCell Cell to get string from
     * @return string of the value of myCell
     */
    public static String toString(final Cell myCell) {
        return Integer.toString(Utils.toInt(myCell));
    }

    /**
     * functionality for solver,
     * <p>
     * for the solver, a blank modified by the user should become a given cell
     * @param myCell modified, if blank and value != 0, then becomes given
     */
    public static void blankToGiven(final Cell myCell) {
        if (myCell.getType() == Type.BLANK && myCell.getVal() != 0) {
            myCell.setType(Type.GIVEN);
        }
    }

    /**
     *
     * @param otherCell cell to copy
     * @return cell copyed
     */
    public static Cell copy(final Cell otherCell) {
        Cell myCell = new Cell();
        myCell.setType(otherCell.getType());
        myCell.setVal(otherCell.getVal());
        return myCell;
    }

    /**
     * reset cell
     * 
     * @param myCell modified, if BLANK, its value becomes zero 
     */
    public static void toZero(final Cell myCell) {
        if (myCell.getType() == Type.BLANK) {
            myCell.setVal(0);
        }
    }

    /**
     *  Hidato to String, for printing purposes
     * 
     * @param hidato unmodified
     * @return String of concatenation of every cell
     */
    public static String toString(final Hidato hidato) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < hidato.getSizeX(); i += 1) {
            for (int j = 0; j < hidato.getSizeY(); j += 1) {
                ret.append(String.format("%2d ", Utils.toInt(hidato.getCell(i, j))));
            }
            ret.append('\n');
        }
        return ret.toString();
    }

    /**
     * reset hidato
     * @param hidato modified, every BLANK Cell to value zero
     */
    public static void clean(final Hidato hidato) {
        for (int i = 0; i < hidato.getSizeX(); i += 1) {
            for (int j = 0; j < hidato.getSizeY(); j += 1) {
                Utils.toZero(hidato.getCell(i, j));
            }
        }
    }
    
    /**
     *  Hidato to String, for printing purposes
     * 
     * @param hidato unmodified
     * @return String of concatenation of every cell
     */
    public static String toStringWithZeros(final Hidato hidato) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < hidato.getSizeX(); i += 1) {
            for (int j = 0; j < hidato.getSizeY(); j += 1) {
                ret.append(String.format("%2d ", Utils.toIntZero(hidato.getCell(i, j))));
            }
            ret.append('\n');
        }
        return ret.toString();
    }
}
