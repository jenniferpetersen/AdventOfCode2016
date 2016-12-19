package DayThree;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DayThree {
	private static ArrayList<Triangle> triangles = new ArrayList<>();
	private ArrayList<Triple> triplets = new ArrayList<>();
	
	public static void main(String[] args) {
		DayThree dt = new DayThree();
		dt.readFile();
		dt.createTriangles();
		
		System.out.println(triangles.size());
	}
	
	private void readFile() {
		try {
			Scanner scanner = new Scanner(new File("triples.txt"));
			
			while(scanner.hasNextLine()) {
				int triF = scanner.nextInt();
				int triS = scanner.nextInt();
				int triT = scanner.nextInt();
				addTriple(triF, triS, triT);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
	}

	private void addTriple(int triF, int triS, int triT) {
		Triple tri = new Triple(triF, triS, triT);
		triplets.add(tri);
	}
	
	private void createTriangles() {
		for (Triple tri : triplets) {
			int x = tri.getFirst();
			int y = tri.getSecond();
			int z = tri.getThird();
			
			if (validTriangle(x,y,z)) {
				Triangle newTri = new Triangle(x,y,z);
				triangles.add(newTri);
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
