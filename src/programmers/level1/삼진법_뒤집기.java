package programmers.level1;

public class 삼진법_뒤집기 {

	public static void main(String[] args) {
		int n = 45;

		Solution solution = new Solution();
		int result = solution.solution(n);
		System.out.println("result = " + result);

	}

	static class Solution {
		public int solution(int n) {
			int answer = 0;
			String num = "";

			if (n == 1 || n == 2) {
				return n;
			}
			//1200 27 18 = 45
			int i = 3;
			while (i*3 <= n) {
				i*=3;
			}

			while (n != 0) {
				num+= Integer.valueOf(n / i);
				n = n % i;
				i = i / 3;
			}

			//System.out.println(num);

			StringBuilder sb = new StringBuilder(num);
			num = sb.reverse().toString();
			//System.out.println(num);

			int tree = 1;
			for (int j = num.length()-1; j>=0; j--) {
				int m = Integer.valueOf(num.charAt(j)-'0');
				answer+= tree * m;
				tree*=3;
			}
			return answer;
		}
	}

	// 세상 간단하다..
	static class Solution2 {
		public int solution(int n) {
			int answer = 0;

			// 10진수 -> n진수 = String
			String a = Integer.toString(n, 3);
			//System.out.println(a);

			StringBuilder sb = new StringBuilder(a);
			a = sb.reverse().toString();

			// n진수 -> 10진수 = int
			answer = Integer.parseInt(a, 3);
			return answer;
		}
	}

}
