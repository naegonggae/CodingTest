package programmers.level2;

import java.util.Arrays;

public class 구명보트 {

	public static void main(String[] args) {
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		Solution solution = new Solution();
		int result = solution.solution(people, limit);
		System.out.println("result = " + result);
	}

	static class Solution {
		public int solution(int[] people, int limit) {
			int answer = 0;
			Arrays.sort(people);
			int lt = 0;
			int rt = people.length-1;
			while (lt <= rt) {
				answer++;
				int n = limit - people[rt--];
				if (n >= people[lt]) lt++;
			}

			return answer;
		}
	}

}
