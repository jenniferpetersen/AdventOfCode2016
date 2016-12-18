
import java.util.ArrayList;

public class Position {
	private Direction currDir;
	private Coordinate coord;
	private ArrayList<Coordinate> visitedCoordinates = new ArrayList<Coordinate>();
	
	public Position(Direction startDir, int x, int y) {
		currDir = startDir;
		coord = new Coordinate(x,y);
		visitedCoordinates.add(coord);
	}
	
	protected void turn(String move){
		if(move.charAt(0)== 'L')
			turnLeft(Integer.parseInt(move.substring(1, move.length())));
		else
			turnRight(Integer.parseInt(move.substring(1, move.length())));
	}
	
	private void turnLeft(int steps) {
		if (currDir==Direction.NORTH) {
			currDir = Direction.WEST;
			moveBackwardX(steps);
		}
		else if (currDir == Direction.EAST) {
			currDir = Direction.NORTH;
			moveForwardY(steps);
		}
		else if (currDir == Direction.SOUTH) {
			currDir = Direction.EAST;
			moveForwardX(steps);
		}
		else {
			currDir = Direction.SOUTH;
			moveBackwardY(steps);
		}
	}
	
	private void turnRight(int steps) {
		if (currDir==Direction.NORTH) {
			currDir = Direction.EAST;
			moveForwardX(steps);
		}
		else if (currDir == Direction.EAST) {
			currDir = Direction.SOUTH;
			moveBackwardY(steps);
		}
		else if (currDir == Direction.SOUTH) {
			currDir = Direction.WEST;
			moveBackwardX(steps);
		}
		else {
			currDir = Direction.NORTH;
			moveForwardY(steps);
		}
	}
	
	private void moveForwardX(int steps) {
		for(int i = 1; i <=steps; i++) {
			visitedCoordinates.add(new Coordinate(coord.getX() + i, coord.getY()));
		}
		int newX = coord.getX()+ steps;
		coord = new Coordinate(newX, coord.getY());
	}
	
	private void moveBackwardX(int steps) {
		for(int i = 1; i <=steps; i++) {
			visitedCoordinates.add(new Coordinate(coord.getX() - i, coord.getY()));
		}
		int newX = coord.getX()- steps;
		coord = new Coordinate(newX, coord.getY());	
	}
	
	private void moveForwardY(int steps) {
		for(int i = 1; i <=steps; i++) {
			visitedCoordinates.add(new Coordinate(coord.getX(), coord.getY() + i));
		}
		int newY = coord.getY()+ steps;
		coord = new Coordinate(coord.getX(), newY);
	}
	
	private void moveBackwardY(int steps) {
		for(int i = 1; i <=steps; i++) {
			visitedCoordinates.add(new Coordinate(coord.getX(), coord.getY() - i));
		}
		int newY = coord.getY()- steps;
		coord = new Coordinate(coord.getX(), newY);	
	}
	
	private Coordinate findPositionTwiceVisited() {
		Coordinate toReturn = null;
		for (int i = 0; i < visitedCoordinates.size(); i++) {	
			Coordinate checkedCoord = visitedCoordinates.get(i);
			if (visitedCoordinates.subList(i+1, visitedCoordinates.size()).contains(visitedCoordinates.get(i))) {
				toReturn = checkedCoord;
				break;
			}
		}
		return toReturn;
	}
	
	public String toString() {
		return "End position: " + coord.toString() + ". \n" +
			"First position visited twice: " + findPositionTwiceVisited().toString();
	}

}
