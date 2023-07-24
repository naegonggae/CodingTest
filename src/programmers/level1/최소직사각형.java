package programmers.level1;

public class 최소직사각형 {

	public static void main(String[] args) {
		int[][] sizes = {{60, 50},{30, 70},{60, 30},{80, 40}};

		Solution solution = new Solution();
		int result = solution.solution(sizes);
		System.out.println("result = " + result);
	}

	static class Solution {
		public int solution(int[][] sizes) {
			int answer = 0;

			// 최대값 변수에 저장 최소값 변수에 저장해서 곱을 리턴
			int m = 0;
			int n = 0;
			for (int i = 0; i<sizes.length; i++) {
				int mm = Math.max(sizes[i][0], sizes[i][1]);
				int nn = Math.min(sizes[i][0], sizes[i][1]);

				if (mm > m) { //최대값 중에 최대값
					m = mm;
				}
				if (nn > n) { //최소값 중에 최소값
					n = nn;
				}

			}
			answer = m * n;

			return answer;
		}
	}

}
