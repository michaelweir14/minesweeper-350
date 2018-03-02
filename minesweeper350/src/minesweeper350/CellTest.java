package minesweeper350;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CellTest {

	@Test
	public void testSetMineCount() {
		Cell cell = new Cell(0, false, false, false);
		cell.setMineCount(1);
		assertTrue(cell.getMineCount() == 1);
	}
	
	@Test
	public void testSetMine() {
		Cell cell = new Cell(0, false, false, false);
		cell.setMine(true);
		assertTrue(cell.isMine() == true);
	}
	@Test
	public void testIsExposed() {
		Cell cell = new Cell(0, false, false, false);
		cell.setExposed(true);
		assertTrue(cell.isExposed() == true);
	}
	@Test
	public void testSetFlagged() {
		Cell cell = new Cell(0, false, false, false);
		cell.setFlagged(true);
		assertTrue(cell.isFlagged() == true);
	}


}
