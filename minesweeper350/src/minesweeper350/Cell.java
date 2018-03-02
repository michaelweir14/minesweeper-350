package minesweeper350;

/**
 * 
 * All values and booleans instantiated.
 *
 */

public class Cell {
    
    /** Total mine count. */
    private int mineCount;
    
    /** If cell is flagged. */
    private boolean isFlagged;
    
    /** If cell is exposed. */
    private boolean isExposed;
    
    /** If cell is a mine. */
    private boolean isMine;
    
    /** Number of cells not exposed. */
    private int notExposed = 100;

    /**
     * Constructor that instantiates a cell's current state.
     * 
     * @param mineCount Total mines.
     * @param isFlagged If flagged.
     * @param isExposed If exposed.
     * @param isMine If a mine.
     */
    public Cell(final int mineCount, final boolean isFlagged, 
            final boolean isExposed, final boolean isMine) {
        this.mineCount = mineCount;
        this.isFlagged = isFlagged;
        this.isExposed = isExposed;
        this.isMine = isMine;

    }

    /**
     * sets mine Count for the game.
     * 
     * @param mineCount Total mine.
     */
    public void setMineCount(final int mineCount) {
        this.mineCount = mineCount;
    }

    /**
     * returns the mine count for the game.
     * 
     * @return mineCount.
     */
    public int getMineCount() {
        return mineCount;
    }

    /**
     * sets a mine at current cell when called.
     * 
     * @param isMine If a mine.
     */
    public void setMine(final boolean isMine) {
        this.isMine = isMine;
    }

    /**
     * sets the current cell as exposed.
     * 
     * @param isExposed If exposed.
     */
    public void setExposed(final boolean isExposed) {
        this.isExposed = isExposed;
        notExposed--;
    }

    /**
     * sets the cell as flagged.
     * 
     * @param isFlagged If flagged.
     */
    public void setFlagged(final boolean isFlagged) {
        this.isFlagged = isFlagged;
    }

    /**
     * checks to see if the cell is flagged.
     * 
     * @return isFlagged
     */
    public boolean isFlagged() {
        return isFlagged;
    }

    /**
     * checks to see if the cell is exposed.
     * 
     * @return isExposed
     */
    public boolean isExposed() {
        return isExposed;
    }

    /**
     * checks to see if the cell is a mine.
     * 
     * @return isMine
     */
    public boolean isMine() {
        return isMine;
    }

    /**
     * returns number of not exposed cells.
     * 
     * @return notExposed
     */
    public int notExposed() {
        return notExposed;
    }

}
