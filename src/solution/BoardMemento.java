package solution;

import java.util.List;

public class BoardMemento {
	private final List<Queen> board;
	
	public BoardMemento(List<Queen> newBoard)
	{
		this.board = newBoard;
	}
	
	public List<Queen> getSavedState()
	{
		return board;
	}
}
