package codingTest.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class 공주구하기 {
	// https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84&unitId=72750

	public static void main(String[] args) {
		int n = 8;
		int k = 3;

		Solution solution = new Solution();
		int result = solution.solution(n, k);
		System.out.println("result = " + result);

		int result2 = solution.solution2(n, k);
		System.out.println("result2 = " + result2);
	}

	static class Solution {
		public int solution(int n, int k) {
			int answer = 0, cnt = 1;

			Queue<Integer> queue = new LinkedList<>();
			for (int i = 1; i<=n; i++) queue.add(i);

			while (queue.size() > 1) {
				if (cnt == k) {
					queue.poll();
					cnt=1;
				}
				else {
					int q = queue.poll();
					queue.add(q);
					cnt++;
				}
			}
			answer = queue.peek();
			return answer;
		}
		public int solution2(int n, int k) {
			int answer = 0, cnt = 1;
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 1; i<=n; i++) queue.add(i);
			while (!queue.isEmpty()) {
				for (int i = 1; i<k; i++) queue.add(queue.poll());
				queue.poll();
				if (queue.size() == 1) answer = queue.poll();
			}

			return answer;
		}

	}

}
