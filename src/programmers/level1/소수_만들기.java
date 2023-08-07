package programmers.level1;

public class 소수_만들기 {

	public static void main(String[] args) {

		int[] nums = {1,2,3,4};

		Solution solution = new Solution();
		int result = solution.solution(nums);
		System.out.println("result = " + result);

	}

	static class Solution {
		public int solution(int[] nums) {
			int answer = 0;

			for (int i = 0; i<nums.length; i++) {
				for (int j = i+1; j<nums.length; j++) {
					for (int k = j+1; k<nums.length; k++) {
						int n = nums[i] + nums[j] + nums[k];
						if (isPrime(n)) {
							answer++;
							//System.out.println(nums[i]+ "+" +nums[j]+ "+" +nums[k]);
						}
					}
				}
			}

			return answer;
		}

		private boolean isPrime(int n) {
			for (int i = 2; i*i<=n; i++) {
				if (n % i == 0) {
					return false;
				}
			}
			return true;
		}
	}

}
