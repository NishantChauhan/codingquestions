package rbctest.inheritance2d;
import java.util.*;

/* Write your class implementations here. Do not use access modifiers when declaring your classes. */
class Point3D extends Point2D{
	int x1;
	int y1;
	int z1;
	public Point3D(int x1, int y1, int z1) {
		super(x1,y1);
		this.x1=x1;
		this.y1=y1;
		this.z1=z1;
	}

	public double dist2D(Point3D p2) {
		Double distance = Math.ceil(Math.sqrt(Math.pow((x1-p2.x1),2)+Math.pow((y1-p2.y1),2)));
		return distance;
	}
	public double dist3D(Point3D p2) {
		Double distance = Math.ceil(Math.sqrt(Math.pow((x1-p2.x1),2)+Math.pow((y1-p2.y1),2)+Math.pow((z1-p2.z1),2)));

		return distance;
	}
	
	public void printDistance(double d2) {
		System.out.println("3D distance = " + ((Double)d2).intValue());
	}
	
}

class Point2D{
	int x1;
	int y1;

	public Point2D(int i, int j) {
		this.x1=i;
		this.y1=j;
	}

	public void printDistance(double d2) {
		System.out.println("2D distance = " + ((Double)d2).intValue());
		
	}
	
}

public class Solution {

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int x1 = scanner.nextInt();
//		int y1 = scanner.nextInt();
//		int z1 = scanner.nextInt();
//		int x2 = scanner.nextInt();
//		int y2 = scanner.nextInt();
//		int z2 = scanner.nextInt();
//        scanner.close();

		int x1 = 1;
		int y1 = 2;
		int z1 = 3;
		int x2 = 4;
		int y2 = 5;
		int z2 = 6;

		Point3D p1 = new Point3D(x1, y1, z1);
		Point3D p2 = new Point3D(x2, y2, z2);
		double d2 = p1.dist2D(p2);
		double d3 = p1.dist3D(p2);
        // The code below uses runtime polymorphism to call the overridden printDistance method:
        Point2D p = new Point2D(0, 0);
		p.printDistance(d2);
		p = p1;
		p.printDistance(d3);
	}
}