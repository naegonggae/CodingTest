package programmers.level2;

public class 점프와_순간이동 {

	public static void main(String[] args) {
		int n = 5;
		Solution solution = new Solution();
		int result = solution.solution(n);
		System.out.println("result = " + result);
	}

	static public class Solution {
		public int solution(int n) {
			int ans = 1;
			int num = n;
			while (num != 1) {
				if (num % 2 == 0) {
					num = num / 2;
				}
				else {
					ans++;
					num--;
				}
			}
			return ans;
		}
	}

}
