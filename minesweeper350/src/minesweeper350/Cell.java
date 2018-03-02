package minesweeper350;

/**
 * 
 * All values and booleans instantiated.
 *
 */

public class Cell {
    private int mineCount;
    private boolean isFlagged;
    private boolean isExposed;
    private boolean isMine;
    public int notExposed = 100;

    /**
     * Constructor that instantiates a cell's current state.
     * 
     * @param mineCount
     * @param isFlagged
     * @param isExposed
     * @param isMine
     */
    public Cell(int mineCount, boolean isFlagged, boolean isExposed, boolean isMine) {
        this.mineCount = mineCount;
        this.isFlagged = isFlagged;
        this.isExposed = isExposed;
        this.isMine = isMine;

    }

    /**
     * sets mine Count for the game.
     * 
     * @param mineCount
     */
    public void setMineCount(int mineCount) {
        this.mineCount = mineCount;
    }

    /**
     * returns the mine count for the game
     * 
     * @return
     */
    public int getMineCount() {
        return mineCount;
    }

    /**
     * sets a mine at current cell when called
     * 
     * @param isMine
     */
    public void setMine(boolean isMine) {
        this.isMine = isMine;
    }

    /**
     * sets the current cell as exposed.
     * 
     * @param isExposed
     */
    public void setExposed(boolean isExposed) {
        this.isExposed = isExposed;
        notExposed--;
    }

    /**
     * sets the cell as flagged.
     * 
     * @param isFlagged
     */
    public void setFlagged(boolean isFlagged) {
        this.isFlagged = isFlagged;
    }

    /**
     * checks to see if the cell is flagged.
     * 
     * @return
     */
    public boolean isFlagged() {
        return isFlagged;
    }

    /**
     * checks to see if the cell is exposed.
     * 
     * @return
     */
    public boolean isExposed() {
        return isExposed;
    }

    /**
     * checks to see if the cell is a mine.
     * 
     * @return
     */
    public boolean isMine() {
        return isMine;
    }

    /**
     * returns number of not exposed cells.
     * 
     * @return
     */
    public int notExposed() {
        return notExposed;
    }

}
