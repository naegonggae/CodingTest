package codingTest.recursivetreegraph;

public class 경로탐색DFS {
	// https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84&unitId=72776
	static int n, m, answer = 0;
	static int[][] graph;
	static int[] ch;

	public static void main(String[] args) {
		Solution solution = new Solution();
		n = 5;
		m = 6;
		int[][] arr = {{1, 2}, {1, 3}, {1, 4}, {2, 1}, {2, 3}, {2, 5}, {3, 4}, {4, 2}, {4, 5}};
		graph = new int[n + 1][n + 1];
		ch = new int[n + 1];
		for (int i = 0; i < arr.length; i++) {
			graph[arr[i][0]][arr[i][1]] = 1;
		}
//		for (int[] ints : graph) {
//			for (int anInt : ints) {
//				System.out.print(anInt+" ");
//			}
//			System.out.println();
//		}

		ch[1] = 1;
		solution.DFS(1);
		System.out.println(answer);

	}

	static class Solution {
		public void DFS(int v) {
			if (v == n) answer++;
			else {
				for (int i = 1; i <= n; i++) {
					if (graph[v][i] == 1 && ch[i] == 0) {
						ch[i] = 1; // 탐색할때 체크해주고
						DFS(i);
						ch[i] = 0; // 백트레킹할때는 체크 풀어주고 대칭구조임
					}
				}
			}
		}
	}
}
