package programmers.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class 두개_뽑아서_더하기 {

	public static void main(String[] args) {

		int[] numbers = {2,1,3,4,1};

		Solution solution = new Solution();
		int[] result = solution.solution(numbers);
		System.out.println("result = " + Arrays.toString(result));

	}

	static class Solution {
		public int[] solution(int[] numbers) {

			HashSet<Integer> set = new HashSet<>();

			// 서로 다른 인덱스로 배치하기
			for (int i = 0; i<numbers.length; i++) {
				for (int j = i+1; j<numbers.length; j++) {
					set.add(numbers[i]+numbers[j]);
				}
			}
			int[] answer = new int[set.size()];

			int idx = 0;
			Iterator<Integer> iter = set.iterator();
			while (iter.hasNext()){
				answer[idx++] = iter.next();
			}

			Arrays.sort(answer);

			return answer;
		}
	}

}
