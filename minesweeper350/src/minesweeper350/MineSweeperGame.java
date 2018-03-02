package minesweeper350;

//import java.awt.Color;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * This class creates the game and all instructions.
 * 
 * @author Michael Weir
 *
 */

public class MineSweeperGame {

  private Cell[][] board;
  private int totalMineCount = 10;
  int wins = 0;
  int losses = 0;
  int selected = 0;
  int totalspaces = 100;

    /**
     * constructor that instantiates the board and creates the layout.
     */

    public MineSweeperGame() {
        board = new Cell[10][10];
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
            board[row][col] = new Cell(0, false, false, false);
        }
        }

        // adds mines to game
        addMines();

        /**
         * Sets neighbor minecounts.
         * 
         */
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (!(board[x][y].isMine())) {
                    int neighborcount = 0;
                    if (x < board.length - 1 && y > 0 && board[x + 1][y - 1].isMine()) { // down left
                        neighborcount++;
                    }
                    if (x > 0 && y > 0 && board[x - 1][y - 1].isMine()) { // up left
                        neighborcount++;
                    }
                    if (y > 0 && board[x][y - 1].isMine()) { // up
                        neighborcount++;
                    }
                    if (x < board.length - 1 && y < board[0].length - 1 && board[x + 1][y + 1].isMine()) { // down right
                        neighborcount++;
                    }
                    if (x > 0 && board[x - 1][y].isMine()) { // left
                        neighborcount++;
                    }
                    if (x < board.length - 1 && board[x + 1][y].isMine()) { // right
                        neighborcount++;
                    }
                    if (x > 0 && y < board[0].length - 1 && board[x - 1][y + 1].isMine()) { // up right
                        neighborcount++;
                    }
                    if (y < board[0].length - 1 && board[x][y + 1].isMine()) { // down
                        neighborcount++;
                    }

                    board[x][y].setMineCount(neighborcount);

                }
            }
        }
    }

    /**
     * selects the current cell and exposes it if it isn't flagged.
     * 
     * @param row
     * @param col
     */

    public void select(int row, int col) {
        board[row][col].setExposed(true);
        if (board[row][col].isMine() && (!board[row][col].isFlagged())) {
            losses++;
            JOptionPane.showMessageDialog(null, "You Lose!");
            reset();
        } else if (!board[row][col].isMine()) {
            selected++;
            if (totalspaces - selected == totalMineCount) {
                wins++;
                JOptionPane.showMessageDialog(null, "You Win!");
                reset();
            }
        }

    }

    /**
     * resets the game to a new game.
     */
    public void reset() {
        new MineSweeperGame();

    }

    /**
     * returns the current cell space.
     * 
     * @param row
     * @param col
     * @return
     */
    public Cell getCell(int row, int col) {
        return board[row][col];
    }

    /**
     * adds mines to board.
     */
    public void addMines() {
        Random random = new Random();
        int mineCount = 0;
        while (mineCount < totalMineCount) {
            int col = random.nextInt(10);
            int row = random.nextInt(10);
            if (!board[row][col].isMine()) {
                board[row][col].setMine(true);
                mineCount++;
            }
        }
    }

}
