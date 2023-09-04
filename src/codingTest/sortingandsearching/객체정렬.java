package codingTest.sortingandsearching;

import java.util.ArrayList;
import java.util.Collections;

public class 객체정렬 {

	public static void main(String[] args) {
		int[] arr2 = {2, 7, 1, 3, 1, 2, 2, 5, 3, 6};
		ArrayList<Point> al = new ArrayList<>();
		for (int i = 0; i<arr2.length-1; i+=2) {
			al.add(new Point(arr2[i], arr2[i+1]));
		}

		Collections.sort(al);
		for (Point point2 : al) {
			System.out.println(point2.x + " "+ point2.y);
		}
	}
	static class Point implements Comparable<Point> {
		int x, y;

		public Point() {
		}

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (this.x == o.x) return this.y - o.y;
			else return this.x - o.x;
		}
	}
}
