package DayThree;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DayThree {
	private ArrayList<Triple> triplets = new ArrayList<>();
	private static int numTriangles;
	
	public static void main(String[] args) {
		DayThree dt = new DayThree();
		dt.readFile();
		dt.checkTriangles();
		
		System.out.println(numTriangles);
	}
	
	private void readFile() {
		try {
			Scanner scanner = new Scanner(new File("inputDayThree.txt"));
			
			while(scanner.hasNextLine()) {
				int triF = scanner.nextInt();
				int triS = scanner.nextInt();
				int triT = scanner.nextInt();
				addTriple(triF, triS, triT);
			}
			scanner.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
	}

	private void addTriple(int triF, int triS, int triT) {
		Triple tri = new Triple(triF, triS, triT);
		triplets.add(tri);
	}
	
	private void checkTriangles() {
		for (Triple tri : triplets) {
			int x = tri.getFirst();
			int y = tri.getSecond();
			int z = tri.getThird();
			
			if (validTriangle(x,y,z)) {
				numTriangles++;
			}
		}
	}
	
	private boolean validTriangle(int x, int y, int z) {
		if (x + y > z && x + z > y && y + z > x)
			return true;
		else
			return false;
	}

}
