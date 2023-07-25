package programmers.level0;

import java.util.*;

public class 신고결과받기 {

	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
		int k = 2;

		Solution solution = new Solution();
		int[] result = solution.solution(id_list, report, k);
		System.out.println(Arrays.toString(result));

	}

	static class Solution {
		public int[] solution(String[] id_list, String[] report, int k) {
			int[] answer = new int[id_list.length];

			ArrayList<User> users = new ArrayList<>();
			HashMap<String, Integer> suspendedList = new HashMap<>();
			HashMap<String, Integer> idIdx = new HashMap<>();
			int idx = 0;

			for (String name : id_list) {
				idIdx.put(name, idx++); // 정답 출력을 위한 인덱스 저장
				users.add(new User(name)); // user 정보 저장, 이름, 내가 신고한사람, 날 신고한 사람
			}

			for (String re : report) {
				String[] str = re.split(" ");
				users.get(idIdx.get(str[0])).reportList.add(str[1]); // 내가 신고한사람 저장
				users.get(idIdx.get(str[1])).reportedList.add(str[0]); // 날 신고한사람 저장
			}

			System.out.println(users.toString());

			for (User user : users) {
				if (user.reportedList.size() >= k)
					suspendedList.put(user.name, 1); // 정지될 사람 표시
			}

			System.out.println(suspendedList);

			for (User user : users) {
				for (String nameReport : user.reportList) {
					if (suspendedList.get(nameReport) != null) { // 내가 신고한사람이 정지된 사람인가?
						answer[idIdx.get(user.name)]++; // null 이 아니면 내가 신고한 사람이 정지되었으므로 신고메일 받는거 +1 해줌
					}
				}
			}
			return answer;
		}

		static class User {

			String name;
			HashSet<String> reportList; // 내가 신고한사람
			HashSet<String> reportedList; // 날 신고한사람

			public User(String name) {
				this.name = name;
				reportList = new HashSet<>();
				reportedList = new HashSet<>();
			}

			@Override
			public String toString() {
				return "User{" +
						"name='" + name +
						", reportList=" + reportList +
						", reportedList=" + reportedList +
						'}';
			}
		}
	}
}
