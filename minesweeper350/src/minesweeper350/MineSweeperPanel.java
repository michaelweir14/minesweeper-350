package minesweeper350;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.JTextArea;

/**
 * Creates and sets up the JPanel for the Mine sweeper game.
 * 
 */
public class MineSweeperPanel implements ActionListener {
    
    /** The specific cell. */
    private Cell iCell;
    
    /** Creates new game board. */
    private MineSweeperGame game = new MineSweeperGame();
    
    /** New JFrame. */
    private JFrame frame = new JFrame("MineSweeper");

    /** JButtons for game board. */
    private JButton[][] buttons = new JButton[10][10];
    
    /** Container. */
    private Container grid = new Container();
    
    /**
     * Creates GUI for board.
     */

    public MineSweeperPanel() {
        frame.setSize(700, 1000);
        frame.setLayout(new BorderLayout());
    //  frame.add(quitButton, BorderLayout.NORTH);
//      frame.add(winloss, BorderLayout.SOUTH);
//      quitButton.addActionListener(this);

        // button grid
        grid.setLayout(new GridLayout(10, 10));

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(this);
                buttons[i][j].addMouseListener(
                        new CustomMouseListener());

                grid.add(buttons[i][j]);
            }
        }
        frame.add(grid, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        displayBoard();
        
    }

    /**
     * actions performed when buttons are clicked.
     * Quit game, selecting cells.
     * @param e Event.
     */
    public void actionPerformed(final ActionEvent e) {

        if (e.getSource().equals(buttons)) {
                System.out.println("");
        } else {
            for (int x = 0; x < buttons.length; x++) {
                for (int y = 0; y < buttons[0].length; y++) {
                    if (e.getSource().equals(buttons[x][y])
                            ) {
                        
                        buttons[x][y].setText("" + game
                                .getCell(x, y)
                        .getMineCount());
            //          game.getGameStatus();
                    }
                }
            }
        }
        
    }

    /**
     * 
     * Mouse listener for flagging cells, selecting cell sets exposed.
     *
     */
    class CustomMouseListener implements MouseListener {
        /**
         * Mouse pressed listener.
         * 
         * @param e event.
         */
        public void mousePressed(final MouseEvent e) {
        }

        /**
         * Mouse clicked listener.
         * 
         * @param e event.
         */
        public void mouseClicked(final MouseEvent e) {

        }

        /**
         * Mouse entered listener.
         * 
         * @param e event.
         */
        public void mouseEntered(final MouseEvent e) {

        }

        /**
         * Mouse exited listener.
         * 
         * @param e event.
         */
        public void mouseExited(final MouseEvent e) {

        }

        @Override
        /**
         * Left click flags cells (red).
         * Right click selects cell and sets exposed. 
         * Calls removeZeros() if the space is not a mine.
         * @param e
         */
        public void mouseReleased(final MouseEvent e) {
            for (int x = 0; x < buttons.length; x++) {
                for (int y = 0; y < buttons[0].length; y++) {
                    if (e.getSource().equals(buttons[x][y]
                            )) {
                        if (e.getButton() == MouseEvent.
                                BUTTON3) {
                            buttons[x][y]
                        .setBackground(Color.red);
                            

                            

                        }
                        if (e.getButton() 
                        == MouseEvent.BUTTON1) {
                        game.select(x, y);
                            buttons[x][y]
                            .setEnabled(false); 
                            game.getCell(x, y)
                            .setExposed(true);
                            if (!game.getCell(x, y) 
                                .isMine()) {
                            removeZeros(x, y);
                        }
                        }
                    }
                }
            }
        }
    }

    /**
     * creates the display for the board.
     */
    private void displayBoard() {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                iCell = game.getCell(row, col);
                if (iCell.isMine()) {
                    buttons[row][col].setText("M");
                }
            }
        }
    }
    /**
     * Selects neighboring cells if not a bomb/on board/not exposed.
     * @param x x value.
     * @param y y value.
     */
    public void removeZeros(int x, int y) {
        for (int row = 0; row < buttons.length; x++) {
            for (int col = 0; col < buttons[0].length; y++) {
                if ((!game.getCell(x + 1, y - 1).isMine()) 
        && (!game.getCell(x + 1, y - 1).isExposed())) { //down left
                    game.select(x + 1, y - 1);
                    buttons[x + 1][y - 1].setEnabled(false);
                    buttons[x + 1][y - 1].setText("" 
                + game.getCell(x + 1, y - 1).getMineCount());
                }
                if ((!game.getCell(x - 1, y - 1).isMine()) 
        && (!game.getCell(x - 1, y - 1).isExposed())) { // up left
                    game.select(x - 1, y - 1);
                    buttons[x - 1][y - 1].setEnabled(false);
                    buttons[x - 1][y - 1].setText("" 
                + game.getCell(x - 1, y - 1).getMineCount());
                }
                if ((!game.getCell(x, y - 1).isMine()) 
            && (!game.getCell(x, y - 1).isExposed())) { // up
                    game.select(x, y - 1);
                    buttons[x][y - 1].setEnabled(false);
                    buttons[x][y - 1].setText("" 
                + game.getCell(x, y - 1).getMineCount());
                }
                if ((!game.getCell(x + 1, y + 1).isMine()) 
        && (!game.getCell(x + 1, y + 1).isExposed())) { // down right
                    game.select(x + 1, y + 1);
                    buttons[x + 1][y + 1].setEnabled(false);
                    buttons[x + 1][y + 1].setText("" 
                + game.getCell(x + 1, y + 1).getMineCount());
                }
                if ((!game.getCell(x - 1, y).isMine()) 
        && (!game.getCell(x - 1, y).isExposed())) { //left
                    game.select(x - 1, y);
                    buttons[x - 1][y].setEnabled(false);
                    buttons[x - 1][y].setText("" 
                + game.getCell(x - 1, y).getMineCount());
                }
                if ((!game.getCell(x + 1, y).isMine()) 
        && (!game.getCell(x + 1, y).isExposed())) { //right
                    game.select(x + 1, y);
                    buttons[x + 1][y].setEnabled(false);
                    buttons[x + 1][y].setText(""
                + game.getCell(x + 1, y).getMineCount());
                }
                if ((!game.getCell(x - 1, y + 1).isMine()) 
        && (!game.getCell(x - 1, y + 1).isExposed())) { // up right
                    game.select(x - 1, y + 1);
                    buttons[x - 1][y + 1].setEnabled(false);
                    buttons[x - 1][y + 1].setText("" 
                + game.getCell(x - 1, y + 1).getMineCount());
                }
                if ((!game.getCell(x, y + 1).isMine()) 
        && (!game.getCell(x, y + 1).isExposed())) { // down
                    game.select(x, y + 1);
                    buttons[x][y + 1].setEnabled(false);
                    buttons[x][y + 1].setText("" 
                + game.getCell(x, y + 1).getMineCount());
        }
            }
        
    }
    }
}
