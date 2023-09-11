package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {

	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

		Solution solution = new Solution();
		int result = solution.solution(maps);
		System.out.println("result = " + result);

	}

	static class Solution {
		int [] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int answer = Integer.MAX_VALUE;
		public int solution(int[][] maps) {
			BFS(0, 0, maps);

			if (maps[maps.length-1][maps[0].length-1] == 1) return -1;
			answer = maps[maps.length-1][maps[0].length-1];
			return answer;
		}
		private void BFS(int x, int y, int[][] maps) {
			Queue<Point> q = new LinkedList<>();
			q.add(new Point(x, y));
			maps[0][0] = 1;
			while (!q.isEmpty()) {
				Point tmp = q.poll();
				for (int i = 0; i<4; i++) {
					int nx = tmp.x + dx[i];
					int ny = tmp.y + dy[i];
					if (nx>=0 && nx<maps.length && ny>=0 && ny<maps[0].length &&
							maps[nx][ny]==1) {
						maps[nx][ny] = maps[tmp.x][tmp.y] + 1;
						q.add(new Point(nx, ny));
					}
				}
			}
		}
		static class Point {
			int x, y;
			public Point(int x, int y) {
				this.x =x;
				this.y =y;
			}
		}
	}


}
