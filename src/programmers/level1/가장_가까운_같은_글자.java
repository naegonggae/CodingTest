package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;

public class 가장_가까운_같은_글자 {

	public static void main(String[] args) {
		String a = "banana";
		Solution solution = new Solution();
		int[] result = solution.solution(a);
		System.out.println(Arrays.toString(result));
	}

	static class Solution {
		public int[] solution(String s) {
			int[] answer = new int[s.length()];

			HashMap<String, Integer> m = new HashMap();
			for (int i = 0; i<s.length(); i++) {
				String t = String.valueOf(s.charAt(i));
				if (m.containsKey(t)) {
					answer[i] = i - m.get(t);
					m.put(t, i);
				} else {
					answer[i] = -1;
					m.put(t, i);
				}
			}

			return answer;
		}
	}

}
