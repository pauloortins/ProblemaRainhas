package solution;

public class Queen {
	
	private int rowNumber;
	private int columnNumber;
	
	public Queen(int rowNumber, int columnNumber) {
		this.rowNumber = rowNumber;
		this.columnNumber = columnNumber;
	}
	
	public Queen(Queen rainha) {
		// TODO Auto-generated constructor stub
		this.rowNumber = rainha.rowNumber;
		this.columnNumber = rainha.columnNumber;
	}

	public int getColumnNumber() {
		return columnNumber;
	}
	
	public int getRowNumber() {
		return rowNumber;
	}
	
	public void move(int columnNumber)
	{
		this.columnNumber = columnNumber;
	}
}
