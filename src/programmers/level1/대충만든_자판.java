package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;

public class 대충만든_자판 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] keymap = {"ABACD", "BCEFD"};
		String[] targets = {"ABCD","AABB"};
		int[] result = solution.solution(keymap, targets);
		System.out.println(Arrays.toString(result));

		String[] keymap2 = {"AA"};
		String[] targets2 = {"AB"};
		int[] result2 = solution.solution(keymap2, targets2);
		System.out.println(Arrays.toString(result2));

	}

	static class Solution {
		public int[] solution(String[] keymap, String[] targets) {
			int[] answer = new int[targets.length];

			// map 으로 문자와 횟수를 기록하고 뽑아서 쓴다. 횟수는 최소한으로 잡는다.

			HashMap<String, Integer> m = new HashMap<>();

			// Map 에 문자마다 할당 횟수를 기록
			for (int i = 0; i<keymap.length; i++) {
				for (int j = 0; j<keymap[i].length(); j++) {
					String a = String.valueOf(keymap[i].charAt(j));
					if (m.containsKey(a)) {
						m.put(a, Math.min(m.get(a), j+1));
					} else {
						m.put(a, j+1);
					}
				}
			}

			int sum = 0;
			// targets 에서 문자 하나당 할당 횟수 총합을 구해서 반환, 만약 기록되지 않은 문자 발견하면 총합을 0으로 처리하고 break;
			for (int i = 0; i<targets.length; i++) {
				for (int j = 0; j<targets[i].length(); j++) {
					String b = String.valueOf(targets[i].charAt(j));
					if (m.containsKey(b)) { // null 처러를 잘하자
						sum += m.get(b);
					} else {
						sum=0; // 중간에 Map 에 기록되지 않은 문자가 나오면 sum=0; 처리하고 끝내기
						break;
					}
				}
				if (sum == 0) {
					answer[i] = -1;
				} else {
					answer[i] = sum;
				}
				sum = 0;

			}

			//System.out.println(m);
			return answer;
		}
	}

}
