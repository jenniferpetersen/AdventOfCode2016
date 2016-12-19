package DayTwo;

public enum InputLetter {
	U('U'), R('R'), D('D'), L('L');
	
	public char asChar() {
		return asChar;
	}
	
    private final char asChar;

    private InputLetter(char asChar) {
        this.asChar = asChar;
    }

}
