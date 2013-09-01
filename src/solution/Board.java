package solution;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import view.ChessBoard;

public class Board {

	private List<Queen> board;

	public Board()
	{
		
	}
	
	public Board(List<Queen> board) {
		this.board = board;
	}

	public static List<Queen> createBoard() {

		List<Queen> queenList = new ArrayList<Queen>();

		for (int rowNumber = 1; rowNumber <= 8; rowNumber++) {
			queenList.add(new Queen(rowNumber, RandomNumber
					.generateRandomNumber(8)));
		}

		return queenList;
	}

	public int countNumberOfAttacks() {
		return countColumnAttacks() + countNumberOfAttacksMainDiagonal()
				+ countNumberOfAttacksAntiDiagonal();

	}

	public int countColumnAttacks() {

		int numberOfAttacks = 0;

		for (Queen attackerQueen : board) {
			for (Queen victimQueen : board) {
				if (attackerQueen != victimQueen
						&& attackerQueen.getColumnNumber() == victimQueen
								.getColumnNumber()) {
					numberOfAttacks++;
				}
			}
		}

		return numberOfAttacks / 2;
	}

	public int countNumberOfAttacksMainDiagonal() {

		int numberOfAttacks = 0;

		for (Queen attackerQueen : board) {
			for (Queen victimQueen : board) {
				if (attackerQueen != victimQueen
						&& attackerQueen.getColumnNumber()
								- attackerQueen.getRowNumber() == victimQueen
								.getColumnNumber()
								- victimQueen.getRowNumber()) {
					numberOfAttacks++;
				}
			}
		}

		return numberOfAttacks / 2;
	}

	public int countNumberOfAttacksAntiDiagonal() {
		
		int numberOfAttacks = 0;

		for (Queen attackerQueen : board) {
			for (Queen victimQueen : board) {
				if (attackerQueen != victimQueen
						&& attackerQueen.getColumnNumber()
								+ attackerQueen.getRowNumber() == victimQueen
								.getColumnNumber()
								+ victimQueen.getRowNumber()) {
					numberOfAttacks++;
				}
			}
		}

		return numberOfAttacks / 2;
	}

	public List<Queen> getBoard() {
		return board;
	}

	public void moveQueen(int rowNumber, int columnNumber) {
		// TODO Auto-generated method stub
		Queen queen = board.get(rowNumber - 1);

		queen.move(columnNumber);
	}

	public BoardMemento saveToMemento() {

		List<Queen> oldBoard = new ArrayList<Queen>();

		for (Queen queen : board) {
			oldBoard.add(new Queen(queen));
		}

		return new BoardMemento(oldBoard);
	}

	public void restoreFromMemento(BoardMemento memento) {
		board = memento.getSavedState();
	}

	public void showWindow() {
//		StringBuilder string = new StringBuilder();
//
//		for (Queen queen : board) {
//			string.append("\n");
//			for (int i = 1; i <= 8; i++) {
//				if (i == queen.getColumnNumber()) {
//					string.append("X ");
//				} else {
//					string.append("O ");
//				}
//			}
//		}
//
//		JOptionPane.showMessageDialog(null, string.toString());
		
	}
}
