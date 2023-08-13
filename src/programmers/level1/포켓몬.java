package programmers.level1;

import java.util.HashSet;

public class 포켓몬 {

	public static void main(String[] args) {

		int[] nums = {3,1,2,3};

		Solution solution = new Solution();
		int result = solution.solution(nums);
		System.out.println("result = " + result);

	}

	static class Solution {
		public int solution(int[] nums) {
			int answer = 0;

			int maxNum = nums.length / 2;
			HashSet<Integer> set = new HashSet<>();
			for (int i : nums) {
				set.add(i);
			}

			if (maxNum < set.size()) {
				answer = maxNum;
			}
			else {
				answer = set.size();
			}
			return answer;
		}
	}

}
