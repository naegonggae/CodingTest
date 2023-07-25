package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 신고_결과_받기 {

	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;

		Solution solution = new Solution();
		int[] result = solution.solution(id_list, report, k);
		System.out.println("result = " + Arrays.toString(result));
	}

	static class Solution {
		public int[] solution(String[] id_list, String[] report, int k) {
			// key: 신고당한놈, value: 몇명한테 당했는지
			Map<String, Set<String>> map = new HashMap<>();

			for (String rep : report) {
				String[] arr = rep.split(" ");
				Set<String> set = map.getOrDefault(arr[1], new HashSet<>());
				set.add(arr[0]);
				map.put(arr[1], set);
				System.out.println(arr[1]+" "+set);
			}

			System.out.println(map);

			// key: 알림받을 놈, value: 몇번 알림받을지
			Map<String, Integer> countMap = new LinkedHashMap<>(); // 순서가 있는 map

			for (String id : id_list) {
				countMap.put(id, 0); // 0으로 초기화
			}

			for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
				if (entry.getValue().size() >= k) { // 정지당할놈
					for (String value : entry.getValue()) {
						countMap.put(value, countMap.getOrDefault(value, 0) + 1);
					}
				}
			}

			return countMap.values().stream().mapToInt(Integer::intValue).toArray();
		}
		// set, HashSet, LinkedHashMap, getOrDefault,
	}

	class Solution2 {
		public int[] solution(String[] id_list, String[] report, int k) {
			int[] answer = new int[id_list.length];

			HashMap<String, Integer> idex = new HashMap<>();
			HashMap<String, ArrayList<String>> reportMap = new HashMap<>();

			for (int i = 0; i<id_list.length; i++) {
				idex.put(id_list[i], i); // id_list 인덱스 저장
				reportMap.put(id_list[i], new ArrayList<>()); // 키 : 신고당한사람 기준, 밸류 배열 선언
			}
			//System.out.println(idex);

			for (String r : report) {
				String[] temp = r.split(" ");
				if (!reportMap.get(temp[1]).contains(temp[0])) { // 특정 사람을 한 사람이 여러번 신고할 수 없음. 최대 한번만 침
					reportMap.get(temp[1]).add(temp[0]); // 날 신고한 사람 저장
				}
			}
			//System.out.println(reportMap);

			for (String a : reportMap.keySet()) { // reportMap 키들에 접근
				if (reportMap.get(a).size() >= k) { // 키가 정지당할 사람들인지 판별
					for (String name : reportMap.get(a)) {
						answer[idex.get(name)]++;
					}
				}
			}

			return answer;
		}
	}
	// keySet() 활용, 맵에 arrayList 넣고 활용하기, 접근 방식을 생각하는게 키
	// 자료구조의 주인공을 누구로 할지 고민이 될거다 당연히 주가 되는 신고한 사람을 해야할거같지만 신고받은사람이 더 효율적이다. 앞으로 주가 될거같은 놈을 자료구조의 주인공으로 꼭 두려하지 않아도 된다.
	// map 은 바로 출력해볼수 있어

}
