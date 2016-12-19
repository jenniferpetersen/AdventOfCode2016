package DayTwo;

public class KeyPadTwo {
	private static final int MAX_COLS_FOR_ROW_ZERO_FOUR = 2;
	private static final int MAX_COLS_FOR_ROW_ONE_THREE = 3;
	private static final int MAX_COLS_FOR_ROW_TWO = 4;
	
	private static final int MIN_COLS_FOR_ROW_ZERO_FOUR = 2;
	private static final int MIN_COLS_FOR_ROW_ONE_THREE = 1;
	private static final int MIN_COLS_FOR_ROW_TWO = 0;
	
	private static final int MAX_ROWS_FOR_COL_ZERO_FOUR = 2;
	private static final int MAX_ROWS_FOR_COL_ONE_THREE = 3;
	private static final int MAX_ROWS_FOR_COL_TWO = 4;
	
	private static final int MIN_ROWS_FOR_COL_ZERO_FOUR = 2;
	private static final int MIN_ROWS_FOR_COL_ONE_THREE = 1;
	private static final int MIN_ROWS_FOR_COL_TWO = 0;

	
	private String[][] pad = {{null,null,"1",null,null},{null,"2","3","4",null},{"5","6","7","8","9"},{null,"A","B","C",null},{null,null,"D",null,null}};
	private String code;
	private int currentRow;
	private int currentCol;
	
	public KeyPadTwo(int row, int col) {
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
		if (currentRow == 0 || currentRow == 4) {
			if (currentCol > MIN_COLS_FOR_ROW_ZERO_FOUR)
				currentCol--;
		}
		else if (currentRow == 1 || currentRow == 3) {
			if (currentCol > MIN_COLS_FOR_ROW_ONE_THREE)
				currentCol--;
		}
		else if (currentRow == 2) {
			if (currentCol > MIN_COLS_FOR_ROW_TWO)
				currentCol--;
		}
	}
	
	private void moveRight() {
		if (currentRow == 0 || currentRow == 4) {
			if (currentCol < MAX_COLS_FOR_ROW_ZERO_FOUR)
				currentCol++;
		}
		else if (currentRow == 1 || currentRow == 3) {
			if (currentCol < MAX_COLS_FOR_ROW_ONE_THREE)
				currentCol++;
		}
		else if (currentRow == 2) {
			if (currentCol < MAX_COLS_FOR_ROW_TWO)
				currentCol++;
		}
	}
	
	private void moveUp() {
		if (currentCol == 0 || currentCol == 4) {
			if (currentRow > MIN_ROWS_FOR_COL_ZERO_FOUR)
				currentRow--;
		}
		else if (currentCol == 1 || currentCol == 3) {
			if (currentRow > MIN_ROWS_FOR_COL_ONE_THREE)
				currentRow--;
		}
		else if (currentCol == 2) {
			if (currentRow > MIN_ROWS_FOR_COL_TWO)
				currentRow--;
		}
	}
	
	private void moveDown() {
		if (currentCol == 0 || currentCol == 4) {
			if (currentRow < MAX_ROWS_FOR_COL_ZERO_FOUR)
				currentRow++;
		}
		else if (currentCol == 1 || currentCol == 3) {
			if (currentRow < MAX_ROWS_FOR_COL_ONE_THREE)
				currentRow++;
		}
		else if (currentCol == 2) {
			if (currentRow < MAX_ROWS_FOR_COL_TWO)
				currentRow++;
		}
	}
	
	public String toString() {
		return "Bathroom code: " + code;
	}
}
	

