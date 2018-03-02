package minesweeper350;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MineSweeperGameTest {

	@Test
	void testSelectNonMine() {
		MineSweeperGame test = new MineSweeperGame();
		Cell[][] board = new Cell[10][10];
		for (int row = 0; row < 10; row++)
			for (int col = 0; col < 10; col++)
				board[row][col] = new Cell(0, false, false, false);
		test.select(1, 2);
		assertTrue(board[1][2].isMine() == false);
	}

	@Test
	void testSelectMine() {
		MineSweeperGame test = new MineSweeperGame();
		Cell[][] board = new Cell[10][10];
		for (int row = 0; row < 10; row++)
			for (int col = 0; col < 10; col++)
				board[row][col] = new Cell(0, false, false, false);
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				board[x][y].setMine(true);
		//		test.select(x,y);

			}
		}
		assertTrue(test.losses >= 1);
		
	}



}
