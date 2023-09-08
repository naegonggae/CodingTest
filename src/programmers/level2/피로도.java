package programmers.level2;

public class 피로도 {
	// DFS 순열구하기
	public static void main(String[] args) {
		int k = 80;
		int[][] dungeons = {{80,20},{50,40},{30,10}};

		Solution solution = new Solution();
		int result = solution.solution(k, dungeons);
		System.out.println("result = " + result);

	}

	static class Solution {
		int n, answer = 0;
		int[] ch, pm;
		public int solution(int k, int[][] dungeons) {
			// 피로도 소모해서 최대한 많은 던전돌기 == 그리디?
			// 전략이 조합 순열0
			n = dungeons.length;
			ch = new int[n];
			pm = new int[n];
			DFS(0, k, dungeons);
			return answer;
		}

		private void DFS(int L, int k, int[][] dungeons) {
			if (L == n) {
				// for (int x : pm) System.out.print(x + " ");
				// System.out.println();
				int cnt = 0;
				for (int x : pm) {
					if (k>=dungeons[x][0]) {
						k-=dungeons[x][1];
						cnt++;
					}
				}
				answer = Math.max(answer, cnt);

			}
			else {
				for (int i = 0; i<n; i++) {
					if (ch[i] == 0) {
						ch[i] = 1;
						pm[L] = i;
						DFS(L+1, k, dungeons);
						ch[i] = 0;
					}
				}
			}
		}
	}

}
