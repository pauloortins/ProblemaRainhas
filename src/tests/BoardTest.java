package tests;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import solution.Board;
import solution.BoardMemento;
import solution.Queen;

public class BoardTest {

	List<Queen> board;
	
	@Test
	public void testIfHaveOneQueenForRow() {
		
		List<Queen> queenList = Board.createBoard();
		
		List<Integer> rowList = new ArrayList<Integer>();
		rowList.add(1);
		rowList.add(2);
		rowList.add(3);
		rowList.add(4);
		rowList.add(5);
		rowList.add(6);
		rowList.add(7);
		rowList.add(8);
		
		for (Queen queen : queenList) {
			rowList.remove(new Integer(queen.getRowNumber()));
		}
		
		Assert.assertTrue(rowList.isEmpty());
	}
	
	@Before
	public void setupBoard() {
		board = new ArrayList<Queen>();
		
		board.add(new Queen(1,1));
		board.add(new Queen(2,3));
		board.add(new Queen(3,4));
		board.add(new Queen(4,8));
		board.add(new Queen(5,6));
		board.add(new Queen(6,2));
		board.add(new Queen(7,4));
		board.add(new Queen(8,8));
	}
	
	@Test
	public void testCountNumberOfColmunAttacks()
	{
		int expected = 2;
		
		Assert.assertEquals(expected, new Board(board).countColumnAttacks());
	}
	
	@Test
	public void testCountNumberOfAttacksMainDiagonal()
	{
		int expected = 4;
		
		Assert.assertEquals(expected, new Board(board).countNumberOfAttacksMainDiagonal());
	}
	
	@Test
	public void testCountNumberOfAttacksAntiDiagonal()
	{
		int expected = 1;
		
		Assert.assertEquals(expected, new Board(board).countNumberOfAttacksAntiDiagonal());
	}
	
	@Test
	public void testNumberOfAttacks()
	{
		int expected = 7;
		
		Assert.assertEquals(expected, new Board(board).countNumberOfAttacks());
	}
	
	@Test
	public void testMoveQueenToRight()
	{
		new Board(board).moveQueen(1,2);
		
		Assert.assertEquals(1, board.get(0).getRowNumber());
		Assert.assertEquals(2, board.get(0).getColumnNumber());
	}
	
	@Test
	public void testMoveQueenToLeft()
	{
		new Board(board).moveQueen(2,2);
		
		Assert.assertEquals(2, board.get(1).getRowNumber());
		Assert.assertEquals(2, board.get(1).getColumnNumber());
	}
	
	@Test
	public void MementoTest()
	{
		List<BoardMemento> mementoList = new ArrayList<BoardMemento>();
		
		Board t = new Board(board);
		mementoList.add(t.saveToMemento());
		t.moveQueen(8, 7);
		
		Assert.assertEquals(t.getBoard().get(7).getColumnNumber(), 7);
		
		t.restoreFromMemento(mementoList.get(0));
		
		Assert.assertEquals(t.getBoard().get(7).getColumnNumber(), 8);
		
	}
}
