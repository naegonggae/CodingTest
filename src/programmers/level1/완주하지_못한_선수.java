package programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {

	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};

		Solution solution = new Solution();
		String result = solution.solution(participant, completion);
		System.out.println("result = " + result);
	}

	static class Solution {
		public String solution(String[] participant, String[] completion) {
			String answer = "";

			Map<String, ArrayList<Integer>> map = new HashMap<>();
			int i = 0;
			for (String name : participant) {
				if (map.containsKey(name)) {
					map.get(name).add(i);
				}
				else {
					map.put(name, new ArrayList<>());
					map.get(name).add(i);
				}
			}
			//System.out.println(map);

			for (String c : completion) {
				if (map.containsKey(c)) {
					map.get(c).remove(0);
				}
			}
			//System.out.println(map);
			for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet())  {
				if (!entry.getValue().isEmpty()) {
					answer = entry.getKey();
				}
			}
			return answer;
		}
	}

	static class Solution2 {
		public String solution(String[] participant, String[] completion) {
			String answer = "";
			HashMap<String, Integer> hm = new HashMap<>();
			for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
			for (String player : completion) hm.put(player, hm.get(player) - 1);

			for (String key : hm.keySet()) {
				if (hm.get(key) != 0){
					answer = key;
				}
			}
			return answer;
		}
	}


}
