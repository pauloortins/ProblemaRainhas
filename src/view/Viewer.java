package view;

import java.util.ArrayList;
import java.util.List;

import solution.Board;
import solution.BoardMemento;
import solution.Challenge;

public class Viewer {
	public static Challenge challenge;
	public static ChessBoard board;
	public static List<BoardMemento> mementoList;
	public static int index;

	public static void startLog() {
		index = 0;
		mementoList = new ArrayList<BoardMemento>();
	}

	public static boolean canMoveNext() {
		if (index < mementoList.size() - 1) {
			return true;
		}

		return false;
	}

	public static Board getNextState() {
		Board board = new Board();
		board.restoreFromMemento(mementoList.get(++index));

		return board;
	}

	public static boolean canMovePrevious() {
		if (index > 0) {
			return true;
		}

		return false;
	}

	public static Board getPreviousState() {
		Board board = new Board();
		board.restoreFromMemento(mementoList.get(--index));

		return board;
	}

	public static int getListSize() {
		return mementoList.size();
	}

	public static Board getFirstState() {
		Board board = new Board();
		board.restoreFromMemento(mementoList.get(0));

		return board;
	}

	public static Board getLastState() {
		Board board = new Board();
		board.restoreFromMemento(mementoList.get(mementoList.size() - 1));

		return board;
	}

	public static void initLastState() {
		if (!mementoList.isEmpty()) {
			Viewer.challenge = new Challenge(Viewer.getLastState());
			Viewer.board.dispose();
			Viewer.board = new ChessBoard();
			Viewer.index = Viewer.getListSize() - 1;
			Viewer.board.lblPager.setText(Viewer.index + 1 + "/"
					+ Viewer.getListSize());
			Viewer.board.lblNumberOfAttacks.setText("Number of Attacks : "
					+ Viewer.challenge.getBoard().countNumberOfAttacks());
			Viewer.board.show();
		}
	}

	public static void initFirstState() {
		if (!mementoList.isEmpty()) {
			Viewer.challenge = new Challenge(Viewer.getFirstState());
			Viewer.board.dispose();
			Viewer.board = new ChessBoard();
			Viewer.index = 0;
			Viewer.board.lblPager.setText(Viewer.index + 1 + "/"
					+ Viewer.getListSize());
			Viewer.board.lblNumberOfAttacks.setText("Number of Attacks : "
					+ Viewer.challenge.getBoard().countNumberOfAttacks());
			Viewer.board.show();
		}
	}

	public static void initNextState() {
		if (Viewer.canMoveNext()) {
			Viewer.challenge = new Challenge(Viewer.getNextState());
			Viewer.board.dispose();
			Viewer.board = new ChessBoard();
			Viewer.board.lblPager.setText(Viewer.index + 1 + "/"
					+ Viewer.getListSize());
			Viewer.board.lblNumberOfAttacks.setText("Number of Attacks : "
					+ Viewer.challenge.getBoard().countNumberOfAttacks());
			Viewer.board.show();
		}
	}

	public static void initPreviousState() {
		if (Viewer.canMovePrevious()) {
			Viewer.challenge = new Challenge(Viewer.getPreviousState());
			Viewer.board.dispose();
			Viewer.board = new ChessBoard();
			Viewer.board.lblPager.setText(Viewer.index + 1 + "/"
					+ Viewer.getListSize());
			Viewer.board.lblNumberOfAttacks.setText("Number of Attacks : "
					+ Viewer.challenge.getBoard().countNumberOfAttacks());
			Viewer.board.show();
		}
	}

	public static void initsolveChallengeState() {
		Viewer.startLog();
		Viewer.challenge.solveChallenge();
		Viewer.board.dispose();
		Viewer.board = new ChessBoard();
		Viewer.board.lblPager.setText(Viewer.getListSize() + "/"
				+ Viewer.getListSize());
		Viewer.index = Viewer.getListSize() - 1;
		Viewer.board.lblNumberOfAttacks.setText("Number of Attacks : "
				+ Viewer.challenge.getBoard().countNumberOfAttacks());
		Viewer.board.show();
	}

	public static void initCreateNewChallenge() {
		Viewer.startLog();
		Viewer.index = 0;
		Viewer.challenge = new Challenge(new Board(Board.createBoard()));
		Viewer.board.dispose();
		Viewer.board = new ChessBoard();
		Viewer.board.lblNumberOfAttacks.setText("Number of Attacks : "
				+ Viewer.challenge.getBoard().countNumberOfAttacks());
		Viewer.board.show();
	}
}
