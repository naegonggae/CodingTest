package codingTest.hashmaptreeset;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class K번째_큰수 {
	// https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84&unitId=72743

	public static void main(String[] args) {
		int n = 10;
		int k = 3;
		int[] arr = {13,15,34,23,45,65,33,11,26,42};

		Solution solution = new Solution();
		int result = solution.solution(n, k, arr);
		System.out.println("result = " + result);
	}

	static class Solution {
		public int solution(int n, int k, int[] arr) {
			int answer = -1;

			// 중복제거하고 오름차순, 내림차순 컨트롤 가능
			TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
			for (int i = 0; i<n; i++) {
				for (int j = i+1; j<n; j++) {
					for (int z = j+1; z<n; z++) {
						treeSet.add(arr[i]+arr[j]+arr[z]);
					}
				}
			}

			int cnt = 0;
			// 특정수 지우기
			treeSet.remove(143);
			System.out.println("size : " + treeSet.size());
			System.out.println("first : " + treeSet.first());
			System.out.println("last : " + treeSet.last());
			for (int i : treeSet) {
				cnt++;
				if (cnt == k) return i; // k번째 카운트된걸 출력
			}

			return answer; // 끝까지 돌았는데 안나오면 -1 력대로 출력
		}
	}

}
