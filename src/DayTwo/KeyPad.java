package DayTwo;

public class KeyPad {
	private static final int MAX_ROW = 2;
	private static final int MAX_COL = 2;
	private static final int MIN_ROW = 0;
	private static final int MIN_COL = 0;
	
	private int[][] pad = {{1,2,3},{4,5,6},{7,8,9}};
	private String code;
	private int currentRow;
	private int currentCol;
	
	public KeyPad(int row, int col) {
		currentRow = row;
		currentCol = col;
		code = "";
	}
	
	protected void move(char ch) {
		if (ch == InputLetter.D.asChar())
			moveDown();
		else if (ch == InputLetter.L.asChar())
			moveLeft();
		else if (ch == InputLetter.R.asChar())
			moveRight();
		else if (ch == InputLetter.U.asChar())
			moveUp();
		else
			code += pad[currentRow][currentCol];
	}
	
	private void moveLeft() {
		if(currentCol>MIN_COL)
			currentCol--;
	}
	
	private void moveRight() {
		if(currentCol<MAX_COL)
			currentCol++;
	}
	
	private void moveUp() {
		if (currentRow>MIN_ROW)
			currentRow--;
	}
	
	private void moveDown() {
		if (currentRow<MAX_ROW)
			currentRow++;
	}
	
	public String toString() {
		return "Key pad: \n" + pad[0][0] + pad[0][1] + pad[0][2] + "\n" +
				pad[1][0] + pad[1][1] + pad[1][2] + "\n" +
				pad[2][0] + pad[2][1] + pad[2][2] + "\n" +
				"Bathroom code: " + code;
	}

}
