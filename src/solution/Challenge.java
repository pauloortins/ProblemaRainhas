package solution;

import java.util.ArrayList;
import java.util.List;

import view.ChessBoard;
import view.Viewer;

import junit.framework.Assert;

public class Challenge {

	private Board board;

	public Challenge(Board board) {
		// TODO Auto-generated constructor stub
		this.board = board;
	}

	public void solveChallenge() {
		// TODO Auto-generated method stub
		int temperature = 100;
		int iterations = 10000;

		Viewer.mementoList.add(board.saveToMemento());
		
		while (board.countNumberOfAttacks() != 0 && iterations > 0) {
			
			List<BoardMemento> mementoList = new ArrayList<BoardMemento>();

			executeMove(temperature, mementoList);

			if (shouldUndoMove(board, mementoList, temperature)) {
				undoMove(mementoList);
			}
			
			Viewer.mementoList.add(board.saveToMemento());

			temperature--;
			iterations--;
		}
	}

	private boolean shouldUndoMove(Board actualBoard,
			List<BoardMemento> mementoList, int temperature) {
		// TODO Auto-generated method stub
		Board oldBoard = new Board(mementoList.get(mementoList.size() - 1)
				.getSavedState());

		int actualNumberOfAttacks = actualBoard.countNumberOfAttacks();
		int oldNumberOfAttacks = oldBoard.countNumberOfAttacks();

		if (actualNumberOfAttacks > oldNumberOfAttacks) {
			return ShouldNotMakeDownHill(temperature);
		}

		return false;
	}

	private void undoMove(List<BoardMemento> mementoList) {
		// TODO Auto-generated method stub
		board.restoreFromMemento(mementoList.get(mementoList.size() - 1));
	}

	private void executeMove(int temperature, List<BoardMemento> mementoList) {
		int queenNumber = RandomNumber.generateRandomNumber(8);
		int columnNumber = RandomNumber.generateRandomNumber(8);

		mementoList.add(board.saveToMemento());
		board.moveQueen(queenNumber, columnNumber);
	}

	private boolean ShouldNotMakeDownHill(int fatorAleatorio) {
		// TODO Auto-generated method stub
		int randomNumber = RandomNumber.generateRandomNumber(100);

		if (randomNumber > fatorAleatorio) {
			return true;
		}

		return false;
	}

	public Board getBoard() {
		// TODO Auto-generated method stub
		return board;
	}

	public static void main(String[] args) {
		Viewer.startLog();
		Viewer.challenge = new Challenge(new Board(Board.createBoard()));
		Viewer.board = new ChessBoard();
		Viewer.initCreateNewChallenge();
	}
}
