package DayOne;

public class Coordinate {
	int x;
	int y;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public boolean equals(Object o) {
		if (this == o) 
			return true;
		
        Coordinate co = (Coordinate) o;
        if (o == null || getClass() != o.getClass() || x != co.x ||y != co.y)
        	return false;
        
        return true;
	}
	
	public String toString() {
		return "(" + x + "," + y + "). Blocks from start: " + (Math.abs(x) + Math.abs(y));
	}

}
