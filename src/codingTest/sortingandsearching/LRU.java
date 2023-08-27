package codingTest.sortingandsearching;

import java.util.Arrays;

public class LRU {
	// https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84&unitId=72757

	public static void main(String[] args) {
		int s = 5;
		int n = 9;
		int[] arr = {1,2,3,2,6,2,3,5,7};

		Solution solution = new Solution();
		int[] result = solution.solution(s, n, arr);
		System.out.println("result = " + Arrays.toString(result));
	}

	static class Solution {
		public int[] solution(int s, int n, int[] arr) {
			int[] cache = new int[s];
			for (int x : arr) {
				int pos = -1; // miss 인지 hit 인지 구별 변수

				// cache 배열을 돌면서 x 가 캐시에 있던 변수인지 확인하고 인덱스 저장
				for (int i = 0; i<s; i++) if (cache[i] == x) pos = i;

				// miss 전체길이의 -1 부터 삽입정렬처럼 뒤로 밀어주고 0번째 인덱스에 x 를 넣어준다.
				if (pos == -1) {
					for (int j = s-1; j>=1; j--) {
						cache[j] = cache[j-1];
					}
//					cache[0] = x;
				}
				// hit pos 가 아까 캐시에 있던 위치인데 거기서 부터 miss 처럼 앞으로 땡겨주면된다.
				else {
					for (int j = pos; j>=1; j--) {
						cache[j] = cache[j-1];
					}
//					cache[0] = x;
				}
				cache[0] = x; // 같은 거 하나로 빼기
			}
			return cache;
		}
	}

}
